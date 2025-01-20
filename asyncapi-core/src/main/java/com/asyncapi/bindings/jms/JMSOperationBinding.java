package com.asyncapi.bindings.jms;

import com.asyncapi.bindings.OperationBinding;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;

/**
 * Describes JMS operation binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/jms#operation-binding-object">JMS operation binding</a>
 * @see <a href="https://www.oracle.com/java/technologies/java-message-service.html">Java Message Service</a>
 * @author Pavel Bodiachevskii
 * @version 0.0.1
 * @since 1.0.0-RC2
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        defaultImpl = com.asyncapi.bindings.jms.v0._0_1.operation.JMSOperationBinding.class,
        property = "bindingVersion",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = com.asyncapi.bindings.jms.v0._0_1.operation.JMSOperationBinding.class, names = {
                "0.0.1",
                "latest"
        }),
})
@EqualsAndHashCode(callSuper = true)
public abstract class JMSOperationBinding extends OperationBinding {}