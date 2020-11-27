package com.asyncapi.plugin.idea.extensions.inspection

import com.intellij.json.JsonLanguage
import com.intellij.json.psi.JsonObject
import com.intellij.psi.PsiFile
import org.jetbrains.yaml.YAMLLanguage
import org.jetbrains.yaml.psi.YAMLDocument
import org.jetbrains.yaml.psi.impl.YAMLKeyValueImpl

/**
 * @author Pavel Bodiachevskii
 */
class AsyncAPISchemaDetector {

    private val asyncapiKey = "asyncapi"
    private val asyncapiVersion = ".*(2(\\.\\d+)+)(?![\\d\\.]).*"

    fun isAsyncAPIYamlSchema(psiFile: PsiFile): Boolean {
        if (psiFile.language !is YAMLLanguage) {
            return false
        }

        val yamlElements = psiFile.children.filterIsInstance<YAMLDocument>().first().topLevelValue?.yamlElements
        val foundAsyncapiYamlPsiElement = yamlElements?.first { it.name.equals(asyncapiKey) }
        foundAsyncapiYamlPsiElement ?: return false
//        return yamlElements?.map { it.name }?.contains(asyncapiKey) ?: false

        return isAsyncAPI2((foundAsyncapiYamlPsiElement as YAMLKeyValueImpl).valueText)
    }

    fun isAsyncAPIJsonSchema(psiFile: PsiFile): Boolean {
        if (psiFile.language !is JsonLanguage) {
            return false
        }

        val jsonObject = psiFile.children.filterIsInstance<JsonObject>().first()
//        jsonObject.findProperty(asyncapiKey) ?: return false

//        return true
        return isAsyncAPI2(jsonObject.findProperty(asyncapiKey)?.value?.text ?: "")
    }

    private fun isAsyncAPI2(foundAsyncapiVersion: String): Boolean {
        return foundAsyncapiVersion.matches(Regex(asyncapiVersion))
    }

}