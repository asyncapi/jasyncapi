package com.asyncapi.bindings.anypointmq;

import com.asyncapi.bindings.OperationBinding;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;

/**
 * Describes Anypoint MQ operation binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/anypointmq#operation-binding-object">Anypoint MQ operation binding</a>
 * @see <a href="https://docs.mulesoft.com/mq/">Anypoint MQ</a>
 * @author Pavel Bodiachevskii
 * @since 1.0.0-RC2
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        defaultImpl = com.asyncapi.bindings.anypointmq.v0._0_1.operation.AnypointMQOperationBinding.class,
        property = "bindingVersion",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = com.asyncapi.bindings.anypointmq.v0._0_1.operation.AnypointMQOperationBinding.class, names = {
                "0.0.1",
                "latest"
        }),
})
@EqualsAndHashCode(callSuper = true)
public abstract class AnypointMQOperationBinding extends OperationBinding {}