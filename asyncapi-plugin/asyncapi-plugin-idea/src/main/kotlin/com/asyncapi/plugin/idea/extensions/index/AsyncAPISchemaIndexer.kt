package com.asyncapi.plugin.idea.extensions.index

import com.asyncapi.plugin.idea._core.AsyncAPISchemaReferences
import com.asyncapi.plugin.idea._core.xpath.JsonFileXPath
import com.intellij.json.psi.JsonFile
import com.intellij.psi.PsiFile
import com.intellij.util.indexing.DataIndexer
import com.intellij.util.indexing.FileContent
import org.jetbrains.yaml.YAMLFileType

/**
 * @author Pavel Bodiachevskii
 */
class AsyncAPISchemaIndexer: DataIndexer<String, Set<String>, FileContent> {

    override fun map(inputData: FileContent): MutableMap<String, Set<String>> {
        val index = mutableMapOf<String, Set<String>>()
        val asyncapiSchemaDir = inputData.file.parent

        if (inputData.fileType is YAMLFileType) {
            return index
        }

        if (!isAsyncAPISchema(inputData.psiFile)) {
            return index
        }

        index[AsyncAPISchemaIndex.asyncapi] = setOf(inputData.file.name)
        val asyncAPISchemaReferences = AsyncAPISchemaReferences(inputData.psiFile as? JsonFile)

        index[AsyncAPISchemaIndex.channels] = asyncAPISchemaReferences.extractReferencedFiles(asyncAPISchemaReferences.channels(), asyncapiSchemaDir).toSet()
        index[AsyncAPISchemaIndex.parameters] = asyncAPISchemaReferences.extractReferencedFiles(asyncAPISchemaReferences.parameters(), asyncapiSchemaDir).toSet()
        index[AsyncAPISchemaIndex.traits] = asyncAPISchemaReferences.extractReferencedFiles(asyncAPISchemaReferences.traits(), asyncapiSchemaDir).toSet()
        index[AsyncAPISchemaIndex.messages] = asyncAPISchemaReferences.extractReferencedFiles(asyncAPISchemaReferences.messages(), asyncapiSchemaDir).toSet()
        index[AsyncAPISchemaIndex.schemas] = asyncAPISchemaReferences.extractReferencedFiles(asyncAPISchemaReferences.schemas(), asyncapiSchemaDir).toSet()
        index[AsyncAPISchemaIndex.securitySchemes] = asyncAPISchemaReferences.extractReferencedFiles(asyncAPISchemaReferences.securitySchemes(), asyncapiSchemaDir).toSet()
        index[AsyncAPISchemaIndex.correlationIds] = asyncAPISchemaReferences.extractReferencedFiles(asyncAPISchemaReferences.correlationIds(), asyncapiSchemaDir).toSet()
        index[AsyncAPISchemaIndex.headers] = asyncAPISchemaReferences.extractReferencedFiles(asyncAPISchemaReferences.headers(), asyncapiSchemaDir).toSet()
        return index
    }

    private fun isAsyncAPISchema(inputData: PsiFile): Boolean {
        return JsonFileXPath.findText(inputData as JsonFile, "$.asyncapi").firstOrNull()?.contains("2.0.0") ?: false
    }

}