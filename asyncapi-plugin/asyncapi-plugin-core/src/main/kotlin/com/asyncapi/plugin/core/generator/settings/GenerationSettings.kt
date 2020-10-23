package com.asyncapi.plugin.core.generator.settings

import com.asyncapi.plugin.core.logging.Logger

data class GenerationSettings(
        val logger: Logger,
        val sources: GenerationSources,
        val rules: GenerationRules,
        val schemaFile: SchemaFileSettings
)