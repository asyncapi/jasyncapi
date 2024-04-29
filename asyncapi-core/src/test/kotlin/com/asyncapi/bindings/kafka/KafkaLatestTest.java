package com.asyncapi.bindings.kafka;

import com.asyncapi.bindings.BindingTest;
import com.asyncapi.bindings.kafka.v0._4_0.channel.KafkaChannelBinding;
import com.asyncapi.bindings.kafka.v0._4_0.message.KafkaMessageBinding;
import com.asyncapi.bindings.kafka.v0._4_0.operation.KafkaOperationBinding;
import com.asyncapi.bindings.kafka.v0._4_0.server.KafkaServerBinding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

@DisplayName("latest")
public class KafkaLatestTest {

    @Nested
    @DisplayName("channel")
    class ChannelTest extends BindingTest<KafkaChannelBinding> {{
        super.binding                          = KafkaV0_4_0Test.channelBinding();
        super.bindingTypeClass                 = KafkaChannelBinding.class;
        super.pathToBindingJson                = "/bindings/kafka/latest/channel/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/kafka/latest/channel/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/kafka/latest/channel/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("message")
    class Message extends BindingTest<KafkaMessageBinding> {{
        super.binding                          = KafkaV0_4_0Test.messageBinding();
        super.bindingTypeClass                 = KafkaMessageBinding.class;
        super.pathToBindingJson                = "/bindings/kafka/latest/message/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/kafka/latest/message/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/kafka/latest/message/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("operation")
    class Operation extends BindingTest<KafkaOperationBinding> {{
        super.binding                          = KafkaV0_4_0Test.operationBinding();
        super.bindingTypeClass                 = KafkaOperationBinding.class;
        super.pathToBindingJson                = "/bindings/kafka/latest/operation/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/kafka/latest/operation/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/kafka/latest/operation/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("server")
    class Server extends BindingTest<KafkaServerBinding> {{
        super.binding                          = KafkaV0_4_0Test.serverBinding();
        super.bindingTypeClass                 = KafkaServerBinding.class;
        super.pathToBindingJson                = "/bindings/kafka/latest/server/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/kafka/latest/server/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/kafka/latest/server/binding - wrongly extended.json";
    }}

}
