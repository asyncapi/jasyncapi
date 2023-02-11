package com.asyncapi.v2._6_0.model.channel.operation

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.v2._6_0.binding.operation.amqp.AMQPOperationBindingTest
import com.asyncapi.v2._6_0.binding.operation.http.HTTPOperationBindingTest
import com.asyncapi.v2._6_0.binding.operation.kafka.KafkaOperationBindingTest
import com.asyncapi.v2._6_0.binding.operation.mqtt.MQTTOperationBindingTest
import com.asyncapi.v2._6_0.binding.operation.nats.NATSOperationBindingTest
import com.asyncapi.v2._6_0.binding.operation.solace.SolaceOperationBindingTest
import com.asyncapi.v2._6_0.model.ExternalDocumentation
import com.asyncapi.v2._6_0.model.Reference
import com.asyncapi.v2._6_0.model.Tag
import com.asyncapi.v2._6_0.model.channel.message.MessageTest
import com.asyncapi.v2._6_0.model.channel.message.OneOfMessages
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class OperationTest {

    private val objectMapper = ObjectMapper()

    private fun build(): Operation {
        return Operation.builder()
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
                        Pair("amqp", AMQPOperationBindingTest.build()),
                        Pair("amqp1", Reference("#/components/operationBindings/amqp1")),
                        Pair("anypointmq", Reference("#/components/operationBindings/anypointmq")),
                        Pair("googlepubsub", Reference("#/components/operationBindings/googlepubsub")),
                        Pair("http", HTTPOperationBindingTest.build()),
                        Pair("ibmmq", Reference("#/components/operationBindings/ibmmq")),
                        Pair("jms", Reference("#/components/operationBindings/jms")),
                        Pair("kafka", KafkaOperationBindingTest.build()),
                        Pair("mercure", Reference("#/components/operationBindings/mercure")),
                        Pair("mqtt", MQTTOperationBindingTest.build()),
                        Pair("mqtt5", Reference("#/components/operationBindings/mqtt5")),
                        Pair("nats", NATSOperationBindingTest.build()),
                        Pair("pulsar", Reference("#/components/operationBindings/pulsar")),
                        Pair("redis", Reference("#/components/operationBindings/redis")),
                        Pair("sns", Reference("#/components/operationBindings/sns")),
                        Pair("solace", SolaceOperationBindingTest.build()),
                        Pair("sqs", Reference("#/components/operationBindings/sqs")),
                        Pair("stomp", Reference("#/components/operationBindings/stomp")),
                        Pair("ws", Reference("#/components/operationBindings/ws"))
                ))
                .traits(listOf(
                        Reference("#/components/operationTraits/sendMessage"),
                        OperationTraitTest.build()
                ))
                .build()
    }

    @Test
    @DisplayName("Operation with reference to message")
    fun referenceToMessage() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/model/channel/operation/operation with reference to message.json")

        val operation = build()
        operation.message = Reference("#/components/schemas/sendMessage")
        Assertions.assertEquals(
                objectMapper.readValue(model, Operation::class.java),
                operation
        )
    }

    @Test
    @DisplayName("Operation with message")
    fun message() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/model/channel/operation/operation with message.json")

        val operation = build()
        operation.message = MessageTest.build()
        Assertions.assertEquals(
                objectMapper.readValue(model, Operation::class.java),
                operation
        )
    }

    @Test
    @DisplayName("Operation with message oneOf")
    fun messageOneOf() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/model/channel/operation/operation with oneOf message.json")

        val operation = build()
        operation.message = OneOfMessages(listOf(
                Reference("#/components/schemas/sendMessage"),
                MessageTest.build()
        ))
        Assertions.assertEquals(
                objectMapper.readValue(model, Operation::class.java),
                operation
        )
    }

}