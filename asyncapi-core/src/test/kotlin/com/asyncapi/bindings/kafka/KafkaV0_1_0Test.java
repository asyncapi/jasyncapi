package com.asyncapi.bindings.kafka;

import com.asyncapi.bindings.BindingTest;
import com.asyncapi.bindings.kafka.v0._1_0.channel.KafkaChannelBinding;
import com.asyncapi.bindings.kafka.v0._1_0.message.KafkaMessageBinding;
import com.asyncapi.bindings.kafka.v0._1_0.operation.KafkaOperationBinding;
import com.asyncapi.bindings.kafka.v0._1_0.server.KafkaServerBinding;
import com.asyncapi.schemas.Type;
import com.asyncapi.schemas.asyncapi.AsyncAPISchema;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

import java.util.List;

@DisplayName("0.1.0")
public class KafkaV0_1_0Test {

    public static KafkaChannelBinding channelBinding () {
        return new KafkaChannelBinding();
    }

    public static KafkaMessageBinding messageBinding () {
        return KafkaMessageBinding.builder()
                .key(AsyncAPISchema.builder()
                        .type(Type.STRING)
                        .enumValue(List.of("myKey"))
                        .build())
                .build();
    }

    public static KafkaOperationBinding operationBinding () {
        return KafkaOperationBinding.builder()
                .groupId(AsyncAPISchema.builder()
                        .type(Type.STRING)
                        .enumValue(List.of("myGroupId"))
                        .build())
                .clientId(AsyncAPISchema.builder()
                        .type(Type.STRING)
                        .enumValue(List.of("myClientId"))
                        .build())
                .build();
    }

    public static KafkaServerBinding serverBinding () {
        return new KafkaServerBinding();
    }

    @Nested
    @DisplayName("channel")
    class ChannelTest extends BindingTest<KafkaChannelBinding> {{
        super.binding                          = channelBinding();
        super.bindingTypeClass                 = KafkaChannelBinding.class;
        super.pathToBindingJson                = "/bindings/kafka/0.1.0/channel/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/kafka/0.1.0/channel/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/kafka/0.1.0/channel/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("message")
    class Message extends BindingTest<KafkaMessageBinding> {{
        super.binding                          = messageBinding();
        super.bindingTypeClass                 = KafkaMessageBinding.class;
        super.pathToBindingJson                = "/bindings/kafka/0.1.0/message/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/kafka/0.1.0/message/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/kafka/0.1.0/message/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("operation")
    class Operation extends BindingTest<KafkaOperationBinding> {{
        super.binding                          = operationBinding();
        super.bindingTypeClass                 = KafkaOperationBinding.class;
        super.pathToBindingJson                = "/bindings/kafka/0.1.0/operation/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/kafka/0.1.0/operation/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/kafka/0.1.0/operation/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("server")
    class Server extends BindingTest<KafkaServerBinding> {{
        super.binding                          = serverBinding();
        super.bindingTypeClass                 = KafkaServerBinding.class;
        super.pathToBindingJson                = "/bindings/kafka/0.1.0/server/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/kafka/0.1.0/server/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/kafka/0.1.0/server/binding - wrongly extended.json";
    }}

}
