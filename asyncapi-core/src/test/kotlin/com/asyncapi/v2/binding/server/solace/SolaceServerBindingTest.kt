package com.asyncapi.v2.binding.server.solace

import com.asyncapi.v2.ClasspathUtils
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @version 2.6.0
 * @author Pavel Bodiachevskii
 */
class SolaceServerBindingTest {

    private val objectMapper = ObjectMapper()

    private fun build(): SolaceServerBinding {
        return SolaceServerBinding.builder()
                .msgVpn("solace.private.net")
                .build()
    }

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/binding/server/solace/solaceServerBinding.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, SolaceServerBinding::class.java),
                build()
        )
    }

}