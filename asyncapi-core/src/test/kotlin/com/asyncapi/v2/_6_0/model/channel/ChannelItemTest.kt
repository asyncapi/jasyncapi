package com.asyncapi.v2._6_0.model.channel

import com.asyncapi.Reference
import com.asyncapi.v2.SerDeTest
import com.asyncapi.v2._6_0.model.channel.operation.OperationWithMessageTest
import com.asyncapi.v2._6_0.model.channel.operation.OperationWithOneOfMessageTest
import com.asyncapi.v2.schema.Schema
import com.asyncapi.bindings.amqp.AMQPV0_2_0Test
import com.asyncapi.bindings.anypointmq.AnypointMQV0_0_1Test
import com.asyncapi.bindings.googlepubsub.GooglePubSubV0_1_0Test
import com.asyncapi.bindings.ibmmq.IBMMQV0_1_0Test
import com.asyncapi.bindings.kafka.KafkaV0_4_0Test
import com.asyncapi.bindings.pulsar.PulsarV0_1_0Test
import com.asyncapi.bindings.websockets.v0._1_0.WebSocketsBindingProvider

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
                    Pair("amqp", AMQPV0_2_0Test.channelBinding()),
                    Pair("amqp1", Reference("#/components/channelBindings/amqp1")),
                    Pair("anypointmq", AnypointMQV0_0_1Test.channelBinding()),
                    Pair("googlepubsub", GooglePubSubV0_1_0Test.channelBinding()),
                    Pair("http", Reference("#/components/channelBindings/http")),
                    Pair("ibmmq", IBMMQV0_1_0Test.channelBinding()),
                    Pair("jms", Reference("#/components/channelBindings/jms")),
                    Pair("kafka", KafkaV0_4_0Test.channelBinding()),
                    Pair("mercure", Reference("#/components/channelBindings/mercure")),
                    Pair("mqtt", Reference("#/components/channelBindings/mqtt")),
                    Pair("mqtt5", Reference("#/components/channelBindings/mqtt5")),
                    Pair("nats", Reference("#/components/channelBindings/nats")),
                    Pair("pulsar", PulsarV0_1_0Test.channelBinding()),
                    Pair("redis", Reference("#/components/channelBindings/redis")),
                    Pair("sns", Reference("#/components/channelBindings/sns")),
                    Pair("solace", Reference("#/components/channelBindings/solace")),
                    Pair("sqs", Reference("#/components/channelBindings/sqs")),
                    Pair("stomp", Reference("#/components/channelBindings/stomp")),
                    Pair("ws", WebSocketsBindingProvider.channel())
            )
        }
    }

}