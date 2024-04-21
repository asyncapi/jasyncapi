package com.asyncapi.v2._0_0.model.channel.message

import com.asyncapi.v2.SerDeTest
import com.asyncapi.v2._0_0.model.ExternalDocumentation
import com.asyncapi.v2.Reference
import com.asyncapi.v2._0_0.model.Tag
import com.asyncapi.v2.schema.Schema
import com.asyncapi.bindings.MessageBinding
import com.asyncapi.v2.binding.message.amqp.AMQPMessageBindingTest
import com.asyncapi.v2.binding.message.amqp1.AMQP1MessageBinding
import com.asyncapi.v2.binding.message.anypointmq.AnypointMQMessageBindingTest
import com.asyncapi.v2.binding.message.googlepubsub.GooglePubSubMessageBindingTest
import com.asyncapi.v2.binding.message.http.HTTPMessageBindingTest
import com.asyncapi.v2.binding.message.ibmmq.IBMMQMessageBindingTest
import com.asyncapi.v2.binding.message.jms.JMSMessageBinding
import com.asyncapi.v2.binding.message.kafka.KafkaMessageBindingTest
import com.asyncapi.v2.binding.message.mercure.MercureMessageBinding
import com.asyncapi.v2.binding.message.mqtt.MQTTMessageBindingTest
import com.asyncapi.v2.binding.message.mqtt5.MQTT5MessageBinding
import com.asyncapi.bindings.nats.v0._1_0.message.NATSMessageBinding
import com.asyncapi.bindings.pulsar.v0._1_0.message.PulsarMessageBinding
import com.asyncapi.bindings.redis.v0._1_0.message.RedisMessageBinding
import com.asyncapi.bindings.sns.v0._1_0.message.SNSMessageBinding
import com.asyncapi.bindings.solace.v0._3_0.message.SolaceMessageBinding
import com.asyncapi.bindings.sqs.v0._1_0.message.SQSMessageBinding
import com.asyncapi.bindings.stomp.v0._1_0.message.STOMPMessageBinding
import com.asyncapi.bindings.websockets.v0._1_0.message.WebSocketsMessageBinding

/**
 * @author Pavel Bodiachevskii
 */
class MessageTest: SerDeTest<Message>() {

    override fun objectClass() = Message::class.java

    override fun baseObjectJson() = "/json/v2/2.0.0/model/channel/message/message.json"

    override fun extendedObjectJson() = "/json/v2/2.0.0/model/channel/message/message - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/2.0.0/model/channel/message/message - wrongly extended.json"

    override fun build(): Message {
        return Message.builder()
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
                .bindings(bindings())
                .examples(listOf(
                        mapOf(
                                Pair("headers", mapOf(
                                        Pair("correlationId", "my-correlation-id"),
                                        Pair("applicationInstanceId", "myInstanceId")
                                )),
                                Pair("payload", mapOf(
                                        Pair("user", mapOf(Pair("someUserKey", "someUserValue"))),
                                        Pair("signup", mapOf(Pair("someSignupKey", "someSignupValue")))
                                ))
                        )
                ))
                .traits(listOf(
                        Reference("#/components/messageTraits/commonHeaders"),
                ))
                .build()
    }

    companion object {
        fun bindings(): Map<String, MessageBinding> {
            return mapOf(
                    Pair("amqp", AMQPMessageBindingTest().build()),
                    Pair("amqp1", AMQP1MessageBinding()),
                    Pair("anypointmq", AnypointMQMessageBindingTest().build()),
                    Pair("googlepubsub", GooglePubSubMessageBindingTest().build()),
                    Pair("http", HTTPMessageBindingTest().build()),
                    Pair("ibmmq", IBMMQMessageBindingTest().build()),
                    Pair("jms", JMSMessageBinding()),
                    Pair("kafka", KafkaMessageBindingTest().build()),
                    Pair("mercure", MercureMessageBinding()),
                    Pair("mqtt", MQTTMessageBindingTest().build()),
                    Pair("mqtt5", MQTT5MessageBinding()),
                    Pair("nats", NATSMessageBinding()),
                    Pair("pulsar", PulsarMessageBinding()),
                    Pair("redis", RedisMessageBinding()),
                    Pair("sns", SNSMessageBinding()),
                    Pair("solace", SolaceMessageBinding()),
                    Pair("sqs", SQSMessageBinding()),
                    Pair("stomp", STOMPMessageBinding()),
                    Pair("ws", WebSocketsMessageBinding())
            )
        }
    }

}
