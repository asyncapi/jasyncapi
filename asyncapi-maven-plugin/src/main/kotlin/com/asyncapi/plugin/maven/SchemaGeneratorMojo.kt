package com.asyncapi.plugin.maven

import com.asyncapi.v2.model.AsyncAPI
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator
import org.apache.maven.plugin.AbstractMojo
import org.apache.maven.plugin.MojoExecutionException
import org.apache.maven.plugins.annotations.LifecyclePhase
import org.apache.maven.plugins.annotations.Mojo
import org.apache.maven.plugins.annotations.Parameter
import org.apache.maven.plugins.annotations.ResolutionScope
import org.apache.maven.project.MavenProject
import org.reflections.Reflections
import org.reflections.scanners.SubTypesScanner
import java.io.File
import java.net.URL
import java.net.URLClassLoader
import java.nio.file.Files
import java.nio.file.Paths

@Mojo(name = "generate",
        defaultPhase = LifecyclePhase.COMPILE,
        requiresDependencyResolution = ResolutionScope.COMPILE,
        requiresDependencyCollection = ResolutionScope.COMPILE
)
class SchemaGeneratorMojo: AbstractMojo() {

    @Parameter(property = "classNames")
    private var classNames: Array<String> = emptyArray()
    @Parameter(property = "packageNames")
    private var packageNames: Array<String> = emptyArray()
    @Parameter(property = "schemaFilePath", defaultValue = "generated/asyncapi")
    private var schemaFilePath: String = "generated/asyncapi"
    @Parameter(property = "schemaFileName", defaultValue = "asyncapi")
    private var schemaFileName: String = "asyncapi"
    @Parameter(property = "schemaFileFormat", defaultValue = "json")
    private var schemaFileFormat: String = "json"
    @Parameter(property = "prettyPrint", defaultValue = "true")
    private var prettyPrint: Boolean = true
    @Parameter(property = "includeNulls", defaultValue = "false")
    private var includeNulls: Boolean = false

    @Parameter(defaultValue = "\${project}", required = true, readonly = true)
    lateinit var project: MavenProject

    private val classLoader: ClassLoader by lazy {
        val urls = emptySet<URL>()

        project.runtimeClasspathElements.forEach {
            urls.plus(File(it).toURI().toURL())
        }

        URLClassLoader(urls.toTypedArray(), Thread.currentThread().contextClassLoader)
    }
    private val objectMapper: ObjectMapper by lazy {
        val instance = when(schemaFileFormat) {
            "json" -> {
                ObjectMapper()
            }
            "yaml" -> {
                ObjectMapper(YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER))
            }
            else -> throw MojoExecutionException("schemaFileFormat=$schemaFileFormat not recognized")
        }

        if (!includeNulls) {
            instance.setSerializationInclusion(JsonInclude.Include.NON_NULL)
        }

        instance
    }

    override fun execute() {
        if (classNames.isEmpty() && packageNames.isEmpty()) {
            throw MojoExecutionException("classNames or packageNames are required")
        }

        classNames.forEach {
            generateSchema(loadClass(it))
        }

        classNames.forEach {
            loadClasses(it).forEach(this::generateSchema)
        }
    }

    @Throws(MojoExecutionException::class)
    private fun loadClass(className: String): Class<*> {
        return try {
            classLoader.loadClass(className)
        } catch (classNotFoundException: ClassNotFoundException) {
            throw MojoExecutionException("Loading class error: $className", classNotFoundException)
        }
    }

    @Throws(MojoExecutionException::class)
    private fun loadClasses(packageName: String): Set<Class<*>> {
        return try {
            val reflections = Reflections(packageName, SubTypesScanner(false))
            reflections.getSubTypesOf(AsyncAPI::class.java)
        } catch (exception: Exception) {
            throw MojoExecutionException("Loading package error: $packageName", exception)
        }
    }

    @Throws(MojoExecutionException::class)
    private fun generateSchema(schemaClass: Class<*>) {
        log.info("Generating AsyncAPI Schema for class ${schemaClass.simpleName}")
        val schema = try {
            val foundAsyncAPI = schemaClass.newInstance()

            if (prettyPrint) {
                objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(foundAsyncAPI)
            } else {
                objectMapper.writeValueAsString(foundAsyncAPI)
            }
        } catch (exception: Exception) {
            throw MojoExecutionException("Can't serialize ${schemaClass.simpleName} because ${exception.message}", exception)
        }

        log.info("Generated schema: ${schemaClass.simpleName}\n$schema")
        writeSchema(schema, schemaClass.simpleName)
    }

    @Throws(MojoExecutionException::class)
    private fun writeSchema(schema: String, schemaName: String) {
        val fileName = when(schemaFileFormat) {
            "json" -> "$schemaName-$schemaFileName.json"
            "yaml" -> "$schemaName-$schemaFileName.yaml"
            else -> throw MojoExecutionException("schemaFileFormat=$schemaFileFormat not recognized")
        }

        val dirPath = if (schemaFilePath.isBlank()) {
            Paths.get("asyncapi-schemas")
        } else {
            Paths.get(schemaFilePath)
        }

        log.info("Saving schema to $dirPath/$fileName")
        File(Files.createDirectories(dirPath).toFile(), fileName).writeText(schema, Charsets.UTF_8)
    }

}