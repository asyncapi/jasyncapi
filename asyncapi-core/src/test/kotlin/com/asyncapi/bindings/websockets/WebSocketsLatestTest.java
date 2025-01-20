package com.asyncapi.bindings.websockets;

import com.asyncapi.bindings.BindingTest;
import com.asyncapi.bindings.websockets.v0._1_0.channel.WebSocketsChannelBinding;
import com.asyncapi.bindings.websockets.v0._1_0.message.WebSocketsMessageBinding;
import com.asyncapi.bindings.websockets.v0._1_0.operation.WebSocketsOperationBinding;
import com.asyncapi.bindings.websockets.v0._1_0.server.WebSocketsServerBinding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

@DisplayName("latest")
public class WebSocketsLatestTest {

    @Nested
    @DisplayName("channel")
    class ChannelTest extends BindingTest<WebSocketsChannelBinding> {{
        super.binding                          = WebSocketsV0_1_0Test.channelBinding();
        super.bindingTypeClass                 = WebSocketsChannelBinding.class;
        super.pathToBindingJson                = "/bindings/websockets/latest/channel/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/websockets/latest/channel/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/websockets/latest/channel/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("message")
    class Message extends BindingTest<WebSocketsMessageBinding> {{
        super.binding                          = WebSocketsV0_1_0Test.messageBinding();
        super.bindingTypeClass                 = WebSocketsMessageBinding.class;
        super.pathToBindingJson                = "/bindings/websockets/latest/message/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/websockets/latest/message/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/websockets/latest/message/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("operation")
    class Operation extends BindingTest<WebSocketsOperationBinding> {{
        super.binding                          = WebSocketsV0_1_0Test.operationBinding();
        super.bindingTypeClass                 = WebSocketsOperationBinding.class;
        super.pathToBindingJson                = "/bindings/websockets/latest/operation/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/websockets/latest/operation/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/websockets/latest/operation/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("server")
    class Server extends BindingTest<WebSocketsServerBinding> {{
        super.binding                          = WebSocketsV0_1_0Test.serverBinding();
        super.bindingTypeClass                 = WebSocketsServerBinding.class;
        super.pathToBindingJson                = "/bindings/websockets/latest/server/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/websockets/latest/server/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/websockets/latest/server/binding - wrongly extended.json";
    }}

}
