package com.asyncapi.bindings.websockets.v0._1_0.channel;

import com.asyncapi.bindings.websockets.v0._1_0.WebSocketsBindingProvider;
import com.asyncapi.v3.SerDeTest;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Nested;

@Nested
public abstract class WebSocketsChannelBindingTest extends SerDeTest<WebSocketsChannelBinding> {

    @NotNull
    @Override
    protected Class<WebSocketsChannelBinding> objectClass() {
        return WebSocketsChannelBinding.class;
    }

    @NotNull
    @Override
    protected String baseObjectJson() {
        return "/bindings/websockets/0.1.0/channel/webSocketsChannelBinding.json";
    }

    @NotNull
    @Override
    protected String extendedObjectJson() {
        return "/bindings/websockets/0.1.0/channel/webSocketsChannelBinding - extended.json";
    }

    @NotNull
    @Override
    protected String wronglyExtendedObjectJson() {
        return "/bindings/websockets/0.1.0/channel/webSocketsChannelBinding - wrongly extended.json";
    }

    @NotNull
    @Override
    public WebSocketsChannelBinding build() {
        return WebSocketsBindingProvider.channel();
    }

}
