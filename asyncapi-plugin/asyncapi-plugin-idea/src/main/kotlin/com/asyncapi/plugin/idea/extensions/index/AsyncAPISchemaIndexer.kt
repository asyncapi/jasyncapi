package com.asyncapi.plugin.idea.extensions.index

import com.asyncapi.plugin.idea._core.AsyncAPISchemaReferences
import com.asyncapi.plugin.idea._core.xpath.PSI
import com.intellij.util.indexing.DataIndexer
import com.intellij.util.indexing.FileContent
import com.jayway.jsonpath.JsonPath
import org.jetbrains.yaml.YAMLFileType

/**
 * @author Pavel Bodiachevskii
 */
class AsyncAPISchemaIndexer: DataIndexer<String, Set<String>, FileContent> {

    /*
        Fastest way is to use existing json path instead of implementing own for idea's psiFile.
        But potential OOM and performance degradation may occur
    */

    override fun map(inputData: FileContent): MutableMap<String, Set<String>> {
        val index = mutableMapOf<String, Set<String>>()
        val asyncapiSchemaDir = inputData.file.parent

        if (inputData.fileType is YAMLFileType) {
            return index
        }

        if (!isAsyncAPISchema(inputData)) {
            return index
        }

        index[AsyncAPISchemaIndex.asyncapi] = setOf(inputData.file.name)
        val asyncAPISchemaReferences = AsyncAPISchemaReferences(inputData.contentAsText.toString())
        PSI.find(inputData.psiFile, "$.info.description")

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

    private fun isAsyncAPISchema(inputData: FileContent): Boolean {
        return try {
            JsonPath.compile("$.asyncapi").read<String>(inputData.contentAsText.toString())

            true
        } catch (e: Exception) {
            false
        }
    }

}