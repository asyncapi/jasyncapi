package com.asyncapi.bindings.nats;

import com.asyncapi.bindings.ChannelBinding;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;

/**
 * Describes NATS channel binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/nats#channel-binding-object">NATS channel binding</a>
 * @see <a href="https://nats.io">NATS</a>
 * @author Pavel Bodiachevskii
 * @version 0.1.0
 * @since 1.0.0-RC2
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        defaultImpl = com.asyncapi.bindings.nats.v0._1_0.channel.NATSChannelBinding.class,
        property = "bindingVersion",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = com.asyncapi.bindings.nats.v0._1_0.channel.NATSChannelBinding.class, names = {
                "0.1.0",
                "latest"
        }),
})
@EqualsAndHashCode(callSuper = true)
public abstract class NATSChannelBinding extends ChannelBinding {}