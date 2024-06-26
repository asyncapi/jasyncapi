package com.asyncapi.v2._0_0.model.server

import com.asyncapi.v2.SerDeTest
import com.asyncapi.bindings.ServerBinding
import com.asyncapi.bindings.amqp1.v0._1_0.server.AMQP1ServerBinding
import com.asyncapi.bindings.anypointmq.v0._0_1.server.AnypointMQServerBinding
import com.asyncapi.bindings.googlepubsub.GooglePubSubV0_2_0Test
import com.asyncapi.bindings.http.HTTPV0_3_0Test
import com.asyncapi.bindings.ibmmq.v0._1_0.server.IBMMQServerBinding
import com.asyncapi.bindings.jms.v0._0_1.server.JMSServerBinding
import com.asyncapi.bindings.kafka.v0._5_0.server.KafkaServerBinding
import com.asyncapi.bindings.mercure.v0._1_0.server.MercureServerBinding
import com.asyncapi.bindings.mqtt.v0._1_0.server.MQTTServerBinding
import com.asyncapi.bindings.mqtt.v0._1_0.server.MQTTServerLastWillConfiguration
import com.asyncapi.bindings.mqtt5.v0._2_0.server.MQTT5ServerBinding
import com.asyncapi.bindings.nats.v0._1_0.server.NATSServerBinding
import com.asyncapi.bindings.pulsar.v0._1_0.server.PulsarServerBinding
import com.asyncapi.bindings.redis.v0._1_0.server.RedisServerBinding
import com.asyncapi.bindings.sns.v0._1_0.server.SNSServerBinding
import com.asyncapi.bindings.solace.v0._4_0.server.SolaceServerBinding
import com.asyncapi.bindings.sqs.SQSV0_2_0Test
import com.asyncapi.bindings.stomp.v0._1_0.server.STOMPServerBinding
import com.asyncapi.bindings.websockets.v0._1_0.server.WebSocketsServerBinding

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
                    Pair("googlepubsub", GooglePubSubV0_2_0Test.serverBinding()),
                    Pair("http", HTTPV0_3_0Test.serverBinding()),
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
                    Pair("solace", SolaceServerBinding.builder()
                            .msgVpn("ProdVPN")
                            .clientName("transactions-broker")
                            .build()
                    ),
                    Pair("sqs", SQSV0_2_0Test.serverBinding()),
                    Pair("stomp", STOMPServerBinding()),
                    Pair("ws", WebSocketsServerBinding()),
            )
        }
    }

}
