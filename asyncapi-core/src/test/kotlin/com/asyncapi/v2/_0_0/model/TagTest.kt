package com.asyncapi.v2._0_0.model

import com.asyncapi.v2.ClasspathUtils
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @author Pavel Bodiachevskii
 */
class TagTest {

    private val objectMapper = ObjectMapper()

    private fun buildTag(): Tag {
        return Tag(
                "user",
                "User-related messages",
                null
        )
    }

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/model/tag.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, Tag::class.java),
                buildTag()
        )
    }

}
