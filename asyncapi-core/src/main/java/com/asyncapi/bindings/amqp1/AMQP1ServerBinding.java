package com.asyncapi.bindings.amqp1;

import com.asyncapi.bindings.ServerBinding;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;

/**
 * Describes AMQP 1.0 server binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/amqp1#server-binding-object">AMQP server binding</a>
 * @see <a href="https://www.amqp.org">AMQP</a>
 * @author Pavel Bodiachevskii
 * @version 0.1.0
 * @since 1.0.0-RC2
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        defaultImpl = com.asyncapi.bindings.amqp1.v0._1_0.server.AMQP1ServerBinding.class,
        property = "bindingVersion",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = com.asyncapi.bindings.amqp1.v0._1_0.server.AMQP1ServerBinding.class, names = {
                "0.1.0",
                "latest"
        }),
})
@EqualsAndHashCode(callSuper = true)
public abstract class AMQP1ServerBinding extends ServerBinding {}