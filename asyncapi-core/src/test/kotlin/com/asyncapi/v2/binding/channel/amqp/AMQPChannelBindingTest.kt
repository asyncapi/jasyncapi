package com.asyncapi.v2.binding.channel.amqp

import com.asyncapi.v2.SerDeTest

/**
 * @version 2.6.0
 * @author Pavel Bodiachevskii
 */
class AMQPChannelBindingTest: SerDeTest<AMQPChannelBinding>() {

    override fun objectClass() = AMQPChannelBinding::class.java

    override fun baseObjectJson() = "/json/2.6.0/binding/channel/amqp/amqpChannelBinding.json"

    override fun extendedObjectJson() = "/json/2.6.0/binding/channel/amqp/amqpChannelBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/2.6.0/binding/channel/amqp/amqpChannelBinding - wrongly extended.json"

    override fun build(): AMQPChannelBinding {
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