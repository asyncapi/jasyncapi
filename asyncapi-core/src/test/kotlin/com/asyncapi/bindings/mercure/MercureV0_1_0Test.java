package com.asyncapi.bindings.mercure;

import com.asyncapi.bindings.BindingTest;
import com.asyncapi.bindings.mercure.v0._1_0.channel.MercureChannelBinding;
import com.asyncapi.bindings.mercure.v0._1_0.message.MercureMessageBinding;
import com.asyncapi.bindings.mercure.v0._1_0.operation.MercureOperationBinding;
import com.asyncapi.bindings.mercure.v0._1_0.server.MercureServerBinding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

@DisplayName("0.1.0")
public class MercureV0_1_0Test {

    public static MercureChannelBinding channelBinding () {
        return new MercureChannelBinding();
    }

    public static MercureMessageBinding messageBinding () {
        return new MercureMessageBinding();
    }

    public static MercureOperationBinding operationBinding () {
        return new MercureOperationBinding();
    }

    public static MercureServerBinding serverBinding () {
        return new MercureServerBinding();
    }

    @Nested
    @DisplayName("channel")
    class ChannelTest extends BindingTest<MercureChannelBinding> {{
        super.binding                          = channelBinding();
        super.bindingTypeClass                 = MercureChannelBinding.class;
        super.pathToBindingJson                = "/bindings/default implementation/0.1.0/channel/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/default implementation/0.1.0/channel/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/default implementation/0.1.0/channel/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("message")
    class Message extends BindingTest<MercureMessageBinding> {{
        super.binding                          = messageBinding();
        super.bindingTypeClass                 = MercureMessageBinding.class;
        super.pathToBindingJson                = "/bindings/default implementation/0.1.0/message/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/default implementation/0.1.0/message/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/default implementation/0.1.0/message/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("operation")
    class Operation extends BindingTest<MercureOperationBinding> {{
        super.binding                          = operationBinding();
        super.bindingTypeClass                 = MercureOperationBinding.class;
        super.pathToBindingJson                = "/bindings/default implementation/0.1.0/operation/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/default implementation/0.1.0/operation/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/default implementation/0.1.0/operation/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("server")
    class Server extends BindingTest<MercureServerBinding> {{
        super.binding                          = serverBinding();
        super.bindingTypeClass                 = MercureServerBinding.class;
        super.pathToBindingJson                = "/bindings/default implementation/0.1.0/server/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/default implementation/0.1.0/server/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/default implementation/0.1.0/server/binding - wrongly extended.json";
    }}

}
