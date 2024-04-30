package com.asyncapi.bindings.mqtt5;

import com.asyncapi.bindings.BindingTest;
import com.asyncapi.bindings.mqtt5.v0._2_0.channel.MQTT5ChannelBinding;
import com.asyncapi.bindings.mqtt5.v0._2_0.message.MQTT5MessageBinding;
import com.asyncapi.bindings.mqtt5.v0._2_0.operation.MQTT5OperationBinding;
import com.asyncapi.bindings.mqtt5.v0._2_0.server.MQTT5ServerBinding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

@DisplayName("unknown version")
public class MQTT5UnknownVersionTest {

    @Nested
    @DisplayName("channel")
    class ChannelTest extends BindingTest<MQTT5ChannelBinding> {{
        super.binding                          = MQTT5V0_2_0Test.channelBinding();
        super.bindingTypeClass                 = MQTT5ChannelBinding.class;
        super.pathToBindingJson                = "/bindings/mqtt5/unknown version/channel/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/mqtt5/unknown version/channel/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/mqtt5/unknown version/channel/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("message")
    class Message extends BindingTest<MQTT5MessageBinding> {{
        super.binding                          = MQTT5V0_2_0Test.messageBinding();
        super.bindingTypeClass                 = MQTT5MessageBinding.class;
        super.pathToBindingJson                = "/bindings/mqtt5/unknown version/message/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/mqtt5/unknown version/message/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/mqtt5/unknown version/message/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("operation")
    class Operation extends BindingTest<MQTT5OperationBinding> {{
        super.binding                          = MQTT5V0_2_0Test.operationBinding();
        super.bindingTypeClass                 = MQTT5OperationBinding.class;
        super.pathToBindingJson                = "/bindings/mqtt5/unknown version/operation/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/mqtt5/unknown version/operation/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/mqtt5/unknown version/operation/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("server")
    class Server extends BindingTest<MQTT5ServerBinding> {{
        super.binding                          = MQTT5V0_2_0Test.serverBinding();
        super.bindingTypeClass                 = MQTT5ServerBinding.class;
        super.pathToBindingJson                = "/bindings/mqtt5/unknown version/server/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/mqtt5/unknown version/server/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/mqtt5/unknown version/server/binding - wrongly extended.json";
    }}

}
