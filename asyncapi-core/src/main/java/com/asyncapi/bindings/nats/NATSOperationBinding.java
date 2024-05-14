package com.asyncapi.bindings.nats;

import com.asyncapi.bindings.OperationBinding;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;

/**
 * Describes NATS operation binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/nats#operation-binding-object">NATS operation binding</a>
 * @see <a href="https://nats.io">NATS</a>
 * @author Pavel Bodiachevskii
 * @version 0.1.0
 * @since 1.0.0-RC2
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        defaultImpl = com.asyncapi.bindings.nats.v0._1_0.operation.NATSOperationBinding.class,
        property = "bindingVersion",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = com.asyncapi.bindings.nats.v0._1_0.operation.NATSOperationBinding.class, names = {
                "0.1.0",
                "latest"
        }),
})
@EqualsAndHashCode(callSuper = true)
public abstract class NATSOperationBinding extends OperationBinding {}