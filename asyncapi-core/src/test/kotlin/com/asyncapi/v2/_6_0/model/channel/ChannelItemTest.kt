package com.asyncapi.v2._6_0.model.channel

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.v2._6_0.binding.channel.amqp.AMQPChannelBindingTest
import com.asyncapi.v2._6_0.binding.channel.anypointmq.AnypointMQChannelBindingTest
import com.asyncapi.v2._6_0.binding.channel.googlepubsub.GooglePubSubChannelBindingTest
import com.asyncapi.v2._6_0.binding.channel.ibmmq.IBMMQChannelBindingTest
import com.asyncapi.v2._6_0.binding.channel.kafka.KafkaChannelBindingTest
import com.asyncapi.v2._6_0.binding.channel.pulsar.PulsarChannelBindingTest
import com.asyncapi.v2._6_0.binding.channel.ws.WebSocketsChannelBindingTest
import com.asyncapi.v2._6_0.model.Reference
import com.asyncapi.v2._6_0.model.channel.message.*
import com.asyncapi.v2._6_0.model.channel.operation.OperationTest
import com.asyncapi.v2._6_0.model.schema.Schema
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ChannelItemTest {

    private val objectMapper = ObjectMapper()

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/model/channel/channelItem.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, ChannelItem::class.java),
                build()
        )
    }

    companion object {
        @JvmStatic
        fun build(): ChannelItem {
            val subscribe = OperationTest.build()
            subscribe.message = OneOfMessages(listOf(
                    Reference("#/components/schemas/sendMessage"),
                    MessageTest.build()
            ))
            val publish = OperationTest.build()
            publish.message = MessageTest.build()
            val userIdParameter = ParameterTest.build()
            userIdParameter.schema = Schema.builder().type("string").build()

            return ChannelItem.builder()
                    .description("This channel is used to exchange messages about users signing up")
                    .servers(listOf("stage.sign"))
                    .subscribe(subscribe)
                    .publish(publish)
                    .parameters(mapOf(
                            Pair("userId", userIdParameter)
                    ))
                    .bindings(mapOf(
                            Pair("amqp", AMQPChannelBindingTest.build()),
                            Pair("amqp1", Reference("#/components/channelBindings/amqp1")),
                            Pair("anypointmq", AnypointMQChannelBindingTest.build()),
                            Pair("googlepubsub", GooglePubSubChannelBindingTest.build()),
                            Pair("http", Reference("#/components/channelBindings/http")),
                            Pair("ibmmq", IBMMQChannelBindingTest.build()),
                            Pair("jms", Reference("#/components/channelBindings/jms")),
                            Pair("kafka", KafkaChannelBindingTest.build()),
                            Pair("mercure", Reference("#/components/channelBindings/mercure")),
                            Pair("mqtt", Reference("#/components/channelBindings/mqtt")),
                            Pair("mqtt5", Reference("#/components/channelBindings/mqtt5")),
                            Pair("nats", Reference("#/components/channelBindings/nats")),
                            Pair("pulsar", PulsarChannelBindingTest.build()),
                            Pair("redis", Reference("#/components/channelBindings/redis")),
                            Pair("sns", Reference("#/components/channelBindings/sns")),
                            Pair("solace", Reference("#/components/channelBindings/solace")),
                            Pair("sqs", Reference("#/components/channelBindings/sqs")),
                            Pair("stomp", Reference("#/components/channelBindings/stomp")),
                            Pair("ws", WebSocketsChannelBindingTest.build())
                    ))
                    .build()
        }
    }

}