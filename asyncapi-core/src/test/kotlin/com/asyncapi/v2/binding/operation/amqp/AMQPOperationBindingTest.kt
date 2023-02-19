package com.asyncapi.v2.binding.operation.amqp

import com.asyncapi.v2.ClasspathUtils
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class AMQPOperationBindingTest {

    private val objectMapper = ObjectMapper()

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/binding/operation/amqp/amqpOperationBinding.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, AMQPOperationBinding::class.java),
                build()
        )
    }

    companion object {
        @JvmStatic
        fun build(): AMQPOperationBinding {
            return AMQPOperationBinding.builder()
                    .expiration(100_000)
                    .userId("guest")
                    .cc(listOf("user.logs"))
                    .priority(10)
                    .deliveryMode(2)
                    .mandatory(false)
                    .bcc(listOf("external.audit"))
                    .replyTo("user.signedup")
                    .timestamp(true)
                    .ack(false)
                    .build()
        }
    }

}