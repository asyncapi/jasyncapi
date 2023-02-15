package com.asyncapi.v2._6_0.binding.message.mqtt

import com.asyncapi.v2.ClasspathUtils
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MQTTMessageBindingTest {

    private val objectMapper = ObjectMapper()

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/binding/message/mqtt/mqttMessageBinding.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, MQTTMessageBinding::class.java),
                build()
        )
    }

    companion object {
        @JvmStatic
        fun build(): MQTTMessageBinding {
            return MQTTMessageBinding.builder()
                    .build()
        }
    }

}