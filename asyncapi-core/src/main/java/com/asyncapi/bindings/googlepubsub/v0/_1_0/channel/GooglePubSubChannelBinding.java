package com.asyncapi.bindings.googlepubsub.v0._1_0.channel;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

/**
 * Describes Google Cloud Pub/Sub channel binding.
 * <p>
 * The Channel Bindings Object is used to describe the Google Cloud Pub/Sub specific <a href="https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.topics/create">Topic</a> details with AsyncAPI.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/googlepubsub#channel-binding-object">Google Cloud Pub/Sub channel binding</a>
 * @see <a href="https://cloud.google.com/pubsub">Google Cloud Pub/Sub</a>
 * @author Pavel Bodiachevskii
 * @version 0.1.0
 * @since 1.0.0-RC2
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonClassDescription("Describes Google Cloud Pub/Sub channel binding.")
public class GooglePubSubChannelBinding extends com.asyncapi.bindings.googlepubsub.GooglePubSubChannelBinding {

    /**
     * The Google Cloud Pub/Sub Topic name.
     */
    @NotNull
    @Builder.Default
    @jakarta.validation.constraints.NotNull
    @JsonProperty(value = "topic", required = true)
    @JsonPropertyDescription("The Google Cloud Pub/Sub Topic name.")
    private String topic = "";

    /**
     * An object of key-value pairs (These are used to categorize Cloud Resources like Cloud Pub/Sub Topics.)
     */
    @Nullable
    @JsonProperty("labels")
    @JsonPropertyDescription("An object of key-value pairs (These are used to categorize Cloud Resources like Cloud Pub/Sub Topics.)")
    private Map<String, Object> labels;

    /**
     * Indicates the minimum duration to retain a message after it is published to the topic (Must be a valid <a href="https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#google.protobuf.Duration">Duration</a>.)
     */
    @Nullable
    @JsonProperty("messageRetentionDuration")
    @JsonPropertyDescription("Indicates the minimum duration to retain a message after it is published to the topic (Must be a valid https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#google.protobuf.Duration.)")
    private String messageRetentionDuration;

    /**
     * Policy constraining the set of Google Cloud Platform regions where messages published to the topic may be stored
     */
    @Nullable
    @JsonProperty("messageStoragePolicy")
    @JsonPropertyDescription("Policy constraining the set of Google Cloud Platform regions where messages published to the topic may be stored")
    private GooglePubSubChannelMessageStoragePolicy messageStoragePolicy;

    /**
     * Settings for validating messages published against a schema
     */
    @NotNull
    @Builder.Default
    @jakarta.validation.constraints.NotNull
    @JsonProperty(value = "schemaSettings", required = true)
    @JsonPropertyDescription("Settings for validating messages published against a schema")
    private GooglePubSubChannelSchemaSettings schemaSettings = new GooglePubSubChannelSchemaSettings();

    @Override
    public String getBindingVersion() {
        return "0.1.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.1.0");
    }

}
