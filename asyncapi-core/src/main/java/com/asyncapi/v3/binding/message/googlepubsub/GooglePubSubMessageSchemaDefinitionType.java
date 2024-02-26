package com.asyncapi.v3.binding.message.googlepubsub;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes Google Cloud Pub/Sub message schema definition type.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/googlepubsub#message-binding-object">Google Cloud Pub/Sub message binding</a>
 * @see <a href="https://cloud.google.com/pubsub/docs/schemas#types-schema">Types of schemas</a>
 * @author Pavel Bodiachevskii
 */
@JsonClassDescription("Describes Google Cloud Pub/Sub message schema definition type.")
public enum GooglePubSubMessageSchemaDefinitionType {

    @JsonProperty("avro")
    AVRO,

    @JsonProperty("protobuf")
    PROTOBUF

}
