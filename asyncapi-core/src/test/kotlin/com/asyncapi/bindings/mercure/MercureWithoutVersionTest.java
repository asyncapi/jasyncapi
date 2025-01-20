package com.asyncapi.bindings.mercure;

import com.asyncapi.bindings.BindingTest;
import com.asyncapi.bindings.mercure.v0._1_0.channel.MercureChannelBinding;
import com.asyncapi.bindings.mercure.v0._1_0.message.MercureMessageBinding;
import com.asyncapi.bindings.mercure.v0._1_0.operation.MercureOperationBinding;
import com.asyncapi.bindings.mercure.v0._1_0.server.MercureServerBinding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

@DisplayName("without version")
public class MercureWithoutVersionTest {

    @Nested
    @DisplayName("channel")
    class ChannelTest extends BindingTest<MercureChannelBinding> {{
        super.binding                          = MercureV0_1_0Test.channelBinding();
        super.bindingTypeClass                 = MercureChannelBinding.class;
        super.pathToBindingJson                = "/bindings/default implementation/without version/channel/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/default implementation/without version/channel/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/default implementation/without version/channel/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("message")
    class Message extends BindingTest<MercureMessageBinding> {{
        super.binding                          = MercureV0_1_0Test.messageBinding();
        super.bindingTypeClass                 = MercureMessageBinding.class;
        super.pathToBindingJson                = "/bindings/default implementation/without version/message/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/default implementation/without version/message/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/default implementation/without version/message/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("operation")
    class Operation extends BindingTest<MercureOperationBinding> {{
        super.binding                          = MercureV0_1_0Test.operationBinding();
        super.bindingTypeClass                 = MercureOperationBinding.class;
        super.pathToBindingJson                = "/bindings/default implementation/without version/operation/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/default implementation/without version/operation/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/default implementation/without version/operation/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("server")
    class Server extends BindingTest<MercureServerBinding> {{
        super.binding                          = MercureV0_1_0Test.serverBinding();
        super.bindingTypeClass                 = MercureServerBinding.class;
        super.pathToBindingJson                = "/bindings/default implementation/without version/server/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/default implementation/without version/server/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/default implementation/without version/server/binding - wrongly extended.json";
    }}

}
