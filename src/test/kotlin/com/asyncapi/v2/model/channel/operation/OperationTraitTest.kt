package com.asyncapi.v2.model.channel.operation

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.v2.model.Tag
import com.asyncapi.v2.model.channel.message.Message
import com.google.gson.GsonBuilder
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @author Pavel Bodiachevskii
 */
class OperationTraitTest {

    private val gson = GsonBuilder().setPrettyPrinting().create()

    private fun buildOperationTrait(): OperationTrait {
        return OperationTrait.builder()
                .bindings(mapOf(
                        Pair("amqp", mapOf(
                                Pair("ack", false)
                        ))
                ))
                .build()
    }

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/model/channel/operation/operationTrait.json")

        Assertions.assertEquals(
                gson.fromJson(model, OperationTrait::class.java),
                buildOperationTrait()
        )
    }

}
