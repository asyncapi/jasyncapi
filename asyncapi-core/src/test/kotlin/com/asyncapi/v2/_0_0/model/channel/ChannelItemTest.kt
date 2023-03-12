package com.asyncapi.v2._0_0.model.channel

import com.asyncapi.v2.SerDeTest
import com.asyncapi.v2._0_0.model.channel.operation.OperationWithMessageTest
import com.asyncapi.v2._0_0.model.channel.operation.OperationWithReferenceToMessageTest
import com.asyncapi.v2._0_0.model.schema.Schema
import com.asyncapi.v2.binding.channel.ChannelBinding
import com.asyncapi.v2.binding.channel.amqp.AMQPChannelBindingTest
import com.asyncapi.v2.binding.channel.amqp1.AMQP1ChannelBinding
import com.asyncapi.v2.binding.channel.anypointmq.AnypointMQChannelBindingTest
import com.asyncapi.v2.binding.channel.googlepubsub.GooglePubSubChannelBindingTest
import com.asyncapi.v2.binding.channel.http.HTTPChannelBinding
import com.asyncapi.v2.binding.channel.ibmmq.IBMMQChannelBindingTest
import com.asyncapi.v2.binding.channel.jms.JMSChannelBinding
import com.asyncapi.v2.binding.channel.kafka.KafkaChannelBindingTest
import com.asyncapi.v2.binding.channel.mercure.MercureChannelBinding
import com.asyncapi.v2.binding.channel.mqtt.MQTTChannelBinding
import com.asyncapi.v2.binding.channel.mqtt5.MQTT5ChannelBinding
import com.asyncapi.v2.binding.channel.nats.NATSChannelBinding
import com.asyncapi.v2.binding.channel.pulsar.PulsarChannelBindingTest
import com.asyncapi.v2.binding.channel.redis.RedisChannelBinding
import com.asyncapi.v2.binding.channel.sns.SNSChannelBinding
import com.asyncapi.v2.binding.channel.solace.SolaceChannelBinding
import com.asyncapi.v2.binding.channel.sqs.SQSChannelBinding
import com.asyncapi.v2.binding.channel.stomp.STOMPChannelBinding
import com.asyncapi.v2.binding.channel.ws.WebSocketsChannelBindingTest

class ChannelItemTest: SerDeTest<ChannelItem>() {

    override fun objectClass() = ChannelItem::class.java

    override fun baseObjectJson() = "/json/2.0.0/model/channel/channelItem.json"

    override fun extendedObjectJson() = "/json/2.0.0/model/channel/channelItem - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/2.0.0/model/channel/channelItem - wrongly extended.json"

    override fun build(): ChannelItem {
        val subscribe = OperationWithReferenceToMessageTest().build()
        val publish = OperationWithMessageTest().build()
        val userIdParameter = ParameterTest().build()
        userIdParameter.schema = Schema.builder().type("string").build()

        return ChannelItem.builder()
                .description("This channel is used to exchange messages about users signing up")
                .subscribe(subscribe)
                .publish(publish)
                .parameters(mapOf(
                        Pair("userId", userIdParameter)
                ))
                .bindings(bindings())
                .build()
    }

    companion object {
        fun bindings(): Map<String, ChannelBinding> {
            return mapOf(
                    Pair("amqp", AMQPChannelBindingTest().build()),
                    Pair("amqp1", AMQP1ChannelBinding()),
                    Pair("anypointmq", AnypointMQChannelBindingTest().build()),
                    Pair("googlepubsub", GooglePubSubChannelBindingTest().build()),
                    Pair("http", HTTPChannelBinding()),
                    Pair("ibmmq", IBMMQChannelBindingTest().build()),
                    Pair("jms", JMSChannelBinding()),
                    Pair("kafka", KafkaChannelBindingTest().build()),
                    Pair("mercure", MercureChannelBinding()),
                    Pair("mqtt", MQTTChannelBinding()),
                    Pair("mqtt5", MQTT5ChannelBinding()),
                    Pair("nats", NATSChannelBinding()),
                    Pair("pulsar", PulsarChannelBindingTest().build()),
                    Pair("redis", RedisChannelBinding()),
                    Pair("sns", SNSChannelBinding()),
                    Pair("solace", SolaceChannelBinding()),
                    Pair("sqs", SQSChannelBinding()),
                    Pair("stomp", STOMPChannelBinding()),
                    Pair("ws", WebSocketsChannelBindingTest().build())
            )
        }
    }

}