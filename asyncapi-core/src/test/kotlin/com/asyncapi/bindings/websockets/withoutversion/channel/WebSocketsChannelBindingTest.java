package com.asyncapi.bindings.websockets.withoutversion.channel;

import com.asyncapi.bindings.websockets.v0._1_0.channel.WebSocketsChannelBinding;
import com.asyncapi.bindings.websockets.v0._1_0.channel.WebSocketsChannelMethod;
import com.asyncapi.v3.SerDeTest;
import com.asyncapi.v3.schema.AsyncAPISchema;
import com.asyncapi.v3.schema.Type;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public abstract class WebSocketsChannelBindingTest extends SerDeTest<WebSocketsChannelBinding> {

    @NotNull
    @Override
    protected Class<WebSocketsChannelBinding> objectClass() {
        return WebSocketsChannelBinding.class;
    }

    @NotNull
    @Override
    protected String baseObjectJson() {
        return "/bindings/websockets/without version/channel/webSocketsChannelBinding.json";
    }

    @NotNull
    @Override
    protected String extendedObjectJson() {
        return "/bindings/websockets/without version/channel/webSocketsChannelBinding - extended.json";
    }

    @NotNull
    @Override
    protected String wronglyExtendedObjectJson() {
        return "/bindings/websockets/without version/channel/webSocketsChannelBinding - wrongly extended.json";
    }

    @NotNull
    @Override
    public WebSocketsChannelBinding build() {
        Map<String, Object> queryProperties = new HashMap<>();
        queryProperties.put(
                "ref",
                AsyncAPISchema.builder()
                        .type(Type.STRING)
                        .description("Referral.")
                        .build()
        );

        Map<String, Object> headersProperties = new HashMap<>();
        headersProperties.put(
                "Authentication",
                AsyncAPISchema.builder()
                        .type(Type.STRING)
                        .description("Authentication token")
                        .build()
        );

        return WebSocketsChannelBinding.builder()
                .method(WebSocketsChannelMethod.GET)
                .query(AsyncAPISchema.builder()
                        .type(Type.OBJECT)
                        .properties(queryProperties)
                        .build()
                )
                .headers(AsyncAPISchema.builder()
                        .type(Type.OBJECT)
                        .properties(headersProperties)
                        .build()
                )
                .build();
    }

}
