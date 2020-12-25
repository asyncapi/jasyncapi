package com.asyncapi.plugin.idea._core

import com.asyncapi.plugin.idea._core.xpath.YamlFileXPath
import com.intellij.lang.Language
import com.intellij.psi.PsiFileFactory
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import junit.framework.TestCase
import org.jetbrains.yaml.YAMLLanguage
import org.jetbrains.yaml.psi.YAMLFile

/**
 * @author Pavel Bodiachevskii
 */
class YamlFileXPathTest: BasePlatformTestCase() {

    fun test() {
        val psiFileFactory = PsiFileFactory.getInstance(project)
        val asyncAPISchema = this.javaClass.getResource("/asyncapi.yaml").readText()
        val asyncAPIPSI = psiFileFactory.createFileFromText(
                "asyncapi.yaml",
                Language.findInstance(YAMLLanguage::class.java),
                asyncAPISchema
        ) as YAMLFile

        collectReferencesToMessages(asyncAPIPSI)
        collectAsyncAPI(asyncAPIPSI)
    }

    private fun collectReferencesToMessages(asyncAPI: YAMLFile) {
        val userSignedUp = listOf(
                "#/components/messages/UserSignedUp",
                "#/components/messages/UserSignedUp",
        )
        val userSignedOut = listOf(
                "#/components/messages/UserSignedOut",
                "#/components/messages/UserSignedOut",
        )
        val allReferences = userSignedUp + userSignedOut

        TestCase.assertEquals(allReferences, YamlFileXPath.findText(asyncAPI, "$.channels.*.*.message.\$ref"))
        TestCase.assertEquals(userSignedUp, YamlFileXPath.findText(asyncAPI, "$.channels.user/signedup.*.message.\$ref"))
        TestCase.assertEquals(userSignedOut, YamlFileXPath.findText(asyncAPI, "$.channels.user/signedout.*.message.\$ref"))
    }

    private fun collectAsyncAPI(asyncAPI: YAMLFile) {
        TestCase.assertEquals(listOf("2.0.0"), YamlFileXPath.findText(asyncAPI, "$.asyncapi"))
    }

}