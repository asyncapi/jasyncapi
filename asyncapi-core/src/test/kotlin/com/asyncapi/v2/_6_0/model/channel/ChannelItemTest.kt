package com.asyncapi.v2._6_0.model.channel

import com.asyncapi.Reference
import com.asyncapi.v2.SerDeTest
import com.asyncapi.v2._6_0.model.channel.operation.OperationWithMessageTest
import com.asyncapi.v2._6_0.model.channel.operation.OperationWithOneOfMessageTest
import com.asyncapi.v2.schema.Schema
import com.asyncapi.bindings.amqp.v0._2_0.channel.AMQPChannelBindingTest
import com.asyncapi.v2.binding.channel.anypointmq.AnypointMQChannelBindingTest
import com.asyncapi.v2.binding.channel.googlepubsub.GooglePubSubChannelBindingTest
import com.asyncapi.v2.binding.channel.ibmmq.IBMMQChannelBindingTest
import com.asyncapi.v2.binding.channel.kafka.KafkaChannelBindingTest
import com.asyncapi.v2.binding.channel.pulsar.PulsarChannelBindingTest
import com.asyncapi.v2.binding.channel.ws.WebSocketsChannelBindingTest

class ChannelItemTest: SerDeTest<ChannelItem>() {

    override fun objectClass() = ChannelItem::class.java

    override fun baseObjectJson() = "/json/v2/2.6.0/model/channel/channelItem.json"

    override fun extendedObjectJson() = "/json/v2/2.6.0/model/channel/channelItem - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/2.6.0/model/channel/channelItem - wrongly extended.json"

    override fun build(): ChannelItem {
        val subscribe = OperationWithOneOfMessageTest().build()
        val publish = OperationWithMessageTest().build()
        val userIdParameter = ParameterWithSchemaTest().build()
        userIdParameter.schema = Schema.builder().type("string").build()

        return ChannelItem.builder()
                .description("This channel is used to exchange messages about users signing up")
                .servers(listOf("stage.sign"))
                .subscribe(subscribe)
                .publish(publish)
                .parameters(mapOf(
                        Pair("userId", userIdParameter)
                ))
                .bindings(bindings())
                .build()
    }

    companion object {
        fun bindings(): Map<String, Any> {
            return mapOf(
                    Pair("amqp", AMQPChannelBindingTest().build()),
                    Pair("amqp1", Reference("#/components/channelBindings/amqp1")),
                    Pair("anypointmq", AnypointMQChannelBindingTest().build()),
                    Pair("googlepubsub", GooglePubSubChannelBindingTest().build()),
                    Pair("http", Reference("#/components/channelBindings/http")),
                    Pair("ibmmq", IBMMQChannelBindingTest().build()),
                    Pair("jms", Reference("#/components/channelBindings/jms")),
                    Pair("kafka", KafkaChannelBindingTest().build()),
                    Pair("mercure", Reference("#/components/channelBindings/mercure")),
                    Pair("mqtt", Reference("#/components/channelBindings/mqtt")),
                    Pair("mqtt5", Reference("#/components/channelBindings/mqtt5")),
                    Pair("nats", Reference("#/components/channelBindings/nats")),
                    Pair("pulsar", PulsarChannelBindingTest().build()),
                    Pair("redis", Reference("#/components/channelBindings/redis")),
                    Pair("sns", Reference("#/components/channelBindings/sns")),
                    Pair("solace", Reference("#/components/channelBindings/solace")),
                    Pair("sqs", Reference("#/components/channelBindings/sqs")),
                    Pair("stomp", Reference("#/components/channelBindings/stomp")),
                    Pair("ws", WebSocketsChannelBindingTest().build())
            )
        }
    }

}