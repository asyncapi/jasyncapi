package com.asyncapi.v2.binding.channel.googlepubsub;

import com.asyncapi.v2.binding.channel.ChannelBinding;
import lombok.*;

import javax.annotation.CheckForNull;
import java.util.List;
import java.util.Map;

/**
 * The Channel Bindings Object is used to describe the Google Cloud Pub/Sub specific <a href="https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.topics/create">Topic</a> details with AsyncAPI.
 * <p>
 * Describes Google Cloud Pub/Sub channel binding.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/googlepubsub#channel-binding-object">Google Cloud Pub/Sub channel binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GooglePubSubChannelBinding extends ChannelBinding {

    /**
     * The Google Cloud Pub/Sub Topic name
     */
    private String topic;

    /**
     * An object of key-value pairs (These are used to categorize Cloud Resources like Cloud Pub/Sub Topics.)
     */
    @CheckForNull
    private Map<String, Object> labels;

    /**
     * Indicates the minimum duration to retain a message after it is published to the topic (Must be a valid <a href="https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#google.protobuf.Duration">Duration</a>.)
     */
    @CheckForNull
    private String messageRetentionDuration;

    /**
     * Policy constraining the set of Google Cloud Platform regions where messages published to the topic may be stored
     */
    @CheckForNull
    private MessageStoragePolicy messageStoragePolicy;

    /**
     * Settings for validating messages published against a schema
     */
    @CheckForNull
    private SchemaSettings schemaSettings;

    /**
     * OPTIONAL, defaults to latest. The version of this binding.
     */
    @CheckForNull
    @Builder.Default
    private String bindingVersion = "0.1.0";

    /**
     * The Message Storage Policy Object is used to describe the Google Cloud Pub/Sub <a href="https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.topics#MessageStoragePolicy">MessageStoragePolicy</a> Object with AsyncAPI.
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class MessageStoragePolicy {

        /**
         * A list of IDs of GCP regions where messages that are published to the topic may be persisted in storage
         */
        @CheckForNull
        private List<String> allowedPersistenceRegions;

    }

    /**
     * The Schema Settings Object is used to describe the Google Cloud Pub/Sub <a href="https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.topics#SchemaSettings">SchemaSettings</a> Object with AsyncAPI.
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class SchemaSettings {

        /**
         * The encoding of the message (Must be one of the possible <a href="https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.topics#encoding">Encoding</a> values.)
         */
        @CheckForNull
        private String encoding;

        /**
         * The minimum (inclusive) revision allowed for validating messages
         */
        @CheckForNull
        private String firstRevisionId;

        /**
         * The maximum (inclusive) revision allowed for validating messages
         */
        @CheckForNull
        private String lastRevisionId;

        /**
         * The name of the schema that messages published should be validated against (The format is projects/{project}/schemas/{schema}.)
         */
        @CheckForNull
        private String name;

    }

}
