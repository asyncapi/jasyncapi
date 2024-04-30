package com.asyncapi.bindings.solace;

import com.asyncapi.bindings.BindingTest;
import com.asyncapi.bindings.solace.v0._3_0.channel.SolaceChannelBinding;
import com.asyncapi.bindings.solace.v0._3_0.message.SolaceMessageBinding;
import com.asyncapi.bindings.solace.v0._3_0.operation.SolaceOperationBinding;
import com.asyncapi.bindings.solace.v0._3_0.server.SolaceServerBinding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

@DisplayName("without version")
public class SolaceWithoutVersionTest {

    @Nested
    @DisplayName("channel")
    class ChannelTest extends BindingTest<SolaceChannelBinding> {{
        super.binding                          = SolaceV0_3_0Test.channelBinding();
        super.bindingTypeClass                 = SolaceChannelBinding.class;
        super.pathToBindingJson                = "/bindings/solace/without version/channel/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/solace/without version/channel/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/solace/without version/channel/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("message")
    class Message extends BindingTest<SolaceMessageBinding> {{
        super.binding                          = SolaceV0_3_0Test.messageBinding();
        super.bindingTypeClass                 = SolaceMessageBinding.class;
        super.pathToBindingJson                = "/bindings/solace/without version/message/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/solace/without version/message/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/solace/without version/message/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("operation")
    class Operation extends BindingTest<SolaceOperationBinding> {{
        super.binding                          = SolaceV0_3_0Test.operationBinding();
        super.bindingTypeClass                 = SolaceOperationBinding.class;
        super.pathToBindingJson                = "/bindings/solace/without version/operation/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/solace/without version/operation/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/solace/without version/operation/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("server")
    class Server extends BindingTest<SolaceServerBinding> {{
        super.binding                          = SolaceV0_3_0Test.serverBinding();
        super.bindingTypeClass                 = SolaceServerBinding.class;
        super.pathToBindingJson                = "/bindings/solace/without version/server/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/solace/without version/server/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/solace/without version/server/binding - wrongly extended.json";
    }}

}
