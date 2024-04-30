package com.asyncapi.v2._0_0.model.channel.message

import com.asyncapi.v2.SerDeTest
import com.asyncapi.v2._0_0.model.ExternalDocumentation
import com.asyncapi.Reference
import com.asyncapi.v2._0_0.model.Tag
import com.asyncapi.v2.schema.Schema
import com.asyncapi.bindings.MessageBinding
import com.asyncapi.bindings.amqp.AMQPV0_2_0Test
import com.asyncapi.bindings.amqp1.v0._1_0.message.AMQP1MessageBinding
import com.asyncapi.bindings.anypointmq.AnypointMQV0_0_1Test
import com.asyncapi.bindings.googlepubsub.GooglePubSubV0_1_0Test
import com.asyncapi.bindings.http.HTTPV0_3_0Test
import com.asyncapi.bindings.ibmmq.IBMMQV0_1_0Test
import com.asyncapi.bindings.jms.v0._0_1.message.JMSMessageBinding
import com.asyncapi.bindings.kafka.KafkaV0_4_0Test
import com.asyncapi.bindings.mercure.v0._1_0.message.MercureMessageBinding
import com.asyncapi.bindings.mqtt.MQTTV0_1_0Test
import com.asyncapi.bindings.mqtt5.v0._2_0.message.MQTT5MessageBinding
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
                    Pair("amqp", AMQPV0_2_0Test.messageBinding()),
                    Pair("amqp1", AMQP1MessageBinding()),
                    Pair("anypointmq", AnypointMQV0_0_1Test.messageBinding()),
                    Pair("googlepubsub", GooglePubSubV0_1_0Test.messageBinding()),
                    Pair("http", HTTPV0_3_0Test.messageBinding()),
                    Pair("ibmmq", IBMMQV0_1_0Test.messageBinding()),
                    Pair("jms", JMSMessageBinding()),
                    Pair("kafka", KafkaV0_4_0Test.messageBinding()),
                    Pair("mercure", MercureMessageBinding()),
                    Pair("mqtt", MQTTV0_1_0Test.messageBinding()),
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
