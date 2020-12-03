package com.asyncapi.plugin.idea._core

import com.asyncapi.plugin.idea._core.xpath.PSI
import com.intellij.lang.Language
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import junit.framework.TestCase

/**
 * @author Pavel Bodiachevskii
 */
class PSITest: BasePlatformTestCase() {

    fun test() {
        val psiFileFactory = PsiFileFactory.getInstance(project)
        val asyncAPISchema = this.javaClass.getResource("/asyncapi.json").readText()
        val asyncAPIPSI = psiFileFactory.createFileFromText(
                "asyncapi.json",
                Language.findLanguageByID("JSON")!!,
                asyncAPISchema
        )

        collectReferencesToMessages(asyncAPIPSI)
        collectAsyncAPI(asyncAPIPSI)
    }

    private fun collectReferencesToMessages(asyncAPI: PsiElement) {
        val userSignedUp = listOf(
                "#/components/messages/UserSignedUp",
                "#/components/messages/UserSignedUp",
        )
        val userSignedOut = listOf(
                "#/components/messages/UserSignedOut",
                "#/components/messages/UserSignedOut",
        )
        val allReferences = userSignedUp + userSignedOut

        TestCase.assertEquals(allReferences, PSI.find(asyncAPI, "$.channels.*.*.message.\$ref"))
        TestCase.assertEquals(userSignedUp, PSI.find(asyncAPI, "$.channels.user/signedup.*.message.\$ref"))
        TestCase.assertEquals(userSignedOut, PSI.find(asyncAPI, "$.channels.user/signedout.*.message.\$ref"))
    }

    private fun collectAsyncAPI(asyncAPI: PsiElement) {
        TestCase.assertEquals(listOf("2.0.0"), PSI.find(asyncAPI, "$.asyncapi"))
    }

}