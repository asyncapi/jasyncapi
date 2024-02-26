package com.asyncapi.v2.binding.message.googlepubsub;

import com.asyncapi.v2.binding.message.MessageBinding;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

/**
 * Describes Google Cloud Pub/Sub message binding.
 * <p>
 * The Message Binding Object is used to describe the Google Cloud Pub/Sub specific <a href="https://cloud.google.com/pubsub/docs/reference/rest/v1/PubsubMessage">PubsubMessage</a> details, alongside with
 * pertintent parts of the Google Cloud Pub/Sub <a href="https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.schemas#Schema">Schema</a> Object, with AsyncAPI.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/googlepubsub#message-binding-object">Google Cloud Pub/Sub message binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonClassDescription("Describes Google Cloud Pub/Sub message binding.")
public class GooglePubSubMessageBinding extends MessageBinding {

    /**
     * If non-empty, identifies related messages for which publish order should be respected (For more information, see <a href="https://cloud.google.com/pubsub/docs/ordering">ordering messages</a>.)
     */
    @Nullable
    @JsonProperty("orderingKey")
    @JsonPropertyDescription("If non-empty, identifies related messages for which publish order should be respected (For more information, see https://cloud.google.com/pubsub/docs/ordering messages")
    private String orderingKey;

    /**
     * Attributes for this message (If this field is empty, the message must contain non-empty data. This can be used to
     * filter messages on the subscription.)
     */
    @Nullable
    @JsonProperty("attributes")
    @JsonPropertyDescription("Attributes for this message (If this field is empty, the message must contain non-empty data. This can be used to filter messages on the subscription.)")
    private Object attributes;

    /**
     * Describes the schema used to validate the payload of this message
     */
    @Nullable
    @JsonProperty("schema")
    @JsonPropertyDescription("Describes the schema used to validate the payload of this message")
    private GooglePubSubMessageSchemaDefinition schema;

    /**
     * The version of this binding.
     */
    @Nullable
    @Builder.Default
    @JsonProperty("bindingVersion")
    @JsonPropertyDescription("The version of this binding.")
    private String bindingVersion = "0.1.0";

}
