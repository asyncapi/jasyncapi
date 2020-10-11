package com.asyncapi.plugin.core.generator.settings

/**
 * Holds schema file settings.
 *
 * @param path where to store generated file.
 * @param format how to store file's content.
 * @param namePostfix file's name postfix.
 *
 * @author Pavel Bodiachevskii
 * @since 1.0.0-RC1
 */
data class SchemaFileSettings(
        val path: String,
        @Deprecated("unused", level = DeprecationLevel.WARNING)
        val format: String,
        val namePostfix: String
)