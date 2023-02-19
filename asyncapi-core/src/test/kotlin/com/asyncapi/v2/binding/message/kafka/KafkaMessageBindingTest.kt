package com.asyncapi.v2.binding.message.kafka

import com.asyncapi.v2.ClasspathUtils
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class KafkaMessageBindingTest {

    private val objectMapper = ObjectMapper()

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/binding/message/kafka/kafkaMessageBinding.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, KafkaMessageBinding::class.java),
                build()
        )
    }

    companion object {
        @JvmStatic
        fun build(): KafkaMessageBinding {
            return KafkaMessageBinding.builder()
                    .key(mapOf(
                            Pair("type", "string"),
                            Pair("enum", listOf("myKey"))
                    ))
                    .schemaIdLocation("payload")
                    .schemaIdPayloadEncoding("apicurio-new")
                    .schemaLookupStrategy("TopicIdStrategy")
                    .build()
        }
    }

}