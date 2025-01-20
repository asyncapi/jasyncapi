package com.asyncapi.bindings.mqtt5;

import com.asyncapi.bindings.BindingTest;
import com.asyncapi.bindings.mqtt5.v0._1_0.channel.MQTT5ChannelBinding;
import com.asyncapi.bindings.mqtt5.v0._1_0.message.MQTT5MessageBinding;
import com.asyncapi.bindings.mqtt5.v0._1_0.operation.MQTT5OperationBinding;
import com.asyncapi.bindings.mqtt5.v0._1_0.server.MQTT5ServerBinding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

@DisplayName("0.1.0")
public class MQTT5V0_1_0Test {

    public static MQTT5ChannelBinding channelBinding () {
        return new MQTT5ChannelBinding();
    }

    public static MQTT5MessageBinding messageBinding () {
        return new MQTT5MessageBinding();
    }

    public static MQTT5OperationBinding operationBinding () {
        return new MQTT5OperationBinding();
    }

    public static MQTT5ServerBinding serverBinding () {
        return new MQTT5ServerBinding();
    }

    @Nested
    @DisplayName("channel")
    class ChannelTest extends BindingTest<MQTT5ChannelBinding> {{
        super.binding                          = channelBinding();
        super.bindingTypeClass                 = MQTT5ChannelBinding.class;
        super.pathToBindingJson                = "/bindings/default implementation/0.1.0/channel/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/default implementation/0.1.0/channel/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/default implementation/0.1.0/channel/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("message")
    class Message extends BindingTest<MQTT5MessageBinding> {{
        super.binding                          = messageBinding();
        super.bindingTypeClass                 = MQTT5MessageBinding.class;
        super.pathToBindingJson                = "/bindings/default implementation/0.1.0/message/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/default implementation/0.1.0/message/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/default implementation/0.1.0/message/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("operation")
    class Operation extends BindingTest<MQTT5OperationBinding> {{
        super.binding                          = operationBinding();
        super.bindingTypeClass                 = MQTT5OperationBinding.class;
        super.pathToBindingJson                = "/bindings/default implementation/0.1.0/operation/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/default implementation/0.1.0/operation/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/default implementation/0.1.0/operation/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("server")
    class Server extends BindingTest<MQTT5ServerBinding> {{
        super.binding                          = serverBinding();
        super.bindingTypeClass                 = MQTT5ServerBinding.class;
        super.pathToBindingJson                = "/bindings/default implementation/0.1.0/server/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/default implementation/0.1.0/server/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/default implementation/0.1.0/server/binding - wrongly extended.json";
    }}

}
