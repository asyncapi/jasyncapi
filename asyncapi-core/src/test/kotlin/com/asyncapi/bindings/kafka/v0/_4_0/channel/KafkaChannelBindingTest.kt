package com.asyncapi.bindings.kafka.v0._4_0.channel

import com.asyncapi.v3.SerDeTest

/**
 * @version 3.0.0
 * @author Pavel Bodiachevskii
 */
class KafkaChannelBindingTest: SerDeTest<KafkaChannelBinding>() {

    override fun objectClass() = KafkaChannelBinding::class.java

    override fun baseObjectJson() = "/bindings/kafka/channel/kafkaChannelBinding.json"

    override fun extendedObjectJson() = "/bindings/kafka/channel/kafkaChannelBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/bindings/kafka/channel/kafkaChannelBinding - wrongly extended.json"

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