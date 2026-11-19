package com.asyncapi.bindings.kafka.v0._6_0.operation;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type of the group a client joins, as Kafka's <code>GroupType</code> names it.
 *
 * @author Pavel Bodiachevskii
 * @version 0.6.0
 * @since 1.0.0-RC6
 */
public enum KafkaOperationGroupType {

    /**
     * The original group protocol.
     */
    @JsonProperty("classic")
    CLASSIC,

    /**
     * The consumer group protocol of KIP-848.
     */
    @JsonProperty("consumer")
    CONSUMER,

    /**
     * A share group, KIP-932.
     */
    @JsonProperty("share")
    SHARE,

    /**
     * A Kafka Streams group, KIP-1071.
     */
    @JsonProperty("streams")
    STREAMS

}
