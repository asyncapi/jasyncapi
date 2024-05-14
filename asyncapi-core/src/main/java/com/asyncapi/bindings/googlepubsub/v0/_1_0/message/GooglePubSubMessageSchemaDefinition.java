package com.asyncapi.bindings.googlepubsub.v0._1_0.message;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.*;
import org.jetbrains.annotations.NotNull;

/**
 * Describes Google Cloud Pub/Sub message schema definition.
 * <p>
 * The Schema Definition Object is used to describe the Google Cloud Pub/Sub Schema Object with AsyncAPI.
 * While some of this information could be, or is, described using native AsyncAPI, for consistency it makes sense to
 * provide this information here at all times, especially for cases where AsyncAPI does not natively support describing
 * payloads using a supported Google Cloud Pub/Sub schema format like Protobuf.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/googlepubsub#message-binding-object">Google Cloud Pub/Sub message binding</a>
 * @see <a href="https://cloud.google.com/pubsub">Google Cloud Pub/Sub</a>
 * @author Pavel Bodiachevskii
 * @version 0.1.0
 * @since 1.0.0-RC2
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@JsonClassDescription("Describes Google Cloud Pub/Sub message schema definition.")
public class GooglePubSubMessageSchemaDefinition {

    /**
     * The name of the schema
     */
    @NotNull
    @Builder.Default
    @javax.validation.constraints.NotNull
    @JsonProperty(value = "name", required = true)
    @JsonPropertyDescription("The name of the schema")
    private String name = "";

    /**
     * The type of the schema
     */
    @NotNull
    @Builder.Default
    @javax.validation.constraints.NotNull
    @JsonProperty(value = "type", required = true)
    @JsonPropertyDescription("The type of the schema")
    private GooglePubSubMessageSchemaDefinitionType type = GooglePubSubMessageSchemaDefinitionType.PROTOBUF;

}
