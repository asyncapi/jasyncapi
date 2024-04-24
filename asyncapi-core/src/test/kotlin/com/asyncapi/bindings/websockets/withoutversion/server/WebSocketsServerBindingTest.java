package com.asyncapi.bindings.websockets.withoutversion.server;

import com.asyncapi.ExtendableObject;
import com.asyncapi.bindings.websockets.v0._1_0.server.WebSocketsServerBinding;
import com.asyncapi.v3.SerDeTest;
import org.jetbrains.annotations.NotNull;

public abstract class WebSocketsServerBindingTest extends SerDeTest<WebSocketsServerBinding> {

    @NotNull
    @Override
    protected Class<WebSocketsServerBinding> objectClass() {
        return WebSocketsServerBinding.class;
    }

    @NotNull
    @Override
    protected String baseObjectJson() {
        return "/bindings/websockets/without version/server/webSocketsServerBinding.json";
    }

    @NotNull
    @Override
    protected String extendedObjectJson() {
        return "/bindings/websockets/without version/server/webSocketsServerBinding - extended.json";
    }

    @NotNull
    @Override
    protected String wronglyExtendedObjectJson() {
        return "/bindings/websockets/without version/server/webSocketsServerBinding - wrongly extended.json";
    }

    @NotNull
    @Override
    public ExtendableObject build() {
        return new WebSocketsServerBinding();
    }

}
