package com.asyncapi.v2._6_0.model.channel.operation

import com.asyncapi.Reference
import com.asyncapi.v2.SerDeTest
import com.asyncapi.v2._6_0.model.ExternalDocumentation
import com.asyncapi.v2._6_0.model.Tag
import com.asyncapi.v2._6_0.model.channel.message.MessageTest
import com.asyncapi.v2._6_0.model.channel.message.OneOfMessages
import com.asyncapi.bindings.amqp.AMQPV0_2_0Test
import com.asyncapi.bindings.http.HTTPV0_3_0Test
import com.asyncapi.bindings.kafka.KafkaV0_4_0Test
import com.asyncapi.bindings.mqtt.MQTTV0_1_0Test
import com.asyncapi.bindings.nats.NATSV0_1_0Test
import com.asyncapi.bindings.solace.SolaceV0_3_0Test

class OperationWithReferenceToMessageTest: SerDeTest<Operation>() {

    override fun objectClass() = Operation::class.java

    override fun baseObjectJson() = "/json/v2/2.6.0/model/channel/operation/operation with reference to message.json"

    override fun extendedObjectJson() = "/json/v2/2.6.0/model/channel/operation/operation with reference to message - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/2.6.0/model/channel/operation/operation with reference to message - wrongly extended.json"

    override fun build(): Operation {
        return Operation.builder()
                .operationId("sendMessage")
                .summary("Send message")
                .description("Send message to remote server")
                .security(listOf(
                        mapOf(
                                Pair("api_key", listOf("write:messages"))
                        )
                ))
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

    override fun baseObjectJson() = "/json/v2/2.6.0/model/channel/operation/operation with message.json"

    override fun extendedObjectJson() = "/json/v2/2.6.0/model/channel/operation/operation with message - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/2.6.0/model/channel/operation/operation with message - wrongly extended.json"

    override fun build(): Operation {
        return Operation.builder()
                .operationId("sendMessage")
                .summary("Send message")
                .description("Send message to remote server")
                .security(listOf(
                        mapOf(
                                Pair("api_key", listOf("write:messages"))
                        )
                ))
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

class OperationWithOneOfMessageTest: SerDeTest<Operation>() {

    override fun objectClass() = Operation::class.java

    override fun baseObjectJson() = "/json/v2/2.6.0/model/channel/operation/operation with oneOf message.json"

    override fun extendedObjectJson() = "/json/v2/2.6.0/model/channel/operation/operation with oneOf message - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/2.6.0/model/channel/operation/operation with oneOf message - wrongly extended.json"

    override fun build(): Operation {
        return Operation.builder()
                .operationId("sendMessage")
                .summary("Send message")
                .description("Send message to remote server")
                .security(listOf(
                        mapOf(
                                Pair("api_key", listOf("write:messages"))
                        )
                ))
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
                .message(OneOfMessages(listOf(
                        Reference("#/components/schemas/sendMessage"),
                        MessageTest().build()
                )))
                .build()
    }
}

class OperationTest {
    companion object {
        @JvmStatic
        fun bindings(): Map<String, Any> {
            return mapOf(
                    Pair("amqp", AMQPV0_2_0Test.operationBinding()),
                    Pair("amqp1", Reference("#/components/operationBindings/amqp1")),
                    Pair("anypointmq", Reference("#/components/operationBindings/anypointmq")),
                    Pair("googlepubsub", Reference("#/components/operationBindings/googlepubsub")),
                    Pair("http", HTTPV0_3_0Test.operationBinding()),
                    Pair("ibmmq", Reference("#/components/operationBindings/ibmmq")),
                    Pair("jms", Reference("#/components/operationBindings/jms")),
                    Pair("kafka", KafkaV0_4_0Test.operationBinding()),
                    Pair("mercure", Reference("#/components/operationBindings/mercure")),
                    Pair("mqtt", MQTTV0_1_0Test.operationBinding()),
                    Pair("mqtt5", Reference("#/components/operationBindings/mqtt5")),
                    Pair("nats", NATSV0_1_0Test.operationBinding()),
                    Pair("pulsar", Reference("#/components/operationBindings/pulsar")),
                    Pair("redis", Reference("#/components/operationBindings/redis")),
                    Pair("sns", Reference("#/components/operationBindings/sns")),
                    Pair("solace", SolaceV0_3_0Test.operationBinding()),
                    Pair("sqs", Reference("#/components/operationBindings/sqs")),
                    Pair("stomp", Reference("#/components/operationBindings/stomp")),
                    Pair("ws", Reference("#/components/operationBindings/ws"))
            )
        }
    }
}