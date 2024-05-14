package com.asyncapi.bindings.amqp;

import com.asyncapi.bindings.ServerBinding;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Describes AMQP 0-9-1 server binding.
 * <p>
 * Contains information about the server representation in AMQP.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/amqp#server-binding-object">AMQP server binding</a>
 * @see <a href="https://www.amqp.org">AMQP</a>
 * @author Pavel Bodiachevskii
 * @since 1.0.0-RC2
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        defaultImpl = com.asyncapi.bindings.amqp.v0._3_0.server.AMQPServerBinding.class,
        property = "bindingVersion",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = com.asyncapi.bindings.amqp.v0._1_0.server.AMQPServerBinding.class, name = "0.1.0"),
        @JsonSubTypes.Type(value = com.asyncapi.bindings.amqp.v0._2_0.server.AMQPServerBinding.class, name = "0.2.0"),
        @JsonSubTypes.Type(value = com.asyncapi.bindings.amqp.v0._3_0.server.AMQPServerBinding.class, names = {
                "0.3.0",
                "latest"
        }),
})
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class AMQPServerBinding extends ServerBinding {}