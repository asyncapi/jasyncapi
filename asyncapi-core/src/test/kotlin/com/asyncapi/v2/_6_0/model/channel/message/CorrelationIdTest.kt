package com.asyncapi.v2._6_0.model.channel.message

import com.asyncapi.v2.ClasspathUtils
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CorrelationIdTest {

    private val objectMapper = ObjectMapper()

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/model/channel/message/correlationId.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, CorrelationId::class.java),
                build()
        )
    }

    companion object {
        @JvmStatic
        fun build(): CorrelationId {
            return CorrelationId.builder()
                    .description("Default Correlation ID")
                    .location("\$message.header#/correlationId")
                    .build()
        }
    }

}