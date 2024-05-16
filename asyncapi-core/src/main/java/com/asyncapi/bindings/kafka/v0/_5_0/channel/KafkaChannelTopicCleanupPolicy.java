package com.asyncapi.bindings.kafka.v0._5_0.channel;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Kafka channel cleanup policy.
 *
 * @see <a href="https://kafka.apache.org">Kafka</a>
 * @author Pavel Bodiachevskii
 * @version 0.5.0
 * @since 1.0.0-RC2
 */
public enum KafkaChannelTopicCleanupPolicy {

    @JsonProperty("compact")
    COMPACT,

    @JsonProperty("delete")
    DELETE

}
