package com.asyncapi.bindings.websockets.v0._1_0.server;

import com.asyncapi.ExtendableObject;
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
        return "/bindings/websockets/0.1.0/server/webSocketsServerBinding.json";
    }

    @NotNull
    @Override
    protected String extendedObjectJson() {
        return "/bindings/websockets/0.1.0/server/webSocketsServerBinding - extended.json";
    }

    @NotNull
    @Override
    protected String wronglyExtendedObjectJson() {
        return "/bindings/websockets/0.1.0/server/webSocketsServerBinding - wrongly extended.json";
    }

    @NotNull
    @Override
    public ExtendableObject build() {
        return new WebSocketsServerBinding();
    }

}
