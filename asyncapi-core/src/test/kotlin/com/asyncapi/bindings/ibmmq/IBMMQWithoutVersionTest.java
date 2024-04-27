package com.asyncapi.bindings.ibmmq;

import com.asyncapi.bindings.BindingTest;
import com.asyncapi.bindings.ibmmq.v0._1_0.channel.IBMMQChannelBinding;
import com.asyncapi.bindings.ibmmq.v0._1_0.message.IBMMQMessageBinding;
import com.asyncapi.bindings.ibmmq.v0._1_0.operation.IBMMQOperationBinding;
import com.asyncapi.bindings.ibmmq.v0._1_0.server.IBMMQServerBinding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

@DisplayName("without version")
public class IBMMQWithoutVersionTest {

    @Nested
    @DisplayName("channel")
    class ChannelTest extends BindingTest<IBMMQChannelBinding> {{
        super.binding                          = IBMMQV0_1_0Test.channelBinding();
        super.bindingTypeClass                 = IBMMQChannelBinding.class;
        super.pathToBindingJson                = "/bindings/ibmmq/without version/channel/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/ibmmq/without version/channel/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/ibmmq/without version/channel/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("message")
    class Message extends BindingTest<IBMMQMessageBinding> {{
        super.binding                          = IBMMQV0_1_0Test.messageBinding();
        super.bindingTypeClass                 = IBMMQMessageBinding.class;
        super.pathToBindingJson                = "/bindings/ibmmq/without version/message/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/ibmmq/without version/message/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/ibmmq/without version/message/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("operation")
    class Operation extends BindingTest<IBMMQOperationBinding> {{
        super.binding                          = IBMMQV0_1_0Test.operationBinding();
        super.bindingTypeClass                 = IBMMQOperationBinding.class;
        super.pathToBindingJson                = "/bindings/ibmmq/without version/operation/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/ibmmq/without version/operation/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/ibmmq/without version/operation/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("server")
    class Server extends BindingTest<IBMMQServerBinding> {{
        super.binding                          = IBMMQV0_1_0Test.serverBinding();
        super.bindingTypeClass                 = IBMMQServerBinding.class;
        super.pathToBindingJson                = "/bindings/ibmmq/without version/server/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/ibmmq/without version/server/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/ibmmq/without version/server/binding - wrongly extended.json";
    }}

}
