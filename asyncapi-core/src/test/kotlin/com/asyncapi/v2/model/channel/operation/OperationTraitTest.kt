package com.asyncapi.v2.model.channel.operation

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.v2._0_0.binding.amqp.AMQPOperationBinding
import com.asyncapi.v2._0_0.model.channel.operation.OperationTrait
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @author Pavel Bodiachevskii
 */
class OperationTraitTest {

    private val objectMapper = ObjectMapper()

    private fun buildOperationTrait(): OperationTrait {
        return OperationTrait.builder()
                .bindings(mutableMapOf(
                        Pair("amqp", AMQPOperationBinding.builder()
                                .ack(false).build()
                        )
                ))
                .build()
    }

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/model/channel/operation/operationTrait.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, OperationTrait::class.java),
                buildOperationTrait()
        )
    }

}
