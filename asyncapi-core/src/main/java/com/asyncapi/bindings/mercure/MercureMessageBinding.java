package com.asyncapi.bindings.mercure;

import com.asyncapi.bindings.MessageBinding;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;

/**
 * Describes Mercure message binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/mercure#message-binding-object">Mercure message binding</a>
 * @see <a href="https://mercure.rocks">Mercure</a>
 * @author Pavel Bodiachevskii
 * @since 1.0.0-RC2
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        defaultImpl = com.asyncapi.bindings.mercure.v0._1_0.message.MercureMessageBinding.class,
        property = "bindingVersion",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = com.asyncapi.bindings.mercure.v0._1_0.message.MercureMessageBinding.class, names = {
                "0.1.0",
                "latest"
        }),
})
@EqualsAndHashCode(callSuper = true)
public abstract class MercureMessageBinding extends MessageBinding {
}
