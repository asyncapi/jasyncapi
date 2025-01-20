package com.asyncapi.bindings.solace;

import com.asyncapi.bindings.BindingTest;
import com.asyncapi.bindings.solace.v0._1_0.channel.SolaceChannelBinding;
import com.asyncapi.bindings.solace.v0._1_0.message.SolaceMessageBinding;
import com.asyncapi.bindings.solace.v0._1_0.operation.SolaceOperationBinding;
import com.asyncapi.bindings.solace.v0._1_0.server.SolaceServerBinding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

@DisplayName("0.1.0")
public class SolaceV0_1_0Test {

    public static SolaceChannelBinding channelBinding () {
        return new SolaceChannelBinding();
    }

    public static SolaceMessageBinding messageBinding () {
        return new SolaceMessageBinding();
    }

    public static SolaceOperationBinding operationBinding () {
        return new SolaceOperationBinding();
    }

    public static SolaceServerBinding serverBinding () {
        return new SolaceServerBinding();
    }

    @Nested
    @DisplayName("channel")
    class ChannelTest extends BindingTest<SolaceChannelBinding> {{
        super.binding                          = channelBinding();
        super.bindingTypeClass                 = SolaceChannelBinding.class;
        super.pathToBindingJson                = "/bindings/default implementation/0.1.0/channel/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/default implementation/0.1.0/channel/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/default implementation/0.1.0/channel/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("message")
    class Message extends BindingTest<SolaceMessageBinding> {{
        super.binding                          = messageBinding();
        super.bindingTypeClass                 = SolaceMessageBinding.class;
        super.pathToBindingJson                = "/bindings/default implementation/0.1.0/message/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/default implementation/0.1.0/message/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/default implementation/0.1.0/message/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("operation")
    class Operation extends BindingTest<SolaceOperationBinding> {{
        super.binding                          = operationBinding();
        super.bindingTypeClass                 = SolaceOperationBinding.class;
        super.pathToBindingJson                = "/bindings/default implementation/0.1.0/operation/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/default implementation/0.1.0/operation/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/default implementation/0.1.0/operation/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("server")
    class Server extends BindingTest<SolaceServerBinding> {{
        super.binding                          = serverBinding();
        super.bindingTypeClass                 = SolaceServerBinding.class;
        super.pathToBindingJson                = "/bindings/default implementation/0.1.0/server/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/default implementation/0.1.0/server/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/default implementation/0.1.0/server/binding - wrongly extended.json";
    }}

}
