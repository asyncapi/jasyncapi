package com.asyncapi.bindings.stomp;

import com.asyncapi.bindings.OperationBinding;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Describes STOMP operation binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/sqs#operation-binding-object">STOMP operation binding</a>
 * @see <a href="https://stomp.github.io">STOMP</a>
 * @author Pavel Bodiachevskii
 * @version 0.1.0
 * @since 1.0.0-RC2
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        defaultImpl = com.asyncapi.bindings.stomp.v0._1_0.operation.STOMPOperationBinding.class,
        property = "bindingVersion",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = com.asyncapi.bindings.stomp.v0._1_0.operation.STOMPOperationBinding.class, names = {
                "0.1.0",
                "latest"
        }),
})
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class STOMPOperationBinding extends OperationBinding {}