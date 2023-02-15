package com.asyncapi.v2._6_0.binding.server.mqtt

import com.asyncapi.v2.ClasspathUtils
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @version 2.6.0
 * @author Pavel Bodiachevskii
 */
class MQTTServerBindingTest {

    private val objectMapper = ObjectMapper()

    private fun build(): MQTTServerBinding {
        return MQTTServerBinding.builder()
                .clientId("guest")
                .cleanSession(true)
                .lastWill(MQTTServerBinding.LastWillConfiguration(
                        "/last-wills",
                        2,
                        "Guest gone offline.",
                        false
                ))
                .keepAlive(60)
                .build()
    }

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/binding/server/mqtt/mqttServerBinding.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, MQTTServerBinding::class.java),
                build()
        )
    }

}