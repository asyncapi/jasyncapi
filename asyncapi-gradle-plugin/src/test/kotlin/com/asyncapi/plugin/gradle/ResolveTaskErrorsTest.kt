package com.asyncapi.plugin.gradle


import org.gradle.testkit.runner.GradleRunner
import org.junit.jupiter.api.*
import org.junit.jupiter.api.io.TempDir
import java.io.File
import java.io.StringWriter

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
open class ResolveTaskErrorsTest {

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

    @Test
    @DisplayName("check exception in case of empty packageNames and classNames")
    fun checkEmptyPackageNamesAndClassNamesExceptionTest() {
        buildGradleFile.appendText("""
            
            resolve {
            }
        """.trimIndent(), Charsets.UTF_8)

        val errorWriter = StringWriter()
        try {
            GradleRunner.create()
                    .withPluginClasspath()
                    .withProjectDir(testProjectDirectory)
                    .withDebug(true)
                    .withArguments("resolve", "--stacktrace", "--info")
                    .forwardOutput()
                    .forwardStdError(errorWriter)
                    .build()

        } catch (exception: Exception) {
            /* Do nothing */
        }

        Assertions.assertTrue(errorWriter.buffer.contains("* What went wrong:\n" +
                "Execution failed for task ':resolve'.\n" +
                "> classNames or packageNames are required", true))
    }

    @Test
    @DisplayName("check exception in case of wrong schemaFileFormat")
    fun wrongSchemaFileFormatException() {
        buildGradleFile.appendText("""
            
            resolve {
                classNames = ['com.asyncapi.plugin.gradle.asyncapi.lamps.Lamps']
                schemaFileFormat = "text"
            }
        """.trimIndent(), Charsets.UTF_8)

        val errorWriter = StringWriter()
        try {
            GradleRunner.create()
                    .withPluginClasspath()
                    .withProjectDir(testProjectDirectory)
                    .withDebug(true)
                    .withArguments("resolve", "--stacktrace", "--info")
                    .forwardOutput()
                    .forwardStdError(errorWriter)
                    .build()

        } catch (exception: Exception) {
            /* Do nothing */
        }

        Assertions.assertTrue(errorWriter.buffer.contains("* What went wrong:\n" +
                "Execution failed for task ':resolve'.\n" +
                "> Can't serialize Lamps because schemaFileFormat=text not recognized", true))
    }

}