package com.asyncapi.plugin.maven

import com.asyncapi.plugin.core.AsyncAPISchemaGenerator
import com.asyncapi.plugin.core.logging.Logger
import org.apache.maven.plugin.AbstractMojo
import org.apache.maven.plugin.MojoExecutionException
import org.apache.maven.plugins.annotations.LifecyclePhase
import org.apache.maven.plugins.annotations.Mojo
import org.apache.maven.plugins.annotations.Parameter
import org.apache.maven.plugins.annotations.ResolutionScope
import org.apache.maven.project.MavenProject
import java.io.File
import java.net.URL
import java.net.URLClassLoader

/**
 * @author Pavel Bodiachevskii
 */
@Mojo(name = "generate",
        defaultPhase = LifecyclePhase.COMPILE,
        requiresDependencyResolution = ResolutionScope.COMPILE,
        requiresDependencyCollection = ResolutionScope.COMPILE
)
class SchemaGeneratorMojo: AbstractMojo() {

    @Parameter(property = "classNames")
    private var classNames: Array<String> = emptyArray()
    @Parameter(property = "packageNames")
    private var packageNames: Array<String> = emptyArray()
    @Parameter(property = "schemaFilePath", defaultValue = "generated/asyncapi")
    private var schemaFilePath: String = "generated/asyncapi"
    @Parameter(property = "schemaFileName", defaultValue = "asyncapi")
    private var schemaFileName: String = "asyncapi"
    @Parameter(property = "schemaFileFormat", defaultValue = "json")
    private var schemaFileFormat: String = "json"
    @Parameter(property = "prettyPrint", defaultValue = "true")
    private var prettyPrint: Boolean = true
    @Parameter(property = "includeNulls", defaultValue = "false")
    private var includeNulls: Boolean = false

    @Parameter(defaultValue = "\${project}", required = true, readonly = true)
    lateinit var project: MavenProject

    override fun execute() {
        val asyncAPISchemaGenerator = object: AsyncAPISchemaGenerator(
                classNames, packageNames, includeNulls, prettyPrint, schemaFileName, schemaFileFormat, schemaFilePath
        ) {

            override fun resolveLogger(): Logger {
                return object: Logger {

                    override fun info(message: String) {
                        log.info(message)
                    }

                    override fun error(message: String) {
                        println(message)
                    }

                }

            }

            override fun resolveClassLoader(): ClassLoader {
                val urls = emptySet<URL>()

                project.runtimeClasspathElements.forEach {
                    urls.plus(File(it).toURI().toURL())
                }

                return URLClassLoader(urls.toTypedArray(), Thread.currentThread().contextClassLoader)
            }

        }

        try {
            asyncAPISchemaGenerator.generate()
        } catch (e: Exception) {
            throw MojoExecutionException("Can't generate schema: ${e.message}", e)
        }
    }

}