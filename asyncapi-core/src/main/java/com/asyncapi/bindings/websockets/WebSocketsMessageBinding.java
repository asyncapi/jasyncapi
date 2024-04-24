package com.asyncapi.bindings.websockets;

import com.asyncapi.bindings.MessageBinding;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * This class <b>MUST NOT</b> contain any properties.
 * <p>
 * Its name is reserved for future use.
 * <p>
 * Describes WebSockets message binding.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/websockets#message-binding-object">WebSockets message binding</a>
 * @author Pavel Bodiachevskii
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        defaultImpl = com.asyncapi.bindings.websockets.v0._1_0.message.WebSocketsMessageBinding.class,
        property = "bindingVersion",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = com.asyncapi.bindings.websockets.v0._1_0.message.WebSocketsMessageBinding.class, names = {
                "0.1.0",
                "latest"
        }),
})
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class WebSocketsMessageBinding extends MessageBinding {}
