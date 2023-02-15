package com.asyncapi.v2._6_0.model.server

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.v2._6_0.binding.server.amqp1.AMQP1ServerBinding
import com.asyncapi.v2._6_0.binding.server.anypointmq.AnypointMQServerBinding
import com.asyncapi.v2._6_0.binding.server.googlepubsub.GooglePubSubServerBinding
import com.asyncapi.v2._6_0.binding.server.http.HTTPServerBinding
import com.asyncapi.v2._6_0.binding.server.ibmmq.IBMMQServerBinding
import com.asyncapi.v2._6_0.binding.server.jms.JMSServerBinding
import com.asyncapi.v2._6_0.binding.server.kafka.KafkaServerBinding
import com.asyncapi.v2._6_0.binding.server.mercure.MercureServerBinding
import com.asyncapi.v2._6_0.binding.server.mqtt.MQTTServerBinding
import com.asyncapi.v2._6_0.binding.server.mqtt5.MQTT5ServerBinding
import com.asyncapi.v2._6_0.binding.server.nats.NATSServerBinding
import com.asyncapi.v2._6_0.binding.server.pulsar.PulsarServerBinding
import com.asyncapi.v2._6_0.binding.server.redis.RedisServerBinding
import com.asyncapi.v2._6_0.binding.server.sns.SNSServerBinding
import com.asyncapi.v2._6_0.binding.server.solace.SolaceServerBinding
import com.asyncapi.v2._6_0.binding.server.sqs.SQSServerBinding
import com.asyncapi.v2._6_0.binding.server.stomp.STOMPServerBinding
import com.asyncapi.v2._6_0.binding.server.ws.WebSocketsServerBinding
import com.asyncapi.v2._6_0.model.Reference
import com.asyncapi.v2._6_0.model.Tag
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @version 2.6.0
 * @author Pavel Bodiachevskii
 */
class ServerTest {

    private val objectMapper = ObjectMapper()

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/model/server/server.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, Server::class.java),
                build()
        )
    }

    companion object {
        @JvmStatic
        fun build(): Server {
            return Server.builder()
                    .url("{username}.gigantic-server.com:{port}/{basePath}")
                    .protocol("secure-mqtt")
                    .protocolVersion("5")
                    .description("The production API server")
                    .variables(mapOf(
                            Pair("username", ServerVariable.builder()
                                    .defaultValue("demo")
                                    .description("This value is assigned by the service provider, in this example `gigantic-server.com`")
                                    .build()),
                            Pair("port", ServerVariable.builder()
                                    .enumValues(listOf("8883", "8884"))
                                    .defaultValue("8883")
                                    .build()),
                            Pair("basePath", Reference("#/components/serverVariables/basePath"))
                    ))
                    .security(listOf(mapOf(
                            Pair("mqttBroker", emptyList())
                    )))
                    .tags(listOf(
                            Tag("env:staging", "This environment is a replica of the production environment", null)
                    ))
                    .bindings(bindings())
                    .build()
        }

        @JvmStatic
        fun bindings(): Map<String, Any> {
            return mapOf(
                    Pair("amqp", Reference("#/components/serverBindings/amqp")),
                    Pair("amqp1", AMQP1ServerBinding()),
                    Pair("anypointmq", AnypointMQServerBinding()),
                    Pair("googlepubsub", GooglePubSubServerBinding()),
                    Pair("http", HTTPServerBinding()),
                    Pair(
                            "ibmmq",
                            IBMMQServerBinding.builder()
                                    .groupId("PRODCLSTR1")
                                    .cipherSpec("ANY_TLS12_OR_HIGHER")
                                    .build()
                    ),
                    Pair("jms", JMSServerBinding()),
                    Pair(
                            "kafka",
                            KafkaServerBinding.builder()
                                    .schemaRegistryUrl("https://my-schema-registry.com")
                                    .schemaRegistryVendor("confluent")
                                    .build()
                    ),
                    Pair("mercure", MercureServerBinding()),
                    Pair(
                            "mqtt",
                            MQTTServerBinding.builder()
                                    .clientId("guest")
                                    .cleanSession(true)
                                    .lastWill(MQTTServerBinding.LastWillConfiguration(
                                            "/last-wills",
                                            2,
                                            "Guest gone offline.",
                                            false
                                    ))
                                    .keepAlive(60)
                                    .build()
                    ),
                    Pair(
                            "mqtt5",
                            MQTT5ServerBinding.builder()
                                    .sessionExpiryInterval(60)
                                    .build()
                    ),
                    Pair("nats", NATSServerBinding()),
                    Pair(
                            "pulsar",
                            PulsarServerBinding.builder()
                                    .tenant("contoso")
                                    .build()
                    ),
                    Pair("redis", RedisServerBinding()),
                    Pair("sns", SNSServerBinding()),
                    Pair(
                            "solace",
                            SolaceServerBinding.builder()
                                    .msgVpn("solace.private.net")
                                    .build()
                    ),
                    Pair("sqs", SQSServerBinding()),
                    Pair("stomp", STOMPServerBinding()),
                    Pair("ws", WebSocketsServerBinding()),
            )
        }
    }

}
