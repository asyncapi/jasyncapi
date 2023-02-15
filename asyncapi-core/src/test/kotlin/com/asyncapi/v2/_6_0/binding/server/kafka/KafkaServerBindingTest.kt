package com.asyncapi.v2._6_0.binding.server.kafka

import com.asyncapi.v2.ClasspathUtils
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @version 2.6.0
 * @author Pavel Bodiachevskii
 */
class KafkaServerBindingTest {

    private val objectMapper = ObjectMapper()

    private fun build(): KafkaServerBinding {
        return KafkaServerBinding.builder()
                .schemaRegistryUrl("https://my-schema-registry.com")
                .schemaRegistryVendor("confluent")
                .build()
    }

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/binding/server/kafka/kafkaServerBinding.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, KafkaServerBinding::class.java),
                build()
        )
    }

}