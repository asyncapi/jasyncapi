package com.asyncapi.plugin.core.generator

import com.asyncapi.plugin.core.generator.exception.AsyncAPISchemaGenerationException
import kotlin.jvm.Throws

/**
 * AsyncAPI schema generation strategy.
 *
 * @author Pavel Bodiachevskii
 * @since 1.0.0-RC1
 */
interface GenerationStrategy {

    /**
     * Generates AsyncAPI Schema.
     *
     * @throws AsyncAPISchemaGenerationException in case of schema generation issues.
     */
    @Throws(AsyncAPISchemaGenerationException::class)
    fun generate()

}