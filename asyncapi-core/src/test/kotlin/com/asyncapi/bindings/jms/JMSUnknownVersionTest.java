package com.asyncapi.bindings.jms;

import com.asyncapi.bindings.BindingTest;
import com.asyncapi.bindings.jms.v0._0_1.channel.JMSChannelBinding;
import com.asyncapi.bindings.jms.v0._0_1.message.JMSMessageBinding;
import com.asyncapi.bindings.jms.v0._0_1.operation.JMSOperationBinding;
import com.asyncapi.bindings.jms.v0._0_1.server.JMSServerBinding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

@DisplayName("unknown version")
public class JMSUnknownVersionTest {

    @Nested
    @DisplayName("channel")
    class ChannelTest extends BindingTest<JMSChannelBinding> {{
        super.binding                          = JMSV0_1_0Test.channelBinding();
        super.bindingTypeClass                 = JMSChannelBinding.class;
        super.pathToBindingJson                = "/bindings/jms/unknown version/channel/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/jms/unknown version/channel/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/jms/unknown version/channel/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("message")
    class Message extends BindingTest<JMSMessageBinding> {{
        super.binding                          = JMSV0_1_0Test.messageBinding();
        super.bindingTypeClass                 = JMSMessageBinding.class;
        super.pathToBindingJson                = "/bindings/jms/unknown version/message/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/jms/unknown version/message/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/jms/unknown version/message/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("operation")
    class Operation extends BindingTest<JMSOperationBinding> {{
        super.binding                          = JMSV0_1_0Test.operationBinding();
        super.bindingTypeClass                 = JMSOperationBinding.class;
        super.pathToBindingJson                = "/bindings/jms/unknown version/operation/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/jms/unknown version/operation/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/jms/unknown version/operation/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("server")
    class Server extends BindingTest<JMSServerBinding> {{
        super.binding                          = JMSV0_1_0Test.serverBinding();
        super.bindingTypeClass                 = JMSServerBinding.class;
        super.pathToBindingJson                = "/bindings/jms/unknown version/server/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/jms/unknown version/server/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/jms/unknown version/server/binding - wrongly extended.json";
    }}

}
