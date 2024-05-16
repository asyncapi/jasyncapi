package com.asyncapi.bindings.anypointmq;

import com.asyncapi.bindings.BindingTest;
import com.asyncapi.bindings.anypointmq.v0._0_1.channel.AnypointMQChannelBinding;
import com.asyncapi.bindings.anypointmq.v0._0_1.message.AnypointMQMessageBinding;
import com.asyncapi.bindings.anypointmq.v0._0_1.operation.AnypointMQOperationBinding;
import com.asyncapi.bindings.anypointmq.v0._0_1.server.AnypointMQServerBinding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

@DisplayName("latest")
public class AnypointMQLatestTest {

    @Nested
    @DisplayName("channel")
    class ChannelTest extends BindingTest<AnypointMQChannelBinding> {{
        super.binding                          = AnypointMQV0_0_1Test.channelBinding();
        super.bindingTypeClass                 = AnypointMQChannelBinding.class;
        super.pathToBindingJson                = "/bindings/anypointmq/latest/channel/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/anypointmq/latest/channel/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/anypointmq/latest/channel/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("message")
    class Message extends BindingTest<AnypointMQMessageBinding> {{
        super.binding                          = AnypointMQV0_0_1Test.messageBinding();
        super.bindingTypeClass                 = AnypointMQMessageBinding.class;
        super.pathToBindingJson                = "/bindings/anypointmq/latest/message/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/anypointmq/latest/message/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/anypointmq/latest/message/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("operation")
    class Operation extends BindingTest<AnypointMQOperationBinding> {{
        super.binding                          = AnypointMQV0_0_1Test.operationBinding();
        super.bindingTypeClass                 = AnypointMQOperationBinding.class;
        super.pathToBindingJson                = "/bindings/anypointmq/latest/operation/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/anypointmq/latest/operation/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/anypointmq/latest/operation/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("server")
    class Server extends BindingTest<AnypointMQServerBinding> {{
        super.binding                          = AnypointMQV0_0_1Test.serverBinding();
        super.bindingTypeClass                 = AnypointMQServerBinding.class;
        super.pathToBindingJson                = "/bindings/anypointmq/latest/server/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/anypointmq/latest/server/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/anypointmq/latest/server/binding - wrongly extended.json";
    }}

}
