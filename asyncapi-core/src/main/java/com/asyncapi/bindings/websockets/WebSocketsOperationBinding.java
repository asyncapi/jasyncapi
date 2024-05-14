package com.asyncapi.bindings.websockets;

import com.asyncapi.bindings.OperationBinding;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Describes WebSockets operation binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/websockets#operation-binding-object">WebSockets operation binding</a>
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/WebSockets_API">MDN WebSockets</a>
 * @author Pavel Bodiachevskii
 * @since 1.0.0-RC2
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        defaultImpl = com.asyncapi.bindings.websockets.v0._1_0.operation.WebSocketsOperationBinding.class,
        property = "bindingVersion",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = com.asyncapi.bindings.websockets.v0._1_0.operation.WebSocketsOperationBinding.class, names = {
                "0.1.0",
                "latest"
        }),
})
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class WebSocketsOperationBinding extends OperationBinding {}
