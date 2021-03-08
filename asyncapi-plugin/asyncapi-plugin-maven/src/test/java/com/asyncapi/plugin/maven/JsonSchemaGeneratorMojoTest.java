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
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Pavel Bodiachevskii
 */
@RunWith(JUnitParamsRunner.class)
public class JsonSchemaGeneratorMojoTest {

    @Rule
    public MojoRule rule = new MojoRule();

    public Object[] singleSchemaGenerationParams() {
        File generatedSchema = FilesHelper.open("target/generated-test-sources/Complete/StreetlightsAsyncAPI-asyncapi.json");
        File expectedSchema = FilesHelper.readResource("reference-test-cases/json/StreetlightsAsyncAPI-asyncapi.json");

        /*
            pom to test, generated schema location, expected schema location
         */
        return new Object[][]{
                {
                    FilesHelper.readResource("reference-test-cases/json/single_class_names-pom.xml"),
                    generatedSchema,
                    expectedSchema
                },
                {
                    FilesHelper.readResource("reference-test-cases/json/single_package_names-pom.xml"),
                    generatedSchema,
                    expectedSchema
                }
        };
    }

    @Test
    @Parameters(method = "singleSchemaGenerationParams")
    public void singleSchemaGenerationTest(File pom, File generatedSchema, File expectedSchema) throws Exception {
        executePom(pom);

        Assert.assertEquals(format(FileUtils.readLines(expectedSchema)), format(FileUtils.readLines(generatedSchema)));
    }

    public Object[] multipleSchemaGenerationParams() {
        File generatedSchemaFirst = FilesHelper.open("target/generated-test-sources/Complete/StreetlightsAsyncAPI-asyncapi.json");
        File expectedSchemaFirst = FilesHelper.readResource("reference-test-cases/json/StreetlightsAsyncAPI-asyncapi.json");

        File generatedSchemaSecond = FilesHelper.open("target/generated-test-sources/Complete/LampsAsyncAPI-asyncapi.json");
        File expectedSchemaSecond = FilesHelper.readResource("reference-test-cases/json/LampsAsyncAPI-asyncapi.json");

        /*
            pom to test, first generated schema location, first expected schema location, second generated schema location, second expected schema location
         */
        return new Object[][]{
                {
                        FilesHelper.readResource("reference-test-cases/json/multiple_class_names-pom.xml"),
                        generatedSchemaFirst,
                        expectedSchemaFirst,
                        generatedSchemaSecond,
                        expectedSchemaSecond
                },
                {
                        FilesHelper.readResource("reference-test-cases/json/multiple_package_names-pom.xml"),
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

        Assert.assertEquals(format(FileUtils.readLines(expectedSchemaFirst)), format(FileUtils.readLines(generatedSchemaFirst)));
        Assert.assertEquals(format(FileUtils.readLines(expectedSchemaSecond)), format(FileUtils.readLines(generatedSchemaSecond)));
    }

    @Test
    public void customFileNameGenerationTest() throws Exception {
        executePom(FilesHelper.readResource("reference-test-cases/json/custom-pom.xml"));

        File generatedSchema = FilesHelper.open("target/generated-test-sources/Complete/StreetlightsAsyncAPI-asyncapi-schema.json");
        File expectedSchema = FilesHelper.readResource("reference-test-cases/json/StreetlightsAsyncAPI-asyncapi.json");

        Assert.assertEquals(format(FileUtils.readLines(expectedSchema)), format(FileUtils.readLines(generatedSchema)));
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

    private List<String> format(List<String> fileLines) {
        return fileLines.stream()
                .filter(Objects::nonNull)
                .filter(line -> !line.isEmpty())
                .map(line -> {
                    int index = line.lastIndexOf(",");
                    if (index > 0) {
                        return line.substring(0, index);
                    }

                    return line;
                })
                .sorted()
                .collect(Collectors.toList());
    }

}
