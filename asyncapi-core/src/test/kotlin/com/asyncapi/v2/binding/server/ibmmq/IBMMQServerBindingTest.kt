package com.asyncapi.v2._6_0.binding.server.ibmmq

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.v2.binding.server.ibmmq.IBMMQServerBinding
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @version 2.6.0
 * @author Pavel Bodiachevskii
 */
class IBMMQServerBindingTest {

    private val objectMapper = ObjectMapper()

    private fun build(): IBMMQServerBinding {
        return IBMMQServerBinding.builder()
                .groupId("PRODCLSTR1")
                .cipherSpec("ANY_TLS12_OR_HIGHER")
                .build()
    }

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/binding/server/ibmmq/ibmmqServerBinding.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, IBMMQServerBinding::class.java),
                build()
        )
    }

}