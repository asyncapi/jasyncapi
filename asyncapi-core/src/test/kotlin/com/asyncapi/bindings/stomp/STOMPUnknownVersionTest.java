package com.asyncapi.bindings.stomp;

import com.asyncapi.bindings.BindingTest;
import com.asyncapi.bindings.stomp.v0._1_0.channel.STOMPChannelBinding;
import com.asyncapi.bindings.stomp.v0._1_0.message.STOMPMessageBinding;
import com.asyncapi.bindings.stomp.v0._1_0.operation.STOMPOperationBinding;
import com.asyncapi.bindings.stomp.v0._1_0.server.STOMPServerBinding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

@DisplayName("unknown version")
public class STOMPUnknownVersionTest {

    @Nested
    @DisplayName("channel")
    class ChannelTest extends BindingTest<STOMPChannelBinding> {{
        super.binding                          = new STOMPChannelBinding();
        super.bindingTypeClass                 = STOMPChannelBinding.class;
        super.pathToBindingJson                = "/bindings/default implementation/unknown version/channel/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/default implementation/unknown version/channel/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/default implementation/unknown version/channel/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("message")
    class Message extends BindingTest<STOMPMessageBinding> {{
        super.binding                          = new STOMPMessageBinding();
        super.bindingTypeClass                 = STOMPMessageBinding.class;
        super.pathToBindingJson                = "/bindings/default implementation/unknown version/message/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/default implementation/unknown version/message/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/default implementation/unknown version/message/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("operation")
    class Operation extends BindingTest<STOMPOperationBinding> {{
        super.binding                          = new STOMPOperationBinding();
        super.bindingTypeClass                 = STOMPOperationBinding.class;
        super.pathToBindingJson                = "/bindings/default implementation/unknown version/operation/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/default implementation/unknown version/operation/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/default implementation/unknown version/operation/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("server")
    class Server extends BindingTest<STOMPServerBinding> {{
        super.binding                          = new STOMPServerBinding();
        super.bindingTypeClass                 = STOMPServerBinding.class;
        super.pathToBindingJson                = "/bindings/default implementation/unknown version/server/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/default implementation/unknown version/server/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/default implementation/unknown version/server/binding - wrongly extended.json";
    }}

}
