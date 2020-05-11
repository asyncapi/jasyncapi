package com.asyncapi.v2.model

import com.asyncapi.v2.ClasspathUtils
import com.google.gson.GsonBuilder
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @author Pavel Bodiachevskii
 */
class ExternalDocumentationTest {

    private val gson = GsonBuilder().setPrettyPrinting().create()

    private fun buildExternalDocumentation(): ExternalDocumentation {
        return ExternalDocumentation(
                "Find more info here",
                "https://example.com"
        )
    }

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/model/externalDocumentation.json")

        Assertions.assertEquals(
                gson.fromJson(model, ExternalDocumentation::class.java),
                buildExternalDocumentation()
        )
    }

}
