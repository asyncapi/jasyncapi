package com.asyncapi.plugin.maven;

import junitparams.JUnitParamsRunner;
import org.apache.commons.io.FileUtils;
import org.apache.maven.plugin.testing.MojoRule;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.configuration.PlexusConfiguration;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.codehaus.plexus.util.xml.Xpp3DomBuilder;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.FileReader;
import java.util.Objects;

@RunWith(JUnitParamsRunner.class)
public class SchemaGeneratorMojoTest {

    @Rule
    public MojoRule rule = new MojoRule();

    // Default name and type
    @Test
    public void singleSchemaGenerationFromClassNames() throws Exception {
        File pom = readResource("reference-test-cases/single_class_names-pom.xml");

        executePom(pom);

        File generatedSchema = new File("target/generated-test-sources/Complete/StreetlightsAsyncAPI-asyncapi.json");
        Assert.assertTrue(generatedSchema.exists());
        generatedSchema.deleteOnExit();

        File expectedSchema = readResource("reference-test-cases/StreetlightsAsyncAPI-asyncapi.json");
        Assert.assertTrue(expectedSchema.exists());

        Assert.assertEquals(FileUtils.readLines(expectedSchema), FileUtils.readLines(generatedSchema));
    }

    // Default name and type
    @Test
    public void multipleSchemaGenerationFromClassNames() throws Exception {
        File pom = readResource("reference-test-cases/multiple_class_names-pom.xml");

        executePom(pom);

        // Getting generated
        File generatedSchemaFirst = new File("target/generated-test-sources/Complete/StreetlightsAsyncAPI-asyncapi.json");
        Assert.assertTrue(generatedSchemaFirst.exists());
        generatedSchemaFirst.deleteOnExit();

        File generatedSchemaSecond = new File("target/generated-test-sources/Complete/LampsAsyncAPI-asyncapi.json");
        Assert.assertTrue(generatedSchemaSecond.exists());
        generatedSchemaSecond.deleteOnExit();

        // Getting expected
        File expectedSchemaFirst = readResource("reference-test-cases/StreetlightsAsyncAPI-asyncapi.json");
        Assert.assertTrue(expectedSchemaFirst.exists());

        File expectedSchemaSecond = readResource("reference-test-cases/LampsAsyncAPI-asyncapi.json");
        Assert.assertTrue(expectedSchemaSecond.exists());

        // Comparing
        Assert.assertEquals(FileUtils.readLines(expectedSchemaFirst), FileUtils.readLines(generatedSchemaFirst));
        Assert.assertEquals(FileUtils.readLines(expectedSchemaSecond), FileUtils.readLines(generatedSchemaSecond));
    }

    // Default name and type
    @Test
    public void singleSchemaGenerationFromPackageNames() throws Exception {
        File pom = readResource("reference-test-cases/single_package_names-pom.xml");

        executePom(pom);

        File generatedSchema = new File("target/generated-test-sources/Complete/StreetlightsAsyncAPI-asyncapi.json");
        Assert.assertTrue(generatedSchema.exists());
        generatedSchema.deleteOnExit();

        File expectedSchema = readResource("reference-test-cases/StreetlightsAsyncAPI-asyncapi.json");
        Assert.assertTrue(expectedSchema.exists());

        Assert.assertEquals(FileUtils.readLines(expectedSchema), FileUtils.readLines(generatedSchema));
    }

    // Default name and type
    @Test
    public void multipleSchemaGenerationFromPackageNames() throws Exception {
        File pom = readResource("reference-test-cases/multiple_package_names-pom.xml");

        executePom(pom);

        // Getting generated
        File generatedSchemaFirst = new File("target/generated-test-sources/Complete/StreetlightsAsyncAPI-asyncapi.json");
        Assert.assertTrue(generatedSchemaFirst.exists());
        generatedSchemaFirst.deleteOnExit();

        File generatedSchemaSecond = new File("target/generated-test-sources/Complete/LampsAsyncAPI-asyncapi.json");
        Assert.assertTrue(generatedSchemaSecond.exists());
        generatedSchemaSecond.deleteOnExit();

        // Getting expected
        File expectedSchemaFirst = readResource("reference-test-cases/StreetlightsAsyncAPI-asyncapi.json");
        Assert.assertTrue(expectedSchemaFirst.exists());

        File expectedSchemaSecond = readResource("reference-test-cases/LampsAsyncAPI-asyncapi.json");
        Assert.assertTrue(expectedSchemaSecond.exists());

        // Comparing
        Assert.assertEquals(FileUtils.readLines(expectedSchemaFirst), FileUtils.readLines(generatedSchemaFirst));
        Assert.assertEquals(FileUtils.readLines(expectedSchemaSecond), FileUtils.readLines(generatedSchemaSecond));
    }

    @Test
    public void customFileNameGenerationTest() throws Exception {
        File pom = readResource("reference-test-cases/custom-pom.xml");

        executePom(pom);

        File generatedSchema = new File("target/generated-test-sources/Complete/asyncapi.json");
        Assert.assertTrue(generatedSchema.exists());
        generatedSchema.deleteOnExit();

        File expectedSchema = readResource("reference-test-cases/StreetlightsAsyncAPI-asyncapi.json");
        Assert.assertTrue(expectedSchema.exists());

        Assert.assertEquals(FileUtils.readLines(expectedSchema), FileUtils.readLines(generatedSchema));
    }

    /**
     * Execute the schema-generator plugin as define the the given pom file
     *
     * @param pomFile The pom file
     * @throws Exception In case of problems
     */
    private void executePom(File pomFile) throws Exception {
        // Get the maven pom file content
        Xpp3Dom pomDom = Xpp3DomBuilder.build(new FileReader(pomFile));
        PlexusConfiguration configuration = rule.extractPluginConfiguration("asyncapi-maven-plugin", pomDom);

        // Configure the Mojo
        SchemaGeneratorMojo myMojo = (SchemaGeneratorMojo) rule.lookupConfiguredMojo(new MavenProject(), "generate");
        myMojo = (SchemaGeneratorMojo) rule.configureMojo(myMojo, configuration);

        // And execute
        myMojo.execute();
    }

    private File readResource(String path) {
        return new File(Objects.requireNonNull(
                getClass().getClassLoader().getResource(path)
        ).getFile());
    }

}
