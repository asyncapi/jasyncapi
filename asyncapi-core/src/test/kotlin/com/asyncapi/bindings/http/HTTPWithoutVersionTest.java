package com.asyncapi.bindings.http;

import com.asyncapi.bindings.BindingTest;
import com.asyncapi.bindings.http.v0._3_0.channel.HTTPChannelBinding;
import com.asyncapi.bindings.http.v0._3_0.message.HTTPMessageBinding;
import com.asyncapi.bindings.http.v0._3_0.operation.HTTPOperationBinding;
import com.asyncapi.bindings.http.v0._3_0.server.HTTPServerBinding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

@DisplayName("without version")
public class HTTPWithoutVersionTest {

    @Nested
    @DisplayName("channel")
    class ChannelTest extends BindingTest<HTTPChannelBinding> {{
        super.binding                          = HTTPV0_3_0Test.channelBinding();
        super.bindingTypeClass                 = HTTPChannelBinding.class;
        super.pathToBindingJson                = "/bindings/http/without version/channel/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/http/without version/channel/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/http/without version/channel/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("message")
    class Message extends BindingTest<HTTPMessageBinding> {{
        super.binding                          = HTTPV0_3_0Test.messageBinding();
        super.bindingTypeClass                 = HTTPMessageBinding.class;
        super.pathToBindingJson                = "/bindings/http/without version/message/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/http/without version/message/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/http/without version/message/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("operation")
    class Operation extends BindingTest<HTTPOperationBinding> {{
        super.binding                          = HTTPV0_3_0Test.operationBinding();
        super.bindingTypeClass                 = HTTPOperationBinding.class;
        super.pathToBindingJson                = "/bindings/http/without version/operation/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/http/without version/operation/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/http/without version/operation/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("server")
    class Server extends BindingTest<HTTPServerBinding> {{
        super.binding                          = HTTPV0_3_0Test.serverBinding();
        super.bindingTypeClass                 = HTTPServerBinding.class;
        super.pathToBindingJson                = "/bindings/http/without version/server/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/http/without version/server/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/http/without version/server/binding - wrongly extended.json";
    }}

}
