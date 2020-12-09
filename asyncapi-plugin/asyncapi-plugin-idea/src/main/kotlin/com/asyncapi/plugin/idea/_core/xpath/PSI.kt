package com.asyncapi.plugin.idea._core.xpath

import com.intellij.json.psi.JsonObject
import com.intellij.json.psi.JsonProperty
import com.intellij.psi.PsiElement

/**
 * @author Pavel Bodiachevskii
 */
object PSI {

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

    private fun exploreNodes(nodes: List<PsiElement>, nodeKey: String): MutableList<PsiElement> {
        val result = mutableListOf<PsiElement>()

        nodes.filterIsInstance(JsonProperty::class.java).forEach { jsonProperty ->
            if (nodeKey == "*") {
                result.add(jsonProperty.value as PsiElement)
            } else {
                if (jsonProperty.name == nodeKey) {
                    result.add(jsonProperty.value as PsiElement)
                }
            }
        }
        nodes.filterIsInstance(JsonObject::class.java).forEach { jsonObject ->
            jsonObject.children.filterIsInstance(JsonProperty::class.java).forEach { jsonProperty ->
                if (nodeKey == "*") {
                    result.add(jsonProperty.value as PsiElement)
                } else {
                    if (jsonProperty.name == nodeKey) {
                        result.add(jsonProperty.value as PsiElement)
                    }
                }
            }
        }

        return result
    }

}
