package com.asyncapi.v2._6_0.binding.channel.amqp

import com.asyncapi.v2.ClasspathUtils
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @version 2.6.0
 * @author Pavel Bodiachevskii
 */
class AMQPChannelBindingTest {

    private val objectMapper = ObjectMapper()

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/binding/channel/amqp/amqpChannelBinding.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, AMQPChannelBinding::class.java),
                build()
        )
    }

    companion object {
        @JvmStatic
        fun build(): AMQPChannelBinding {
            return AMQPChannelBinding.builder()
                    .`is`("routingKey")
                    .queue(AMQPChannelBinding.QueueProperties.builder()
                            .name("my-queue-name")
                            .durable(true)
                            .exclusive(true)
                            .autoDelete(false)
                            .build()
                    )
                    .exchange(AMQPChannelBinding.ExchangeProperties.builder()
                            .name("myExchange")
                            .type("topic")
                            .durable(true)
                            .autoDelete(false)
                            .build()
                    )
                    .build()
        }
    }

}