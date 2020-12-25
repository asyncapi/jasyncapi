package com.asyncapi.plugin.idea.extensions.psi.reference

import com.asyncapi.plugin.idea._core.xpath.JsonFileXPath
import com.asyncapi.plugin.idea._core.xpath.YamlFileXPath
import com.intellij.codeInsight.completion.CompletionUtilCore
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.json.psi.JsonElement
import com.intellij.json.psi.JsonFile
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase
import org.jetbrains.yaml.psi.YAMLFile
import org.jetbrains.yaml.psi.YAMLPsiElement

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

//    val key = element.text.substring(textRange.startOffset, textRange.endOffset)

    override fun resolve(): PsiElement? {
        val psiPath = JsonFileXPath.compileXPath(psiElement.text).replace(CompletionUtilCore.DUMMY_IDENTIFIER, "").trim()

        val variants = when (val containingFile = psiElement.containingFile) {
            is JsonFile -> JsonFileXPath.findPsi(containingFile as? JsonFile, psiPath)
            is YAMLFile -> YamlFileXPath.findPsi(containingFile as? YAMLFile, psiPath)
            else -> emptyList()
        }

        return if (variants.isEmpty()) {
            null
        } else {
            variants[0]
        }
    }

    override fun getVariants(): Array<LookupElement> {
//        val lookupString = key.replace(CompletionUtilCore.DUMMY_IDENTIFIER, "").trim()
        val psiPath = JsonFileXPath.compileXPath(psiElement.text).replace(CompletionUtilCore.DUMMY_IDENTIFIER, "").trim()

        return when (val containingFile = psiElement.containingFile) {
            is JsonFile -> {
                val psiElements = JsonFileXPath.findPsi(containingFile as? JsonFile, psiPath, true)
                JsonFileVariantsProvider(
                        psiElements.filterIsInstance<JsonElement>(),
                        element.containingFile.name,
                        psiPath
                ).variants()
            }
            is YAMLFile -> {
                val psiElements = YamlFileXPath.findPsi(containingFile as? YAMLFile, psiPath, true)
                YamlFileVariantsProvider(
                        psiElements.filterIsInstance<YAMLPsiElement>(),
                        element.containingFile.name,
                        psiPath
                ).variants()
            }
            else -> emptyArray()
        }
    }

}