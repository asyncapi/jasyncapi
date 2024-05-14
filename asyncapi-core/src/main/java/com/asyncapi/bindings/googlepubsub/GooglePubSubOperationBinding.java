package com.asyncapi.bindings.googlepubsub;

import com.asyncapi.bindings.OperationBinding;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;

/**
 * Describes Google Cloud Pub/Sub operation binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/googlepubsub#operation-binding-object">Google Cloud Pub/Sub operation binding</a>
 * @see <a href="https://cloud.google.com/pubsub">Google Cloud Pub/Sub</a>
 * @author Pavel Bodiachevskii
 * @since 1.0.0-RC2
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        defaultImpl = com.asyncapi.bindings.googlepubsub.v0._2_0.operation.GooglePubSubOperationBinding.class,
        property = "bindingVersion",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = com.asyncapi.bindings.googlepubsub.v0._1_0.operation.GooglePubSubOperationBinding.class, names = "0.1.0"),
        @JsonSubTypes.Type(value = com.asyncapi.bindings.googlepubsub.v0._2_0.operation.GooglePubSubOperationBinding.class, names = {
                "0.2.0",
                "latest"
        }),
})
@EqualsAndHashCode(callSuper = true)
public abstract class GooglePubSubOperationBinding extends OperationBinding {}