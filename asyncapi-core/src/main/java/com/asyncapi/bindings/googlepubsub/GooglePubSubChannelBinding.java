package com.asyncapi.bindings.googlepubsub;

import com.asyncapi.bindings.ChannelBinding;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;

/**
 * Describes Google Cloud Pub/Sub channel binding.
 * <p>
 * The Channel Bindings Object is used to describe the Google Cloud Pub/Sub specific <a href="https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.topics/create">Topic</a> details with AsyncAPI.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/googlepubsub#channel-binding-object">Google Cloud Pub/Sub channel binding</a>
 * @see <a href="https://cloud.google.com/pubsub">Google Cloud Pub/Sub</a>
 * @author Pavel Bodiachevskii
 * @since 1.0.0-RC2
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        defaultImpl = com.asyncapi.bindings.googlepubsub.v0._2_0.channel.GooglePubSubChannelBinding.class,
        property = "bindingVersion",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = com.asyncapi.bindings.googlepubsub.v0._1_0.channel.GooglePubSubChannelBinding.class, names = "0.1.0"),
        @JsonSubTypes.Type(value = com.asyncapi.bindings.googlepubsub.v0._2_0.channel.GooglePubSubChannelBinding.class, names = {
                "0.2.0",
                "latest"
        }),
})
@EqualsAndHashCode(callSuper = true)
public abstract class GooglePubSubChannelBinding extends ChannelBinding {}