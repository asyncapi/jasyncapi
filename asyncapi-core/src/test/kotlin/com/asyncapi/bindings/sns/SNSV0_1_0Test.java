package com.asyncapi.bindings.sns;

import com.asyncapi.bindings.BindingTest;
import com.asyncapi.bindings.sns.v0._1_0.channel.SNSChannelBinding;
import com.asyncapi.bindings.sns.v0._1_0.message.SNSMessageBinding;
import com.asyncapi.bindings.sns.v0._1_0.operation.SNSOperationBinding;
import com.asyncapi.bindings.sns.v0._1_0.server.SNSServerBinding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

@DisplayName("0.1.0")
public class SNSV0_1_0Test {

    public static SNSChannelBinding channelBinding () {
        return new SNSChannelBinding();
    }

    public static SNSMessageBinding messageBinding () {
        return new SNSMessageBinding();
    }

    public static SNSOperationBinding operationBinding () {
        return new SNSOperationBinding();
    }

    public static SNSServerBinding serverBinding () {
        return new SNSServerBinding();
    }

    @Nested
    @DisplayName("channel")
    class ChannelTest extends BindingTest<SNSChannelBinding> {{
        super.binding                          = channelBinding();
        super.bindingTypeClass                 = SNSChannelBinding.class;
        super.pathToBindingJson                = "/bindings/default implementation/0.1.0/channel/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/default implementation/0.1.0/channel/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/default implementation/0.1.0/channel/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("message")
    class Message extends BindingTest<SNSMessageBinding> {{
        super.binding                          = messageBinding();
        super.bindingTypeClass                 = SNSMessageBinding.class;
        super.pathToBindingJson                = "/bindings/default implementation/0.1.0/message/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/default implementation/0.1.0/message/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/default implementation/0.1.0/message/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("operation")
    class Operation extends BindingTest<SNSOperationBinding> {{
        super.binding                          = operationBinding();
        super.bindingTypeClass                 = SNSOperationBinding.class;
        super.pathToBindingJson                = "/bindings/default implementation/0.1.0/operation/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/default implementation/0.1.0/operation/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/default implementation/0.1.0/operation/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("server")
    class Server extends BindingTest<SNSServerBinding> {{
        super.binding                          = serverBinding();
        super.bindingTypeClass                 = SNSServerBinding.class;
        super.pathToBindingJson                = "/bindings/default implementation/0.1.0/server/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/default implementation/0.1.0/server/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/default implementation/0.1.0/server/binding - wrongly extended.json";
    }}

}
