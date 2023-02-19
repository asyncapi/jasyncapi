package com.asyncapi.v2._0_0.model.channel.operation

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.v2._0_0.model.Reference
import com.asyncapi.v2._0_0.model.Tag
import com.asyncapi.v2._0_0.model.channel.message.Message
import com.asyncapi.v2._0_0.model.schema.Schema
import com.asyncapi.v2._0_0.model.schema.Type
import com.asyncapi.v2.binding.operation.amqp.AMQPOperationBinding
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @author Pavel Bodiachevskii
 */
class OperationTest {

    private val objectMapper = ObjectMapper().registerKotlinModule()

    private fun buildOperation(): Operation {
        return Operation.builder()
                .operationId("registerUser")
                .summary("Action to sign a user up.")
                .description("A longer description")
                .tags(listOf(
                        Tag("user", null, null),
                        Tag("signup", null, null),
                        Tag("register", null, null)
                ))
                .message(Message.builder()
                        .headers(Schema.builder()
                                .type(Type.OBJECT)
                                .properties(mapOf(
                                        Pair("applicationInstanceId", Schema.builder()
                                                .type(Type.STRING)
                                                .description("Unique identifier for a given instance of the publishing application")
                                                .build()
                                        )
                                ))
                                .build()
                        )
                        .payload(Schema.builder()
                                .type(Type.OBJECT)
                                .properties(mapOf(
                                        Pair("user", Schema.builder().ref("#/components/schemas/userCreate").build()),
                                        Pair("signup", Schema.builder().ref("#/components/schemas/signup").build())
                                ))
                                .build()
                        )
                        .build()
                )
                .bindings(mutableMapOf(
                        Pair("amqp", AMQPOperationBinding.builder().ack(false).build())
                ))
                .traits(listOf(
                        Reference("#/components/operationTraits/kafka"),
                        OperationTrait.builder()
                                .bindings(mapOf(
                                        Pair("amqp", AMQPOperationBinding.builder().ack(false).build())
                                ))
                                .build()
                ))
                .build()
    }

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/model/channel/operation/operation.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, Operation::class.java),
                buildOperation()
        )
    }

}
