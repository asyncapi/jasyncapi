package com.asyncapi.v2.model

import com.asyncapi.v2.ClasspathUtils
import com.google.gson.GsonBuilder
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @author Pavel Bodiachevskii
 */
class TagTest {

    private val gson = GsonBuilder().setPrettyPrinting().create()

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
                gson.fromJson(model, Tag::class.java),
                buildTag()
        )
    }

}
