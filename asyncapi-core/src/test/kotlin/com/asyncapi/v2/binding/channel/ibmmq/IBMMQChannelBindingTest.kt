package com.asyncapi.v2._6_0.binding.channel.ibmmq

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.v2.binding.channel.ibmmq.IBMMQChannelBinding
import com.asyncapi.v2.binding.channel.ibmmq.IBMMQChannelBinding.Topic
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class IBMMQChannelBindingTest {

    private val objectMapper = ObjectMapper()

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/binding/channel/ibmmq/ibmMQChannelBinding.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, IBMMQChannelBinding::class.java),
                build()
        )
    }

    companion object {
        @JvmStatic
        fun build(): IBMMQChannelBinding {
            return IBMMQChannelBinding.builder()
                    .destinationType("topic")
                    .queue(IBMMQChannelBinding.Queue.builder()
                            .objectName("message")
                            .isPartitioned(false)
                            .exclusive(true)
                            .build()
                    )
                    .topic(Topic.builder()
                            .string("messages")
                            .objectName("message")
                            .durablePermitted(true)
                            .lastMsgRetained(true)
                            .build()
                    )
                    .maxMsgLength(1024)
                    .build()
        }
    }

}