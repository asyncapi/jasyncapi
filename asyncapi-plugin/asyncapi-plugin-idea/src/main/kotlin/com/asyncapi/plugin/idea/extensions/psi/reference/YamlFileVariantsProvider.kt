package com.asyncapi.plugin.idea.extensions.psi.reference

import com.asyncapi.plugin.idea.extensions.icon.Icons
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import org.jetbrains.yaml.psi.YAMLKeyValue
import org.jetbrains.yaml.psi.YAMLMapping
import org.jetbrains.yaml.psi.YAMLPsiElement
import org.jetbrains.yaml.psi.YAMLScalar

/**
 * @author Pavel Bodiachevskii
 */
// JsonReferenceVariantsProvider
class YamlFileVariantsProvider(
        private val foundYamlElements: List<YAMLPsiElement>,
        private val asyncAPISchemaName: String,
        private val psiXPath: String,
        private val referencedFileLocation: String? = null
) {

    fun variants(): Array<LookupElement> {
        val result = ArrayList<LookupElement>()

        result.addAll(inspectYamlMappings(foundYamlElements.filterIsInstance<YAMLMapping>()))
        result.addAll(inspectYamlKeyValues(foundYamlElements.filterIsInstance<YAMLKeyValue>()))
        result.addAll(inspectYamlScalar(foundYamlElements.filterIsInstance<YAMLScalar>()))

        return result.toTypedArray()
    }

    private fun inspectYamlScalar(yamlScalars: List<YAMLScalar>): ArrayList<LookupElement> {
        val variants = ArrayList<LookupElement>()

        yamlScalars.forEach { yamlScalar ->
            val parentName = resolveParentName(yamlScalar)
            var restoredPath = convertToSchemaReferenceAndActualize(psiXPath)

            if (parentName.isNotBlank()) {
                restoredPath = restoredPath.plus("/$parentName")

                variants.add(buildVariant(restoredPath))
            }
        }

        return variants
    }

    private fun inspectYamlMappings(yamlMappings: List<YAMLMapping>): ArrayList<LookupElement> {
        val variants = ArrayList<LookupElement>()

        yamlMappings.forEach { foundYamlMapping ->
            val parentName = resolveParentName(foundYamlMapping)
            var restoredPath = convertToSchemaReferenceAndActualize(psiXPath)

            if (parentName.isNotBlank()) {
                restoredPath = restoredPath.plus("/$parentName")

                variants.add(buildVariant(restoredPath))
            }

            foundYamlMapping.keyValues.forEach { nestedProperty ->
                variants.add(buildVariant("$restoredPath/${nestedProperty.name}"))
            }
        }

        return variants
    }

    private fun inspectYamlKeyValues(yamlKeyValues: List<YAMLKeyValue>): ArrayList<LookupElement> {
        val variants = ArrayList<LookupElement>()

        yamlKeyValues.forEach { yamlKeyValue ->
            val parentName = resolveParentName(yamlKeyValue)
            var restoredPath = convertToSchemaReferenceAndActualize(psiXPath)

            if (parentName.isNotBlank()) {
                restoredPath = restoredPath.plus("/$parentName")

                variants.add(buildVariant(restoredPath))
            }
        }

        return variants
    }

    private fun resolveParentName(yamlPsiElement: YAMLPsiElement): String {
        return (yamlPsiElement.parent as? YAMLPsiElement)?.name ?: ""
    }

    private fun convertToSchemaReferenceAndActualize(psiXPath: String): String {
        val schemaReference = psiXPath.replace("$", "#")
                .split(".")
                /*
                    Last element if it exists must be deleted.
                    It always will be an property which we are searching for.
                 */
                .dropLast(1)
                .joinToString("/")

        return referencedFileLocation?.plus(schemaReference) ?: schemaReference
    }

    private fun buildVariant(variant: String): LookupElement {
        return LookupElementBuilder.create(variant)
                .withCaseSensitivity(false)
                .withTypeText(asyncAPISchemaName)
                .withIcon(Icons.ASYNCAPI_ICON)
    }

}