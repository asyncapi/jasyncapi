package com.asyncapi.plugin.idea.extensions.psi.reference

import com.asyncapi.plugin.idea._core.xpath.JsonFileXPath
import com.asyncapi.plugin.idea._core.xpath.YamlFileXPath
import com.intellij.codeInsight.completion.CompletionUtilCore
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.json.psi.JsonElement
import com.intellij.json.psi.JsonFile
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiManager
import com.intellij.psi.PsiReferenceBase
import org.jetbrains.yaml.psi.YAMLFile
import org.jetbrains.yaml.psi.YAMLPsiElement

/**
 * Reference to schema located in file.
 *
 * @author Pavel Bodiachevskii
 */
class AsyncAPIFileReference(
        private val psiElement: PsiElement,
        private val textRange: TextRange
): PsiReferenceBase<PsiElement>(psiElement, textRange) {

    override fun resolve(): PsiElement? {
        val fileReference = psiElement.text.replace(CompletionUtilCore.DUMMY_IDENTIFIER, "").trim()

        val fileLocation = extractFileLocation(fileReference)
        fileLocation ?: return null

        val file = findFile(fileLocation)
        file ?: return null

        val localReference = extractLocalReference(fileReference)
        localReference ?: return file

        val psiXPath = JsonFileXPath.compileXPath(localReference)
        return when (file) {
            is JsonFile -> JsonFileXPath.findPsi(file, psiXPath, false).firstOrNull()
            is YAMLFile -> YamlFileXPath.findPsi(file, psiXPath, false).firstOrNull()
            else -> null
        }
    }

    @Synchronized
    override fun getVariants(): Array<LookupElement> {
        val fileReference = psiElement.text.replace(CompletionUtilCore.DUMMY_IDENTIFIER, "").trim()

        val fileLocation = extractFileLocation(fileReference)
        fileLocation ?: return LookupElement.EMPTY_ARRAY

        val file = findFile(fileLocation)
        file ?: return LookupElement.EMPTY_ARRAY

        val localReference = extractLocalReference(fileReference)
        localReference ?: return LookupElement.EMPTY_ARRAY

        val psiXPath = JsonFileXPath.compileXPath(localReference)
        return when (file) {
            is JsonFile -> {
                val foundPsiElements = JsonFileXPath.findPsi(file, psiXPath, true)

                JsonFileVariantsProvider(
                        foundPsiElements.filterIsInstance<JsonElement>(),
                        file.containingFile.name,
                        psiXPath,
                        fileLocation
                ).variants()
            }
            is YAMLFile -> {
                val foundPsiElements = YamlFileXPath.findPsi(file, psiXPath, true)

                YamlFileVariantsProvider(
                        foundPsiElements.filterIsInstance<YAMLPsiElement>(),
                        file.containingFile.name,
                        psiXPath,
                        fileLocation
                ).variants()
            }
            else -> emptyArray()
        }
    }

    private fun extractFileLocation(fileReference: String): String? {
        return fileReference.removePrefix("\"").removeSuffix("\"").split("#/").firstOrNull()
    }

    private fun extractLocalReference(fileReference: String): String? {
        return fileReference.removePrefix("\"").removeSuffix("\"").split("#/").getOrNull(1)
    }

    private fun findFile(fileLocation: String): PsiFile? {
//        val rootDir = psiElement.containingFile?.virtualFile?.parent
        val rootDir = psiElement.containingFile?.originalFile?.virtualFile?.parent
        rootDir ?: return null

        val virtualFile = rootDir.findFileByRelativePath(fileLocation)
        virtualFile ?: return null

        return PsiManager.getInstance(psiElement.project).findFile(virtualFile)
    }

}