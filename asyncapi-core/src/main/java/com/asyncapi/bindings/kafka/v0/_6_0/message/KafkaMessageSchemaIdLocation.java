package com.asyncapi.bindings.kafka.v0._6_0.message;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Where the id of the schema is stored, when a Schema Registry is used.
 *
 * @author Pavel Bodiachevskii
 * @version 0.6.0
 * @since 1.0.0-RC6
 */
public enum KafkaMessageSchemaIdLocation {

    @JsonProperty("header")
    HEADER,

    @JsonProperty("payload")
    PAYLOAD

}
