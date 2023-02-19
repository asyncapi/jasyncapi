package com.asyncapi.v2._6_0.binding.operation.kafka

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.v2.binding.operation.kafka.KafkaOperationBinding
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class KafkaOperationBindingTest {

    private val objectMapper = ObjectMapper()

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/binding/operation/kafka/kafkaOperationBinding.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, KafkaOperationBinding::class.java),
                build()
        )
    }

    companion object {
        @JvmStatic
        fun build(): KafkaOperationBinding {
            return KafkaOperationBinding.builder()
                    .groupId(mapOf(
                            Pair("type", "string"),
                            Pair("enum", listOf("myGroupId"))
                    ))
                    .clientId(mapOf(
                            Pair("type", "string"),
                            Pair("enum", listOf("myClientId"))
                    ))
                    .build()
        }
    }

}