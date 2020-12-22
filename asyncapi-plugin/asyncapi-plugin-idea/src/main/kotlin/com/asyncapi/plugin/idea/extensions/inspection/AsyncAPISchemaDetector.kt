package com.asyncapi.plugin.idea.extensions.inspection

import com.asyncapi.plugin.idea.extensions.index.AsyncAPISchemaIndex
import com.intellij.json.psi.JsonFile
import com.intellij.psi.PsiFile
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.util.indexing.FileBasedIndex
import org.jetbrains.yaml.psi.YAMLFile

/**
 * @author Pavel Bodiachevskii
 */
class AsyncAPISchemaDetector {

    fun isAsyncAPIJsonSchema(psiFile: PsiFile?): Boolean {
        psiFile ?: return false
        if (psiFile !is JsonFile) {
            return false
        }

        return indexedAsyncAPISchemas(psiFile).contains(psiFile.virtualFile?.path)
    }

    fun isAsyncAPIYamlSchema(psiFile: PsiFile?): Boolean {
        psiFile ?: return false
        if (psiFile !is YAMLFile) {
            return false
        }

        return indexedAsyncAPISchemas(psiFile).contains(psiFile.virtualFile?.path)
    }

    fun isAsyncAPISchema(psiFile: PsiFile?): Boolean {
        psiFile ?: return false
        return when (psiFile) {
            is JsonFile -> return isAsyncAPIJsonSchema(psiFile)
            is YAMLFile -> return isAsyncAPIYamlSchema(psiFile)
            else -> false
        }
    }

    fun isReferencedAsyncAPIJsonSchema(psiFile: PsiFile?): Boolean {
        psiFile ?: return false
        if (psiFile !is JsonFile) {
            return false
        }

        return indexedReferencedAsyncAPISchemas(psiFile).contains(psiFile.virtualFile?.path)
    }

    fun isReferencedAsyncAPIYamlSchema(psiFile: PsiFile?): Boolean {
        psiFile ?: return false
        if (psiFile !is JsonFile) {
            return false
        }

        return indexedReferencedAsyncAPISchemas(psiFile).contains(psiFile.virtualFile?.path)
    }

    fun isReferencedAsyncAPISchema(psiFile: PsiFile?): Boolean {
        psiFile ?: return false
        return when (psiFile) {
            is JsonFile -> return isReferencedAsyncAPIJsonSchema(psiFile)
            is YAMLFile -> return isReferencedAsyncAPIYamlSchema(psiFile)
            else -> false
        }
    }

    private fun indexedAsyncAPISchemas(asyncapiSchema: PsiFile): List<String> {
        return FileBasedIndex.getInstance().getValues(
                AsyncAPISchemaIndex.asyncapiIndexId,
                AsyncAPISchemaIndex.asyncapi,
                GlobalSearchScope.allScope(asyncapiSchema.project)
        ).flatten()
    }

    private fun indexedReferencedAsyncAPISchemas(asyncapiSchema: PsiFile): List<String> {
        return FileBasedIndex.getInstance().getValues(
                AsyncAPISchemaIndex.asyncapiIndexId,
                AsyncAPISchemaIndex.references,
                GlobalSearchScope.allScope(asyncapiSchema.project)
        ).flatten()
    }

}