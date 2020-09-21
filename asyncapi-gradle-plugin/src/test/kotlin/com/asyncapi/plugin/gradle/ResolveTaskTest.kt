package com.asyncapi.plugin.gradle

import org.gradle.testkit.runner.GradleRunner
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.io.TempDir
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.util.stream.Stream

open class ResolveTaskTest {

    private lateinit var testProjectDirectory: File
    private lateinit var buildGradleFile: File

    @BeforeEach
    fun prepareProjectDirectory(@TempDir tempDir: File) {
        testProjectDirectory = tempDir

        buildGradleFile = File(testProjectDirectory, "build.gradle")
        buildGradleFile.writeText(this::class.java.getResource("/build.gradle").readText(Charsets.UTF_8),
                Charsets.UTF_8)

        File(testProjectDirectory,"settings.gradle")
                .writeText(this::class.java.getResource("/settings.gradle").readText(Charsets.UTF_8))
        copySources()
    }

    private fun copySources() {
        val sourcesLocation = Files.createDirectories(Paths.get(testProjectDirectory.path,"/src/main/kotlin")).toFile()
        File("src/test/kotlin").copyRecursively(sourcesLocation)
    }

    @AfterEach
    fun cleanSchemasFolder() {
        Assertions.assertTrue(File(targetFolderRoot).deleteRecursively())
    }

    @ParameterizedTest
    @ValueSource(strings = [
        """

            resolve {
                classNames = ['com.asyncapi.plugin.gradle.asyncapi.lamps.Lamps']
                classPath = sourceSets.main.runtimeClasspath
            }
        """,
        """
            
            resolve {
                packageNames = ['com.asyncapi.plugin.gradle.asyncapi.lamps']
                classPath = sourceSets.main.runtimeClasspath
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
                classPath = sourceSets.main.runtimeClasspath
            }
        """,
        """
            
            resolve {
                packageNames = ['com.asyncapi.plugin.gradle.asyncapi.lamps', 'com.asyncapi.plugin.gradle.asyncapi.streetlights']
                classPath = sourceSets.main.runtimeClasspath
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

        val generatedLampsSchemaFile = File("$targetFolderRoot/asyncapi/Lamps-asyncapi.json")
        val expectedLampsSchema = this::class.java.getResource("/lamps_prettyPrint-asyncapi.json").readText(Charsets.UTF_8)

        Assertions.assertTrue(generatedLampsSchemaFile.exists())
        Assertions.assertEquals(generatedLampsSchemaFile.readText(Charsets.UTF_8), expectedLampsSchema)

        val generatedStreetlightsSchemaFile = File("$targetFolderRoot/asyncapi/Streetlights-asyncapi.json")
        val expectedStreetlightsSchema = this::class.java.getResource("/streetlights-asyncapi.json").readText(Charsets.UTF_8)

        Assertions.assertTrue(generatedStreetlightsSchemaFile.exists())
        Assertions.assertEquals(expectedStreetlightsSchema, generatedStreetlightsSchemaFile.readText(Charsets.UTF_8))
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
    }

    companion object {
        private const val targetFolderRoot = "generated"

        @JvmStatic
        fun schemaGenerationWithCustomParamsTestProperties(): Stream<Arguments> {
            return Stream.of(
                    Arguments.of("""
                    
                    resolve {
                        schemaFileName = "asyncapi-schema"
                        schemaFilePath = "$targetFolderRoot/asyncapi/json"
                        classNames = ['com.asyncapi.plugin.gradle.asyncapi.lamps.Lamps']
                        prettyPrint = false
                        classPath = sourceSets.main.runtimeClasspath
                    }
                """.trimIndent(), "generated/asyncapi/json/Lamps-asyncapi-schema.json", "/lamps-asyncapi.json"
                    ),
                    Arguments.of("""
                    
                    resolve {
                        schemaFileName = "asyncapi-schema"
                        schemaFilePath = "$targetFolderRoot/asyncapi/yaml"
                        schemaFileFormat = "yaml"
                        classNames = ['com.asyncapi.plugin.gradle.asyncapi.lamps.Lamps']
                        prettyPrint = false
                        classPath = sourceSets.main.runtimeClasspath
                    }
                """.trimIndent(), "generated/asyncapi/yaml/Lamps-asyncapi-schema.yaml", "/lamps-asyncapi.yaml"
                    )
            )
        }
    }

}