package com.asyncapi.v2.model.info

import com.asyncapi.v2.ClasspathUtils
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @author Pavel Bodiachevskii
 */
class InfoTest {

    private val objectMapper = ObjectMapper()

    private fun buildContact(): Contact {
        return objectMapper.readValue(
                ClasspathUtils.readAsString("/json/model/info/contact.json"),
                Contact::class.java
        )
    }

    private fun buildLicense(): License {
        return objectMapper.readValue(
                ClasspathUtils.readAsString("/json/model/info/license.json"),
                License::class.java
        )
    }

    private fun buildInfo(): Info {
        return Info(
                "AsyncApi sample",
                "2.0",
                "short description",
                "https://www.asyncapi.com/about/",
                buildContact(),
                buildLicense(),
                emptyMap()
        )
    }

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/model/info/info.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, Info::class.java),
                buildInfo()
        )
    }

}
