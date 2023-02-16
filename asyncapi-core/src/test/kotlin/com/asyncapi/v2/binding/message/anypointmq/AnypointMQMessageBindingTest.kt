package com.asyncapi.v2._6_0.binding.message.anypointmq

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.v2.binding.message.anypointmq.AnypointMQMessageBinding
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class AnypointMQMessageBindingTest {

    private val objectMapper = ObjectMapper()

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/binding/message/anypointmq/anypointMQMessageBinding.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, AnypointMQMessageBinding::class.java),
                build()
        )
    }

    companion object {
        @JvmStatic
        fun build(): AnypointMQMessageBinding {
            return AnypointMQMessageBinding.builder()
                    .headers(mapOf(
                            Pair("type", "object"),
                            Pair("properties", mapOf(

                                    Pair("correlationId", mapOf(
                                            Pair("description", "Correlation ID set by application"),
                                            Pair("type", "string")
                                    ))
                            ))
                    ))
                    .build()
        }
    }

}