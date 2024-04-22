package com.asyncapi.v2.binding.channel.amqp

import com.asyncapi.v2.SerDeTest
import com.asyncapi.bindings.amqp.v0._2_0.channel.AMQPChannelBinding
import com.asyncapi.bindings.amqp.v0._2_0.channel.AMQPChannelType
import com.asyncapi.bindings.amqp.v0._2_0.channel.exchange.AMQPChannelExchangeProperties
import com.asyncapi.bindings.amqp.v0._2_0.channel.exchange.AMQPChannelExchangeType
import com.asyncapi.bindings.amqp.v0._2_0.channel.queue.AMQPChannelQueueProperties

/**
 * @version 2.6.0
 * @author Pavel Bodiachevskii
 */
class AMQPChannelBindingTest: SerDeTest<AMQPChannelBinding>() {

    override fun objectClass() = AMQPChannelBinding::class.java

    override fun baseObjectJson() = "/json/v2/binding/channel/amqp/amqpChannelBinding.json"

    override fun extendedObjectJson() = "/json/v2/binding/channel/amqp/amqpChannelBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/binding/channel/amqp/amqpChannelBinding - wrongly extended.json"

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