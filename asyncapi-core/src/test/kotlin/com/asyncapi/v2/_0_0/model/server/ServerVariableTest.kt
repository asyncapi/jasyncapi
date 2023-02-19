package com.asyncapi.v2._0_0.model.server

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.v2._0_0.model.server.ServerVariable
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @author Pavel Bodiachevskii
 */
class ServerVariableTest {

    private val objectMapper = ObjectMapper()

    private fun buildServerVariable(): ServerVariable {
        return ServerVariable.builder()
                .enumValues(listOf("8883", "8884"))
                .defaultValue("8883")
                .build()
    }

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/model/server/serverVariable.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, ServerVariable::class.java),
                buildServerVariable()
        )
    }

}
