package com.asyncapi.v2._6_0.binding.channel.anypointmq

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.v2.binding.channel.anypointmq.AnypointMQChannelBinding
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @version 2.6.0
 * @author Pavel Bodiachevskii
 */
class AnypointMQChannelBindingTest {

    private val objectMapper = ObjectMapper()

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/binding/channel/anypoint/anypointMQChannelBinding.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, AnypointMQChannelBinding::class.java),
                build()
        )
    }

    companion object {
        @JvmStatic
        fun build(): AnypointMQChannelBinding {
            return AnypointMQChannelBinding.builder()
                    .destination("user-signup-exchg")
                    .destinationType("exchange")
                    .build()
        }
    }

}