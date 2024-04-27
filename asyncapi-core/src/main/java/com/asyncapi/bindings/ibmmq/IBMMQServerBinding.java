package com.asyncapi.bindings.ibmmq;

import com.asyncapi.bindings.ServerBinding;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;

/**
 * Describes IBM MQ server binding.
 * <p>
 * This object contains server connection information about the IBM MQ server, referred to as an IBM MQ queue manager.
 * This object contains additional connectivity information not possible to represent within the core AsyncAPI specification.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/ibmmq#server-binding-object">IBM MQ server binding</a>
 * @author Pavel Bodiachevskii
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
public class IBMMQServerBinding extends ServerBinding {}