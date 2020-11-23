package com.asyncapi.plugin.core.generator.settings

/**
 * @author Pavel Bodiachevskii
 */
data class GenerationSources(
        val classes: Array<String>,
        val packages: Array<String>,
        val classLoader: ClassLoader
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as GenerationSources

        if (!classes.contentEquals(other.classes)) return false
        if (!packages.contentEquals(other.packages)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = classes.contentHashCode()
        result = 31 * result + packages.contentHashCode()
        return result
    }
}