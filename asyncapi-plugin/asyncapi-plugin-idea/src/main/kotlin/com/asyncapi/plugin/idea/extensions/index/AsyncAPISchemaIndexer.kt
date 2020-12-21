package com.asyncapi.plugin.idea.extensions.index

import com.asyncapi.plugin.idea._core.AsyncAPISchemaReferencesCollector
import com.asyncapi.plugin.idea._core.xpath.JsonFileXPath
import com.asyncapi.plugin.idea._core.xpath.YamlFileXPath
import com.intellij.json.psi.JsonFile
import com.intellij.psi.PsiFile
import com.intellij.util.indexing.DataIndexer
import com.intellij.util.indexing.FileContent
import org.jetbrains.yaml.psi.YAMLFile

/**
 * @author Pavel Bodiachevskii
 */
class AsyncAPISchemaIndexer: DataIndexer<String, Set<String>, FileContent> {

    override fun map(inputData: FileContent): MutableMap<String, Set<String>> {
        val index = mutableMapOf<String, Set<String>>()

        if (!isAsyncAPISchema(inputData.psiFile)) {
            return index
        }

        index[AsyncAPISchemaIndex.asyncapi] = setOf(inputData.file.path)
        AsyncAPISchemaReferencesCollector(inputData.psiFile as? JsonFile).collectFiles().forEach { (referenceType, references) ->
            index[referenceType] = references
        }

        return index
    }

    private fun isAsyncAPISchema(inputData: PsiFile): Boolean {
        if (inputData !is JsonFile || inputData !is YAMLFile) {
            return false
        }

        val psiXPath = "$.asyncapi"
        val asyncapi: String? = when (inputData::class) {
            is JsonFile -> JsonFileXPath.findText(inputData, psiXPath).firstOrNull()
            is YAMLFile -> YamlFileXPath.findText(inputData, psiXPath).firstOrNull()
            else -> ""
        }

        return asyncapi == "2.0.0"
    }

}