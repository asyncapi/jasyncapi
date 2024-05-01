package com.asyncapi.v3._0_0.model.operation

import com.asyncapi.bindings.amqp.AMQPV0_2_0Test
import com.asyncapi.bindings.http.HTTPV0_3_0Test
import com.asyncapi.bindings.kafka.KafkaV0_4_0Test
import com.asyncapi.bindings.mqtt.MQTTV0_1_0Test
import com.asyncapi.bindings.nats.NATSV0_1_0Test
import com.asyncapi.bindings.solace.SolaceV0_3_0Test
import com.asyncapi.schemas.Reference
import com.asyncapi.v3.SerDeTest
import com.asyncapi.v3._0_0.model.ExternalDocumentation
import com.asyncapi.v3._0_0.model.Tag
import com.asyncapi.v3._0_0.model.operation.reply.OperationReplyTest
import com.asyncapi.v3.security_scheme.ApiKeySecuritySchemeTest

/**
 * @version 3.0.0
 * @author Pavel Bodiachevskii
 */
class OperationTest: SerDeTest<Operation>() {

    override fun objectClass() = Operation::class.java

    override fun baseObjectJson() = "/json/v3/3.0.0/model/operation/operation.json"

    override fun extendedObjectJson() = "/json/v3/3.0.0/model/operation/operation - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/3.0.0/model/operation/operation - wrongly extended.json"

    override fun build(): Operation {
        return Operation.builder()
                .action(OperationAction.SEND)
                .channel(Reference("#/components/channels/channel"))
                .title("Send message operation")
                .summary("Send message")
                .description("Send message to remote server")
                .security(listOf(
                        ApiKeySecuritySchemeTest().build(),
                    Reference("#/components/security/plain")
                ))
                .tags(listOf(
                        Tag("messages", "operations with messages", ExternalDocumentation(
                                "Messages validation rules", "messages/validation-rules"
                        )),
                    Reference("#/components/tags/tag")
                ))
                .externalDocs(ExternalDocumentation("Messages validation rules", "messages/validation-rules"))
                .bindings(bindings())
                .traits(listOf(
                        OperationTraitTest().build(),
                        OperationTraitTestWithReference().build(),
                    Reference("#/components/operations/trait")
                ))
                .messages(listOf(
                    Reference("#/components/messages/message 1"),
                    Reference("#/components/messages/message 2"),
                    Reference("#/components/messages/message 3"),
                ))
                .reply(OperationReplyTest().build())
                .build()
    }

    companion object {
        fun bindings(): Map<String, Any> {
            return mapOf(
                    Pair("amqp", AMQPV0_2_0Test.operationBinding()),
                    Pair("amqp1",
                        Reference("#/components/operationBindings/amqp1")
                    ),
                    Pair("anypointmq",
                        Reference("#/components/operationBindings/anypointmq")
                    ),
                    Pair("googlepubsub",
                        Reference("#/components/operationBindings/googlepubsub")
                    ),
                    Pair("http", HTTPV0_3_0Test.operationBinding()),
                    Pair("ibmmq",
                        Reference("#/components/operationBindings/ibmmq")
                    ),
                    Pair("jms", Reference("#/components/operationBindings/jms")),
                    Pair("kafka", KafkaV0_4_0Test.operationBinding()),
                    Pair("mercure",
                        Reference("#/components/operationBindings/mercure")
                    ),
                    Pair("mqtt", MQTTV0_1_0Test.operationBinding()),
                    Pair("mqtt5",
                        Reference("#/components/operationBindings/mqtt5")
                    ),
                    Pair("nats", NATSV0_1_0Test.operationBinding()),
                    Pair("pulsar",
                        Reference("#/components/operationBindings/pulsar")
                    ),
                    Pair("redis",
                        Reference("#/components/operationBindings/redis")
                    ),
                    Pair("sns", Reference("#/components/operationBindings/sns")),
                    Pair("solace", SolaceV0_3_0Test.operationBinding()),
                    Pair("sqs", Reference("#/components/operationBindings/sqs")),
                    Pair("stomp",
                        Reference("#/components/operationBindings/stomp")
                    ),
                    Pair("ws", Reference("#/components/operationBindings/ws"))
            )
        }
    }

}

class OperationTestWithReference: SerDeTest<Operation>() {

    override fun objectClass() = Operation::class.java

    override fun baseObjectJson() = "/json/v3/3.0.0/model/operation/operation with reference.json"

    override fun extendedObjectJson() = "/json/v3/3.0.0/model/operation/operation with reference - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/3.0.0/model/operation/operation with reference - wrongly extended.json"

    override fun build(): Operation {
        return Operation.builder()
                .action(OperationAction.RECEIVE)
                .channel(Reference("#/components/channels/channel"))
                .title("Send message operation")
                .summary("Send message")
                .description("Send message to remote server")
                .security(listOf(
                        ApiKeySecuritySchemeTest().build(),
                    Reference("#/components/security/plain")
                ))
                .tags(listOf(
                        Tag("messages", "operations with messages", ExternalDocumentation(
                                "Messages validation rules", "messages/validation-rules"
                        )),
                    Reference("#/components/tags/tag")
                ))
                .externalDocs(Reference("#/components/externalDocs/external-doc"))
                .bindings(mapOf(
                        Pair("amqp", AMQPV0_2_0Test.operationBinding()),
                        Pair("amqp1",
                            Reference("#/components/operationBindings/amqp1")
                        ),
                        Pair("anypointmq",
                            Reference("#/components/operationBindings/anypointmq")
                        ),
                        Pair("googlepubsub",
                            Reference("#/components/operationBindings/googlepubsub")
                        ),
                        Pair("http", HTTPV0_3_0Test.operationBinding()),
                        Pair("ibmmq",
                            Reference("#/components/operationBindings/ibmmq")
                        ),
                        Pair("jms",
                            Reference("#/components/operationBindings/jms")
                        ),
                        Pair("kafka", KafkaV0_4_0Test.operationBinding()),
                        Pair("mercure",
                            Reference("#/components/operationBindings/mercure")
                        ),
                        Pair("mqtt", MQTTV0_1_0Test.operationBinding()),
                        Pair("mqtt5",
                            Reference("#/components/operationBindings/mqtt5")
                        ),
                        Pair("nats", NATSV0_1_0Test.operationBinding()),
                        Pair("pulsar",
                            Reference("#/components/operationBindings/pulsar")
                        ),
                        Pair("redis",
                            Reference("#/components/operationBindings/redis")
                        ),
                        Pair("sns",
                            Reference("#/components/operationBindings/sns")
                        ),
                        Pair("solace", SolaceV0_3_0Test.operationBinding()),
                        Pair("sqs",
                            Reference("#/components/operationBindings/sqs")
                        ),
                        Pair("stomp",
                            Reference("#/components/operationBindings/stomp")
                        ),
                        Pair("ws",
                            Reference("#/components/operationBindings/ws")
                        )
                ))
                .traits(listOf(
                        OperationTraitTest().build(),
                        OperationTraitTestWithReference().build(),
                    Reference("#/components/operations/trait")
                ))
                .messages(listOf(
                    Reference("#/components/messages/message 1"),
                    Reference("#/components/messages/message 2"),
                    Reference("#/components/messages/message 3"),
                ))
                .reply(Reference("#/components/replies/reply"))
                .build()
    }

}
