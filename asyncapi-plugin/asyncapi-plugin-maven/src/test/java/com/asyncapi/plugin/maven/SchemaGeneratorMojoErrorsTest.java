package com.asyncapi.plugin.maven;

import junitparams.JUnitParamsRunner;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.testing.MojoRule;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.configuration.PlexusConfiguration;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.codehaus.plexus.util.xml.Xpp3DomBuilder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.FileReader;

@RunWith(JUnitParamsRunner.class)
public class SchemaGeneratorMojoErrorsTest {

    @Rule
    public MojoRule rule = new MojoRule();

    @Test(expected = MojoExecutionException.class)
    public void testClassNotFoundError() throws Exception {
        File testCaseLocation = new File("src/test/resources/error-test-cases");

        executePom(new File(testCaseLocation, "ClassNotFound-pom.xml"));
    }

    @Test(expected = MojoExecutionException.class)
    public void testUnknownSchemaFormatError() throws Exception {
        File testCaseLocation = new File("src/test/resources/error-test-cases");

        executePom(new File(testCaseLocation, "UnknownSchemaFormat-pom.xml"));
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
