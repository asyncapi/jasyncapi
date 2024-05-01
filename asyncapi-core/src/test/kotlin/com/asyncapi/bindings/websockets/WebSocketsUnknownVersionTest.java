package com.asyncapi.bindings.websockets;

import com.asyncapi.bindings.BindingTest;
import com.asyncapi.bindings.websockets.v0._1_0.channel.WebSocketsChannelBinding;
import com.asyncapi.bindings.websockets.v0._1_0.message.WebSocketsMessageBinding;
import com.asyncapi.bindings.websockets.v0._1_0.operation.WebSocketsOperationBinding;
import com.asyncapi.bindings.websockets.v0._1_0.server.WebSocketsServerBinding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

@DisplayName("unknown version")
public class WebSocketsUnknownVersionTest {

    @Nested
    @DisplayName("channel")
    class ChannelTest extends BindingTest<WebSocketsChannelBinding> {{
        super.binding                          = WebSocketsV0_1_0Test.channelBinding();
        super.bindingTypeClass                 = WebSocketsChannelBinding.class;
        super.pathToBindingJson                = "/bindings/websockets/unknown version/channel/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/websockets/unknown version/channel/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/websockets/unknown version/channel/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("message")
    class Message extends BindingTest<WebSocketsMessageBinding> {{
        super.binding                          = WebSocketsV0_1_0Test.messageBinding();
        super.bindingTypeClass                 = WebSocketsMessageBinding.class;
        super.pathToBindingJson                = "/bindings/websockets/unknown version/message/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/websockets/unknown version/message/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/websockets/unknown version/message/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("operation")
    class Operation extends BindingTest<WebSocketsOperationBinding> {{
        super.binding                          = WebSocketsV0_1_0Test.operationBinding();
        super.bindingTypeClass                 = WebSocketsOperationBinding.class;
        super.pathToBindingJson                = "/bindings/websockets/unknown version/operation/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/websockets/unknown version/operation/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/websockets/unknown version/operation/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("server")
    class Server extends BindingTest<WebSocketsServerBinding> {{
        super.binding                          = WebSocketsV0_1_0Test.serverBinding();
        super.bindingTypeClass                 = WebSocketsServerBinding.class;
        super.pathToBindingJson                = "/bindings/websockets/unknown version/server/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/websockets/unknown version/server/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/websockets/unknown version/server/binding - wrongly extended.json";
    }}

}
