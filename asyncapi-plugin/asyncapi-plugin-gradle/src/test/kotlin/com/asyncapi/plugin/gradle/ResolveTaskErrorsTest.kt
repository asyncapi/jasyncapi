package com.asyncapi.plugin.gradle


import org.gradle.testkit.runner.GradleRunner
import org.junit.jupiter.api.*
import org.junit.jupiter.api.io.TempDir
import java.io.File
import java.io.StringWriter
import java.nio.file.Files
import java.nio.file.Paths

/**
 * @author Pavel Bodiachevskii
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
open class ResolveTaskErrorsTest {

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
        Assertions.assertTrue(File(ResolveTaskErrorsTest.targetFolderRoot).deleteRecursively())
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
                "> Can't generate schema: classNames or packageNames are required", true))
    }

    @Test
    @DisplayName("check exception in case of wrong schemaFileFormat")
    fun wrongSchemaFileFormatException() {
        buildGradleFile.appendText("""
            
            resolve {
                classNames = ['com.asyncapi.plugin.gradle.asyncapi.lamps.Lamps']
                classPath = sourceSets.main.runtimeClasspath
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
                "> Can't generate schema: schemaFileFormat=text not recognize", true))
    }

    companion object {
        private const val targetFolderRoot = "generated"
    }

}