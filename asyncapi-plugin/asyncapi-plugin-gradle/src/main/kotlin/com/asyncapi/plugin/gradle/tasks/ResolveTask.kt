package com.asyncapi.plugin.gradle.tasks

import com.asyncapi.plugin.core.AsyncAPISchemaGenerator
import com.asyncapi.plugin.core.logging.Logger
import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import org.gradle.api.tasks.Classpath
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.TaskAction
import java.io.File
import java.net.URLClassLoader

/**
 * @author Pavel Bodiachevskii
 */
open class ResolveTask: DefaultTask() {

    @get:Input
    var classNames: Array<String> = emptyArray()
    @get:Input
    var packageNames: Array<String> = emptyArray()
    @get:Input
    var schemaFileName: String = "asyncapi"
    @get:Input
    var schemaFileFormat: String = "json"
    @get:Input
    var schemaFilePath: String = "generated/asyncapi"
    @get:Input
    var includeNulls: Boolean = false
    @get:Input
    var prettyPrint: Boolean = true

    @Optional
    @get:Classpath
    var buildClasspath: Iterable<File> = emptySet()
    @get:Classpath
    var classPath: Iterable<File> = emptySet()

    @TaskAction
    @Throws(GradleException::class)
    fun resolve() {
        val asyncAPISchemaGenerator = object: AsyncAPISchemaGenerator(
                classNames, packageNames, includeNulls, prettyPrint, schemaFileName, schemaFileFormat, schemaFilePath
        ) {

            override fun resolveLogger(): Logger {
                return object: Logger {

                    override fun info(message: String) {
                        logger.info(message)
                    }

                    override fun error(message: String) {
                        logger.error(message)
                    }

                }
            }

            override fun resolveClassLoader(): ClassLoader {
                val classPathUrls = classPath.map {
                    try { it.toURI().toURL() } catch (exception: Exception) { throw GradleException("Can't create classpath for task: $name", exception) }
                }.toSet()
                val buildClasspathUrls = buildClasspath.map {
                    try { it.toURI().toURL() } catch (exception: Exception) { throw GradleException("Can't create classpath for task: $name", exception) }
                }.toSet()

                classPathUrls.plus(buildClasspathUrls)
                return URLClassLoader(classPathUrls.toTypedArray(), Thread.currentThread().contextClassLoader)
            }

        }

        try {
            asyncAPISchemaGenerator.generate()
        } catch (e: Exception) {
            throw GradleException("Can't generate schema: ${e.message}", e)
        }

    }

}