package com.asyncapi.v2._6_0.model.channel.message

import com.asyncapi.v2.ClasspathUtils
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MessageExampleTest {

    private val objectMapper = ObjectMapper()

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/model/channel/message/messageExample.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, MessageExample::class.java),
                build()
        )
    }

    companion object {
        @JvmStatic
        fun build(): MessageExample {
            return MessageExample.builder()
                    .name("SimpleSignup")
                    .summary("A simple UserSignup example message")
                    .headers(mapOf(
                            Pair("correlationId", "my-correlation-id"),
                            Pair("applicationInstanceId", "myInstanceId")
                    ))
                    .payload(mapOf(
                            Pair("user", mapOf(
                                    Pair("someUserKey", "someUserValue")
                            )),
                            Pair("signup", mapOf(
                                    Pair("someSignupKey", "someSignupValue")
                            ))
                    ))
                    .build()
        }
    }

}