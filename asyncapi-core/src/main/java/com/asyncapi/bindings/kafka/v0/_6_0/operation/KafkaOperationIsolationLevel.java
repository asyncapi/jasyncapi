package com.asyncapi.bindings.kafka.v0._6_0.operation;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The <code>isolation.level</code> a consumer reads with.
 *
 * @author Pavel Bodiachevskii
 * @version 0.6.0
 * @since 1.0.0-RC6
 */
public enum KafkaOperationIsolationLevel {

    /**
     * Every record is returned.
     */
    @JsonProperty("read_uncommitted")
    READ_UNCOMMITTED,

    /**
     * Only committed transactional records are returned.
     */
    @JsonProperty("read_committed")
    READ_COMMITTED

}
