package com.asyncapi.plugin.gradle

import org.gradle.testkit.runner.GradleRunner
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.io.TempDir
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.io.File
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
open class ResolveTaskTest {

    private lateinit var testProjectDirectory: File
    private lateinit var buildGradleFile: File

    @BeforeAll
    fun prepareProjectDirectory(@TempDir tempDir: File) {
        testProjectDirectory = tempDir

        buildGradleFile = File(testProjectDirectory, "build.gradle")
        buildGradleFile.writeText(this::class.java.getResource("/build.gradle").readText(Charsets.UTF_8),
                Charsets.UTF_8)

        File(testProjectDirectory,"settings.gradle")
                .writeText(this::class.java.getResource("/settings.gradle").readText(Charsets.UTF_8))
    }

    @ParameterizedTest
    @ValueSource(strings = [
        """

            resolve {
                classNames = ['com.asyncapi.plugin.gradle.asyncapi.lamps.Lamps']
            }
        """,
        """
            
            resolve {
                packageNames = ['com.asyncapi.plugin.gradle.asyncapi.lamps']
            }
        """
    ])
    fun singleSchemaGenerationTest(taskConfiguration: String) {
        buildGradleFile.appendText(taskConfiguration, Charsets.UTF_8)

        GradleRunner.create()
                .withPluginClasspath()
                .withProjectDir(testProjectDirectory)
                .withDebug(true)
                .withArguments("resolve", "--stacktrace", "--info")
                .forwardOutput()
                .build()

        val generatedLampsSchemaFile = File("generated/asyncapi/Lamps-asyncapi.json")
        val expectedLampsSchema = this::class.java.getResource("/lamps_prettyPrint-asyncapi.json").readText(Charsets.UTF_8)

        Assertions.assertTrue(generatedLampsSchemaFile.exists())
        Assertions.assertEquals(generatedLampsSchemaFile.readText(Charsets.UTF_8), expectedLampsSchema)

        Assertions.assertTrue(generatedLampsSchemaFile.delete())
    }

    @ParameterizedTest
    @ValueSource(strings = [
        """

            resolve {
                classNames = ['com.asyncapi.plugin.gradle.asyncapi.lamps.Lamps', 'com.asyncapi.plugin.gradle.asyncapi.streetlights.Streetlights']
            }
        """,
        """
            
            resolve {
                packageNames = ['com.asyncapi.plugin.gradle.asyncapi.lamps', 'com.asyncapi.plugin.gradle.asyncapi.streetlights']
            }
        """
    ])
    fun multipleSchemaGenerationTest(taskConfiguration: String) {
        buildGradleFile.appendText(taskConfiguration, Charsets.UTF_8)

        val executionResult = GradleRunner.create()
                .withPluginClasspath()
                .withProjectDir(testProjectDirectory)
                .withDebug(true)
                .withArguments("resolve", "--stacktrace", "--info")
                .forwardOutput()
                .build()

        val generatedLampsSchemaFile = File("generated/asyncapi/Lamps-asyncapi.json")
        val expectedLampsSchema = this::class.java.getResource("/lamps_prettyPrint-asyncapi.json").readText(Charsets.UTF_8)

        Assertions.assertTrue(generatedLampsSchemaFile.exists())
        Assertions.assertEquals(generatedLampsSchemaFile.readText(Charsets.UTF_8), expectedLampsSchema)

        val generatedStreetlightsSchemaFile = File("generated/asyncapi/Streetlights-asyncapi.json")
        val expectedStreetlightsSchema = this::class.java.getResource("/streetlights-asyncapi.json").readText(Charsets.UTF_8)

        Assertions.assertTrue(generatedStreetlightsSchemaFile.exists())
        Assertions.assertEquals(expectedStreetlightsSchema, generatedStreetlightsSchemaFile.readText(Charsets.UTF_8))

        Assertions.assertTrue(generatedLampsSchemaFile.delete())
        Assertions.assertTrue(generatedStreetlightsSchemaFile.delete())
    }

    fun schemaGenerationWithCustomParamsTestProperties(): Stream<Arguments> {
        return Stream.of(
                Arguments.of("""
                    
                    resolve {
                        schemaFileName = "asyncapi-schema"
                        schemaFilePath = "generated/asyncapi/json"
                        classNames = ['com.asyncapi.plugin.gradle.asyncapi.lamps.Lamps']
                        prettyPrint = false
                    }
                """.trimIndent(), "generated/asyncapi/json/Lamps-asyncapi-schema.json", "/lamps-asyncapi.json"
                ),
                Arguments.of("""
                    
                    resolve {
                        schemaFileName = "asyncapi-schema"
                        schemaFilePath = "generated/asyncapi/yaml"
                        schemaFileFormat = "yaml"
                        classNames = ['com.asyncapi.plugin.gradle.asyncapi.lamps.Lamps']
                        prettyPrint = false
                    }
                """.trimIndent(), "generated/asyncapi/yaml/Lamps-asyncapi-schema.yaml", "/lamps-asyncapi.yaml"
                )
        )
    }

    @ParameterizedTest
    @MethodSource("schemaGenerationWithCustomParamsTestProperties")
    fun schemaGenerationWithCustomParamsTest(taskConfiguration: String,
                                             generatedSchemaFilePath: String,
                                             expectedFilePath: String
    ) {
        buildGradleFile.appendText(taskConfiguration, Charsets.UTF_8)

        GradleRunner.create()
                .withPluginClasspath()
                .withProjectDir(testProjectDirectory)
                .withDebug(true)
                .withArguments("resolve", "--stacktrace", "--info")
                .forwardOutput()
                .build()

        val generatedSchemaFile = File(generatedSchemaFilePath)
        val expectedSchema = this::class.java.getResource(expectedFilePath).readText(Charsets.UTF_8)

        Assertions.assertTrue(generatedSchemaFile.exists())
        Assertions.assertEquals(expectedSchema, generatedSchemaFile.readText(Charsets.UTF_8))

        Assertions.assertTrue(generatedSchemaFile.delete())
    }

}