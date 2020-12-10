package com.asyncapi.plugin.idea.extensions.psi.reference

import com.asyncapi.plugin.idea._core.xpath.PSI
import com.intellij.codeInsight.completion.CompletionUtilCore
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.json.psi.JsonElement
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiManager
import com.intellij.psi.PsiReferenceBase

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

        val psiXPath = PSI.compileXPath(localReference)
        return PSI.findPsiElements(file as PsiElement, psiXPath, false).firstOrNull()
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

        val psiXPath = PSI.compileXPath(localReference)
        val foundPsiElements = PSI.findPsiElements(file as PsiElement, psiXPath, true)

        return JsonFileVariantsProvider(
                foundPsiElements.filterIsInstance<JsonElement>(),
                file.containingFile.name,
                psiXPath,
                fileLocation
        ).variants()
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