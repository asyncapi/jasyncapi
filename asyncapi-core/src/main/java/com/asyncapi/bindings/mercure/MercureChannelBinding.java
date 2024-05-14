package com.asyncapi.bindings.mercure;

import com.asyncapi.bindings.ChannelBinding;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;

/**
 * Describes Mercure channel binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/mercure#channel-binding-object">Mercure channel binding</a>
 * @see <a href="https://mercure.rocks">Mercure</a>
 * @author Pavel Bodiachevskii
 * @since 1.0.0-RC2
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        defaultImpl = com.asyncapi.bindings.mercure.v0._1_0.channel.MercureChannelBinding.class,
        property = "bindingVersion",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = com.asyncapi.bindings.mercure.v0._1_0.channel.MercureChannelBinding.class, names = {
                "0.1.0",
                "latest"
        }),
})
@EqualsAndHashCode(callSuper = true)
public abstract class MercureChannelBinding extends ChannelBinding {
}
