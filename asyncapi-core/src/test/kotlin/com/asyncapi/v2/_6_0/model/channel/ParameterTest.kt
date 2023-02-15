package com.asyncapi.v2._6_0.model.channel

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.v2._6_0.model.Reference
import com.asyncapi.v2._6_0.model.schema.Schema
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ParameterTest {

    private val objectMapper = ObjectMapper()

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun schemaReference() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/model/channel/parameter with reference to schema.json")

        val parameter = build()
        parameter.schema = Reference("#/components/schemas/userId")
        Assertions.assertEquals(
                objectMapper.readValue(model, Parameter::class.java),
                parameter
        )
    }

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun schema() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/model/channel/parameter with schema.json")

        val parameter = build()
        parameter.schema = Schema.builder().type("string").build()
        Assertions.assertEquals(
                objectMapper.readValue(model, Parameter::class.java),
                parameter
        )
    }

    companion object {
        @JvmStatic
        fun build(): Parameter {
            return Parameter.builder()
                    .description("Id of the user.")
                    .location("\$message.payload#/user/id")
                    .build()
        }

        fun buildWithSchema(): Parameter {
            val parameter = build()
            parameter.schema = Schema.builder().type("string").build()

            return parameter
        }

        fun buildWithSchemaReference(): Parameter {
            val parameter = build()
            parameter.schema = Reference("#/components/schemas/userId")

            return parameter
        }
    }

}