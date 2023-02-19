package com.asyncapi.v2.model.channel

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.v2._0_0.model.channel.Parameter
import com.asyncapi.v2._0_0.model.schema.Schema
import com.asyncapi.v2._0_0.model.schema.Type
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @author Pavel Bodiachevskii
 */
class ParameterTest {

    private val objectMapper = ObjectMapper()

    private fun buildParameter(): Parameter {
        return Parameter(
                "Id of the user.",
                Schema.builder().type(Type.STRING).build(),
                "\$message.payload#/user/id",
                emptyMap()
        )
    }

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/model/channel/parameter.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, Parameter::class.java),
                buildParameter()
        )
    }

}
