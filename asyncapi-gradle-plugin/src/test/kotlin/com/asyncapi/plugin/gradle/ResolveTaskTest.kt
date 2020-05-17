package com.asyncapi.plugin.gradle


import org.gradle.testkit.runner.GradleRunner
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.io.TempDir
import java.io.File

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
open class ResolveTaskTest {

    @JvmField @TempDir
    var testProjectDirectory: File? = null

    @Test
    fun test() {
        File(testProjectDirectory, "build.gradle")
                .writeText(this::class.java.getResource("/build.gradle").readText(Charsets.UTF_8))
        File(testProjectDirectory,"settings.gradle")
                .writeText(this::class.java.getResource("/settings.gradle").readText(Charsets.UTF_8))
        copySources()

        val executionResult = GradleRunner.create()
                .withPluginClasspath()
                .withProjectDir(testProjectDirectory)
                .withDebug(true)
                .withArguments("resolve", "--stacktrace", "--info")
                .forwardOutput()
                .build()

        val generatedSchemaFile = File("asyncapi-schemas/Lamps-asyncapi.json")
        val expectedSchema = this::class.java.getResource("/lamps-asyncapi.json").readText(Charsets.UTF_8)

        Assertions.assertTrue(generatedSchemaFile.exists())
        Assertions.assertEquals(generatedSchemaFile.readText(Charsets.UTF_8), expectedSchema)
    }

    private fun copySources() {
//        val sourcePath = File("src/test/kotlin")
//
//        val srcFolder = File(testProjectDirectory, "src")
//        val srcTestFolder = File(srcFolder, "main")
//        val kotlinFolder = File(srcTestFolder, "kotlin")
//
//        sourcePath.copyRecursively(kotlinFolder, overwrite = true, onError = { file: File, ioException: IOException ->
//            println("File: ${file.name} error: ${ioException.message}")
//
//            OnErrorAction.SKIP
//        })
//
//        File(testProjectDirectory!!.path + "/src/main/kotlin/com/asyncapi/plugin/gradle/ResolveTaskTest.kt").delete()

//        testProjectDirectory!!.copyRecursively(File("src"))
//        val destinationPath = testProjectDirectory!!.toPath()
//
//        Files.walk(sourcePath).forEach {
//            println("Copy ${it.fileName} from '${it.toAbsolutePath()}' to '${destinationPath.resolve(sourcePath.relativize(it))}")
//
//            try {
//                Files.copy(it, destinationPath.resolve(sourcePath.relativize(it)))
//            } catch (exception: Exception) {
//                println("error: ${exception.message}")
//            }
//        }
    }

    fun foo(): String {
        return """
            plugins {
                id 'java'
                id 'com.asyncapi.asyncapi-gradle-plugin'
                id 'org.jetbrains.kotlin.jvm' version '1.3.61'
            }
            sourceSets {
                main {
                    java {
                        srcDirs('${File("src/test/kotlin").absolutePath}')
                        exclude('**/*Test.kt')
                    }
                }
                test {
                    java {
                        // srcDirs('${File("src/test/kotlin").absolutePath}')
                        exclude('**/*Test.kt')
                    }
                }
            }
            repositories {
                jcenter()
                mavenLocal()
                mavenCentral()
            }
            dependencies {
                implementation "com.asyncapi:asyncapi-core:1.0.0-SNAPSHOT"
                implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
            }
            resolve {
                classPath = sourceSets.test.runtimeClasspath + sourceSets.test.compileClasspath
            //    classPath = sourceSets.main.compileClasspath + sourceSets.main.runtimeClasspath
                classNames = ['com.asyncapi.plugin.gradle.asyncapi.lamps.Lamps']
            }
        """.trimIndent()
    }

}