package com.asyncapi.plugin.maven;

import com.asyncapi.v2.model.AsyncAPI;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.maven.artifact.DependencyResolutionRequiredException;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.apache.maven.project.MavenProject;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.MessageFormat;
import java.util.List;
import java.util.Set;

/*
By convention, the AsyncAPI Specification (A2S) file is named asyncapi.json or asyncapi.yaml.
    TODO: Tasks:
        * Generate as json
        * Generate as yaml
 */

/**
 * Maven plugin for the java-asyncapi.
 */
@Mojo(name = "generate",
        defaultPhase = LifecyclePhase.COMPILE,
        requiresDependencyResolution = ResolutionScope.COMPILE,
        requiresDependencyCollection = ResolutionScope.COMPILE)
public class SchemaGeneratorMojo extends AbstractMojo {

    /**
     * Full name of the classes for which the AsyncAPI schema will be generated.
     */
    @Parameter(property = "classNames")
    private String[] classNames;

    /**
     * Full name of the packages for which a AsyncAPI schema will be generated for each contained class.
     */
    @Parameter(property = "packageNames")
    private String[] packageNames;

    /**
     * The directory path where the schema files are generated.
     * <br>
     * By default, this is: {@code src/main/resources}
     */
    @Parameter(property = "schemaFilePath")
    private File schemaFilePath;

    /**
     * The name of the file in which the generated schema is written. Allowing for two placeholders:
     * <ul>
     * <li><code>{0}</code> - containing the simple class name of the class for which the schema was generated</li>
     * <li><code>{1}</code> - containing the package path of the class for which the schema was generated</li>
     * </ul>
     * The default name is: <code>{0}-schema.json</code>
     */
    @Parameter(property = "schemaFileName", defaultValue = "{0}-asyncapi.json")
    private String schemaFileName;

    /**
     * The schema format to be used:
     * <ul>
     *     <li>json</li>
     *     <li>yaml</li>
     * </ul>
     */
    @Parameter(property = "schemaFormat", defaultValue = "json")
    private String schemaFormat;

    /**
     * The Maven project.
     */
    @Parameter(defaultValue = "${project}", required = true, readonly = true)
    MavenProject project;

    /**
     * Jacksons mapper to serialize schemas to json/yaml
     */
    private ObjectMapper objectMapper = null;

    /**
     * The classloader used for loading classes.
     */
    private ClassLoader classLoader = null;

    /**
     * Invoke the schema generator.
     *
     * @throws MojoExecutionException An exception in case of errors and unexpected behavior
     */
    @Override
    public void execute() throws MojoExecutionException {
        // trigger initialization of the generator instance
        this.getObjectMapper();

        if (classNames != null) {
            for (String className : this.classNames) {
                this.getLog().info("Generating AsyncAPI Schema for class " + className);
                generateSchema(className);
            }
        }

        if (this.packageNames != null) {
            for (String packageName : this.packageNames) {
                this.getLog().info("Generating AsyncAPI Schema for package " + packageName);
                generateSchemaForPackage(packageName);
            }
        }
    }

    /**
     * Generate the AsyncAPI schema for the given className.
     *
     * @param className The name of the class
     * @throws MojoExecutionException In case of problems
     */
    private void generateSchema(String className) throws MojoExecutionException {
        // Load the class for which the schema will be generated
        Class<?> schemaClass = this.loadClass(className);
        this.generateSchema(schemaClass);
    }

    /**
     * Generate the AsyncAPI schema for the given className.
     *
     * @param schemaClass The class for which the schema is to be generated
     * @throws MojoExecutionException In case of problems
     */
    private void generateSchema(Class<?> schemaClass) throws MojoExecutionException {
        try {
            AsyncAPI asyncAPI = (AsyncAPI) schemaClass.newInstance();

            String asyncapiSchema = getObjectMapper()
                    .setSerializationInclusion(JsonInclude.Include.NON_NULL) // TODO: Customize
                    .writerWithDefaultPrettyPrinter() // TODO: Customize
                    .writeValueAsString(
                    AsyncAPI.builder()
                            .asyncapi(asyncAPI.getAsyncapi())
                            .id(asyncAPI.getId())
                            .defaultContentType(asyncAPI.getDefaultContentType())
                            .info(asyncAPI.getInfo())
                            .servers(asyncAPI.getServers())
                            .channels(asyncAPI.getChannels())
                            .components(asyncAPI.getComponents())
                            .tags(asyncAPI.getTags())
                            .externalDocs(asyncAPI.getExternalDocs())
                            .build()
            );

            this.getLog().info("Generated Schema: \n" + asyncapiSchema + "\n--------");

            File file = getSchemaFile(schemaClass);
            this.getLog().info("- Writing schema to file: " + file);
            this.writeToFile(asyncapiSchema, file);
        } catch (JsonProcessingException jsonProcessingException) {
            throw new MojoExecutionException("[Jackson] Can't serialize.", jsonProcessingException);
        } catch (java.lang.InstantiationException | java.lang.IllegalAccessException e) {
            throw new MojoExecutionException("[Reflection] Can't serialize.", e);
        }
    }

