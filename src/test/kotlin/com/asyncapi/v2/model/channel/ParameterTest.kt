package com.asyncapi.v2.model.channel

import com.asyncapi.v2.ClasspathUtils
import com.google.gson.GsonBuilder
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @author Pavel Bodiachevskii
 */
class ParameterTest {

    private val gson = GsonBuilder().setPrettyPrinting().create()

    private fun buildParameter(): Parameter {
        return Parameter(
                "Id of the user.",
                mapOf(Pair("type", "string")),
                "\$message.payload#/user/id"
        )
    }

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/model/channel/parameter.json")

        Assertions.assertEquals(
                gson.fromJson(model, Parameter::class.java),
                buildParameter()
        )
    }

}
