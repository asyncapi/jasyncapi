package com.asyncapi.plugin.idea._core.xpath

import org.jetbrains.yaml.psi.*

/**
 * @author Pavel Bodiachevskii
 */
object PSI_yaml {

    fun find(yamlFile: YAMLFile?, path: String): List<String> {
        yamlFile ?: return emptyList()
        val tokens = path.replace("$.", "").split(".")
        var keyValuesToInspect = mutableListOf<YAMLPsiElement>()

        yamlFile.documents.forEach { yamlDocument ->
            // YAMLBlockMappingImpl
            yamlDocument.yamlElements.filterIsInstance<YAMLMapping>().forEach { yamlBlockMapping ->
                keyValuesToInspect.addAll(yamlBlockMapping.keyValues)
            }
        }

        val tokensIterator = tokens.iterator()
        while (tokensIterator.hasNext()) {
            keyValuesToInspect = explore(keyValuesToInspect, tokensIterator.next())
        }

        return keyValuesToInspect.map { it.text }.map { it.removePrefix("\"").removeSuffix("\"") }
    }

    /*
        YAMLKeyValue values:
            * YAMLScalar - single value
            * YAMLSequence - collection
            * YAMLMapping - KeyValue
     */

    private fun explore(yamlPsiElements: List<YAMLPsiElement>, expectedKey: String): MutableList<YAMLPsiElement> {
        val foundYamlPsiElements = mutableListOf<YAMLPsiElement>()

        yamlPsiElements.filterIsInstance<YAMLMapping>().forEach { yamlMapping ->
            yamlMapping.keyValues.forEach forEach@{ yamlKeyValue ->
                if (expectedKey == "*") {
                    yamlKeyValue.value ?: return@forEach

                    foundYamlPsiElements.add(yamlKeyValue.value!!)
                } else if (yamlKeyValue.keyText == expectedKey) {
                    yamlKeyValue.value ?: return@forEach

                    foundYamlPsiElements.add(yamlKeyValue.value!!)
                }
            }
        }
        yamlPsiElements.filterIsInstance<YAMLKeyValue>().forEach forEach@{ yamlKeyValue ->
            if (expectedKey == "*") {
                yamlKeyValue.value ?: return@forEach

                foundYamlPsiElements.add(yamlKeyValue.value!!)
            } else if (yamlKeyValue.keyText == expectedKey) {
                yamlKeyValue.value ?: return@forEach

                foundYamlPsiElements.add(yamlKeyValue.value!!)
            }
        }

        return foundYamlPsiElements
    }

}
