package com.asyncapi.v2._0_0.model.info

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.v2._0_0.model.info.Contact
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @author Pavel Bodiachevskii
 */
class ContactTest {

    private val objectMapper = ObjectMapper()

    private fun buildContact(): Contact {
        return Contact(
                "AsyncApi",
                "https://www.asyncapi.com",
                "java@asyncapi.com"
        )
    }

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/model/info/contact.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, Contact::class.java),
                buildContact()
        )
    }

}
