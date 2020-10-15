package com.asyncapi.plugin.core.generator.strategy

import com.asyncapi.plugin.core.DefaultSchemaProperties
import com.asyncapi.plugin.core.generator.settings.GenerationRules
import com.asyncapi.plugin.core.generator.settings.GenerationSources
import com.asyncapi.plugin.core.generator.settings.SchemaFileSettings
import com.asyncapi.plugin.core.logging.Logger
import java.net.URLClassLoader

open class GenerationStrategyTest {

    protected val logger = object: Logger {
        override fun info(message: String) {
            println(message)
        }
    }

    protected fun composeGenerationSources(classes: Array<String> = emptyArray(),
                                           packages: Array<String> = emptyArray()): GenerationSources {
        return GenerationSources(classes, packages, URLClassLoader.getSystemClassLoader())
    }

    protected fun composeGenerationRules(includeNulls: Boolean = DefaultSchemaProperties.schemaIncludeNulls,
                                         prettyPrint: Boolean = DefaultSchemaProperties.schemaPrettyPrint): GenerationRules {
        return GenerationRules(includeNulls, prettyPrint)
    }

    protected fun composeSchemaFileSettings(path: String = DefaultSchemaProperties.filePath,
                                            namePostfix: String = DefaultSchemaProperties.fileNamePostfix): SchemaFileSettings {
        return SchemaFileSettings(path, namePostfix)
    }

}