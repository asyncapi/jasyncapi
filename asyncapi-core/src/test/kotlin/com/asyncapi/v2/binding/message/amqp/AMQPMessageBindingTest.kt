package com.asyncapi.v2._6_0.binding.message.amqp

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.v2.binding.message.amqp.AMQPMessageBinding
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class AMQPMessageBindingTest {

    private val objectMapper = ObjectMapper()

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/binding/message/amqp/amqpMessageBinding.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, AMQPMessageBinding::class.java),
                build()
        )
    }

    companion object {
        @JvmStatic
        fun build(): AMQPMessageBinding {
            return AMQPMessageBinding.builder()
                    .contentEncoding("gzip")
                    .messageType("user.signup")
                    .build()
        }
    }

}