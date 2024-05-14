package com.asyncapi.bindings.googlepubsub.v0._1_0.message;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes Google Cloud Pub/Sub message schema definition type.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/googlepubsub#message-binding-object">Google Cloud Pub/Sub message binding</a>
 * @see <a href="https://cloud.google.com/pubsub/docs/schemas#types-schema">Types of schemas</a>
 * @see <a href="https://cloud.google.com/pubsub">Google Cloud Pub/Sub</a>
 * @author Pavel Bodiachevskii
 * @version 0.1.0
 * @since 1.0.0-RC2
 */
@JsonClassDescription("Describes Google Cloud Pub/Sub message schema definition type.")
public enum GooglePubSubMessageSchemaDefinitionType {

    @JsonProperty("avro")
    AVRO,

    @JsonProperty("protobuf")
    PROTOBUF

}
