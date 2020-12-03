package com.asyncapi.plugin.idea._core

import com.intellij.openapi.vfs.VirtualFile
import com.jayway.jsonpath.Configuration
import com.jayway.jsonpath.JsonPath

/**
 * @author Pavel Bodiachevskii
 */
class AsyncAPISchemaReferences(
        asyncapiJson: String
) {

    private val asyncapiJsonObject = Configuration.defaultConfiguration().jsonProvider().parse(asyncapiJson)

    fun extractReferencedFiles(references: List<String>, asyncapiSchemaDir: VirtualFile): List<String> {
        return references.asSequence().filter { !it.startsWith("#/") }
                .map { cutReferenceToPropertyIfExists(it) }
                .filter { it.endsWith(".json") || it.endsWith(".yaml") || it.endsWith(".yml") }
                .map { asyncapiSchemaDir.findFileByRelativePath(it)?.path ?: "" }
                .filter { it.isNotBlank() }
                .toList()
    }

    fun channels(): List<String> {
        return extractElements("\$.channels.*.\$ref")
    }

    fun parameters(): List<String> {
        return extractElements("\$.channels.*.parameters.*.\$ref", "\$.components.parameters.*.\$ref")
    }

    fun traits(): List<String> {
        return extractElements("\$.channels.*.subscribe.traits.*.\$ref", "\$.channels.*.publish.traits.*.\$ref", "\$.components.messages.*.traits.*.\$ref")
    }

    fun messages(): List<String> {
        return extractElements("\$.channels.*.subscribe.message.\$ref", "\$.channels.*.publish.message.\$ref", "\$.components.messages.*.\$ref")
    }

    fun schemas(): List<String> {
        return extractElements("\$.components.schemas.*.\$ref")
    }

    fun securitySchemes(): List<String> {
        return extractElements("\$.components.securitySchemes.*.\$ref")
    }

    fun correlationIds(): List<String> {
        return extractElements("\$.components.messages.*.correlationId.\$ref", "\$.components.messages.*.traits.*.correlationId.\$ref")
    }

    fun headers(): List<String> {
        return extractElements("\$.components.messages.*.headers.\$ref", "\$.components.messages.*.traits.*.headers.\$ref")
    }

    private fun extractElements(vararg jsonPaths: String): List<String> {
        val references = mutableListOf<String>()

        jsonPaths.forEach {
            try {
                references.addAll(JsonPath.read<List<String>>(asyncapiJsonObject, it))
            } catch (e: Exception) {
                /* do nothing */
            }
        }

        return references
    }

    private fun cutReferenceToPropertyIfExists(reference: String): String {
        if (reference.contains("#/")) {
            return reference.substring(0, reference.indexOf("#/"))
        }

        return reference
    }

}