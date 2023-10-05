package com.asyncapi.v3.binding.message.kafka;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes Kafka message schema id location.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/kafka#message-binding-object">Kafka message binding</a>
 * @author Pavel Bodiachevskii
 */
public enum KafkaMessageSchemaIdLocation {

    @JsonProperty("header")
    HEADER,

    @JsonProperty("payload")
    PAYLOAD

}
