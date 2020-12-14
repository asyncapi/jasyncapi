package com.asyncapi.plugin.idea._core

import com.asyncapi.plugin.idea._core.xpath.PSI_yaml
import com.intellij.lang.Language
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import junit.framework.TestCase
import org.jetbrains.yaml.YAMLLanguage
import org.jetbrains.yaml.psi.YAMLFile

/**
 * @author Pavel Bodiachevskii
 */
class PSI_yamlTest: BasePlatformTestCase() {

    fun test() {
        val psiFileFactory = PsiFileFactory.getInstance(project)
        val asyncAPISchema = this.javaClass.getResource("/asyncapi.yaml").readText()
        val asyncAPIPSI = psiFileFactory.createFileFromText(
                "asyncapi.yaml",
                Language.findInstance(YAMLLanguage::class.java),
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

        TestCase.assertEquals(allReferences, PSI_yaml.find(asyncAPI as? YAMLFile, "$.channels.*.*.message.\$ref"))
        TestCase.assertEquals(userSignedUp, PSI_yaml.find(asyncAPI as? YAMLFile, "$.channels.user/signedup.*.message.\$ref"))
        TestCase.assertEquals(userSignedOut, PSI_yaml.find(asyncAPI as? YAMLFile, "$.channels.user/signedout.*.message.\$ref"))
    }

    private fun collectAsyncAPI(asyncAPI: PsiElement) {
        TestCase.assertEquals(listOf("2.0.0"), PSI_yaml.find(asyncAPI as? YAMLFile, "$.asyncapi"))
    }

}