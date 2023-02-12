package com.asyncapi.v2._6_0.model.channel.message

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.v2._6_0.binding.message.amqp.AMQPMessageBindingTest
import com.asyncapi.v2._6_0.binding.message.anypointmq.AnypointMQMessageBindingTest
import com.asyncapi.v2._6_0.binding.message.googlepubsub.GooglePubSubMessageBindingTest
import com.asyncapi.v2._6_0.binding.message.http.HTTPMessageBindingTest
import com.asyncapi.v2._6_0.binding.message.ibmmq.IBMMQMessageBindingTest
import com.asyncapi.v2._6_0.binding.message.kafka.KafkaMessageBindingTest
import com.asyncapi.v2._6_0.binding.message.mqtt.MQTTMessageBindingTest
import com.asyncapi.v2._6_0.model.ExternalDocumentation
import com.asyncapi.v2._6_0.model.Reference
import com.asyncapi.v2._6_0.model.Tag
import com.asyncapi.v2._6_0.model.schema.Schema
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MessageTest {

    private val objectMapper = ObjectMapper()

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/model/channel/message/message.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, Message::class.java),
                build()
        )
    }

    companion object {
        @JvmStatic
        fun build(): Message {
            return Message.builder()
                    .messageId("userSignup")
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
                    .payload(Schema.builder()
                            .type("object")
                            .properties(mapOf(
                                    Pair(
                                            "user",
                                            Schema.builder()
                                                    .ref("#/components/schemas/userCreate")
                                                    .build()
                                    ),
                                    Pair(
                                            "signup",
                                            Schema.builder()
                                                    .ref("#/components/schemas/signup")
                                                    .build()
                                    )
                            ))
                            .build()
                    )
                    .correlationId(CorrelationId("Default Correlation ID", "\$message.header#/correlationId"))
                    .schemaFormat("application/vnd.apache.avro+json;version=1.9.0")
                    .contentType("application/json")
                    .name("UserSignup")
                    .title("User signup")
                    .summary("Action to sign a user up.")
                    .description("A longer description")
                    .tags(listOf(
                            Tag("user", null, null),
                            Tag("signup", null, null),
                            Tag("register", null, null)
                    ))
                    .externalDocs(ExternalDocumentation("User sign up rules", "messages/sign-up-rules"))
                    .bindings(mapOf(
                            Pair("amqp", AMQPMessageBindingTest.build()),
                            Pair("amqp1", Reference("#/components/messageBindings/amqp1")),
                            Pair("anypointmq", AnypointMQMessageBindingTest.build()),
                            Pair("googlepubsub", GooglePubSubMessageBindingTest.build()),
                            Pair("http", HTTPMessageBindingTest.build()),
                            Pair("ibmmq", IBMMQMessageBindingTest.build()),
                            Pair("jms", Reference("#/components/messageBindings/jms")),
                            Pair("kafka", KafkaMessageBindingTest.build()),
                            Pair("mercure", Reference("#/components/messageBindings/mercure")),
                            Pair("mqtt", MQTTMessageBindingTest.build()),
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
                    .examples(listOf(MessageExampleTest.build()))
                    .traits(listOf(
                            Reference("#/components/messageTraits/commonHeaders"),
                    ))
                    .build()
        }
    }

}