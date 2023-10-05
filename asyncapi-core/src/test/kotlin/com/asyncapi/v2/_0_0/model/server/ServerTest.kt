package com.asyncapi.v2._0_0.model.server

import com.asyncapi.v2.SerDeTest
import com.asyncapi.v2.binding.server.ServerBinding
import com.asyncapi.v2.binding.server.amqp1.AMQP1ServerBinding
import com.asyncapi.v2.binding.server.anypointmq.AnypointMQServerBinding
import com.asyncapi.v2.binding.server.googlepubsub.GooglePubSubServerBinding
import com.asyncapi.v2.binding.server.http.HTTPServerBinding
import com.asyncapi.v2.binding.server.ibmmq.IBMMQServerBinding
import com.asyncapi.v2.binding.server.jms.JMSServerBinding
import com.asyncapi.v2.binding.server.kafka.KafkaServerBinding
import com.asyncapi.v2.binding.server.mercure.MercureServerBinding
import com.asyncapi.v2.binding.server.mqtt.MQTTServerBinding
import com.asyncapi.v2.binding.server.mqtt.MQTTServerLastWillConfiguration
import com.asyncapi.v2.binding.server.mqtt5.MQTT5ServerBinding
import com.asyncapi.v2.binding.server.nats.NATSServerBinding
import com.asyncapi.v2.binding.server.pulsar.PulsarServerBinding
import com.asyncapi.v2.binding.server.redis.RedisServerBinding
import com.asyncapi.v2.binding.server.sns.SNSServerBinding
import com.asyncapi.v2.binding.server.solace.SolaceServerBinding
import com.asyncapi.v2.binding.server.sqs.SQSServerBinding
import com.asyncapi.v2.binding.server.stomp.STOMPServerBinding
import com.asyncapi.v2.binding.server.ws.WebSocketsServerBinding

/**
 * @author Pavel Bodiachevskii
 */
class ServerTest: SerDeTest<Server>() {

    override fun objectClass() = Server::class.java

    override fun baseObjectJson() = "/json/v2/2.0.0/model/server/server.json"

    override fun extendedObjectJson() = "/json/v2/2.0.0/model/server/server - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/2.0.0/model/server/server - wrongly extended.json"

    override fun build(): Server {
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
                                .build())
                ))
                .security(listOf(mapOf(
                        Pair("mqttBroker", emptyList())
                )))
                .bindings(bindings())
                .build()
    }

    companion object {
        @JvmStatic
        fun bindings(): Map<String, ServerBinding> {
            return mapOf(
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
                                    .lastWill(MQTTServerLastWillConfiguration(
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
