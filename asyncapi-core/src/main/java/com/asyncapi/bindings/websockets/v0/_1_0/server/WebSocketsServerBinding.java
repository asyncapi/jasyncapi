package com.asyncapi.bindings.websockets.v0._1_0.server;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jetbrains.annotations.Nullable;

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
@Data
@EqualsAndHashCode(callSuper = true)
public class WebSocketsServerBinding extends com.asyncapi.bindings.websockets.WebSocketsServerBinding {

    public WebSocketsServerBinding() {
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
