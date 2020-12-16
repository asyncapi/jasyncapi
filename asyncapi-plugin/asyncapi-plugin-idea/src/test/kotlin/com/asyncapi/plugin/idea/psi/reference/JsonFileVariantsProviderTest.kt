package com.asyncapi.plugin.idea.psi.reference

import com.asyncapi.plugin.idea._core.xpath.JsonFileXPath
import com.asyncapi.plugin.idea.extensions.psi.reference.JsonFileVariantsProvider
import com.intellij.json.psi.JsonElement
import com.intellij.json.psi.JsonFile
import com.intellij.lang.Language
import com.intellij.psi.PsiFileFactory
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import junit.framework.TestCase

/*
    LightPlatformCodeInsightTestCase
    LightCompletionTestCase
    CodeInsightFixtureTestCase
 */

/**
 * @author Pavel Bodiachevskii
 */
//class JsonSchemaReferenceCompletionTest: LightJavaCodeInsightFixtureTestCase() {
//class JsonSchemaReferenceCompletionTest: CompletionAutoPopupTestCase() {
//class JsonSchemaReferenceCompletionTest: BasePlatformTestCase() {
class JsonFileVariantsProviderTest: BasePlatformTestCase() {

    override fun getTestDataPath(): String {
        return "src/test/testData"
    }

    fun testCompletion() {
        val psiFileFactory = PsiFileFactory.getInstance(project)
        val asyncAPISchema = this.javaClass.getResource("/asyncapi.json").readText()
        val asyncAPIPSI = psiFileFactory.createFileFromText(
                "asyncapi.json",
                Language.findLanguageByID("JSON")!!,
                asyncAPISchema
        ) as JsonFile

        TestCase.assertEquals(listOf("#/components", "#/components/messages"), collectVariants("#/co", asyncAPIPSI))
        TestCase.assertEquals(listOf("#/components", "#/components/messages"), collectVariants("#/comp", asyncAPIPSI))
        TestCase.assertEquals(listOf("#/components", "#/components/messages"), collectVariants("#/components", asyncAPIPSI))
        TestCase.assertEquals(
                listOf(
                        "#/components/messages",
                        "#/components/messages/UserSignedUp",
                        "#/components/messages/UserSignedOut"
                ),
                collectVariants("#/components/m", asyncAPIPSI)
        )
        TestCase.assertEquals(
                listOf(
                        "#/components/messages/UserSignedUp",
                        "#/components/messages/UserSignedUp/payload",
                        "#/components/messages/UserSignedOut",
                        "#/components/messages/UserSignedOut/payload"
                ),
                collectVariants("#/components/messages/u", asyncAPIPSI)
        )

        TestCase.assertEquals(
                listOf(
                        "#/info",
                        "#/info/title",
                        "#/info/version",
                        "#/info/description",
                        "#/asyncapi"
                ),
                collectVariants("#/i", asyncAPIPSI)
        )
        TestCase.assertEquals(
                listOf(
                        "#/info",
                        "#/info/title",
                        "#/info/version",
                        "#/info/description",
                ),
                collectVariants("#/in", asyncAPIPSI)
        )
        TestCase.assertEquals(
                listOf(
                        "#/info",
                        "#/info/title",
                        "#/info/version",
                        "#/info/description",
                ),
                collectVariants("#/inf", asyncAPIPSI)
        )

        TestCase.assertEquals(
                listOf(
                        "#/info",
                        "#/info/title",
                        "#/info/version",
                        "#/info/description",
                        "#/channels",
                        "#/channels/user/signedup",
                        "#/channels/user/signedout",
                        "#/components",
                        "#/components/messages",
                        "#/asyncapi"
                ),
                collectVariants("#/", asyncAPIPSI)
        )

        TestCase.assertTrue("In case of wrong property name variants must be empty", collectVariants("#/qwerty", asyncAPIPSI).isEmpty())
        TestCase.assertTrue("In case of wrong property name variants must be empty", collectVariants("#/123", asyncAPIPSI).isEmpty())
        TestCase.assertTrue("In case of wrong property name variants must be empty", collectVariants("#/$%^^", asyncAPIPSI).isEmpty())
    }

    private fun collectVariants(xpath: String, schema: JsonFile): List<String> {
        val psiPath = JsonFileXPath.compileXPath(xpath)
        val foundPsiElements = JsonFileXPath.findPsi(schema, psiPath, true)

        return JsonFileVariantsProvider(
                foundPsiElements.filterIsInstance<JsonElement>(),
                schema.name,
                psiPath
        ).variants().map { it.lookupString }
    }

}