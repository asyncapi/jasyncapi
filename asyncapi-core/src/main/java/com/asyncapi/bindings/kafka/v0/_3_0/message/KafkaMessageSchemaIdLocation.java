package com.asyncapi.bindings.kafka.v0._3_0.message;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes Kafka message schema id location.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/kafka#message-binding-object">Kafka message binding</a>
 * @see <a href="https://kafka.apache.org">Kafka</a>
 * @author Pavel Bodiachevskii
 * @version 0.3.0
 * @since 1.0.0-RC2
 */
public enum KafkaMessageSchemaIdLocation {

    @JsonProperty("header")
    HEADER,

    @JsonProperty("payload")
    PAYLOAD

}
