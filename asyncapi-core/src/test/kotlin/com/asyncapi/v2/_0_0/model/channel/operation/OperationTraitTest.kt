package com.asyncapi.v2._0_0.model.channel.operation

import com.asyncapi.v2.SerDeTest
import com.asyncapi.v2._0_0.model.ExternalDocumentation
import com.asyncapi.v2._0_0.model.Tag
import com.asyncapi.bindings.amqp.AMQPV0_2_0Test
import com.asyncapi.bindings.amqp1.v0._1_0.operation.AMQP1OperationBinding
import com.asyncapi.bindings.anypointmq.v0._0_1.operation.AnypointMQOperationBinding
import com.asyncapi.bindings.googlepubsub.GooglePubSubV0_2_0Test
import com.asyncapi.bindings.http.HTTPV0_3_0Test
import com.asyncapi.bindings.ibmmq.v0._1_0.operation.IBMMQOperationBinding
import com.asyncapi.bindings.jms.v0._0_1.operation.JMSOperationBinding
import com.asyncapi.bindings.kafka.v0._4_0.operation.KafkaOperationBindingTest
import com.asyncapi.bindings.mercure.v0._1_0.operation.MercureOperationBinding
import com.asyncapi.bindings.mqtt.v0._1_0.operation.MQTTOperationBindingTest
import com.asyncapi.bindings.mqtt5.v0._2_0.operation.MQTT5OperationBinding
import com.asyncapi.bindings.nats.v0._1_0.operation.NATSOperationBindingTest
import com.asyncapi.bindings.pulsar.v0._1_0.operation.PulsarOperationBinding
import com.asyncapi.bindings.redis.v0._1_0.operation.RedisOperationBinding
import com.asyncapi.bindings.sns.v0._1_0.operation.SNSOperationBinding
import com.asyncapi.bindings.solace.v0._3_0.operation.SolaceOperationBindingTest
import com.asyncapi.bindings.sqs.v0._1_0.operation.SQSOperationBinding
import com.asyncapi.bindings.stomp.v0._1_0.operation.STOMPOperationBinding
import com.asyncapi.bindings.websockets.v0._1_0.operation.WebSocketsOperationBinding

/**
 * @author Pavel Bodiachevskii
 */
class OperationTraitTest: SerDeTest<OperationTrait>() {

    override fun objectClass() = OperationTrait::class.java

    override fun baseObjectJson() = "/json/v2/2.0.0/model/channel/operation/operationTrait.json"

    override fun extendedObjectJson() = "/json/v2/2.0.0/model/channel/operation/operationTrait - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/2.0.0/model/channel/operation/operationTrait - wrongly extended.json"

    override fun build(): OperationTrait {
        return OperationTrait.builder()
                .operationId("sendMessage")
                .summary("Send message")
                .description("Send message to remote server")
                .tags(listOf(
                        Tag.builder()
                                .name("messages")
                                .description("operations with messages")
                                .externalDocs(ExternalDocumentation("Messages validation rules", "messages/validation-rules"))
                                .build()
                ))
                .externalDocs(ExternalDocumentation("Messages sending rules", "messages/sending-rules"))
                .bindings(mapOf(
                        Pair("amqp", AMQPV0_2_0Test.operationBinding()),
                        Pair("amqp1", AMQP1OperationBinding()),
                        Pair("anypointmq", AnypointMQOperationBinding()),
                        Pair("googlepubsub", GooglePubSubV0_2_0Test.operationBinding()),
                        Pair("http", HTTPV0_3_0Test.operationBinding()),
                        Pair("ibmmq", IBMMQOperationBinding()),
                        Pair("jms", JMSOperationBinding()),
                        Pair("kafka", KafkaOperationBindingTest().build()),
                        Pair("mercure", MercureOperationBinding()),
                        Pair("mqtt", MQTTOperationBindingTest().build()),
                        Pair("mqtt5", MQTT5OperationBinding()),
                        Pair("nats", NATSOperationBindingTest().build()),
                        Pair("pulsar", PulsarOperationBinding()),
                        Pair("redis", RedisOperationBinding()),
                        Pair("sns", SNSOperationBinding()),
                        Pair("solace", SolaceOperationBindingTest().build()),
                        Pair("sqs", SQSOperationBinding()),
                        Pair("stomp", STOMPOperationBinding()),
                        Pair("ws", WebSocketsOperationBinding())
                ))
                .build()
    }

}
