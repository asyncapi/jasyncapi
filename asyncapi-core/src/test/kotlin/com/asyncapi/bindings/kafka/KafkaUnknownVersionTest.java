package com.asyncapi.bindings.kafka;

import com.asyncapi.bindings.BindingTest;
import com.asyncapi.bindings.kafka.v0._5_0.channel.KafkaChannelBinding;
import com.asyncapi.bindings.kafka.v0._5_0.message.KafkaMessageBinding;
import com.asyncapi.bindings.kafka.v0._5_0.operation.KafkaOperationBinding;
import com.asyncapi.bindings.kafka.v0._5_0.server.KafkaServerBinding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

@DisplayName("unknown version")
public class KafkaUnknownVersionTest {

    @Nested
    @DisplayName("channel")
    class ChannelTest extends BindingTest<KafkaChannelBinding> {{
        super.binding                          = KafkaV0_5_0Test.channelBinding();
        super.bindingTypeClass                 = KafkaChannelBinding.class;
        super.pathToBindingJson                = "/bindings/kafka/unknown version/channel/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/kafka/unknown version/channel/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/kafka/unknown version/channel/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("message")
    class Message extends BindingTest<KafkaMessageBinding> {{
        super.binding                          = KafkaV0_5_0Test.messageBinding();
        super.bindingTypeClass                 = KafkaMessageBinding.class;
        super.pathToBindingJson                = "/bindings/kafka/unknown version/message/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/kafka/unknown version/message/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/kafka/unknown version/message/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("operation")
    class Operation extends BindingTest<KafkaOperationBinding> {{
        super.binding                          = KafkaV0_5_0Test.operationBinding();
        super.bindingTypeClass                 = KafkaOperationBinding.class;
        super.pathToBindingJson                = "/bindings/kafka/unknown version/operation/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/kafka/unknown version/operation/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/kafka/unknown version/operation/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("server")
    class Server extends BindingTest<KafkaServerBinding> {{
        super.binding                          = KafkaV0_5_0Test.serverBinding();
        super.bindingTypeClass                 = KafkaServerBinding.class;
        super.pathToBindingJson                = "/bindings/kafka/unknown version/server/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/kafka/unknown version/server/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/kafka/unknown version/server/binding - wrongly extended.json";
    }}

}
