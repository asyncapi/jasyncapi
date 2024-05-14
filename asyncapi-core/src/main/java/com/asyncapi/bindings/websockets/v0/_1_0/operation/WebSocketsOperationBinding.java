package com.asyncapi.bindings.websockets.v0._1_0.operation;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jetbrains.annotations.Nullable;

/**
 * This class <b>MUST NOT</b> contain any properties.
 * <p>
 * Its name is reserved for future use.
 * <p>
 * Describes WebSockets operation binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/websockets#operation-binding-object">WebSockets operation binding</a>
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/WebSockets_API">MDN WebSockets</a>
 * @author Pavel Bodiachevskii
 * @version 0.1.0
 * @since 1.0.0-RC2
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WebSocketsOperationBinding extends com.asyncapi.bindings.websockets.WebSocketsOperationBinding {

    public WebSocketsOperationBinding() {
        this.setBindingVersion("0.1.0");
    }

    @Override
    public String getBindingVersion() {
        return "0.1.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.1.0");
    }

}
