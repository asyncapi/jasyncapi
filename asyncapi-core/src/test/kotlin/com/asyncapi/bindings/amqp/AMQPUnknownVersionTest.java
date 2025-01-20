package com.asyncapi.bindings.amqp;

import com.asyncapi.bindings.BindingTest;
import com.asyncapi.bindings.amqp.v0._3_0.channel.AMQPChannelBinding;
import com.asyncapi.bindings.amqp.v0._3_0.message.AMQPMessageBinding;
import com.asyncapi.bindings.amqp.v0._3_0.operation.AMQPOperationBinding;
import com.asyncapi.bindings.amqp.v0._3_0.server.AMQPServerBinding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

@DisplayName("unknown version")
public class AMQPUnknownVersionTest {

    @Nested
    @DisplayName("channel")
    class ChannelTest extends BindingTest<AMQPChannelBinding> {{
        super.binding                          = AMQPV0_3_0Test.channelBinding();
        super.bindingTypeClass                 = AMQPChannelBinding.class;
        super.pathToBindingJson                = "/bindings/amqp/unknown version/channel/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/amqp/unknown version/channel/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/amqp/unknown version/channel/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("message")
    class Message extends BindingTest<AMQPMessageBinding> {{
        super.binding                          = AMQPV0_3_0Test.messageBinding();
        super.bindingTypeClass                 = AMQPMessageBinding.class;
        super.pathToBindingJson                = "/bindings/amqp/unknown version/message/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/amqp/unknown version/message/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/amqp/unknown version/message/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("operation")
    class Operation extends BindingTest<AMQPOperationBinding> {{
        super.binding                          = AMQPV0_3_0Test.operationBinding();
        super.bindingTypeClass                 = AMQPOperationBinding.class;
        super.pathToBindingJson                = "/bindings/amqp/unknown version/operation/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/amqp/unknown version/operation/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/amqp/unknown version/operation/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("server")
    class Server extends BindingTest<AMQPServerBinding> {{
        super.binding                          = AMQPV0_3_0Test.serverBinding();
        super.bindingTypeClass                 = AMQPServerBinding.class;
        super.pathToBindingJson                = "/bindings/amqp/unknown version/server/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/amqp/unknown version/server/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/amqp/unknown version/server/binding - wrongly extended.json";
    }}

}
