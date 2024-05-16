package com.asyncapi.bindings.nats;

import com.asyncapi.bindings.BindingTest;
import com.asyncapi.bindings.nats.v0._1_0.channel.NATSChannelBinding;
import com.asyncapi.bindings.nats.v0._1_0.message.NATSMessageBinding;
import com.asyncapi.bindings.nats.v0._1_0.operation.NATSOperationBinding;
import com.asyncapi.bindings.nats.v0._1_0.server.NATSServerBinding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

@DisplayName("0.1.0")
public class NATSV0_1_0Test {

    public static NATSChannelBinding channelBinding () {
        return new NATSChannelBinding();
    }

    public static NATSMessageBinding messageBinding () {
        return new NATSMessageBinding();
    }

    public static NATSOperationBinding operationBinding () {
        return NATSOperationBinding.builder()
                .queue("messages")
                .build();
    }

    public static NATSServerBinding serverBinding () {
        return new NATSServerBinding();
    }

    @Nested
    @DisplayName("channel")
    class ChannelTest extends BindingTest<NATSChannelBinding> {{
        super.binding                          = channelBinding();
        super.bindingTypeClass                 = NATSChannelBinding.class;
        super.pathToBindingJson                = "/bindings/nats/0.1.0/channel/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/nats/0.1.0/channel/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/nats/0.1.0/channel/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("message")
    class Message extends BindingTest<NATSMessageBinding> {{
        super.binding                          = messageBinding();
        super.bindingTypeClass                 = NATSMessageBinding.class;
        super.pathToBindingJson                = "/bindings/nats/0.1.0/message/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/nats/0.1.0/message/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/nats/0.1.0/message/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("operation")
    class Operation extends BindingTest<NATSOperationBinding> {{
        super.binding                          = operationBinding();
        super.bindingTypeClass                 = NATSOperationBinding.class;
        super.pathToBindingJson                = "/bindings/nats/0.1.0/operation/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/nats/0.1.0/operation/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/nats/0.1.0/operation/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("server")
    class Server extends BindingTest<NATSServerBinding> {{
        super.binding                          = serverBinding();
        super.bindingTypeClass                 = NATSServerBinding.class;
        super.pathToBindingJson                = "/bindings/nats/0.1.0/server/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/nats/0.1.0/server/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/nats/0.1.0/server/binding - wrongly extended.json";
    }}

}
