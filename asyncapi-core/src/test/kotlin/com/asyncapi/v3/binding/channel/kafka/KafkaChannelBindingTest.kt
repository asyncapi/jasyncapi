package com.asyncapi.v3.binding.channel.kafka

import com.asyncapi.v3.SerDeTest
import com.asyncapi.bindings.kafka.v0._4_0.channel.KafkaChannelBinding
import com.asyncapi.bindings.kafka.v0._4_0.channel.KafkaChannelTopicCleanupPolicy
import com.asyncapi.bindings.kafka.v0._4_0.channel.KafkaChannelTopicConfiguration

/**
 * @version 3.0.0
 * @author Pavel Bodiachevskii
 */
class KafkaChannelBindingTest: SerDeTest<KafkaChannelBinding>() {

    override fun objectClass() = KafkaChannelBinding::class.java

    override fun baseObjectJson() = "/json/v3/binding/channel/kafka/kafkaChannelBinding.json"

    override fun extendedObjectJson() = "/json/v3/binding/channel/kafka/kafkaChannelBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/binding/channel/kafka/kafkaChannelBinding - wrongly extended.json"

    override fun build(): KafkaChannelBinding {
        return KafkaChannelBinding.builder()
                .topic("my-specific-topic-name")
                .partitions(20)
                .replicas(3)
                .topicConfiguration(KafkaChannelTopicConfiguration.builder()
                        .cleanupPolicy(listOf(
                                KafkaChannelTopicCleanupPolicy.DELETE,
                                KafkaChannelTopicCleanupPolicy.COMPACT
                        ))
                        .retentionMs(604_800_000)
                        .retentionBytes(1_000_000_000)
                        .deleteRetentionMs(86_400_000)
                        .maxMessageBytes(1_048_588)
                        .build()
                )
                .build()
    }

}