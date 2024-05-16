package com.asyncapi.bindings.mqtt;

import com.asyncapi.bindings.BindingTest;
import com.asyncapi.bindings.mqtt.v0._1_0.channel.MQTTChannelBinding;
import com.asyncapi.bindings.mqtt.v0._1_0.message.MQTTMessageBinding;
import com.asyncapi.bindings.mqtt.v0._1_0.operation.MQTTOperationBinding;
import com.asyncapi.bindings.mqtt.v0._1_0.server.MQTTServerBinding;
import com.asyncapi.bindings.mqtt.v0._1_0.server.MQTTServerLastWillConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

@DisplayName("0.1.0")
public class MQTTV0_1_0Test {

    public static MQTTChannelBinding channelBinding () {
        return new MQTTChannelBinding();
    }

    public static MQTTMessageBinding messageBinding () {
        return new MQTTMessageBinding();
    }

    public static MQTTOperationBinding operationBinding () {
        return MQTTOperationBinding.builder()
                .qos(2)
                .retain(true)
                .build();
    }

    public static MQTTServerBinding serverBinding () {
        return MQTTServerBinding.builder()
                .clientId("guest")
                .cleanSession(true)
                .lastWill(new MQTTServerLastWillConfiguration(
                        "/last-wills",
                        2,
                        "Guest gone offline.",
                        false
                ))
                .keepAlive(60)
                .build();
    }

    @Nested
    @DisplayName("channel")
    class ChannelTest extends BindingTest<MQTTChannelBinding> {{
        super.binding                          = channelBinding();
        super.bindingTypeClass                 = MQTTChannelBinding.class;
        super.pathToBindingJson                = "/bindings/mqtt/0.1.0/channel/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/mqtt/0.1.0/channel/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/mqtt/0.1.0/channel/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("message")
    class Message extends BindingTest<MQTTMessageBinding> {{
        super.binding                          = messageBinding();
        super.bindingTypeClass                 = MQTTMessageBinding.class;
        super.pathToBindingJson                = "/bindings/mqtt/0.1.0/message/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/mqtt/0.1.0/message/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/mqtt/0.1.0/message/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("operation")
    class Operation extends BindingTest<MQTTOperationBinding> {{
        super.binding                          = operationBinding();
        super.bindingTypeClass                 = MQTTOperationBinding.class;
        super.pathToBindingJson                = "/bindings/mqtt/0.1.0/operation/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/mqtt/0.1.0/operation/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/mqtt/0.1.0/operation/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("server")
    class Server extends BindingTest<MQTTServerBinding> {{
        super.binding                          = serverBinding();
        super.bindingTypeClass                 = MQTTServerBinding.class;
        super.pathToBindingJson                = "/bindings/mqtt/0.1.0/server/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/mqtt/0.1.0/server/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/mqtt/0.1.0/server/binding - wrongly extended.json";
    }}

}
