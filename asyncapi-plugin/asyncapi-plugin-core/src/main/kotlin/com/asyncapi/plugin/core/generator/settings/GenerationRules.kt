package com.asyncapi.plugin.core.generator.settings

/**
 * AsyncAPI schema generation rules.
 *
 * @param avoidNulls include null values to generated schema.
 * @param prettyPrint pretty print schema if it possible.
 */
data class GenerationRules(
        val avoidNulls: Boolean = true,
        val prettyPrint: Boolean = true
)