package com.asyncapi.v2._6_0.model.channel.operation

import com.asyncapi.Reference
import com.asyncapi.v2.SerDeTest
import com.asyncapi.v2._6_0.model.ExternalDocumentation
import com.asyncapi.v2._6_0.model.Tag
import com.asyncapi.bindings.amqp.v0._2_0.operation.AMQPOperationBindingTest
import com.asyncapi.bindings.http.v0._1_0.operation.HTTPOperationBindingTest
import com.asyncapi.bindings.kafka.v0._4_0.operation.KafkaOperationBindingTest
import com.asyncapi.bindings.mqtt.v0._1_0.operation.MQTTOperationBindingTest
import com.asyncapi.bindings.nats.v0._1_0.operation.NATSOperationBindingTest
import com.asyncapi.v2.binding.operation.solace.SolaceOperationBindingTest

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
                        Pair("amqp", AMQPOperationBindingTest().build()),
                        Pair("amqp1", Reference("#/components/operationBindings/amqp1")),
                        Pair("anypointmq", Reference("#/components/operationBindings/anypointmq")),
                        Pair("googlepubsub", Reference("#/components/operationBindings/googlepubsub")),
                        Pair("http", HTTPOperationBindingTest().build()),
                        Pair("ibmmq", Reference("#/components/operationBindings/ibmmq")),
                        Pair("jms", Reference("#/components/operationBindings/jms")),
                        Pair("kafka", KafkaOperationBindingTest().build()),
                        Pair("mercure", Reference("#/components/operationBindings/mercure")),
                        Pair("mqtt", MQTTOperationBindingTest().build()),
                        Pair("mqtt5", Reference("#/components/operationBindings/mqtt5")),
                        Pair("nats", NATSOperationBindingTest().build()),
                        Pair("pulsar", Reference("#/components/operationBindings/pulsar")),
                        Pair("redis", Reference("#/components/operationBindings/redis")),
                        Pair("sns", Reference("#/components/operationBindings/sns")),
                        Pair("solace", SolaceOperationBindingTest().build()),
                        Pair("sqs", Reference("#/components/operationBindings/sqs")),
                        Pair("stomp", Reference("#/components/operationBindings/stomp")),
                        Pair("ws", Reference("#/components/operationBindings/ws"))
                ))
                .build()
    }

}