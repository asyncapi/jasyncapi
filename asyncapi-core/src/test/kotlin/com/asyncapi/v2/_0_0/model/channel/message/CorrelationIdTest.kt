package com.asyncapi.v2._0_0.model.channel.message

import com.asyncapi.v2.ClasspathUtils
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @author Pavel Bodiachevskii
 */
class CorrelationIdTest {

    private val objectMapper = ObjectMapper()

    private fun buildParameter(): CorrelationId {
        return CorrelationId(
                "Default Correlation ID",
                "\$message.header#/correlationId"
        )
    }

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/model/channel/message/correlationId.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, CorrelationId::class.java),
                buildParameter()
        )
    }

}
