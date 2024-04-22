package com.asyncapi.v3._0_0.model.channel

import com.asyncapi.Reference
import com.asyncapi.v3.SerDeTest
import com.asyncapi.v3._0_0.model.ExternalDocumentationTest
import com.asyncapi.v3._0_0.model.TagTest
import com.asyncapi.v3._0_0.model.TagTestWithReferenceToExternalDocs
import com.asyncapi.v3._0_0.model.channel.message.MessageTestWithMultiFormatSchema
import com.asyncapi.v3._0_0.model.channel.message.MessageTestWithReference
import com.asyncapi.v3._0_0.model.channel.message.MessageTestWithSchema
import com.asyncapi.v3.binding.channel.amqp.AMQPChannelBindingTest
import com.asyncapi.v3.binding.channel.anypointmq.AnypointMQChannelBindingTest
import com.asyncapi.v3.binding.channel.googlepubsub.GooglePubSubChannelBindingTest
import com.asyncapi.v3.binding.channel.ibmmq.IBMMQChannelBindingTest
import com.asyncapi.v3.binding.channel.kafka.KafkaChannelBindingTest
import com.asyncapi.v3.binding.channel.pulsar.PulsarChannelBindingTest
import com.asyncapi.v3.binding.channel.ws.WebSocketsChannelBindingTest

class ChannelTest: SerDeTest<Channel>() {

    override fun objectClass() = Channel::class.java

    override fun baseObjectJson() = "/json/v3/3.0.0/model/channel/channel.json"

    override fun extendedObjectJson() = "/json/v3/3.0.0/model/channel/channel - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/3.0.0/model/channel/channel - wrongly extended.json"

    override fun build(): Channel {
        return Channel.builder()
                .address("users.{userId}")
                .title("Users channel")
                .summary("messages about user events.")
                .description("This channel is used to exchange messages about users signing up")
                .servers(listOf(
                    Reference("#/components/servers/1"),
                    Reference("#/components/servers/2"),
                    Reference("#/components/servers/3")
                ))
                .parameters(mapOf(
                        Pair("userId", ParameterTest().build()),
                        Pair("userStatus",
                            Reference("#/components/parameters/user-status")
                        )
                ))
                .messages(mapOf(
                        Pair("changeStatus",
                            Reference("#/components/parameters/user-status")
                        ),
                        Pair("message", MessageTestWithSchema().build()),
                        Pair("message 2", MessageTestWithMultiFormatSchema().build()),
                        Pair("message with reference", MessageTestWithReference().build()),
                ))
                .bindings(bindings())
                .tags(listOf(
                        TagTest().build(),
                        TagTestWithReferenceToExternalDocs().build(),
                    Reference("#/components/tag")
                ))
                .externalDocs(ExternalDocumentationTest().build())
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

class ChannelTestWithReference: SerDeTest<Channel>() {

    override fun objectClass() = Channel::class.java

    override fun baseObjectJson() = "/json/v3/3.0.0/model/channel/channel with reference.json"

    override fun extendedObjectJson() = "/json/v3/3.0.0/model/channel/channel with reference - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/3.0.0/model/channel/channel with reference - wrongly extended.json"

    override fun build(): Channel {
        return Channel.builder()
                .address("users.{userId}")
                .title("Users channel")
                .summary("messages about user events.")
                .description("This channel is used to exchange messages about users signing up")
                .servers(listOf(
                    Reference("#/components/servers/1"),
                    Reference("#/components/servers/2"),
                    Reference("#/components/servers/3")
                ))
                .parameters(mapOf(
                        Pair("userId", ParameterTest().build()),
                        Pair("userStatus",
                            Reference("#/components/parameters/user-status")
                        )
                ))
                .messages(mapOf(
                        Pair("changeStatus",
                            Reference("#/components/parameters/user-status")
                        ),
                        Pair("message", MessageTestWithSchema().build()),
                        Pair("message 2", MessageTestWithMultiFormatSchema().build()),
                        Pair("message with reference", MessageTestWithReference().build()),
                ))
                .bindings(bindings())
                .tags(listOf(
                        TagTest().build(),
                        TagTestWithReferenceToExternalDocs().build(),
                    Reference("#/components/tag")
                ))
                .externalDocs(Reference("#/components/external-doc"))
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