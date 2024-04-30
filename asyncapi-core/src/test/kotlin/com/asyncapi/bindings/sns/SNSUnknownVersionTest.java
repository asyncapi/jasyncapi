package com.asyncapi.bindings.sns;

import com.asyncapi.bindings.BindingTest;
import com.asyncapi.bindings.sns.v0._1_0.channel.SNSChannelBinding;
import com.asyncapi.bindings.sns.v0._1_0.message.SNSMessageBinding;
import com.asyncapi.bindings.sns.v0._1_0.operation.SNSOperationBinding;
import com.asyncapi.bindings.sns.v0._1_0.server.SNSServerBinding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

@DisplayName("unknown version")
public class SNSUnknownVersionTest {

    @Nested
    @DisplayName("channel")
    class ChannelTest extends BindingTest<SNSChannelBinding> {{
        super.binding                          = SNSV0_1_0Test.channelBinding();
        super.bindingTypeClass                 = SNSChannelBinding.class;
        super.pathToBindingJson                = "/bindings/default implementation/unknown version/channel/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/default implementation/unknown version/channel/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/default implementation/unknown version/channel/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("message")
    class Message extends BindingTest<SNSMessageBinding> {{
        super.binding                          = SNSV0_1_0Test.messageBinding();
        super.bindingTypeClass                 = SNSMessageBinding.class;
        super.pathToBindingJson                = "/bindings/default implementation/unknown version/message/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/default implementation/unknown version/message/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/default implementation/unknown version/message/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("operation")
    class Operation extends BindingTest<SNSOperationBinding> {{
        super.binding                          = SNSV0_1_0Test.operationBinding();
        super.bindingTypeClass                 = SNSOperationBinding.class;
        super.pathToBindingJson                = "/bindings/default implementation/unknown version/operation/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/default implementation/unknown version/operation/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/default implementation/unknown version/operation/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("server")
    class Server extends BindingTest<SNSServerBinding> {{
        super.binding                          = SNSV0_1_0Test.serverBinding();
        super.bindingTypeClass                 = SNSServerBinding.class;
        super.pathToBindingJson                = "/bindings/default implementation/unknown version/server/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/default implementation/unknown version/server/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/default implementation/unknown version/server/binding - wrongly extended.json";
    }}

}
