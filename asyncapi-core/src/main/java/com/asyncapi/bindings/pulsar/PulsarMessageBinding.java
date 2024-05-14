package com.asyncapi.bindings.pulsar;

import com.asyncapi.bindings.MessageBinding;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;

/**
 * Describes Pulsar message binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/pulsar#message-binding-object">Pulsar message binding</a>
 * @see <a href="https://pulsar.apache.org">Pulsar</a>
 * @author Pavel Bodiachevskii
 * @version 0.1.0
 * @since 1.0.0-RC2
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        defaultImpl = com.asyncapi.bindings.pulsar.v0._1_0.message.PulsarMessageBinding.class,
        property = "bindingVersion",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = com.asyncapi.bindings.pulsar.v0._1_0.message.PulsarMessageBinding.class, names = {
                "0.1.0",
                "latest"
        }),
})
@EqualsAndHashCode(callSuper = true)
public abstract class PulsarMessageBinding extends MessageBinding {}