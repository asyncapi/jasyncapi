package com.asyncapi.plugin.idea._core.xpath

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile

/**
 * Dummy implementation of XPath for [PsiFile].
 *
 * @author Pavel Bodiachevskii
 */
abstract class PsiFileXPath<AsyncAPISchema: PsiFile> {

    /**
     * Converts schema reference to PSI XPath.
     * For example: #/components/messages will be compiled as $.components.messages
     *
     * @param schemaReference to compile as PSI xpath.
     */
    fun compileXPath(schemaReference: String): String {
        return schemaReference
                .removePrefix("\"")
                .removeSuffix("\"")
                .replace("#/", "")
                .split("/")
                .joinToString(".", "$.", "")
    }

    /**
     * Search for [PsiElement] by given xpath.
     *
     * @param asyncAPISchema [PsiFile] to inspect.
     * @param psiXPath PSI XPath to execute.
     * @param partialMatch is partial match allowed.
     *
     * @return list of [PsiElement.getText] for each found [PsiElement] or empty.
     */
    abstract fun findText(asyncAPISchema: AsyncAPISchema?, psiXPath: String, partialMatch: Boolean = false): List<String>

    /**
     * Search for [PsiElement] text by given xpath.
     *
     * @param asyncAPISchema [PsiFile] to inspect.
     * @param psiXPath PSI XPath to execute.
     * @param partialMatch is partial match allowed.
     *
     * @return list of found [PsiElement] or empty.
     */
    abstract fun findPsi(asyncAPISchema: AsyncAPISchema?, psiXPath: String, partialMatch: Boolean = false): List<PsiElement>

    /**
     * Split psiXPath to tokens.
     *
     * @return list of tokens or empty
     */
    protected fun tokenize(psiXPath: String): List<String> {
        return psiXPath.replace("$.", "").split(".")
    }

}