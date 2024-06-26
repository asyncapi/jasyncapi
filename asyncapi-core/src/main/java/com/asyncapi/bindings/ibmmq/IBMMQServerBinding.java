package com.asyncapi.bindings.ibmmq;

import com.asyncapi.bindings.ServerBinding;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;

/**
 * Describes IBM MQ server binding.
 * <p>
 * This object contains server connection information about the IBM MQ server, referred to as an IBM MQ queue manager.
 * <p>
 * This object contains additional connectivity information not possible to represent within the core AsyncAPI specification.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/ibmmq#server-binding-object">IBM MQ server binding</a>
 * @see <a href="https://www.ibm.com/products/mq">IBM MQ</a>
 * @author Pavel Bodiachevskii
 * @since 1.0.0-RC2
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        defaultImpl = com.asyncapi.bindings.ibmmq.v0._1_0.server.IBMMQServerBinding.class,
        property = "bindingVersion",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = com.asyncapi.bindings.ibmmq.v0._1_0.server.IBMMQServerBinding.class, names = {
                "0.1.0",
                "latest"
        }),
})
@EqualsAndHashCode(callSuper = true)
public abstract class IBMMQServerBinding extends ServerBinding {}