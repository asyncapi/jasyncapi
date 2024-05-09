package com.asyncapi.bindings.websockets;

import com.asyncapi.bindings.BindingTest;
import com.asyncapi.bindings.websockets.v0._1_0.channel.WebSocketsChannelBinding;
import com.asyncapi.bindings.websockets.v0._1_0.channel.WebSocketsChannelMethod;
import com.asyncapi.bindings.websockets.v0._1_0.message.WebSocketsMessageBinding;
import com.asyncapi.bindings.websockets.v0._1_0.operation.WebSocketsOperationBinding;
import com.asyncapi.bindings.websockets.v0._1_0.server.WebSocketsServerBinding;
import com.asyncapi.schemas.asyncapi.AsyncAPISchema;
import com.asyncapi.schemas.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

import java.util.HashMap;
import java.util.Map;

@DisplayName("0.1.0")
public class WebSocketsV0_1_0Test {

    public static WebSocketsChannelBinding channelBinding () {
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

    public static WebSocketsMessageBinding messageBinding () {
        return new WebSocketsMessageBinding();
    }

    public static WebSocketsOperationBinding operationBinding () {
        return new WebSocketsOperationBinding();
    }

    public static WebSocketsServerBinding serverBinding () {
        return new WebSocketsServerBinding();
    }

    @Nested
    @DisplayName("channel")
    class ChannelTest extends BindingTest<WebSocketsChannelBinding> {{
        super.binding                          = channelBinding();
        super.bindingTypeClass                 = WebSocketsChannelBinding.class;
        super.pathToBindingJson                = "/bindings/websockets/0.1.0/channel/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/websockets/0.1.0/channel/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/websockets/0.1.0/channel/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("message")
    class Message extends BindingTest<WebSocketsMessageBinding> {{
        super.binding                          = messageBinding();
        super.bindingTypeClass                 = WebSocketsMessageBinding.class;
        super.pathToBindingJson                = "/bindings/websockets/0.1.0/message/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/websockets/0.1.0/message/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/websockets/0.1.0/message/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("operation")
    class Operation extends BindingTest<WebSocketsOperationBinding> {{
        super.binding                          = operationBinding();
        super.bindingTypeClass                 = WebSocketsOperationBinding.class;
        super.pathToBindingJson                = "/bindings/websockets/0.1.0/operation/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/websockets/0.1.0/operation/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/websockets/0.1.0/operation/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("server")
    class Server extends BindingTest<WebSocketsServerBinding> {{
        super.binding                          = serverBinding();
        super.bindingTypeClass                 = WebSocketsServerBinding.class;
        super.pathToBindingJson                = "/bindings/websockets/0.1.0/server/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/websockets/0.1.0/server/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/websockets/0.1.0/server/binding - wrongly extended.json";
    }}

}
