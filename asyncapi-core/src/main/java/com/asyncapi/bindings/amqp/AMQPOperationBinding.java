package com.asyncapi.bindings.amqp;

import com.asyncapi.bindings.OperationBinding;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Describes AMQP 0-9-1 operation binding.
 * <p>
 * Contains information about the operation representation in AMQP.
 *
 * @since 1.0.0-RC2
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/amqp#operation-binding-object">AMQP operation binding</a>
 * @author Pavel Bodiachevskii
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        defaultImpl = com.asyncapi.bindings.amqp.v0._3_0.operation.AMQPOperationBinding.class,
        property = "bindingVersion",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = com.asyncapi.bindings.amqp.v0._1_0.operation.AMQPOperationBinding.class, name = "0.1.0"),
        @JsonSubTypes.Type(value = com.asyncapi.bindings.amqp.v0._2_0.operation.AMQPOperationBinding.class, name = "0.2.0"),
        @JsonSubTypes.Type(value = com.asyncapi.bindings.amqp.v0._3_0.operation.AMQPOperationBinding.class, names = {
                "0.3.0",
                "latest"
        }),
})
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class AMQPOperationBinding extends OperationBinding {}