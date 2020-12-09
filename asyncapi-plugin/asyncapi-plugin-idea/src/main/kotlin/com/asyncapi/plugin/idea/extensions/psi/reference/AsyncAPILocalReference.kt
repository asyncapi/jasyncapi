package com.asyncapi.plugin.idea.extensions.psi.reference

import com.asyncapi.plugin.idea._core.xpath.PSI
import com.intellij.codeInsight.completion.CompletionUtilCore
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.json.psi.JsonElement
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase

/**
 * Reference to element inside current schema.
 *
 * @author Pavel Bodiachevskii
 *
 */
class AsyncAPILocalReference(private val psiElement: PsiElement, private val textRange: TextRange):
        PsiReferenceBase<PsiElement>(psiElement, textRange)
//        PsiPolyVariantReference
{

    val key = element.text.substring(textRange.startOffset, textRange.endOffset)

    override fun resolve(): PsiElement? {
        val variants = PSI.findPsiElements(psiElement.containingFile, PSI.compileXPath(psiElement.text), false)
        return if (variants.isEmpty()) {
            null
        } else {
            variants[0]
        }
    }

    override fun getVariants(): Array<LookupElement> {
        val lookupString = key.replace(CompletionUtilCore.DUMMY_IDENTIFIER, "").trim()
        val psiPath = PSI.compileXPath(psiElement.text).replace(CompletionUtilCore.DUMMY_IDENTIFIER, "").trim()

        val foundPsiElements = PSI.findPsiElements(psiElement.containingFile, psiPath, true)

        return JsonFileVariantsProvider(
                foundPsiElements.filterIsInstance<JsonElement>(),
                element.containingFile.name,
                psiPath
        ).variants()
    }

}