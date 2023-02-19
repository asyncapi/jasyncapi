package com.asyncapi.v2.binding.message.googlepubsub;

import com.asyncapi.v2.binding.message.MessageBinding;
import lombok.*;

import javax.annotation.CheckForNull;

/**
 * The Message Binding Object is used to describe the Google Cloud Pub/Sub specific <a href="https://cloud.google.com/pubsub/docs/reference/rest/v1/PubsubMessage">PubsubMessage</a> details, alongside with
 * pertintent parts of the Google Cloud Pub/Sub <a href="https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.schemas#Schema">Schema</a> Object, with AsyncAPI.
 * <p>
 * Describes Google Cloud Pub/Sub message binding.
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
public class GooglePubSubMessageBinding extends MessageBinding {

    /**
     * If non-empty, identifies related messages for which publish order should be respected (For more information, see <a href="https://cloud.google.com/pubsub/docs/ordering">ordering messages</a>.)
     */
    @CheckForNull
    private String orderingKey;

    /**
     * Attributes for this message (If this field is empty, the message must contain non-empty data. This can be used to
     * filter messages on the subscription.)
     */
    @CheckForNull
    private Object attributes;

    /**
     * Describes the schema used to validate the payload of this message
     */
    @CheckForNull
    private SchemaDefinition schema;

    /**
     * OPTIONAL, defaults to latest. The version of this binding.
     */
    @CheckForNull
    @Builder.Default
    private String bindingVersion = "0.1.0";

    /**
     * The Schema Definition Object is used to describe the Google Cloud Pub/Sub Schema Object with AsyncAPI.
     * While some of this information could be, or is, described using native AsyncAPI, for consistency it makes sense to
     * provide this information here at all times, especially for cases where AsyncAPI does not natively support describing
     * payloads using a supported Google Cloud Pub/Sub schema format like Protobuf.
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class SchemaDefinition {

        /**
         * The name of the schema
         */
        @CheckForNull
        private String name;

        /**
         * The type of the schema
         */
        @CheckForNull
        private String type;

    }

}
