package com.asyncapi.bindings.websockets.v0._1_0;

import com.asyncapi.bindings.websockets.v0._1_0.channel.WebSocketsChannelBinding;
import com.asyncapi.bindings.websockets.v0._1_0.channel.WebSocketsChannelMethod;
import com.asyncapi.bindings.websockets.v0._1_0.message.WebSocketsMessageBinding;
import com.asyncapi.bindings.websockets.v0._1_0.operation.WebSocketsOperationBinding;
import com.asyncapi.bindings.websockets.v0._1_0.server.WebSocketsServerBinding;
import com.asyncapi.v3.schema.AsyncAPISchema;
import com.asyncapi.v3.schema.Type;

import java.util.HashMap;
import java.util.Map;

public class WebSocketsBindingProvider {

    public static WebSocketsChannelBinding channel() {
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

    public static WebSocketsMessageBinding message() {
        return new WebSocketsMessageBinding();
    }

    public static WebSocketsOperationBinding operation() {
        return new WebSocketsOperationBinding();
    }

    public static WebSocketsServerBinding server() {
        return new WebSocketsServerBinding();
    }

}
