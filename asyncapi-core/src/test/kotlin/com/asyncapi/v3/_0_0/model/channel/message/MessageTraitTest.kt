package com.asyncapi.v3._0_0.model.channel.message

import com.asyncapi.schemas.asyncapi.Reference
import com.asyncapi.v3.SerDeTest
import com.asyncapi.v3._0_0.model.ExternalDocumentation
import com.asyncapi.v3._0_0.model.Tag
import com.asyncapi.schemas.asyncapi.AsyncAPISchema
import com.asyncapi.bindings.amqp.AMQPV0_2_0Test
import com.asyncapi.bindings.anypointmq.AnypointMQV0_0_1Test
import com.asyncapi.bindings.googlepubsub.GooglePubSubV0_1_0Test
import com.asyncapi.bindings.http.HTTPV0_3_0Test
import com.asyncapi.bindings.ibmmq.IBMMQV0_1_0Test
import com.asyncapi.bindings.kafka.KafkaV0_4_0Test
import com.asyncapi.bindings.mqtt.MQTTV0_1_0Test
import com.asyncapi.schemas.asyncapi.multiformat.AsyncAPIFormatSchema

class MessageTraitTestWithSchema: SerDeTest<MessageTrait>() {

    override fun objectClass() = MessageTrait::class.java

    override fun baseObjectJson() = "/json/v3/3.0.0/model/channel/message/messageTrait.json"

    override fun extendedObjectJson() = "/json/v3/3.0.0/model/channel/message/messageTrait - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/3.0.0/model/channel/message/messageTrait - wrongly extended.json"

    override fun build(): MessageTrait {
        return MessageTrait.builder()
                .headers(
                    AsyncAPISchema.builder()
                        .type("object")
                        .properties(mapOf(
                                Pair(
                                        "correlationId",
                                        AsyncAPISchema.builder()
                                                .description("Correlation ID set by application")
                                                .type("string")
                                                .build()
                                ),
                                Pair(
                                        "applicationInstanceId",
                                        AsyncAPISchema.builder()
                                                .description("Unique identifier for a given instance of the publishing application")
                                                .type("string")
                                                .build()
                                )
                        ))
                        .build()
                )
                .correlationId(CorrelationId("Default Correlation ID", "\$message.header#/correlationId"))
                .contentType("application/json")
                .name("UserSignup")
                .title("User signup")
                .summary("Action to sign a user up.")
                .description("A longer description")
                .tags(listOf(
                        Tag("user", null, null),
                        Tag("signup", null, null),
                        Tag("register", null, null),
                ))
                .externalDocs(ExternalDocumentation("User sign up rules", "messages/sign-up-rules"))
                .bindings(mapOf(
                        Pair("amqp", AMQPV0_2_0Test.messageBinding()),
                        Pair("amqp1",
                            Reference("#/components/messageBindings/amqp1")
                        ),
                        Pair("anypointmq", AnypointMQV0_0_1Test.messageBinding()),
                        Pair("googlepubsub", GooglePubSubV0_1_0Test.messageBinding()),
                        Pair("http", HTTPV0_3_0Test.messageBinding()),
                        Pair("ibmmq", IBMMQV0_1_0Test.messageBinding()),
                        Pair("jms",
                            Reference("#/components/messageBindings/jms")
                        ),
                        Pair("kafka", KafkaV0_4_0Test.messageBinding()),
                        Pair("mercure",
                            Reference("#/components/messageBindings/mercure")
                        ),
                        Pair("mqtt", MQTTV0_1_0Test.messageBinding()),
                        Pair("mqtt5",
                            Reference("#/components/messageBindings/mqtt5")
                        ),
                        Pair("nats",
                            Reference("#/components/messageBindings/nats")
                        ),
                        Pair("pulsar",
                            Reference("#/components/messageBindings/pulsar")
                        ),
                        Pair("redis",
                            Reference("#/components/messageBindings/redis")
                        ),
                        Pair("sns",
                            Reference("#/components/messageBindings/sns")
                        ),
                        Pair("solace",
                            Reference("#/components/messageBindings/solace")
                        ),
                        Pair("sqs",
                            Reference("#/components/messageBindings/sqs")
                        ),
                        Pair("stomp",
                            Reference("#/components/messageBindings/stomp")
                        ),
                        Pair("ws",
                            Reference("#/components/messageBindings/ws")
                        )
                ))
                .examples(listOf(MessageExampleTest().build()))
                .build()
    }

}

class MessageTraitTestWithReference: SerDeTest<MessageTrait>() {

    override fun objectClass() = MessageTrait::class.java

    override fun baseObjectJson() = "/json/v3/3.0.0/model/channel/message/messageTrait with reference.json"

    override fun extendedObjectJson() = "/json/v3/3.0.0/model/channel/message/messageTrait with reference - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/3.0.0/model/channel/message/messageTrait with reference - wrongly extended.json"

