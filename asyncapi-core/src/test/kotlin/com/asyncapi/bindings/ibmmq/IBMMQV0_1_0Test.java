package com.asyncapi.bindings.ibmmq;

import com.asyncapi.bindings.BindingTest;
import com.asyncapi.bindings.ibmmq.v0._1_0.channel.IBMMQChannelBinding;
import com.asyncapi.bindings.ibmmq.v0._1_0.channel.IBMMQChannelDestinationType;
import com.asyncapi.bindings.ibmmq.v0._1_0.channel.IBMMQChannelQueueProperties;
import com.asyncapi.bindings.ibmmq.v0._1_0.channel.IBMMQChannelTopicProperties;
import com.asyncapi.bindings.ibmmq.v0._1_0.message.IBMMQMessageBinding;
import com.asyncapi.bindings.ibmmq.v0._1_0.message.IBMMQMessageType;
import com.asyncapi.bindings.ibmmq.v0._1_0.operation.IBMMQOperationBinding;
import com.asyncapi.bindings.ibmmq.v0._1_0.server.IBMMQServerBinding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

@DisplayName("0.1.0")
public class IBMMQV0_1_0Test {

    public static IBMMQChannelBinding channelBinding () {
        return IBMMQChannelBinding.builder()
                .destinationType(IBMMQChannelDestinationType.TOPIC)
                .queue(IBMMQChannelQueueProperties.builder()
                        .objectName("message")
                        .isPartitioned(false)
                        .exclusive(true)
                        .build()
                )
                .topic(IBMMQChannelTopicProperties.builder()
                        .string("messages")
                        .objectName("message")
                        .durablePermitted(true)
                        .lastMsgRetained(true)
                        .build()
                )
                .maxMsgLength(1024)
                .build();
    }

    public static IBMMQMessageBinding messageBinding () {
        return IBMMQMessageBinding.builder()
                .type(IBMMQMessageType.JMS)
                .description("JMS stream message")
                .headers("Content-Type: application/json")
                .expiry(0)
                .build();
    }

    public static IBMMQOperationBinding operationBinding () {
        return new IBMMQOperationBinding();
    }

    public static IBMMQServerBinding serverBinding () {
        return IBMMQServerBinding.builder()
                .groupId("PRODCLSTR1")
                .cipherSpec("ANY_TLS12_OR_HIGHER")
                .build();
    }

    @Nested
    @DisplayName("channel")
    class ChannelTest extends BindingTest<IBMMQChannelBinding> {{
        super.binding                          = channelBinding();
        super.bindingTypeClass                 = IBMMQChannelBinding.class;
        super.pathToBindingJson                = "/bindings/ibmmq/0.1.0/channel/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/ibmmq/0.1.0/channel/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/ibmmq/0.1.0/channel/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("message")
    class Message extends BindingTest<IBMMQMessageBinding> {{
        super.binding                          = messageBinding();
        super.bindingTypeClass                 = IBMMQMessageBinding.class;
        super.pathToBindingJson                = "/bindings/ibmmq/0.1.0/message/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/ibmmq/0.1.0/message/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/ibmmq/0.1.0/message/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("operation")
    class Operation extends BindingTest<IBMMQOperationBinding> {{
        super.binding                          = operationBinding();
        super.bindingTypeClass                 = IBMMQOperationBinding.class;
        super.pathToBindingJson                = "/bindings/ibmmq/0.1.0/operation/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/ibmmq/0.1.0/operation/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/ibmmq/0.1.0/operation/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("server")
    class Server extends BindingTest<IBMMQServerBinding> {{
        super.binding                          = serverBinding();
        super.bindingTypeClass                 = IBMMQServerBinding.class;
        super.pathToBindingJson                = "/bindings/ibmmq/0.1.0/server/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/ibmmq/0.1.0/server/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/ibmmq/0.1.0/server/binding - wrongly extended.json";
    }}

}
