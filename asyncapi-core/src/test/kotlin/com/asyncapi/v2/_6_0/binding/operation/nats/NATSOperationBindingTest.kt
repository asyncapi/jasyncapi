package com.asyncapi.v2._6_0.binding.operation.nats

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.v2._6_0.binding.operation.mqtt.MQTTOperationBinding
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class NATSOperationBindingTest {

    private val objectMapper = ObjectMapper()

    private fun build(): NATSOperationBinding {
        return NATSOperationBinding.builder()
                .queue("messages")
                .build()
    }

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/binding/operation/nats/natsOperationBinding.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, NATSOperationBinding::class.java),
                build()
        )
    }

}