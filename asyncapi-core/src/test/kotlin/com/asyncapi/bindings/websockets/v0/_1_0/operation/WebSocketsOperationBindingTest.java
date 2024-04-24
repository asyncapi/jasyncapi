package com.asyncapi.bindings.websockets.v0._1_0.operation;

import com.asyncapi.ExtendableObject;
import com.asyncapi.v3.SerDeTest;
import org.jetbrains.annotations.NotNull;

public abstract class WebSocketsOperationBindingTest extends SerDeTest<WebSocketsOperationBinding> {

    @NotNull
    @Override
    protected Class<WebSocketsOperationBinding> objectClass() {
        return WebSocketsOperationBinding.class;
    }

    @NotNull
    @Override
    protected String baseObjectJson() {
        return "/bindings/websockets/0.1.0/operation/webSocketsOperationBinding.json";
    }

    @NotNull
    @Override
    protected String extendedObjectJson() {
        return "/bindings/websockets/0.1.0/operation/webSocketsOperationBinding - extended.json";
    }

    @NotNull
    @Override
    protected String wronglyExtendedObjectJson() {
        return "/bindings/websockets/0.1.0/operation/webSocketsOperationBinding - wrongly extended.json";
    }

    @NotNull
    @Override
    public ExtendableObject build() {
        return new WebSocketsOperationBinding();
    }

}
