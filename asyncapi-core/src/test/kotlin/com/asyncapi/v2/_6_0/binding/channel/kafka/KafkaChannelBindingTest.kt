package com.asyncapi.v2._6_0.binding.channel.kafka

import com.asyncapi.v2.ClasspathUtils
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @version 2.6.0
 * @author Pavel Bodiachevskii
 */
class KafkaChannelBindingTest {

    private val objectMapper = ObjectMapper()

    private fun build(): KafkaChannelBinding {
        return KafkaChannelBinding.builder()
                .topic("my-specific-topic-name")
                .partitions(20)
                .replicas(3)
                .topicConfiguration(KafkaChannelBinding.TopicConfiguration.builder()
                        .cleanupPolicy(listOf("delete", "compact"))
                        .retentionMs(604_800_000)
                        .retentionBytes(1_000_000_000)
                        .deleteRetentionMs(86_400_000)
                        .maxMessageBytes(1_048_588)
                        .build()
                )
                .build()
    }

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/binding/channel/kafka/kafkaChannelBinding.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, KafkaChannelBinding::class.java),
                build()
        )
    }

}