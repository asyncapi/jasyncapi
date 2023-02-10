package com.asyncapi.v2._6_0.binding.message.ibmmq

import com.asyncapi.v2.ClasspathUtils
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class IBMMQMessageBindingTest {

    private val objectMapper = ObjectMapper()

    private fun build(): IBMMQMessageBinding {
        return IBMMQMessageBinding.builder()
                .type("jms")
                .description("JMS stream message")
                .headers("Content-Type: application/json")
                .expiry(0)
                .build()
    }

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/binding/message/ibmmq/ibmMQMessageBinding.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, IBMMQMessageBinding::class.java),
                build()
        )
    }

}