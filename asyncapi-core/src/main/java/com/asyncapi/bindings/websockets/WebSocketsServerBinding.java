package com.asyncapi.bindings.websockets;

import com.asyncapi.bindings.ServerBinding;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * This class <b>MUST NOT</b> contain any properties.
 * <p>
 * Its name is reserved for future use.
 * <p>
 * Describes WebSockets server binding.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/websockets#server-binding-object">WebSockets server binding</a>
 * @author Pavel Bodiachevskii
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        defaultImpl = com.asyncapi.bindings.websockets.v0._1_0.server.WebSocketsServerBinding.class,
        property = "bindingVersion",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = com.asyncapi.bindings.websockets.v0._1_0.server.WebSocketsServerBinding.class, names = {
                "0.1.0",
                "latest"
        }),
})
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class WebSocketsServerBinding extends ServerBinding {}
