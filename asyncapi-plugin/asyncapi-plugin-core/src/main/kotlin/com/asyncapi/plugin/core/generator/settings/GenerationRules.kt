package com.asyncapi.plugin.core.generator.settings

import com.asyncapi.plugin.core.DefaultSchemaProperties

/**
 * AsyncAPI schema generation rules.
 *
 * @param includeNulls include null values to generated schema.
 * @param prettyPrint pretty print schema if it possible.
 */
data class GenerationRules(
        val includeNulls: Boolean = DefaultSchemaProperties.schemaIncludeNulls,
        val prettyPrint: Boolean = DefaultSchemaProperties.schemaPrettyPrint
)