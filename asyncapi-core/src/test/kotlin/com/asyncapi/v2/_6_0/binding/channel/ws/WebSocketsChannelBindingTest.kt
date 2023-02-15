package com.asyncapi.v2._6_0.binding.channel.ws

import com.asyncapi.v2.ClasspathUtils
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @version 2.6.0
 * @author Pavel Bodiachevskii
 */
class WebSocketsChannelBindingTest {

    private val objectMapper = ObjectMapper()

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/binding/channel/ws/webSocketsChannelBinding.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, WebSocketsChannelBinding::class.java),
                build()
        )
    }

    companion object {
        @JvmStatic
        fun build(): WebSocketsChannelBinding {
            return WebSocketsChannelBinding.builder()
                    .method("GET")
                    .query(mapOf(
                            Pair("type", "object"),
                            Pair("properties", mapOf(
                                    Pair("ref", mapOf(
                                            Pair("type", "string"),
                                            Pair("description", "Referral.")
                                    ))
                            )),
                    ))
                    .headers(mapOf(
                            Pair("type", "object"),
                            Pair("properties", mapOf(
                                    Pair("Authentication", mapOf(
                                            Pair("type", "string"),
                                            Pair("description", "Authentication token")
                                    ))
                            )),
                    ))
                    .build()
        }
    }

}