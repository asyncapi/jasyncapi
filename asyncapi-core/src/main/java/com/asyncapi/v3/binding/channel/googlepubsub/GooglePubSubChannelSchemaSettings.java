package com.asyncapi.v3.binding.channel.googlepubsub;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Describes Google Cloud Pub/Sub SchemaSettings.
 * <p>
 * The Schema Settings Object is used to describe the Google Cloud Pub/Sub <a href="https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.topics#SchemaSettings">SchemaSettings</a> Object with AsyncAPI.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@JsonClassDescription("Describe the Google Cloud Pub/Sub SchemaSettings")
public class GooglePubSubChannelSchemaSettings {

    /**
     * The encoding of the message (Must be one of the possible <a href="https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.topics#encoding">Encoding</a> values.)
     */
    @NotNull
    @Builder.Default
    @javax.validation.constraints.NotNull
    @JsonProperty(value = "encoding", required = true)
    @JsonPropertyDescription("The encoding of the message (Must be one of the possible https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.topics#encoding values.)")
    private String encoding = "";

    /**
     * The minimum (inclusive) revision allowed for validating messages
     */
    @Nullable
    @JsonProperty("firstRevisionId")
    @JsonPropertyDescription("The minimum (inclusive) revision allowed for validating messages")
    private String firstRevisionId;

    /**
     * The maximum (inclusive) revision allowed for validating messages
     */
    @Nullable
    @JsonProperty("lastRevisionId")
    @JsonPropertyDescription("The maximum (inclusive) revision allowed for validating messages")
    private String lastRevisionId;

    /**
     * The name of the schema that messages published should be validated against (The format is projects/{project}/schemas/{schema}.)
     */
    @NotNull
    @Builder.Default
    @javax.validation.constraints.NotNull
    @JsonProperty(value = "name", required = true)
    @JsonPropertyDescription("The name of the schema that messages published should be validated against (The format is projects/{project}/schemas/{schema}.)")
    private String name = "";

}
