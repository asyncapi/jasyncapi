package com.asyncapi.plugin.idea.extensions.psi.reference.provider.json

import com.asyncapi.plugin.idea.extensions.psi.reference.AsyncAPILocalReference
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceProvider
import com.intellij.util.ProcessingContext

/**
 * @author Pavel Bodiachevskii
 */
class AsyncAPILocalReferenceProvider: PsiReferenceProvider() {

    override fun getReferencesByElement(element: PsiElement, context: ProcessingContext): Array<PsiReference> {
        /* experimental */
        val value = element.text.removePrefix("\"").removeSuffix("\"")
        val textRange = TextRange(1, value.length + 1)
        /* experimental */

        return arrayOf(AsyncAPILocalReference(element, textRange))
    }

}