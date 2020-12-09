package com.asyncapi.plugin.idea.extensions.psi.reference.contributor.json

import com.asyncapi.plugin.idea.extensions.psi.reference.provider.json.AsyncAPILocalReferenceProvider
import com.intellij.json.psi.JsonLiteral
import com.intellij.json.psi.JsonProperty
import com.intellij.patterns.PlatformPatterns
import com.intellij.patterns.PsiElementPattern
import com.intellij.patterns.StandardPatterns
import com.intellij.psi.PsiReferenceContributor
import com.intellij.psi.PsiReferenceRegistrar

/**
 * @author Pavel Bodiachevskii
 */
class AsyncAPISchemaReferenceContributor: PsiReferenceContributor() {

    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(localReferencePattern(), AsyncAPILocalReferenceProvider())
    }

    private fun localReferencePattern(): PsiElementPattern.Capture<JsonLiteral> {
        val expectedChild = PlatformPatterns.psiElement(JsonLiteral::class.java)
                .withText(StandardPatterns.string().contains("#/"))

        val expectedParent = PlatformPatterns.psiElement(JsonProperty::class.java)
                .withName("\$ref")
                .withChild(expectedChild)

        return expectedChild.withParent(expectedParent)
    }

}