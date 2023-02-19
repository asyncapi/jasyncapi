package com.asyncapi.v2.binding.server.pulsar

import com.asyncapi.v2.ClasspathUtils
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @version 2.6.0
 * @author Pavel Bodiachevskii
 */
class PulsarServerBindingTest {

    private val objectMapper = ObjectMapper()

    private fun build(): PulsarServerBinding {
        return PulsarServerBinding.builder()
                .tenant("contoso")
                .build()
    }

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/binding/server/pulsar/pulsarServerBinding.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, PulsarServerBinding::class.java),
                build()
        )
    }

}