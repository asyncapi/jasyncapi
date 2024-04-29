package com.asyncapi.v3._0_0.model.channel.message

import com.asyncapi.Reference
import com.asyncapi.v3.SerDeTest
import com.asyncapi.v3._0_0.model.ExternalDocumentation
import com.asyncapi.v3._0_0.model.Tag
import com.asyncapi.bindings.amqp.AMQPV0_2_0Test
import com.asyncapi.bindings.anypointmq.AnypointMQV0_0_1Test
import com.asyncapi.bindings.googlepubsub.GooglePubSubV0_1_0Test
import com.asyncapi.bindings.http.HTTPV0_3_0Test
import com.asyncapi.bindings.ibmmq.IBMMQV0_1_0Test
import com.asyncapi.bindings.kafka.KafkaV0_4_0Test
import com.asyncapi.bindings.mqtt.v0._1_0.message.MQTTMessageBindingTest
import com.asyncapi.v3.schema.AsyncAPISchema
import com.asyncapi.v3.schema.multiformat.AsyncAPIFormatSchema

class MessageTestWithSchema: SerDeTest<Message>() {

    override fun objectClass() = Message::class.java

    override fun baseObjectJson() = "/json/v3/3.0.0/model/channel/message/message.json"

    override fun extendedObjectJson() = "/json/v3/3.0.0/model/channel/message/message - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/3.0.0/model/channel/message/message - wrongly extended.json"

