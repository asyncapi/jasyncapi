package com.asyncapi.bindings.nats;

import com.asyncapi.bindings.BindingTest;
import com.asyncapi.bindings.nats.v0._1_0.channel.NATSChannelBinding;
import com.asyncapi.bindings.nats.v0._1_0.message.NATSMessageBinding;
import com.asyncapi.bindings.nats.v0._1_0.operation.NATSOperationBinding;
import com.asyncapi.bindings.nats.v0._1_0.server.NATSServerBinding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

@DisplayName("unknown version")
public class NATSUnknownVersionTest {

    @Nested
    @DisplayName("channel")
    class ChannelTest extends BindingTest<NATSChannelBinding> {{
        super.binding                          = NATSV0_1_0Test.channelBinding();
        super.bindingTypeClass                 = NATSChannelBinding.class;
        super.pathToBindingJson                = "/bindings/nats/unknown version/channel/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/nats/unknown version/channel/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/nats/unknown version/channel/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("message")
    class Message extends BindingTest<NATSMessageBinding> {{
        super.binding                          = NATSV0_1_0Test.messageBinding();
        super.bindingTypeClass                 = NATSMessageBinding.class;
        super.pathToBindingJson                = "/bindings/nats/unknown version/message/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/nats/unknown version/message/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/nats/unknown version/message/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("operation")
    class Operation extends BindingTest<NATSOperationBinding> {{
        super.binding                          = NATSV0_1_0Test.operationBinding();
        super.bindingTypeClass                 = NATSOperationBinding.class;
        super.pathToBindingJson                = "/bindings/nats/unknown version/operation/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/nats/unknown version/operation/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/nats/unknown version/operation/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("server")
    class Server extends BindingTest<NATSServerBinding> {{
        super.binding                          = NATSV0_1_0Test.serverBinding();
        super.bindingTypeClass                 = NATSServerBinding.class;
        super.pathToBindingJson                = "/bindings/nats/unknown version/server/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/nats/unknown version/server/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/nats/unknown version/server/binding - wrongly extended.json";
    }}

}
