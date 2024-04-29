package com.asyncapi.bindings.pulsar;

import com.asyncapi.bindings.BindingTest;
import com.asyncapi.bindings.pulsar.v0._1_0.channel.PulsarChannelBinding;
import com.asyncapi.bindings.pulsar.v0._1_0.channel.PulsarChannelPersistence;
import com.asyncapi.bindings.pulsar.v0._1_0.channel.PulsarChannelRetentionDefinition;
import com.asyncapi.bindings.pulsar.v0._1_0.message.PulsarMessageBinding;
import com.asyncapi.bindings.pulsar.v0._1_0.operation.PulsarOperationBinding;
import com.asyncapi.bindings.pulsar.v0._1_0.server.PulsarServerBinding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

import java.util.List;

@DisplayName("0.1.0")
public class PulsarV0_1_0Test {

    public static PulsarChannelBinding channelBinding () {
        return PulsarChannelBinding.builder()
                .namespace("staging")
                .persistence(PulsarChannelPersistence.PERSISTENT)
                .compaction(1000)
                .geoReplication(List.of("us-east1", "us-west1"))
                .retention(PulsarChannelRetentionDefinition.builder()
                        .time(7)
                        .size(1000)
                        .build()
                )
                .ttl(360)
                .deduplication(false)
                .build();
    }

    public static PulsarMessageBinding messageBinding () {
        return new PulsarMessageBinding();
    }

    public static PulsarOperationBinding operationBinding () {
        return new PulsarOperationBinding();
    }

    public static PulsarServerBinding serverBinding () {
        return PulsarServerBinding.builder()
                .tenant("contoso")
                .build();
    }

    @Nested
    @DisplayName("channel")
    class ChannelTest extends BindingTest<PulsarChannelBinding> {{
        super.binding                          = channelBinding();
        super.bindingTypeClass                 = PulsarChannelBinding.class;
        super.pathToBindingJson                = "/bindings/pulsar/0.1.0/channel/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/pulsar/0.1.0/channel/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/pulsar/0.1.0/channel/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("message")
    class Message extends BindingTest<PulsarMessageBinding> {{
        super.binding                          = messageBinding();
        super.bindingTypeClass                 = PulsarMessageBinding.class;
        super.pathToBindingJson                = "/bindings/pulsar/0.1.0/message/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/pulsar/0.1.0/message/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/pulsar/0.1.0/message/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("operation")
    class Operation extends BindingTest<PulsarOperationBinding> {{
        super.binding                          = operationBinding();
        super.bindingTypeClass                 = PulsarOperationBinding.class;
        super.pathToBindingJson                = "/bindings/pulsar/0.1.0/operation/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/pulsar/0.1.0/operation/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/pulsar/0.1.0/operation/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("server")
    class Server extends BindingTest<PulsarServerBinding> {{
        super.binding                          = serverBinding();
        super.bindingTypeClass                 = PulsarServerBinding.class;
        super.pathToBindingJson                = "/bindings/pulsar/0.1.0/server/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/pulsar/0.1.0/server/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/pulsar/0.1.0/server/binding - wrongly extended.json";
    }}

}
