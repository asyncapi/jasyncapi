package com.asyncapi.plugin.idea._core

import com.asyncapi.plugin.idea._core.xpath.JsonFileXPath
import com.intellij.json.psi.JsonFile
import com.intellij.lang.Language
import com.intellij.psi.PsiFileFactory
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import junit.framework.TestCase

/**
 * @author Pavel Bodiachevskii
 */
class JsonFileXPathTest: BasePlatformTestCase() {

    fun test() {
        val psiFileFactory = PsiFileFactory.getInstance(project)
        val asyncAPISchema = this.javaClass.getResource("/asyncapi.json").readText()
        val asyncAPIPSI = psiFileFactory.createFileFromText(
                "asyncapi.json",
                Language.findLanguageByID("JSON")!!,
                asyncAPISchema
        ) as JsonFile

        collectReferencesToMessages(asyncAPIPSI)
        collectAsyncAPI(asyncAPIPSI)
    }

    private fun collectReferencesToMessages(asyncAPI: JsonFile) {
        val userSignedUp = listOf(
                "#/components/messages/UserSignedUp",
                "#/components/messages/UserSignedUp",
        )
        val userSignedOut = listOf(
                "#/components/messages/UserSignedOut",
                "#/components/messages/UserSignedOut",
        )
        val allReferences = userSignedUp + userSignedOut

        TestCase.assertEquals(allReferences, JsonFileXPath.findText(asyncAPI, "$.channels.*.*.message.\$ref"))
        TestCase.assertEquals(userSignedUp, JsonFileXPath.findText(asyncAPI, "$.channels.user/signedup.*.message.\$ref"))
        TestCase.assertEquals(userSignedOut, JsonFileXPath.findText(asyncAPI, "$.channels.user/signedout.*.message.\$ref"))
    }

    private fun collectAsyncAPI(asyncAPI: JsonFile) {
        TestCase.assertEquals(listOf("2.0.0"), JsonFileXPath.findText(asyncAPI, "$.asyncapi"))
    }

}