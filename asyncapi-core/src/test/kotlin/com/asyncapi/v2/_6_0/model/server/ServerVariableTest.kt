package com.asyncapi.v2._6_0.model.server

import com.asyncapi.v2.ClasspathUtils
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @version 2.6.0
 * @author Pavel Bodiachevskii
 */
class ServerVariableTest {

    private val objectMapper = ObjectMapper()

    private fun build(): ServerVariable {
        return ServerVariable.builder()
                .enumValues(listOf("8883", "8884"))
                .description("To which port connect")
                .defaultValue("8883")
                .examples(listOf("8883", "8884"))
                .build()
    }

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/model/server/serverVariable.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, ServerVariable::class.java),
                build()
        )
    }

}
