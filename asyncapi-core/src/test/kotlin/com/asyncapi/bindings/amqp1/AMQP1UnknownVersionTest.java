package com.asyncapi.bindings.amqp1;

import com.asyncapi.bindings.BindingTest;
import com.asyncapi.bindings.amqp1.v0._1_0.channel.AMQP1ChannelBinding;
import com.asyncapi.bindings.amqp1.v0._1_0.message.AMQP1MessageBinding;
import com.asyncapi.bindings.amqp1.v0._1_0.operation.AMQP1OperationBinding;
import com.asyncapi.bindings.amqp1.v0._1_0.server.AMQP1ServerBinding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

@DisplayName("unknown version")
public class AMQP1UnknownVersionTest {

    @Nested
    @DisplayName("channel")
    class ChannelTest extends BindingTest<AMQP1ChannelBinding> {{
        super.binding                          = new AMQP1ChannelBinding();
        super.bindingTypeClass                 = AMQP1ChannelBinding.class;
        super.pathToBindingJson                = "/bindings/default implementation/unknown version/channel/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/default implementation/unknown version/channel/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/default implementation/unknown version/channel/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("message")
    class Message extends BindingTest<AMQP1MessageBinding> {{
        super.binding                          = new AMQP1MessageBinding();
        super.bindingTypeClass                 = AMQP1MessageBinding.class;
        super.pathToBindingJson                = "/bindings/default implementation/unknown version/message/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/default implementation/unknown version/message/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/default implementation/unknown version/message/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("operation")
    class Operation extends BindingTest<AMQP1OperationBinding> {{
        super.binding                          = new AMQP1OperationBinding();
        super.bindingTypeClass                 = AMQP1OperationBinding.class;
        super.pathToBindingJson                = "/bindings/default implementation/unknown version/operation/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/default implementation/unknown version/operation/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/default implementation/unknown version/operation/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("server")
    class Server extends BindingTest<AMQP1ServerBinding> {{
        super.binding                          = new AMQP1ServerBinding();
        super.bindingTypeClass                 = AMQP1ServerBinding.class;
        super.pathToBindingJson                = "/bindings/default implementation/unknown version/server/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/default implementation/unknown version/server/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/default implementation/unknown version/server/binding - wrongly extended.json";
    }}

}
