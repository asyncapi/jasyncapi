package com.asyncapi.plugin.core.generator.strategy

import com.asyncapi.plugin.core.DefaultSchemaProperties
import com.asyncapi.plugin.core.generator.settings.GenerationRules
import com.asyncapi.plugin.core.generator.settings.GenerationSources
import com.asyncapi.plugin.core.generator.settings.SchemaFileSettings
import com.asyncapi.plugin.core.logging.Logger
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import java.io.File
import java.net.URLClassLoader

open class GenerationStrategyTest {

    protected val logger = object: Logger {
        override fun info(message: String) {
            println(message)
        }
    }

    @BeforeEach
    private fun deleteGeneratedSchemas() {
        val defaultSchemasFolder = File(defaultPath.split("/")[0])
        val schemasFolder = File(customPath)

        if (defaultSchemasFolder.exists()) {
            defaultSchemasFolder.deleteRecursively()
        }

        if (schemasFolder.exists()) {
            schemasFolder.deleteRecursively()
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

    protected fun validateSchemaContent(schema: File, generationRules: GenerationRules, format: String) {
        val expectedSchemaName = schema.nameWithoutExtension.split("-")[0] + "-asyncapi.$format"
        val expectedSchemaPath = if (generationRules.prettyPrint) {
            if (generationRules.includeNulls) {
                "schemas/pretty-print/include-nulls"
            } else {
                "schemas/pretty-print/avoid-nulls"
            }
        } else {
            if (!generationRules.includeNulls) {
                "schemas/raw/include-nulls"
            } else {
                "schemas/raw/avoid-nulls"
            }
        }

        Assertions.assertEquals(
                this::class.java.getResource("/$expectedSchemaPath/$expectedSchemaName").readText(Charsets.UTF_8),
                File(schema.path).readText(Charsets.UTF_8),
                "Handwritten schema must be identical to generated."
        )
    }

    companion object {
        const val defaultPath = DefaultSchemaProperties.filePath
        const val customPath = "asyncapi-schemas"
    }

}