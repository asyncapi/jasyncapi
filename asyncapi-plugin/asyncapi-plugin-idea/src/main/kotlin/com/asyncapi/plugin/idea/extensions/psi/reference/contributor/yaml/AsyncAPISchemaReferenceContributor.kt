package com.asyncapi.plugin.idea.extensions.psi.reference.contributor.yaml

import com.asyncapi.plugin.idea.extensions.psi.reference.provider.yaml.AsyncAPIFileReferenceProvider
import com.asyncapi.plugin.idea.extensions.psi.reference.provider.yaml.AsyncAPILocalReferenceProvider
import com.intellij.patterns.PlatformPatterns
import com.intellij.patterns.PsiElementPattern
import com.intellij.patterns.StandardPatterns
import com.intellij.psi.PsiReferenceContributor
import com.intellij.psi.PsiReferenceRegistrar
import org.jetbrains.yaml.psi.YAMLKeyValue
import org.jetbrains.yaml.psi.YAMLQuotedText
import org.jetbrains.yaml.psi.YAMLValue

/**
 * @author Pavel Bodiachevskii
 */
class AsyncAPISchemaReferenceContributor: PsiReferenceContributor() {

    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(localReferencePattern(), AsyncAPILocalReferenceProvider())
        registrar.registerReferenceProvider(fileReferencePattern(), AsyncAPIFileReferenceProvider())
    }

    private fun localReferencePattern(): PsiElementPattern.Capture<YAMLQuotedText> {
        val expectedChild = PlatformPatterns.psiElement(YAMLQuotedText::class.java)
                .withText(StandardPatterns.string().contains("#/"))

        val expectedParent = PlatformPatterns.psiElement(YAMLKeyValue::class.java)
                .withName("\$ref")
                .withChild(expectedChild)

//        return expectedChild
        return expectedChild.withParent(expectedParent)
    }

    private fun fileReferencePattern(): PsiElementPattern.Capture<YAMLValue> {
        val expectedChild = PlatformPatterns.psiElement(YAMLValue::class.java)
                .withText(StandardPatterns.string().contains(".yaml"))

        val expectedParent = PlatformPatterns.psiElement(YAMLKeyValue::class.java)
                .withName("\$ref")
                .withChild(expectedChild)

        return expectedChild.withParent(expectedParent)
    }

}