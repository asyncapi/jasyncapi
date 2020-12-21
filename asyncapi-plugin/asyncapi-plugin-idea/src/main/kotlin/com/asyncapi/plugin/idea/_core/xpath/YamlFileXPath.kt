package com.asyncapi.plugin.idea._core.xpath

import com.intellij.psi.PsiElement
import org.jetbrains.yaml.psi.YAMLFile
import org.jetbrains.yaml.psi.YAMLKeyValue
import org.jetbrains.yaml.psi.YAMLMapping

/**
 * Dummy implementation of XPath for [YAMLFile]
 *
 * @author Pavel Bodiachevskii
 */
object YamlFileXPath: PsiFileXPath<YAMLFile>() {

    override fun findText(asyncAPISchema: YAMLFile?, psiXPath: String, partialMatch: Boolean): List<String> {
        return findPsi(asyncAPISchema, psiXPath, partialMatch).map {
            it.text.removePrefix("\"").removeSuffix("\"")
        }
    }

    override fun findPsi(asyncAPISchema: YAMLFile?, psiXPath: String, partialMatch: Boolean): List<PsiElement> {
        asyncAPISchema ?: return emptyList()

        val tokens = tokenize(psiXPath)
        if (tokens.isEmpty()) {
            return emptyList()
        }

        var elements: List<PsiElement> = asyncAPISchema.documents.flatMap { it.yamlElements }

        tokens.forEach { token ->
            elements = exploreNodes(elements, token, partialMatch)
        }

        return elements
    }

    private fun exploreNodes(nodes: List<PsiElement>, nodeKey: String, partialMatch: Boolean = false): List<PsiElement> {
        val result = mutableListOf<PsiElement>()

        result.addAll(nodes.filterIsInstance<YAMLKeyValue>().mapNotNull { checkProperty(it, nodeKey, partialMatch) })
        result.addAll(nodes.filterIsInstance<YAMLMapping>().flatMap { it.keyValues }.mapNotNull { checkProperty(it, nodeKey, partialMatch) })

        return result
    }

    private fun checkProperty(yamlKeyValue: YAMLKeyValue, expectedPropertyName: String, partialMatch: Boolean): PsiElement? {
        if (expectedPropertyName == "*") {
            return yamlKeyValue.value
        } else {
            if (partialMatch) {
                if (yamlKeyValue.keyText.contains(expectedPropertyName)) {
                    return yamlKeyValue.value
                }
            } else {
                if (yamlKeyValue.keyText == expectedPropertyName) {
                    return yamlKeyValue.value
                }
            }
        }

        return null
    }

}
