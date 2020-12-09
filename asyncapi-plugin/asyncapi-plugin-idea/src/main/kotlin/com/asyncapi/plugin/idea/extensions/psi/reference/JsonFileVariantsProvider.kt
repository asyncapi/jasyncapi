package com.asyncapi.plugin.idea.extensions.psi.reference

import com.asyncapi.plugin.idea.extensions.icon.Icons
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.json.psi.JsonElement
import com.intellij.json.psi.JsonLiteral
import com.intellij.json.psi.JsonObject
import com.intellij.json.psi.JsonProperty

/**
 * @author Pavel Bodiachevskii
 */
// JsonReferenceVariantsProvider
class JsonFileVariantsProvider(
        private val foundJsonElements: List<JsonElement>,
        private val asyncAPISchemaName: String,
        private val psiXPath: String
) {

    fun variants(): Array<LookupElement> {
        val result = ArrayList<LookupElement>()

        result.addAll(inspectJsonObjects(foundJsonElements.filterIsInstance<JsonObject>()))
        result.addAll(inspectJsonStringLiterals(foundJsonElements.filterIsInstance<JsonLiteral>()))

        return result.toTypedArray()
    }

    private fun inspectJsonObjects(jsonObjects: List<JsonObject>): ArrayList<LookupElement> {
        val variants = ArrayList<LookupElement>()

        jsonObjects.forEach { foundJsonObject ->
            val parentName = resolveParentName(foundJsonObject)
            var restoredPath = convertToSchemaReferenceAndActualize(psiXPath)

            if (parentName.isNotBlank()) {
                restoredPath = restoredPath.plus("/$parentName")

                variants.add(buildVariant(restoredPath))
            }

            foundJsonObject.propertyList.forEach { nestedProperty ->
                variants.add(buildVariant("$restoredPath/${nestedProperty.name}"))
            }
        }

        return variants
    }

    private fun inspectJsonStringLiterals(jsonStringLiterals: List<JsonLiteral>): ArrayList<LookupElement> {
        val variants = ArrayList<LookupElement>()

        jsonStringLiterals.forEach { jsonStringLiteral ->
            val parentName = resolveParentName(jsonStringLiteral)
            var restoredPath = convertToSchemaReferenceAndActualize(psiXPath)

            if (parentName.isNotBlank()) {
                restoredPath = restoredPath.plus("/$parentName")

                variants.add(buildVariant(restoredPath))
            }
        }

        return variants
    }

    private fun resolveParentName(jsonObject: JsonElement): String {
        return (jsonObject.parent as? JsonProperty)?.name ?: ""
    }

    private fun convertToSchemaReferenceAndActualize(psiXPath: String): String {
        return psiXPath.replace("$", "#")
                .split(".")
                /*
                    Last element if it exists must be deleted.
                    It always will be an property which we are searching for.
                 */
                .dropLast(1)
                .joinToString("/")
    }

    private fun buildVariant(variant: String): LookupElement {
        return LookupElementBuilder.create(variant)
                .withCaseSensitivity(false)
                .withTypeText(asyncAPISchemaName)
                .withIcon(Icons.ASYNCAPI_ICON)
    }

}