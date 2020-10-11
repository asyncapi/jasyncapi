package com.asyncapi.plugin.core.generator.exception

/**
 * Means that something went wrong while AsyncAPI schema generation.
 *
 * @author Pavel Bodiachevskii
 * @since 1.0.0-RC1
 */
class AsyncAPISchemaGenerationException(
        override val message: String?,
        override val cause: Throwable?
): Exception(message, cause)