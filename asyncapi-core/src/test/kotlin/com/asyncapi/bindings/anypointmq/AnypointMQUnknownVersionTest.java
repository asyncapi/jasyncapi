package com.asyncapi.bindings.anypointmq;

import com.asyncapi.bindings.BindingTest;
import com.asyncapi.bindings.anypointmq.v0._0_1.channel.AnypointMQChannelBinding;
import com.asyncapi.bindings.anypointmq.v0._0_1.message.AnypointMQMessageBinding;
import com.asyncapi.bindings.anypointmq.v0._0_1.operation.AnypointMQOperationBinding;
import com.asyncapi.bindings.anypointmq.v0._0_1.server.AnypointMQServerBinding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

@DisplayName("unknown version")
public class AnypointMQUnknownVersionTest {

    @Nested
    @DisplayName("channel")
    class ChannelTest extends BindingTest<com.asyncapi.bindings.anypointmq.v0._0_1.channel.AnypointMQChannelBinding> {{
        super.binding                          = AnypointMQV0_0_1Test.channelBinding();
        super.bindingTypeClass                 = AnypointMQChannelBinding.class;
        super.pathToBindingJson                = "/bindings/anypointmq/unknown version/channel/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/anypointmq/unknown version/channel/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/anypointmq/unknown version/channel/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("message")
    class Message extends BindingTest<com.asyncapi.bindings.anypointmq.v0._0_1.message.AnypointMQMessageBinding> {{
        super.binding                          = AnypointMQV0_0_1Test.messageBinding();
        super.bindingTypeClass                 = AnypointMQMessageBinding.class;
        super.pathToBindingJson                = "/bindings/anypointmq/unknown version/message/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/anypointmq/unknown version/message/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/anypointmq/unknown version/message/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("operation")
    class Operation extends BindingTest<com.asyncapi.bindings.anypointmq.v0._0_1.operation.AnypointMQOperationBinding> {{
        super.binding                          = AnypointMQV0_0_1Test.operationBinding();
        super.bindingTypeClass                 = AnypointMQOperationBinding.class;
        super.pathToBindingJson                = "/bindings/anypointmq/unknown version/operation/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/anypointmq/unknown version/operation/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/anypointmq/unknown version/operation/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("server")
    class Server extends BindingTest<com.asyncapi.bindings.anypointmq.v0._0_1.server.AnypointMQServerBinding> {{
        super.binding                          = AnypointMQV0_0_1Test.serverBinding();
        super.bindingTypeClass                 = AnypointMQServerBinding.class;
        super.pathToBindingJson                = "/bindings/anypointmq/unknown version/server/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/anypointmq/unknown version/server/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/anypointmq/unknown version/server/binding - wrongly extended.json";
    }}

}
