package com.asyncapi.bindings.solace;

import com.asyncapi.bindings.BindingTest;
import com.asyncapi.bindings.solace.v0._3_0.channel.SolaceChannelBinding;
import com.asyncapi.bindings.solace.v0._3_0.message.SolaceMessageBinding;
import com.asyncapi.bindings.solace.v0._3_0.operation.SolaceOperationBinding;
import com.asyncapi.bindings.solace.v0._3_0.server.SolaceServerBinding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

@DisplayName("latest")
public class SolaceLatestTest {

    @Nested
    @DisplayName("channel")
    class ChannelTest extends BindingTest<SolaceChannelBinding> {{
        super.binding                          = SolaceV0_3_0Test.channelBinding();
        super.bindingTypeClass                 = SolaceChannelBinding.class;
        super.pathToBindingJson                = "/bindings/solace/latest/channel/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/solace/latest/channel/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/solace/latest/channel/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("message")
    class Message extends BindingTest<SolaceMessageBinding> {{
        super.binding                          = SolaceV0_3_0Test.messageBinding();
        super.bindingTypeClass                 = SolaceMessageBinding.class;
        super.pathToBindingJson                = "/bindings/solace/latest/message/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/solace/latest/message/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/solace/latest/message/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("operation")
    class Operation extends BindingTest<SolaceOperationBinding> {{
        super.binding                          = SolaceV0_3_0Test.operationBinding();
        super.bindingTypeClass                 = SolaceOperationBinding.class;
        super.pathToBindingJson                = "/bindings/solace/latest/operation/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/solace/latest/operation/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/solace/latest/operation/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("server")
    class Server extends BindingTest<SolaceServerBinding> {{
        super.binding                          = SolaceV0_3_0Test.serverBinding();
        super.bindingTypeClass                 = SolaceServerBinding.class;
        super.pathToBindingJson                = "/bindings/solace/latest/server/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/solace/latest/server/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/solace/latest/server/binding - wrongly extended.json";
    }}

}