    override fun build(): MessageTrait {
        return MessageTrait.builder()
                .headers(Reference("#/components/messages/message-header"))
                .correlationId(Reference("#/components/messages/message-correlation-id"))
                .contentType("application/json")
                .name("UserSignup")
                .title("User signup")
                .summary("Action to sign a user up.")
                .description("A longer description")
                .tags(listOf(
                        Tag("user", null, null),
                        Tag("signup", null, null),
                        Tag("register", null, null),
                    Reference("#/components/tags/tag")
                ))
                .externalDocs(Reference("#/components/externalDocs/external-doc"))
                .bindings(mapOf(
                        Pair("amqp", AMQPV0_2_0Test.messageBinding()),
                        Pair("amqp1",
                            Reference("#/components/messageBindings/amqp1")
                        ),
                        Pair("anypointmq", AnypointMQV0_0_1Test.messageBinding()),
                        Pair("googlepubsub", GooglePubSubV0_1_0Test.messageBinding()),
                        Pair("http", HTTPV0_3_0Test.messageBinding()),
                        Pair("ibmmq", IBMMQV0_1_0Test.messageBinding()),
                        Pair("jms",
                            Reference("#/components/messageBindings/jms")
                        ),
                        Pair("kafka", KafkaV0_4_0Test.messageBinding()),
                        Pair("mercure",
                            Reference("#/components/messageBindings/mercure")
                        ),
                        Pair("mqtt", MQTTV0_1_0Test.messageBinding()),
                        Pair("mqtt5",
                            Reference("#/components/messageBindings/mqtt5")
                        ),
                        Pair("nats",
                            Reference("#/components/messageBindings/nats")
                        ),
                        Pair("pulsar",
                            Reference("#/components/messageBindings/pulsar")
                        ),
                        Pair("redis",
                            Reference("#/components/messageBindings/redis")
                        ),
                        Pair("sns",
                            Reference("#/components/messageBindings/sns")
                        ),
                        Pair("solace",
                            Reference("#/components/messageBindings/solace")
                        ),
                        Pair("sqs",
                            Reference("#/components/messageBindings/sqs")
                        ),
                        Pair("stomp",
                            Reference("#/components/messageBindings/stomp")
                        ),
                        Pair("ws",
                            Reference("#/components/messageBindings/ws")
                        )
                ))
                .examples(listOf(MessageExampleTest().build()))
                .build()
    }

}

class MessageTraitTestWithMultiFormatSchema: SerDeTest<MessageTrait>() {

    override fun objectClass() = MessageTrait::class.java

    override fun baseObjectJson() = "/json/v3/3.0.0/model/channel/message/messageTrait 2.json"

    override fun extendedObjectJson() = "/json/v3/3.0.0/model/channel/message/messageTrait 2 - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/3.0.0/model/channel/message/messageTrait 2 - wrongly extended.json"

    override fun build(): MessageTrait {
        return MessageTrait.builder()
                .headers(
                    AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+json;version=3.0.0",
                        AsyncAPISchema.builder()
                            .type("object")
                            .properties(
                                mapOf(
                                    Pair(
                                        "correlationId", AsyncAPISchema.builder()
                                            .type("string")
                                            .description("Correlation ID set by application")
                                            .build()
                                    ),
                                    Pair(
                                        "applicationInstanceId", AsyncAPISchema.builder()
                                            .type("string")
                                            .description("Unique identifier for a given instance of the publishing application")
                                            .build()
                                    )
                                )
                            )
                            .build()
                    )
                )
                .correlationId(Reference("#/components/messages/message-correlation-id"))
                .contentType("application/json")
                .name("UserSignup")
                .title("User signup")
                .summary("Action to sign a user up.")
                .description("A longer description")
                .tags(listOf(
                        Tag("user", null, null),
                        Tag("signup", null, null),
                        Tag("register", null, null),
                    Reference("#/components/tags/tag")
                ))
                .externalDocs(Reference("#/components/externalDocs/external-doc"))
                .bindings(mapOf(
                        Pair("amqp", AMQPV0_2_0Test.messageBinding()),
                        Pair("amqp1",
                            Reference("#/components/messageBindings/amqp1")
                        ),
                        Pair("anypointmq", AnypointMQV0_0_1Test.messageBinding()),
                        Pair("googlepubsub", GooglePubSubV0_1_0Test.messageBinding()),
                        Pair("http", HTTPV0_3_0Test.messageBinding()),
                        Pair("ibmmq", IBMMQV0_1_0Test.messageBinding()),
                        Pair("jms",
                            Reference("#/components/messageBindings/jms")
                        ),
                        Pair("kafka", KafkaV0_4_0Test.messageBinding()),
                        Pair("mercure",
                            Reference("#/components/messageBindings/mercure")
                        ),
                        Pair("mqtt", MQTTV0_1_0Test.messageBinding()),
                        Pair("mqtt5",
                            Reference("#/components/messageBindings/mqtt5")
                        ),
                        Pair("nats",
                            Reference("#/components/messageBindings/nats")
                        ),
                        Pair("pulsar",
                            Reference("#/components/messageBindings/pulsar")
                        ),
                        Pair("redis",
                            Reference("#/components/messageBindings/redis")
                        ),
                        Pair("sns",
                            Reference("#/components/messageBindings/sns")
                        ),
                        Pair("solace",
                            Reference("#/components/messageBindings/solace")
                        ),
                        Pair("sqs",
                            Reference("#/components/messageBindings/sqs")
                        ),
                        Pair("stomp",
                            Reference("#/components/messageBindings/stomp")
                        ),
                        Pair("ws",
                            Reference("#/components/messageBindings/ws")
                        )
                ))
                .examples(listOf(MessageExampleTest().build()))
                .build()
    }

}