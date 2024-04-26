package com.asyncapi.bindings.websockets.withoutversion.message;

import com.asyncapi.ExtendableObject;
import com.asyncapi.bindings.websockets.v0._1_0.message.WebSocketsMessageBinding;
import com.asyncapi.v3.SerDeTest;
import org.jetbrains.annotations.NotNull;

public abstract class WebSocketsMessageBindingTest extends SerDeTest<WebSocketsMessageBinding> {

    @NotNull
    @Override
    protected Class<WebSocketsMessageBinding> objectClass() {
        return WebSocketsMessageBinding.class;
    }

    @NotNull
    @Override
    protected String baseObjectJson() {
        return "/bindings/websockets/without version/message/webSocketsMessageBinding.json";
    }

    @NotNull
    @Override
    protected String extendedObjectJson() {
        return "/bindings/websockets/without version/message/webSocketsMessageBinding - extended.json";
    }

    @NotNull
    @Override
    protected String wronglyExtendedObjectJson() {
        return "/bindings/websockets/without version/message/webSocketsMessageBinding - wrongly extended.json";
    }

    @NotNull
    @Override
    public ExtendableObject build() {
        return new WebSocketsMessageBinding();
    }

}