package com.asyncapi.v2._6_0.binding.operation.solace

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.v2.binding.operation.solace.SolaceOperationBinding
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class SolaceOperationBindingTest {

    private val objectMapper = ObjectMapper()

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/binding/operation/solace/solaceOperationBinding.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, SolaceOperationBinding::class.java),
                build()
        )
    }

    companion object {
        @JvmStatic
        fun build(): SolaceOperationBinding {
            return SolaceOperationBinding.builder()
                    .destinations(listOf(
                            SolaceOperationBinding.Destination.builder()
                                    .destinationType("queue")
                                    .queue(SolaceOperationBinding.Destination.Queue.builder()
                                            .name("CreatedHREvents")
                                            .topicSubscriptions(listOf("person/*/created"))
                                            .accessType("exclusive")
                                            .maxMsgSpoolSize("1,500")
                                            .maxTtl("60")
                                            .build()
                                    )
                                    .build(),
                            SolaceOperationBinding.Destination.builder()
                                    .destinationType("queue")
                                    .queue(SolaceOperationBinding.Destination.Queue.builder()
                                            .name("UpdatedHREvents")
                                            .topicSubscriptions(listOf("person/*/updated"))
                                            .build()
                                    )
                                    .topic(SolaceOperationBinding.Destination.Topic.builder()
                                            .topicSubscriptions(listOf("person/*/updated"))
                                            .build()
                                    )
                                    .build()
                    ))
                    .build()
        }
    }

}