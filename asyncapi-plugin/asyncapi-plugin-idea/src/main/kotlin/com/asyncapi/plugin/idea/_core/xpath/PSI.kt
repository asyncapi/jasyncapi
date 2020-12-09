package com.asyncapi.plugin.idea._core.xpath

import com.intellij.json.psi.JsonObject
import com.intellij.json.psi.JsonProperty
import com.intellij.psi.PsiElement

/**
 * @author Pavel Bodiachevskii
 */
object PSI {

    /**
     * Converts schema reference to PSI XPath.
     * For example: #/components/messages will be compiled as $.components.messages
     *
     * @param schemaReference to compile as PSI xpath.
     */
    fun compileXPath(schemaReference: String): String {
        return schemaReference
                .removePrefix("\"")
                .removeSuffix("\"")
                .replace("#/", "")
                .split("/")
                .joinToString(".", "$.", "")
    }

    /**
     * Converts PSI xpath to schema reference.
     * For example: $.components.messages will be compiled as #/components/messages
     *
     * @param xpath to compile as schema reference.
     */
    fun compileSchemaReference(xpath: String): String {
        return xpath
                .removePrefix("\"")
                .removeSuffix("\"")
                .replace("$", "")
                .split("/")
                .joinToString("/", "#/")
    }

    fun findPsiElements(psiElement: PsiElement, path: String, partialMatch: Boolean): List<PsiElement> {
        val tokens = tokenize(path)
        var nodes = mutableListOf<PsiElement>()

        /*
            Extracting root properties.
         */
        psiElement.children.filterIsInstance(JsonObject::class.java)
                .forEach { jsonObject ->
                    jsonObject.children.filterIsInstance<JsonProperty>().forEach { nodes.add(it) }
                }

        val iterator = tokens.iterator()
        while(iterator.hasNext()) {
            nodes = exploreNodes(nodes, iterator.next(), partialMatch)
        }

        return nodes
    }

    fun find(psiElement: PsiElement, path: String): List<String> {
        val tokens = path.replace("$.", "").split(".")
        var nodes = mutableListOf<PsiElement>()

        /*
            Extracting root properties.
         */
        psiElement.children.filterIsInstance(JsonObject::class.java)
                .forEach { jsonObject ->
                    jsonObject.children.filterIsInstance<JsonProperty>().forEach { nodes.add(it) }
                }

        val iterator = tokens.iterator()
        while(iterator.hasNext()) {
            nodes = exploreNodes(nodes, iterator.next())
        }

        return nodes.map { it.text ?: "" }.map { it.removePrefix("\"").removeSuffix("\"") }
    }

    private fun tokenize(path: String): List<String> {
        return path.replace("$.", "").split(".")
    }

    private fun exploreNodes(nodes: List<PsiElement>, nodeKey: String, partialMatch: Boolean = false): MutableList<PsiElement> {
        val result = mutableListOf<PsiElement>()

        nodes.filterIsInstance(JsonProperty::class.java).forEach { jsonProperty ->
            if (nodeKey == "*") {
                result.add(jsonProperty.value as PsiElement)
            } else {
                if (partialMatch) {
                    if (jsonProperty.name.contains(nodeKey, true)) {
                        result.add(jsonProperty.value as PsiElement)
                    }
                } else {
                    if (jsonProperty.name == nodeKey) {
                        result.add(jsonProperty.value as PsiElement)
                    }
                }
            }
        }
        nodes.filterIsInstance(JsonObject::class.java).forEach { jsonObject ->
            jsonObject.children.filterIsInstance(JsonProperty::class.java).forEach { jsonProperty ->
                if (nodeKey == "*") {
                    result.add(jsonProperty.value as PsiElement)
                } else {
                    if (partialMatch) {
                        if (jsonProperty.name.contains(nodeKey, true)) {
                            result.add(jsonProperty.value as PsiElement)
                        }
                    } else {
                        if (jsonProperty.name == nodeKey) {
                            result.add(jsonProperty.value as PsiElement)
                        }
                    }
                }
            }
        }

        return result
    }

}
