package com.asyncapi.bindings.jms;

import com.asyncapi.bindings.ServerBinding;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;

/**
 * This class MUST NOT contain any properties. Its name is reserved for future use.
 * <p>
 * Describes JMS server binding.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/jms#server-binding-object">JMS server binding</a>
 * @author Pavel Bodiachevskii
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        defaultImpl = com.asyncapi.bindings.jms.v0._0_1.server.JMSServerBinding.class,
        property = "bindingVersion",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = com.asyncapi.bindings.jms.v0._0_1.server.JMSServerBinding.class, names = {
                "0.0.1",
                "latest"
        }),
})
@EqualsAndHashCode(callSuper = true)
public class JMSServerBinding extends ServerBinding {}