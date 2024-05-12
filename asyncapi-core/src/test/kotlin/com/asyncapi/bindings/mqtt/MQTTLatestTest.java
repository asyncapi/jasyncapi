package com.asyncapi.bindings.mqtt;

import com.asyncapi.bindings.BindingTest;
import com.asyncapi.bindings.mqtt.v0._2_0.channel.MQTTChannelBinding;
import com.asyncapi.bindings.mqtt.v0._2_0.message.MQTTMessageBinding;
import com.asyncapi.bindings.mqtt.v0._2_0.operation.MQTTOperationBinding;
import com.asyncapi.bindings.mqtt.v0._2_0.server.MQTTServerBinding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

@DisplayName("latest")
public class MQTTLatestTest {

    @Nested
    @DisplayName("channel")
    class ChannelTest extends BindingTest<MQTTChannelBinding> {{
        super.binding                          = MQTTV0_2_0Test.channelBinding();
        super.bindingTypeClass                 = MQTTChannelBinding.class;
        super.pathToBindingJson                = "/bindings/mqtt/latest/channel/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/mqtt/latest/channel/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/mqtt/latest/channel/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("message")
    class Message extends BindingTest<MQTTMessageBinding> {{
        super.binding                          = MQTTV0_2_0Test.messageBinding();
        super.bindingTypeClass                 = MQTTMessageBinding.class;
        super.pathToBindingJson                = "/bindings/mqtt/latest/message/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/mqtt/latest/message/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/mqtt/latest/message/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("operation")
    class Operation extends BindingTest<MQTTOperationBinding> {{
        super.binding                          = MQTTV0_2_0Test.operationBinding();
        super.bindingTypeClass                 = MQTTOperationBinding.class;
        super.pathToBindingJson                = "/bindings/mqtt/latest/operation/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/mqtt/latest/operation/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/mqtt/latest/operation/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("server")
    class Server extends BindingTest<MQTTServerBinding> {{
        super.binding                          = MQTTV0_2_0Test.serverBinding();
        super.bindingTypeClass                 = MQTTServerBinding.class;
        super.pathToBindingJson                = "/bindings/mqtt/latest/server/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/mqtt/latest/server/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/mqtt/latest/server/binding - wrongly extended.json";
    }}

}
