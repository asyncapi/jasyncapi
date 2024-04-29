package com.asyncapi.bindings.pulsar;

import com.asyncapi.bindings.MessageBinding;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;

/**
 * Describes Pulsar message binding.
 * <p>
 * This object MUST NOT contain any properties. Its name is reserved for future use.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/pulsar#message-binding-object">Pulsar message binding</a>
 * @author Pavel Bodiachevskii
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
public class PulsarMessageBinding extends MessageBinding {}