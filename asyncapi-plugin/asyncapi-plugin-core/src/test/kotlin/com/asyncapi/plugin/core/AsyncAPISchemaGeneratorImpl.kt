package com.asyncapi.plugin.core

import com.asyncapi.plugin.core.logging.Logger
import java.net.URLClassLoader

class AsyncAPISchemaGeneratorImpl(
        // sources to generate from
        private val classNames: Array<String> = emptyArray(),
        private val packageNames: Array<String> = emptyArray(),
        // generation preferences
        private val includeNulls: Boolean = false,
        private val prettyPrint: Boolean = true,
        // schema file preferences
        private val schemaFileNamePostfix: String = "asyncapi",
        private val schemaFileFormat: String = "json",
        private val schemaFilePath: String = "generated/asyncapi"
): AsyncAPISchemaGenerator(classNames, packageNames, includeNulls, prettyPrint, schemaFileNamePostfix, schemaFileFormat, schemaFilePath) {

    override fun resolveLogger(): Logger {
        return object: Logger {
            override fun info(message: String) {
                println(message)
            }
            override fun error(message: String) {
                println(message)
            }
        }
    }

    override fun resolveClassLoader(): ClassLoader {
        return URLClassLoader(emptyArray())
    }

}