    override fun build(): Message {
        return Message.builder()
                .headers(AsyncAPISchema.builder()
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
                .payload(AsyncAPISchema.builder()
                        .type("object")
                        .properties(mapOf(
                                Pair(
                                        "metric",
                                        AsyncAPISchema.builder()
                                                .description("Metric set by application")
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
                .bindings(bindings())
                .examples(listOf(MessageExampleTest().build()))
                .traits(listOf(
                        MessageTraitTestWithSchema().build(),
                        MessageTraitTestWithReference().build(),
                        MessageTraitTestWithMultiFormatSchema().build()
                ))
                .build()
    }

    companion object {
        fun bindings(): Map<String, Any> {
            return mapOf(
                    Pair("amqp", AMQPV0_2_0Test.messageBinding()),
                    Pair("amqp1", Reference("#/components/messageBindings/amqp1")),
                    Pair("anypointmq", AnypointMQV0_0_1Test.messageBinding()),
                    Pair("googlepubsub", GooglePubSubV0_1_0Test.messageBinding()),
                    Pair("http", HTTPV0_3_0Test.messageBinding()),
                    Pair("ibmmq", IBMMQV0_1_0Test.messageBinding()),
                    Pair("jms", Reference("#/components/messageBindings/jms")),
                    Pair("kafka", KafkaV0_4_0Test.messageBinding()),
                    Pair("mercure", Reference("#/components/messageBindings/mercure")),
                    Pair("mqtt", MQTTMessageBindingTest().build()),
                    Pair("mqtt5", Reference("#/components/messageBindings/mqtt5")),
                    Pair("nats", Reference("#/components/messageBindings/nats")),
                    Pair("pulsar", Reference("#/components/messageBindings/pulsar")),
                    Pair("redis", Reference("#/components/messageBindings/redis")),
                    Pair("sns", Reference("#/components/messageBindings/sns")),
                    Pair("solace", Reference("#/components/messageBindings/solace")),
                    Pair("sqs", Reference("#/components/messageBindings/sqs")),
                    Pair("stomp", Reference("#/components/messageBindings/stomp")),
                    Pair("ws", Reference("#/components/messageBindings/ws"))
            )
        }
    }

}

class MessageTestWithReference: SerDeTest<Message>() {

    override fun objectClass() = Message::class.java

    override fun baseObjectJson() = "/json/v3/3.0.0/model/channel/message/message with reference.json"

    override fun extendedObjectJson() = "/json/v3/3.0.0/model/channel/message/message with reference - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/3.0.0/model/channel/message/message with reference - wrongly extended.json"

    override fun build(): Message {
        return Message.builder()
                .headers(Reference("#/components/messages/message-header"))
                .payload(Reference("#/components/messages/message-payload"))
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
                        Pair("amqp1", Reference("#/components/messageBindings/amqp1")),
                        Pair("anypointmq", AnypointMQV0_0_1Test.messageBinding()),
                        Pair("googlepubsub", GooglePubSubV0_1_0Test.messageBinding()),
                        Pair("http", HTTPV0_3_0Test.messageBinding()),
                        Pair("ibmmq", IBMMQV0_1_0Test.messageBinding()),
                        Pair("jms", Reference("#/components/messageBindings/jms")),
                        Pair("kafka", KafkaV0_4_0Test.messageBinding()),
                        Pair("mercure",
                            Reference("#/components/messageBindings/mercure")
                        ),
                        Pair("mqtt", MQTTMessageBindingTest().build()),
                        Pair("mqtt5", Reference("#/components/messageBindings/mqtt5")),
                        Pair("nats", Reference("#/components/messageBindings/nats")),
                        Pair("pulsar", Reference("#/components/messageBindings/pulsar")),
                        Pair("redis", Reference("#/components/messageBindings/redis")),
                        Pair("sns", Reference("#/components/messageBindings/sns")),
                        Pair("solace", Reference("#/components/messageBindings/solace")),
                        Pair("sqs", Reference("#/components/messageBindings/sqs")),
                        Pair("stomp", Reference("#/components/messageBindings/stomp")),
                        Pair("ws", Reference("#/components/messageBindings/ws"))
                ))
                .examples(listOf(MessageExampleTest().build()))
                .traits(listOf(
                        MessageTraitTestWithSchema().build(),
                        MessageTraitTestWithReference().build(),
                        MessageTraitTestWithMultiFormatSchema().build()
                ))
                .build()
    }

}

class MessageTestWithMultiFormatSchema: SerDeTest<Message>() {

    override fun objectClass() = Message::class.java

    override fun baseObjectJson() = "/json/v3/3.0.0/model/channel/message/message 2.json"

    override fun extendedObjectJson() = "/json/v3/3.0.0/model/channel/message/message 2 - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/3.0.0/model/channel/message/message 2 - wrongly extended.json"

    override fun build(): Message {
        return Message.builder()
                .headers(AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+json;version=3.0.0",
                        AsyncAPISchema.builder()
                                .type("object")
                                .properties(mapOf(
                                        Pair("correlationId", AsyncAPISchema.builder()
                                                .type("string")
                                                .description("Correlation ID set by application")
                                                .build()
                                        ),
                                        Pair("applicationInstanceId", AsyncAPISchema.builder()
                                                .type("string")
                                                .description("Unique identifier for a given instance of the publishing application")
                                                .build()
                                        )
                                ))
                                .build()
                ))
                .payload(AsyncAPIFormatSchema(
                        "application/vnd.aai.asyncapi+json;version=3.0.0",
                        AsyncAPISchema.builder()
                                .type("object")
                                .properties(mapOf(
                                        Pair("metric", AsyncAPISchema.builder()
                                                .type("string")
                                                .description("Metric set by application")
                                                .build()
                                        )
                                ))
                                .build()
                ))
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
                        Pair("amqp1", Reference("#/components/messageBindings/amqp1")),
                        Pair("anypointmq", AnypointMQV0_0_1Test.messageBinding()),
                        Pair("googlepubsub", GooglePubSubV0_1_0Test.messageBinding()),
                        Pair("http", HTTPV0_3_0Test.messageBinding()),
                        Pair("ibmmq", IBMMQV0_1_0Test.messageBinding()),
                        Pair("jms", Reference("#/components/messageBindings/jms")),
                        Pair("kafka", KafkaV0_4_0Test.messageBinding()),
                        Pair("mercure",
                            Reference("#/components/messageBindings/mercure")
                        ),
                        Pair("mqtt", MQTTMessageBindingTest().build()),
                        Pair("mqtt5", Reference("#/components/messageBindings/mqtt5")),
                        Pair("nats", Reference("#/components/messageBindings/nats")),
                        Pair("pulsar", Reference("#/components/messageBindings/pulsar")),
                        Pair("redis", Reference("#/components/messageBindings/redis")),
                        Pair("sns", Reference("#/components/messageBindings/sns")),
                        Pair("solace", Reference("#/components/messageBindings/solace")),
                        Pair("sqs", Reference("#/components/messageBindings/sqs")),
                        Pair("stomp", Reference("#/components/messageBindings/stomp")),
                        Pair("ws", Reference("#/components/messageBindings/ws"))
                ))
                .examples(listOf(MessageExampleTest().build()))
                .traits(listOf(
                        MessageTraitTestWithSchema().build(),
                        MessageTraitTestWithReference().build(),
                        MessageTraitTestWithMultiFormatSchema().build()
                ))
                .build()
    }

}