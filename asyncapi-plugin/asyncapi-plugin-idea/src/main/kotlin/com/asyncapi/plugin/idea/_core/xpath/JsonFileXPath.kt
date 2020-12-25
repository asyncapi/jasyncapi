package com.asyncapi.plugin.idea._core.xpath

import com.intellij.json.psi.JsonFile
import com.intellij.json.psi.JsonObject
import com.intellij.json.psi.JsonProperty
import com.intellij.psi.PsiElement

/**
 * Dummy implementation of XPath for [JsonFile].
 *
 * @author Pavel Bodiachevskii
 */
object JsonFileXPath: PsiFileXPath<JsonFile>() {

    override fun findPsi(asyncAPISchema: JsonFile?, psiXPath: String, partialMatch: Boolean): List<PsiElement> {
        asyncAPISchema ?: return emptyList()

        val tokens = tokenize(psiXPath)
        if (tokens.isEmpty()) {
            return emptyList()
        }

        var elements: List<PsiElement> = asyncAPISchema.children.filterIsInstance(JsonObject::class.java).flatMap {
            it.propertyList
        }

        tokens.forEach { token ->
            elements = exploreNodes(elements, token, partialMatch)
        }

        return elements
    }

    override fun findText(asyncAPISchema: JsonFile?, psiXPath: String, partialMatch: Boolean): List<String> {
        return findPsi(asyncAPISchema, psiXPath, partialMatch).map {
            it.text.removePrefix("\"").removeSuffix("\"")
        }
    }

    private fun exploreNodes(nodes: List<PsiElement>, nodeKey: String, partialMatch: Boolean = false): MutableList<PsiElement> {
        val result = mutableListOf<PsiElement>()

        result.addAll(nodes.filterIsInstance(JsonProperty::class.java).mapNotNull { checkProperty(it, nodeKey, partialMatch) })
        result.addAll(nodes.filterIsInstance(JsonObject::class.java).flatMap { it.propertyList }.mapNotNull { checkProperty(it, nodeKey, partialMatch) })

        return result
    }

    private fun checkProperty(jsonProperty: JsonProperty, expectedPropertyName: String, partialMatch: Boolean): PsiElement? {
        if (expectedPropertyName == "*") {
            return jsonProperty.value
        } else {
            if (partialMatch) {
                if (jsonProperty.name.contains(expectedPropertyName, true)) {
                    return jsonProperty.value
                }
            } else {
                if (jsonProperty.name == expectedPropertyName) {
                    return jsonProperty.value
                }
            }
        }

        return null
    }

}
