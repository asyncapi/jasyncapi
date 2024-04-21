package com.asyncapi.v3._0_0.model.server

import com.asyncapi.v3.Reference
import com.asyncapi.v3.SerDeTest
import com.asyncapi.v3._0_0.model.ExternalDocumentationTest
import com.asyncapi.v3._0_0.model.Tag
import com.asyncapi.v3.binding.server.amqp1.AMQP1ServerBinding
import com.asyncapi.v3.binding.server.anypointmq.AnypointMQServerBinding
import com.asyncapi.v3.binding.server.googlepubsub.GooglePubSubServerBinding
import com.asyncapi.v3.binding.server.http.HTTPServerBinding
import com.asyncapi.v3.binding.server.ibmmq.IBMMQServerBinding
import com.asyncapi.v3.binding.server.jms.JMSServerBinding
import com.asyncapi.v3.binding.server.kafka.KafkaServerBinding
import com.asyncapi.v3.binding.server.mercure.MercureServerBinding
import com.asyncapi.v3.binding.server.mqtt.MQTTServerBinding
import com.asyncapi.v3.binding.server.mqtt.MQTTServerLastWillConfiguration
import com.asyncapi.bindings.mqtt5.v0._2_0.server.MQTT5ServerBinding
import com.asyncapi.bindings.nats.v0._1_0.server.NATSServerBinding
import com.asyncapi.bindings.pulsar.v0._1_0.server.PulsarServerBinding
import com.asyncapi.bindings.redis.v0._1_0.server.RedisServerBinding
import com.asyncapi.bindings.sns.v0._1_0.server.SNSServerBinding
import com.asyncapi.bindings.solace.v0._3_0.server.SolaceServerBinding
import com.asyncapi.bindings.sqs.v0._1_0.server.SQSServerBinding
import com.asyncapi.bindings.stomp.v0._1_0.server.STOMPServerBinding
import com.asyncapi.bindings.websockets.v0._1_0.server.WebSocketsServerBinding
import com.asyncapi.v3.security_scheme.ApiKeySecuritySchemeTest
import com.asyncapi.v3.security_scheme.http.HttpSecuritySchemeBearerTest

/**
 * @version 3.0.0
 * @author Pavel Bodiachevskii
 */
class ServerTest: SerDeTest<Server>() {

    override fun objectClass() = Server::class.java

    override fun baseObjectJson() = "/json/v3/3.0.0/model/server/server.json"

    override fun extendedObjectJson() = "/json/v3/3.0.0/model/server/server - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/3.0.0/model/server/server - wrongly extended.json"

    override fun build(): Server {
        return Server.builder()
                .host("{username}.gigantic-server.com:{port}/{basePath}")
                .protocol("secure-mqtt")
                .protocolVersion("5")
                .pathname("/messages")
                .description("The production API server")
                .title("secure-mqtt API server")
                .summary("API server")
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
                .security(listOf(
                        ApiKeySecuritySchemeTest().build(),
                        HttpSecuritySchemeBearerTest().build()
                ))
                .tags(listOf(
                        Tag("env:staging", "This environment is a replica of the production environment", null)
                ))
                .externalDocs(ExternalDocumentationTest().build())
                .bindings(bindings())
                .build()
    }

    companion object {
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

class ServerTestWithReference: SerDeTest<Server>() {

    override fun objectClass() = Server::class.java

    override fun baseObjectJson() = "/json/v3/3.0.0/model/server/server with reference.json"

    override fun extendedObjectJson() = "/json/v3/3.0.0/model/server/server with reference - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/3.0.0/model/server/server with reference - wrongly extended.json"

    override fun build(): Server {
        return Server.builder()
                .host("{username}.gigantic-server.com:{port}/{basePath}")
                .protocol("secure-mqtt")
                .protocolVersion("5")
                .pathname("/messages")
                .description("The production API server")
                .title("secure-mqtt API server")
                .summary("API server")
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
                .security(listOf(
                        ApiKeySecuritySchemeTest().build(),
                        HttpSecuritySchemeBearerTest().build(),
                        Reference("#/components/securitySchemes/openId")
                ))
                .tags(listOf(
                        Tag("env:staging", "This environment is a replica of the production environment", null),
                        Reference("#/components/tags/tag_name")
                ))
                .externalDocs(Reference("#/components/externalDocs/externalDoc"))
                .bindings(bindings())
                .build()
    }

    companion object {
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