    /**
     * Generate AsyncAPI schema's for all classes in a package.
     *
     * @param packageName The name of the package
     * @throws MojoExecutionException in case of problems
     */
    private void generateSchemaForPackage(String packageName) throws MojoExecutionException {
        Reflections reflections = new Reflections(packageName, new SubTypesScanner(false));
        Set<Class<? extends AsyncAPI>> subTypes = reflections.getSubTypesOf(AsyncAPI.class);
        for (Class<?> mainType : subTypes) {
            this.generateSchema(mainType);
        }
    }

    /**
     * Return the file in which the schema has to be written.
     *
     * <p>The path is determined based on the {@link #schemaFilePath} parameter.
     * <br>
     * The name of the file is determined based on the {@link #schemaFileName} parameter, which allows for two placeholders:
     * <ul>
     * <li><code>{0}</code> - containing the simple name of the class the schema was generated for</li>
     * <li><code>{1}</code> - containing the package path of the class the schema was generated for</li>
     * </ul>
     * </p>
     * The default path is: {@code src/main/resources}
     * <br>
     * The default name is: <code>{0}-schema.json</code>
     *
     * @param mainType targeted class for which the schema is being generated
     * @return The full path name of the schema file
     */
    private File getSchemaFile(Class<?> mainType) {
        // At first find the root location where the schema files are written
        File directory;
        if (this.schemaFilePath == null) {
            directory = new File("src" + File.separator + "main" + File.separator + "resources");
            this.getLog().debug("- No 'schemaFilePath' configured. Applying default: " + directory);
        } else {
            directory = this.schemaFilePath;
        }

        // Then build the full qualified file name.
        String fileName = MessageFormat.format(this.schemaFileName,
                // placeholder {0}
                mainType.getSimpleName(),
                // placeholder {1}
                mainType.getPackage().getName().replace('.', File.separatorChar));
        File schemaFile = new File(directory, fileName);

        // Make sure the directory is available
        try {
            Files.createDirectories(schemaFile.getParentFile().toPath());
        } catch (IOException e) {
            this.getLog().warn("Failed to ensure existence of " + schemaFile.getParent(), e);
        }

        return schemaFile;
    }

    /**
     * Get object mapper. Create it when required.
     * <br>
     * Configuring it by setting output format:
     * <ul>
     *     <li>json</li>
     *     <li>yaml</li>
     * </ul>
     *
     * @return configured object mapper
     * @throws MojoExecutionException In case of problems
     */
    private ObjectMapper getObjectMapper() throws MojoExecutionException {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }

        return objectMapper;
    }

    /**
     * Construct the classloader based on the project classpath.
     *
     * @return The classloader
     */
    private ClassLoader getClassLoader() {
        if (this.classLoader == null) {
            List<String> runtimeClasspathElements = null;
            try {
                runtimeClasspathElements = project.getRuntimeClasspathElements();
            } catch (DependencyResolutionRequiredException e) {
                this.getLog().error("Failed to resolve runtime classpath elements", e);
            }

            if (runtimeClasspathElements != null) {
                URL[] runtimeUrls = new URL[runtimeClasspathElements.size()];
                for (int i = 0; i < runtimeClasspathElements.size(); i++) {
                    String element = runtimeClasspathElements.get(i);
                    try {
                        runtimeUrls[i] = new File(element).toURI().toURL();
                    } catch (MalformedURLException e) {
                        this.getLog().error("Failed to resolve runtime classpath element", e);
                    }
                }
                this.classLoader = new URLClassLoader(runtimeUrls,
                        Thread.currentThread().getContextClassLoader());
            }
        }

        return this.classLoader;
    }

    /**
     * Load a class from the plugin classpath enriched with the project dependencies.
     *
     * @param className Name of the class to be loaded
     * @return The loaded class
     * @throws MojoExecutionException In case of unexpected behavior
     */
    private Class<?> loadClass(String className) throws MojoExecutionException {
        try {
            return this.getClassLoader().loadClass(className);
        } catch (ClassNotFoundException e) {
            throw new MojoExecutionException("Error loading class " + className, e);
        }
    }

    /**
     * Write generated schema to a file.
     *
     * @param asyncapiSchema Generated schema to be written
     * @param file           The file to write to
     * @throws MojoExecutionException In case of problems when writing the targeted file
     */
    private void writeToFile(String asyncapiSchema, File file) throws MojoExecutionException {
        try (FileOutputStream outputStream = new FileOutputStream(file);
             PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8))) {
            writer.print(asyncapiSchema);
        } catch (IOException e) {
            throw new MojoExecutionException("Error: Can not write to file " + file, e);
        }
    }

}
