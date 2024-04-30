package com.asyncapi.bindings.solace;

import com.asyncapi.bindings.OperationBinding;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Describes Solace operation binding.
 * <p>
 * Contains information about the operation representation in Solace PubSub+ Broker.
 *
 * @version 0.3.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/solace#operation-binding-object">Solace operation binding</a>
 * @author Dennis Brinley, Pavel Bodiachevskii
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        defaultImpl = com.asyncapi.bindings.solace.v0._3_0.operation.SolaceOperationBinding.class,
        property = "bindingVersion",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = com.asyncapi.bindings.solace.v0._3_0.operation.SolaceOperationBinding.class, names = {
                "0.3.0",
                "latest"
        }),
})
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class SolaceOperationBinding extends OperationBinding {}