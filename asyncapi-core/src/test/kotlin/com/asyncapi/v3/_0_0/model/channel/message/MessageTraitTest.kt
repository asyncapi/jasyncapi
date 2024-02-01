package com.asyncapi.v3._0_0.model.channel.message

import com.asyncapi.v3.Reference
import com.asyncapi.v3.SerDeTest
import com.asyncapi.v3._0_0.model.ExternalDocumentation
import com.asyncapi.v3._0_0.model.Tag
import com.asyncapi.v3.schema.Schema
import com.asyncapi.v3.schema.MultiFormatSchema
import com.asyncapi.v3.binding.message.amqp.AMQPMessageBindingTest
import com.asyncapi.v3.binding.message.anypointmq.AnypointMQMessageBindingTest
import com.asyncapi.v3.binding.message.googlepubsub.GooglePubSubMessageBindingTest
import com.asyncapi.v3.binding.message.http.HTTPMessageBindingTest
import com.asyncapi.v3.binding.message.ibmmq.IBMMQMessageBindingTest
import com.asyncapi.v3.binding.message.kafka.KafkaMessageBindingTest
import com.asyncapi.v3.binding.message.mqtt.MQTTMessageBindingTest

class MessageTraitTestWithSchema: SerDeTest<MessageTrait>() {

    override fun objectClass() = MessageTrait::class.java

    override fun baseObjectJson() = "/json/v3/3.0.0/model/channel/message/messageTrait.json"

    override fun extendedObjectJson() = "/json/v3/3.0.0/model/channel/message/messageTrait - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/3.0.0/model/channel/message/messageTrait - wrongly extended.json"

    override fun build(): MessageTrait {
        return MessageTrait.builder()
                .headers(Schema.builder()
                        .type("object")
                        .properties(mapOf(
                                Pair(
                                        "correlationId",
                                        Schema.builder()
                                                .description("Correlation ID set by application")
                                                .type("string")
                                                .build()
                                ),
                                Pair(
                                        "applicationInstanceId",
                                        Schema.builder()
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
                        Pair("amqp", AMQPMessageBindingTest().build()),
                        Pair("amqp1", Reference("#/components/messageBindings/amqp1")),
                        Pair("anypointmq", AnypointMQMessageBindingTest().build()),
                        Pair("googlepubsub", GooglePubSubMessageBindingTest().build()),
                        Pair("http", HTTPMessageBindingTest().build()),
                        Pair("ibmmq", IBMMQMessageBindingTest().build()),
                        Pair("jms", Reference("#/components/messageBindings/jms")),
                        Pair("kafka", KafkaMessageBindingTest().build()),
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
                        Pair("amqp", AMQPMessageBindingTest().build()),
                        Pair("amqp1", Reference("#/components/messageBindings/amqp1")),
                        Pair("anypointmq", AnypointMQMessageBindingTest().build()),
                        Pair("googlepubsub", GooglePubSubMessageBindingTest().build()),
                        Pair("http", HTTPMessageBindingTest().build()),
                        Pair("ibmmq", IBMMQMessageBindingTest().build()),
                        Pair("jms", Reference("#/components/messageBindings/jms")),
                        Pair("kafka", KafkaMessageBindingTest().build()),
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
                .headers(MultiFormatSchema.builder()
                        .schemaFormat("application/vnd.aai.asyncapi+json;version=3.0.0")
                        .schema(linkedMapOf(
                                Pair("type", "object"),
                                Pair("properties", mapOf(
                                        Pair(
                                                "correlationId",
                                                mapOf(
                                                        Pair("description", "Correlation ID set by application"),
                                                        Pair("type", "string")
                                                )
                                        ),
                                        Pair(
                                                "applicationInstanceId",
                                                mapOf(
                                                        Pair("description", "Unique identifier for a given instance of the publishing application"),
                                                        Pair("type", "string")
                                                )
                                        )
                                ))
                        )).build()
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
                        Pair("amqp", AMQPMessageBindingTest().build()),
                        Pair("amqp1", Reference("#/components/messageBindings/amqp1")),
                        Pair("anypointmq", AnypointMQMessageBindingTest().build()),
                        Pair("googlepubsub", GooglePubSubMessageBindingTest().build()),
                        Pair("http", HTTPMessageBindingTest().build()),
                        Pair("ibmmq", IBMMQMessageBindingTest().build()),
                        Pair("jms", Reference("#/components/messageBindings/jms")),
                        Pair("kafka", KafkaMessageBindingTest().build()),
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
                ))
                .examples(listOf(MessageExampleTest().build()))
                .build()
    }

}