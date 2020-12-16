package com.asyncapi.plugin.idea.psi.reference

import com.intellij.codeInsight.completion.CompletionType
import com.intellij.testFramework.fixtures.BasePlatformTestCase


class JsonReferenceVariantsTest: BasePlatformTestCase() {

    override fun getTestDataPath(): String = "src/test/testData/json/reference/completion"

    fun `test co`() {
        myFixture.configureByFile("co.json")
        myFixture.complete(CompletionType.BASIC, 1)
        val variants = myFixture.lookupElementStrings ?: emptyList()

        assertTrue(listOf("#/components", "#/components/messages").containsAll(variants))
    }

    fun `test comp`() {
        myFixture.configureByFile("comp.json")
        myFixture.complete(CompletionType.BASIC, 1)
        val variants = myFixture.lookupElementStrings ?: emptyList()

        assertTrue(listOf("#/components", "#/components/messages").containsAll(variants))
    }

    fun `test components`() {
        myFixture.configureByFile("components.json")
        myFixture.complete(CompletionType.BASIC, 1)
        val variants = myFixture.lookupElementStrings ?: emptyList()

        assertTrue(listOf("#/components", "#/components/messages").containsAll(variants))
    }

    fun `test components_m`() {
        myFixture.configureByFile("components_m.json")
        myFixture.complete(CompletionType.BASIC, 1)
        val variants = myFixture.lookupElementStrings ?: emptyList()

        assertTrue(
                listOf(
                        "#/components/messages",
                        "#/components/messages/UserSignedUp",
                        "#/components/messages/UserSignedOut"
                ).containsAll(variants)
        )
    }

    fun `test components_messages_u`() {
        myFixture.configureByFile("components_messages_u.json")
        myFixture.complete(CompletionType.BASIC, 1)
        val variants = myFixture.lookupElementStrings ?: emptyList()

        assertTrue(
                listOf(
                        "#/components/messages/UserSignedUp",
                        "#/components/messages/UserSignedUp/payload",
                        "#/components/messages/UserSignedOut",
                        "#/components/messages/UserSignedOut/payload"
                ).containsAll(variants)
        )
    }

    fun `test i`() {
        myFixture.configureByFile("i.json")
        myFixture.complete(CompletionType.BASIC, 1)
        val variants = myFixture.lookupElementStrings ?: emptyList()

        assertTrue(
                listOf(
                        "#/info",
                        "#/info/title",
                        "#/info/version",
                        "#/info/description",
                        "#/asyncapi"
                ).containsAll(variants)
        )
    }

    fun `test in`() {
        myFixture.configureByFile("in.json")
        myFixture.complete(CompletionType.BASIC, 1)
        val variants = myFixture.lookupElementStrings ?: emptyList()

        assertTrue(
                listOf(
                        "#/info",
                        "#/info/title",
                        "#/info/version",
                        "#/info/description"
                ).containsAll(variants)
        )
    }

    fun `test inf`() {
        myFixture.configureByFile("inf.json")
        myFixture.complete(CompletionType.BASIC, 1)
        val variants = myFixture.lookupElementStrings ?: emptyList()

        assertTrue(
                listOf(
                        "#/info",
                        "#/info/title",
                        "#/info/version",
                        "#/info/description"
                ).containsAll(variants)
        )
    }

    fun `test `() {
        myFixture.configureByFile("_.json")
        myFixture.complete(CompletionType.BASIC, 1)
        val variants = myFixture.lookupElementStrings ?: emptyList()

        assertTrue(
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
                ).containsAll(variants)
        )
    }

    fun `test qwerty`() {
        myFixture.configureByFile("qwerty.json")
        myFixture.complete(CompletionType.BASIC, 1)
        val variants = myFixture.lookupElementStrings ?: emptyList()

        assertTrue("In case of wrong property name variants must be empty", variants.isEmpty())
    }

    fun `test 123`() {
        myFixture.configureByFile("123.json")
        myFixture.complete(CompletionType.BASIC, 1)
        val variants = myFixture.lookupElementStrings ?: emptyList()

        assertTrue("In case of wrong property name variants must be empty", variants.isEmpty())
    }

    fun `test $^^`() {
        myFixture.configureByFile("\$^^.json")
        myFixture.complete(CompletionType.BASIC, 1)
        val variants = myFixture.lookupElementStrings ?: emptyList()

        assertTrue("In case of wrong property name variants must be empty", variants.isEmpty())
    }

    fun `test referenced file`() {
        myFixture.configureByFiles("reference.json", "ref.json")
        myFixture.complete(CompletionType.BASIC, 1)
        val variants = myFixture.lookupElementStrings ?: emptyList()

        assertEquals(listOf("./ref.json#/reference"), variants)
    }

}