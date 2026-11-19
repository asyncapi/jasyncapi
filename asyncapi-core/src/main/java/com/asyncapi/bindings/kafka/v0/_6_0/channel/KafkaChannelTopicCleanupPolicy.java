package com.asyncapi.bindings.kafka.v0._6_0.channel;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Kafka topic cleanup policy: <code>cleanup.policy</code>.
 *
 * @see <a href="https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_cleanup.policy">cleanup.policy</a>
 * @author Pavel Bodiachevskii
 * @version 0.6.0
 * @since 1.0.0-RC6
 */
public enum KafkaChannelTopicCleanupPolicy {

    @JsonProperty("compact")
    COMPACT,

    @JsonProperty("delete")
    DELETE

}
