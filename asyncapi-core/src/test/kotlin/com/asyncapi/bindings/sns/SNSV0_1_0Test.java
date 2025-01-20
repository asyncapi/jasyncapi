package com.asyncapi.bindings.sns;

import com.asyncapi.bindings.BindingTest;
import com.asyncapi.bindings.sns.v0._1_0.channel.SNSChannelBinding;
import com.asyncapi.bindings.sns.v0._1_0.channel.SNSChannelPolicy;
import com.asyncapi.bindings.sns.v0._1_0.channel.SNSChannelPolicyStatement;
import com.asyncapi.bindings.sns.v0._1_0.channel.SNSChannelPolicyStatementEffect;
import com.asyncapi.bindings.sns.v0._1_0.message.SNSMessageBinding;
import com.asyncapi.bindings.sns.v0._1_0.operation.SNSOperationBinding;
import com.asyncapi.bindings.sns.v0._1_0.operation.*;
import com.asyncapi.bindings.sns.v0._1_0.server.SNSServerBinding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@DisplayName("0.1.0")
public class SNSV0_1_0Test {

    public static SNSChannelBinding channelBinding () {
        return SNSChannelBinding.builder()
                .name("my-sns-topic")
                .policy(SNSChannelPolicy.builder()
                        .statements(List.of(SNSChannelPolicyStatement.builder()
                                        .effect(SNSChannelPolicyStatementEffect.ALLOW)
                                        .principal("*")
                                        .action("SNS:Publish")
                                .build()
                        ))
                        .build()
                )
                .build();
    }

    public static SNSMessageBinding messageBinding () {
        return new SNSMessageBinding();
    }

    public static SNSOperationBinding operationBinding () {
        var filterPolicy = new LinkedHashMap<String, Object>();
        filterPolicy.put("store", List.of("asyncapi_corp"));
        filterPolicy.put("event", List.of(Map.ofEntries(Map.entry("anything-but", "order_cancelled"))));
        filterPolicy.put("customer_interests", List.of("rugby", "football", "baseball"));

        return SNSOperationBinding.builder()
                .topic(SNSOperationDestinationIdentifier.builder()
                        .name("someTopic")
                        .build()
                )
                .consumers(List.of(
                        SNSOperationConsumer.builder()
                                .protocol(SNSOperationConsumerProtocol.SQS)
                                .endpoint(SNSOperationDestinationIdentifier.builder()
                                        .name("someQueue")
                                        .build()
                                )
                                .filterPolicy(filterPolicy)
                                .filterPolicyScope(SNSOperationConsumerFilterPolicyScope.MESSAGE_ATTRIBUTES)
                                .rawMessageDelivery(false)
                                .redrivePolicy(SNSOperationConsumerRedrivePolicy.builder()
                                        .deadLetterQueue(SNSOperationDestinationIdentifier.builder()
                                                .arn("arn:aws:SQS:eu-west-1:0000000:123456789")
                                                .build()
                                        )
                                        .maxReceiveCount(25)
                                        .build()
                                )
                                .deliveryPolicy(SNSOperationConsumerDeliveryPolicy.builder()
                                        .minDelayTarget(10)
                                        .maxDelayTarget(100)
                                        .numRetries(5)
                                        .numNoDelayRetries(2)
                                        .numMinDelayRetries(3)
                                        .numMaxDelayRetries(5)
                                        .backoffFunction(SNSOperationConsumerDeliveryPolicyBackoffFunction.LINEAR)
                                        .maxReceivesPerSecond(2)
                                        .build()
                                )
                                .build()
                ))
                .build();
    }

    public static SNSServerBinding serverBinding () {
        return new SNSServerBinding();
    }

    @Nested
    @DisplayName("channel")
    class ChannelTest extends BindingTest<SNSChannelBinding> {{
        super.binding                          = channelBinding();
        super.bindingTypeClass                 = SNSChannelBinding.class;
        super.pathToBindingJson                = "/bindings/sns/0.1.0/channel/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/sns/0.1.0/channel/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/sns/0.1.0/channel/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("message")
    class Message extends BindingTest<SNSMessageBinding> {{
        super.binding                          = messageBinding();
        super.bindingTypeClass                 = SNSMessageBinding.class;
        super.pathToBindingJson                = "/bindings/sns/0.1.0/message/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/sns/0.1.0/message/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/sns/0.1.0/message/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("operation")
    class Operation extends BindingTest<SNSOperationBinding> {{
        super.binding                          = operationBinding();
        super.bindingTypeClass                 = SNSOperationBinding.class;
        super.pathToBindingJson                = "/bindings/sns/0.1.0/operation/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/sns/0.1.0/operation/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/sns/0.1.0/operation/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("server")
    class Server extends BindingTest<SNSServerBinding> {{
        super.binding                          = serverBinding();
        super.bindingTypeClass                 = SNSServerBinding.class;
        super.pathToBindingJson                = "/bindings/sns/0.1.0/server/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/sns/0.1.0/server/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/sns/0.1.0/server/binding - wrongly extended.json";
    }}

}
