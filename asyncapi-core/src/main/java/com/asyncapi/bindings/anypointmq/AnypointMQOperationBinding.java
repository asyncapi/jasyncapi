package com.asyncapi.bindings.anypointmq;

import com.asyncapi.bindings.OperationBinding;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Describes <a href="https://docs.mulesoft.com/mq/">Anypoint MQ</a> operation binding.
 *
 * @version 0.0.1
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/anypointmq#operation-binding-object">Anypoint MQ operation binding</a>
 * @author Pavel Bodiachevskii
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
public class AnypointMQOperationBinding extends OperationBinding {}