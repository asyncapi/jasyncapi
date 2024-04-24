package com.asyncapi.bindings.amqp.v0._2_0.channel

import com.asyncapi.v3.SerDeTest
import com.asyncapi.bindings.amqp.v0._2_0.channel.exchange.AMQPChannelExchangeProperties
import com.asyncapi.bindings.amqp.v0._2_0.channel.exchange.AMQPChannelExchangeType
import com.asyncapi.bindings.amqp.v0._2_0.channel.queue.AMQPChannelQueueProperties

/**
 * @version 3.0.0
 * @author Pavel Bodiachevskii
 */
class AMQPChannelBindingTest: SerDeTest<AMQPChannelBinding>() {

    override fun objectClass() = AMQPChannelBinding::class.java

    override fun baseObjectJson() = "/bindings/amqp/channel/amqpChannelBinding.json"

    override fun extendedObjectJson() = "/bindings/amqp/channel/amqpChannelBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/bindings/amqp/channel/amqpChannelBinding - wrongly extended.json"

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