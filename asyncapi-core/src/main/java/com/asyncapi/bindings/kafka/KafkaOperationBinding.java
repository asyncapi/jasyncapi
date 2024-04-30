package com.asyncapi.bindings.kafka;

import com.asyncapi.bindings.OperationBinding;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;

/**
 * Describes Kafka operation binding.
 * <p>
 * Contains information about the operation representation in Kafka.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/kafka#operation-binding-object">Kafka operation binding</a>
 * @author Pavel Bodiachevskii
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        defaultImpl = com.asyncapi.bindings.kafka.v0._4_0.operation.KafkaOperationBinding.class,
        property = "bindingVersion",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = com.asyncapi.bindings.kafka.v0._4_0.operation.KafkaOperationBinding.class, names = {
                "0.4.0",
                "latest"
        }),
})
@EqualsAndHashCode(callSuper = true)
public abstract class KafkaOperationBinding extends OperationBinding {}