package com.asyncapi.v2._6_0.model.channel.operation

import com.asyncapi.schemas.asyncapi.Reference
import com.asyncapi.v2.SerDeTest
import com.asyncapi.v2._6_0.model.ExternalDocumentation
import com.asyncapi.v2._6_0.model.Tag
import com.asyncapi.bindings.amqp.AMQPV0_2_0Test
import com.asyncapi.bindings.http.HTTPV0_3_0Test
import com.asyncapi.bindings.kafka.KafkaV0_4_0Test
import com.asyncapi.bindings.mqtt.MQTTV0_1_0Test
import com.asyncapi.bindings.nats.NATSV0_1_0Test
import com.asyncapi.bindings.solace.SolaceV0_4_0Test

class OperationTraitTest: SerDeTest<OperationTrait>() {

    override fun objectClass() = OperationTrait::class.java

    override fun baseObjectJson() = "/json/v2/2.6.0/model/channel/operation/operationTrait.json"

    override fun extendedObjectJson() = "/json/v2/2.6.0/model/channel/operation/operationTrait - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/2.6.0/model/channel/operation/operationTrait - wrongly extended.json"

    override fun build(): OperationTrait {
        return OperationTrait.builder()
                .operationId("sendMessage")
                .summary("Send message")
                .description("Send message to remote server")
                .security(listOf(
                        mapOf(
                                Pair("api_key", listOf("write:messages"))
                        )
                ))
                .tags(listOf(
                        Tag.builder()
                                .name("messages")
                                .description("operations with messages")
                                .externalDocs(ExternalDocumentation("Messages validation rules", "messages/validation-rules"))
                                .build()
                ))
                .externalDocs(ExternalDocumentation("Messages sending rules", "messages/sending-rules"))
                .bindings(mapOf(
                        Pair("amqp", AMQPV0_2_0Test.operationBinding()),
                        Pair("amqp1",
                            Reference("#/components/operationBindings/amqp1")
                        ),
                        Pair("anypointmq",
                            Reference("#/components/operationBindings/anypointmq")
                        ),
                        Pair("googlepubsub",
                            Reference("#/components/operationBindings/googlepubsub")
                        ),
                        Pair("http", HTTPV0_3_0Test.operationBinding()),
                        Pair("ibmmq",
                            Reference("#/components/operationBindings/ibmmq")
                        ),
                        Pair("jms",
                            Reference("#/components/operationBindings/jms")
                        ),
                        Pair("kafka", KafkaV0_4_0Test.operationBinding()),
                        Pair("mercure",
                            Reference("#/components/operationBindings/mercure")
                        ),
                        Pair("mqtt", MQTTV0_1_0Test.operationBinding()),
                        Pair("mqtt5",
                            Reference("#/components/operationBindings/mqtt5")
                        ),
                        Pair("nats", NATSV0_1_0Test.operationBinding()),
                        Pair("pulsar",
                            Reference("#/components/operationBindings/pulsar")
                        ),
                        Pair("redis",
                            Reference("#/components/operationBindings/redis")
                        ),
                        Pair("sns",
                            Reference("#/components/operationBindings/sns")
                        ),
                        Pair("solace", SolaceV0_4_0Test.operationBinding()),
                        Pair("sqs",
                            Reference("#/components/operationBindings/sqs")
                        ),
                        Pair("stomp",
                            Reference("#/components/operationBindings/stomp")
                        ),
                        Pair("ws",
                            Reference("#/components/operationBindings/ws")
                        )
                ))
                .build()
    }

}