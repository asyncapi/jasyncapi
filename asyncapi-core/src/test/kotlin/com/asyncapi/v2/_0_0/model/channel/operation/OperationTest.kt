package com.asyncapi.v2._0_0.model.channel.operation

import com.asyncapi.v2.SerDeTest
import com.asyncapi.v2._0_0.model.ExternalDocumentation
import com.asyncapi.Reference
import com.asyncapi.v2._0_0.model.Tag
import com.asyncapi.v2._0_0.model.channel.message.MessageTest
import com.asyncapi.bindings.OperationBinding
import com.asyncapi.bindings.amqp.v0._2_0.operation.AMQPOperationBindingTest
import com.asyncapi.bindings.amqp1.v0._1_0.operation.AMQP1OperationBinding
import com.asyncapi.bindings.anypointmq.v0._0_1.operation.AnypointMQOperationBinding
import com.asyncapi.bindings.googlepubsub.v0._1_0.operation.GooglePubSubOperationBinding
import com.asyncapi.v2.binding.operation.http.HTTPOperationBindingTest
import com.asyncapi.bindings.ibmmq.v0._1_0.operation.IBMMQOperationBinding
import com.asyncapi.bindings.jms.v0._0_1.operation.JMSOperationBinding
import com.asyncapi.v2.binding.operation.kafka.KafkaOperationBindingTest
import com.asyncapi.bindings.mercure.v0._1_0.operation.MercureOperationBinding
import com.asyncapi.v2.binding.operation.mqtt.MQTTOperationBindingTest
import com.asyncapi.bindings.mqtt5.v0._2_0.operation.MQTT5OperationBinding
import com.asyncapi.v2.binding.operation.nats.NATSOperationBindingTest
import com.asyncapi.bindings.pulsar.v0._1_0.operation.PulsarOperationBinding
import com.asyncapi.bindings.redis.v0._1_0.operation.RedisOperationBinding
import com.asyncapi.bindings.sns.v0._1_0.operation.SNSOperationBinding
import com.asyncapi.v2.binding.operation.solace.SolaceOperationBindingTest
import com.asyncapi.bindings.sqs.v0._1_0.operation.SQSOperationBinding
import com.asyncapi.bindings.stomp.v0._1_0.operation.STOMPOperationBinding
import com.asyncapi.bindings.websockets.v0._1_0.operation.WebSocketsOperationBinding

/**
 * @author Pavel Bodiachevskii
 */
class OperationWithReferenceToMessageTest: SerDeTest<Operation>() {

    override fun objectClass() = Operation::class.java

    override fun baseObjectJson() = "/json/v2/2.0.0/model/channel/operation/operation with reference to message.json"

    override fun extendedObjectJson() = "/json/v2/2.0.0/model/channel/operation/operation with reference to message - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/2.0.0/model/channel/operation/operation with reference to message - wrongly extended.json"

    override fun build(): Operation {
        return Operation.builder()
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
                .bindings(OperationTest.bindings())
                .traits(listOf(
                        Reference("#/components/operationTraits/sendMessage"),
                        OperationTraitTest().build()
                ))
                .message(Reference("#/components/schemas/sendMessage"))
                .build()
    }

}

class OperationWithMessageTest: SerDeTest<Operation>() {

    override fun objectClass() = Operation::class.java

    override fun baseObjectJson() = "/json/v2/2.0.0/model/channel/operation/operation with message.json"

    override fun extendedObjectJson() = "/json/v2/2.0.0/model/channel/operation/operation with message - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/2.0.0/model/channel/operation/operation with message - wrongly extended.json"

    override fun build(): Operation {
        return Operation.builder()
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
                .bindings(OperationTest.bindings())
                .traits(listOf(
                        Reference("#/components/operationTraits/sendMessage"),
                        OperationTraitTest().build()
                ))
                .message(MessageTest().build())
                .build()
    }
}

class OperationTest {
    companion object {
        @JvmStatic
        fun bindings(): Map<String, OperationBinding> {
            return mapOf(
                    Pair("amqp", AMQPOperationBindingTest().build()),
                    Pair("amqp1", AMQP1OperationBinding()),
                    Pair("anypointmq", AnypointMQOperationBinding()),
                    Pair("googlepubsub", GooglePubSubOperationBinding()),
                    Pair("http", HTTPOperationBindingTest().build()),
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
            )
        }
    }
}
