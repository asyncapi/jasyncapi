package com.asyncapi.bindings.amqp;

import com.asyncapi.bindings.BindingTest;
import com.asyncapi.bindings.amqp.v0._1_0.channel.AMQPChannelBinding;
import com.asyncapi.bindings.amqp.v0._1_0.channel.AMQPChannelType;
import com.asyncapi.bindings.amqp.v0._1_0.channel.exchange.AMQPChannelExchangeProperties;
import com.asyncapi.bindings.amqp.v0._1_0.channel.exchange.AMQPChannelExchangeType;
import com.asyncapi.bindings.amqp.v0._1_0.channel.queue.AMQPChannelQueueProperties;
import com.asyncapi.bindings.amqp.v0._1_0.message.AMQPMessageBinding;
import com.asyncapi.bindings.amqp.v0._1_0.operation.AMQPOperationBinding;
import com.asyncapi.bindings.amqp.v0._1_0.server.AMQPServerBinding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

import java.util.List;

@DisplayName("0.1.0")
public class AMQPV0_1_0Test {

    public static AMQPChannelBinding channelBinding () {
        return AMQPChannelBinding.builder()
                .is(AMQPChannelType.ROUTING_KEY)
                .queue(AMQPChannelQueueProperties.builder()
                        .name("my-queue-name")
                        .durable(true)
                        .exclusive(true)
                        .autoDelete(false)
                        .build()
                )
                .exchange(AMQPChannelExchangeProperties.builder()
                        .name("myExchange")
                        .type(AMQPChannelExchangeType.TOPIC)
                        .durable(true)
                        .autoDelete(false)
                        .build()
                )
                .build();
    }

    public static AMQPMessageBinding messageBinding () {
        return AMQPMessageBinding.builder()
                .contentEncoding("gzip")
                .messageType("user.signup")
                .build();
    }

    public static AMQPOperationBinding operationBinding () {
        return AMQPOperationBinding.builder()
                .expiration(100_000)
                .userId("guest")
                .cc(List.of("user.logs"))
                .priority(10)
                .deliveryMode(2)
                .mandatory(false)
                .bcc(List.of("external.audit"))
                .replyTo("user.signedup")
                .timestamp(true)
                .ack(false)
                .build();
    }

    public static AMQPServerBinding serverBinding () {
        return new AMQPServerBinding();
    }

    @Nested
    @DisplayName("channel")
    class ChannelTest extends BindingTest<AMQPChannelBinding> {{
        super.binding                          = channelBinding();
        super.bindingTypeClass                 = AMQPChannelBinding.class;
        super.pathToBindingJson                = "/bindings/amqp/0.1.0/channel/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/amqp/0.1.0/channel/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/amqp/0.1.0/channel/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("message")
    class Message extends BindingTest<AMQPMessageBinding> {{
        super.binding                          = messageBinding();
        super.bindingTypeClass                 = AMQPMessageBinding.class;
        super.pathToBindingJson                = "/bindings/amqp/0.1.0/message/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/amqp/0.1.0/message/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/amqp/0.1.0/message/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("operation")
    class Operation extends BindingTest<AMQPOperationBinding> {{
        super.binding                          = operationBinding();
        super.bindingTypeClass                 = AMQPOperationBinding.class;
        super.pathToBindingJson                = "/bindings/amqp/0.1.0/operation/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/amqp/0.1.0/operation/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/amqp/0.1.0/operation/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("server")
    class Server extends BindingTest<AMQPServerBinding> {{
        super.binding                          = serverBinding();
        super.bindingTypeClass                 = AMQPServerBinding.class;
        super.pathToBindingJson                = "/bindings/amqp/0.1.0/server/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/amqp/0.1.0/server/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/amqp/0.1.0/server/binding - wrongly extended.json";
    }}

}
