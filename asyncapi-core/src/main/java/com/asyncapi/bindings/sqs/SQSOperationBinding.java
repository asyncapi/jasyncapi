package com.asyncapi.bindings.sqs;

import com.asyncapi.bindings.OperationBinding;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;

/**
 * This class <b>MUST NOT</b> contain any properties.
 * <p>
 * Its name is reserved for future use.
 * <p>
 * Describes SQS operation binding.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/sqs#operation-binding-object">SQS operation binding</a>
 * @author Pavel Bodiachevskii
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        defaultImpl = com.asyncapi.bindings.sqs.v0._1_0.operation.SQSOperationBinding.class,
        property = "bindingVersion",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = com.asyncapi.bindings.sqs.v0._1_0.operation.SQSOperationBinding.class, names = {
                "0.1.0",
                "latest"
        }),
})
@EqualsAndHashCode(callSuper = true)
public class SQSOperationBinding extends OperationBinding {}