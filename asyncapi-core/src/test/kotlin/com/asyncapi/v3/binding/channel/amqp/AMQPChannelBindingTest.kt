package com.asyncapi.v3.binding.channel.amqp

import com.asyncapi.v3.SerDeTest
import com.asyncapi.v3.binding.channel.amqp.exchange.AMQPChannelExchangeProperties
import com.asyncapi.v3.binding.channel.amqp.exchange.AMQPChannelExchangeType
import com.asyncapi.v3.binding.channel.amqp.queue.AMQPChannelQueueProperties

/**
 * @version 3.0.0
 * @author Pavel Bodiachevskii
 */
class AMQPChannelBindingTest: SerDeTest<AMQPChannelBinding>() {

    override fun objectClass() = AMQPChannelBinding::class.java

    override fun baseObjectJson() = "/json/v3/binding/channel/amqp/amqpChannelBinding.json"

    override fun extendedObjectJson() = "/json/v3/binding/channel/amqp/amqpChannelBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/binding/channel/amqp/amqpChannelBinding - wrongly extended.json"

    override fun build(): AMQPChannelBinding {
        return AMQPChannelBinding.builder()
                .`is`(AMQPChannelType.ROUTING_KEY)
                .queue(AMQPChannelQueueProperties.builder()
                        .name("my-queue-name")
                        .durable(true)
                        .exclusive(true)
                        .autoDelete(false)
                        .build()
                )
                .exchange(AMQPChannelExchangeProperties.builder()
                        .name("myExchange")
                        .type(AMQPChannelExchangeType.TOPIC)
                        .durable(true)
                        .autoDelete(false)
                        .build()
                )
                .build()
    }

}