package com.asyncapi.plugin.maven;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
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

@RunWith(JUnitParamsRunner.class)
public class YamlSchemaGeneratorMojoTest {

    @Rule
    public MojoRule rule = new MojoRule();

    public Object[] singleSchemaGenerationParams() {
        File generatedSchema = FilesHelper.open("target/generated-test-sources/Complete/StreetlightsAsyncAPI-asyncapi.yaml");
        File expectedSchema = FilesHelper.readResource("reference-test-cases/yaml/StreetlightsAsyncAPI-asyncapi.yaml");

        /*
            pom to test, generated schema location, expected schema location
         */
        return new Object[][]{
                {
                        FilesHelper.readResource("reference-test-cases/yaml/single_class_names-pom.xml"),
                        generatedSchema,
                        expectedSchema
                },
                {
                        FilesHelper.readResource("reference-test-cases/yaml/single_package_names-pom.xml"),
                        generatedSchema,
                        expectedSchema
                }
        };
    }

    @Test
    @Parameters(method = "singleSchemaGenerationParams")
    public void singleSchemaGenerationTest(File pom, File generatedSchema, File expectedSchema) throws Exception {
        executePom(pom);

        Assert.assertEquals(FileUtils.readLines(expectedSchema), FileUtils.readLines(generatedSchema));
    }

    public Object[] multipleSchemaGenerationParams() {
        File generatedSchemaFirst = FilesHelper.open("target/generated-test-sources/Complete/StreetlightsAsyncAPI-asyncapi.yaml");
        File expectedSchemaFirst = FilesHelper.readResource("reference-test-cases/yaml/StreetlightsAsyncAPI-asyncapi.yaml");

        File generatedSchemaSecond = FilesHelper.open("target/generated-test-sources/Complete/LampsAsyncAPI-asyncapi.yaml");
        File expectedSchemaSecond = FilesHelper.readResource("reference-test-cases/yaml/LampsAsyncAPI-asyncapi.yaml");

        /*
            pom to test, first generated schema location, first expected schema location, second generated schema location, second expected schema location
         */
        return new Object[][]{
                {
                        FilesHelper.readResource("reference-test-cases/yaml/multiple_class_names-pom.xml"),
                        generatedSchemaFirst,
                        expectedSchemaFirst,
                        generatedSchemaSecond,
                        expectedSchemaSecond
                },
                {
                        FilesHelper.readResource("reference-test-cases/yaml/multiple_package_names-pom.xml"),
                        generatedSchemaFirst,
                        expectedSchemaFirst,
                        generatedSchemaSecond,
                        expectedSchemaSecond
                }
        };
    }

    @Test
    @Parameters(method = "multipleSchemaGenerationParams")
    public void multipleSchemasGenerationTest(File pom,
                                              File generatedSchemaFirst,
                                              File expectedSchemaFirst,
                                              File generatedSchemaSecond,
                                              File expectedSchemaSecond
    ) throws Exception {
        executePom(pom);

        Assert.assertEquals(FileUtils.readLines(expectedSchemaFirst), FileUtils.readLines(generatedSchemaFirst));
        Assert.assertEquals(FileUtils.readLines(expectedSchemaSecond), FileUtils.readLines(generatedSchemaSecond));
    }

    @Test
    public void customFileNameGenerationTest() throws Exception {
        executePom(FilesHelper.readResource("reference-test-cases/yaml/custom-pom.xml"));

        File generatedSchema = FilesHelper.open("target/generated-test-sources/Complete/asyncapi.yaml");
        File expectedSchema = FilesHelper.readResource("reference-test-cases/yaml/StreetlightsAsyncAPI-asyncapi.yaml");

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

}
