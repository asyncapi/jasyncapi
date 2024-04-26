package com.asyncapi.bindings.anypointmq;

import com.asyncapi.bindings.BindingTest;
import com.asyncapi.bindings.anypointmq.v0._0_1.channel.AnypointMQChannelBinding;
import com.asyncapi.bindings.anypointmq.v0._0_1.channel.AnypointMQChannelDestinationType;
import com.asyncapi.bindings.anypointmq.v0._0_1.message.AnypointMQMessageBinding;
import com.asyncapi.bindings.anypointmq.v0._0_1.operation.AnypointMQOperationBinding;
import com.asyncapi.bindings.anypointmq.v0._0_1.server.AnypointMQServerBinding;
import com.asyncapi.v3.schema.AsyncAPISchema;
import com.asyncapi.v3.schema.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

import java.util.Map;

@DisplayName("0.1.0")
public class AnypointMQV0_0_1Test {

    public static AnypointMQChannelBinding channelBinding () {
        return AnypointMQChannelBinding.builder()
                .destination("user-signup-exchg")
                .destinationType(AnypointMQChannelDestinationType.EXCHANGE)
                .build();
    }

    public static AnypointMQMessageBinding messageBinding () {
        return AnypointMQMessageBinding.builder()
                .headers(AsyncAPISchema.builder()
                        .type(Type.OBJECT)
                        .properties(Map.ofEntries(Map.entry(
                                "correlationId",
                                AsyncAPISchema.builder()
                                        .type(Type.STRING)
                                        .description("Correlation ID set by application")
                                        .build()
                        )))
                        .build())
                .build();
    }

    public static AnypointMQOperationBinding operationBinding () {
        return new AnypointMQOperationBinding();
    }

    public static AnypointMQServerBinding serverBinding () {
        return new AnypointMQServerBinding();
    }

    @Nested
    @DisplayName("channel")
    class ChannelTest extends BindingTest<AnypointMQChannelBinding> {{
        super.binding                          = channelBinding();
        super.bindingTypeClass                 = AnypointMQChannelBinding.class;
        super.pathToBindingJson                = "/bindings/anypointmq/0.0.1/channel/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/anypointmq/0.0.1/channel/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/anypointmq/0.0.1/channel/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("message")
    class Message extends BindingTest<AnypointMQMessageBinding> {{
        super.binding                          = messageBinding();
        super.bindingTypeClass                 = AnypointMQMessageBinding.class;
        super.pathToBindingJson                = "/bindings/anypointmq/0.0.1/message/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/anypointmq/0.0.1/message/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/anypointmq/0.0.1/message/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("operation")
    class Operation extends BindingTest<AnypointMQOperationBinding> {{
        super.binding                          = operationBinding();
        super.bindingTypeClass                 = AnypointMQOperationBinding.class;
        super.pathToBindingJson                = "/bindings/anypointmq/0.0.1/operation/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/anypointmq/0.0.1/operation/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/anypointmq/0.0.1/operation/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("server")
    class Server extends BindingTest<AnypointMQServerBinding> {{
        super.binding                          = serverBinding();
        super.bindingTypeClass                 = AnypointMQServerBinding.class;
        super.pathToBindingJson                = "/bindings/anypointmq/0.0.1/server/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/anypointmq/0.0.1/server/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/anypointmq/0.0.1/server/binding - wrongly extended.json";
    }}

}
