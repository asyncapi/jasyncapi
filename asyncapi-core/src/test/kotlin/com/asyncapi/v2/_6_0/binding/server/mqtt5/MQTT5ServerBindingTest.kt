package com.asyncapi.v2._6_0.binding.server.mqtt5

import com.asyncapi.v2.ClasspathUtils
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @version 2.6.0
 * @author Pavel Bodiachevskii
 */
class MQTT5ServerBindingTest {

    private val objectMapper = ObjectMapper()

    private fun build(): MQTT5ServerBinding {
        return MQTT5ServerBinding.builder()
                .sessionExpiryInterval(60)
                .build()
    }

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/binding/server/mqtt5/mqtt5ServerBinding.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, MQTT5ServerBinding::class.java),
                build()
        )
    }

}