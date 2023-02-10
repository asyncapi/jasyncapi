package com.asyncapi.v2._6_0.binding.operation.mqtt

import com.asyncapi.v2.ClasspathUtils
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MQTTOperationBindingTest {

    private val objectMapper = ObjectMapper()

    private fun build(): MQTTOperationBinding {
        return MQTTOperationBinding.builder()
                .qos(2)
                .retain(true)
                .build()
    }

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/binding/operation/mqtt/mqttOperationBinding.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, MQTTOperationBinding::class.java),
                build()
        )
    }

}