package com.asyncapi.bindings.sqs;

import com.asyncapi.bindings.BindingTest;
import com.asyncapi.bindings.sqs.v0._2_0.channel.SQSChannelBinding;
import com.asyncapi.bindings.sqs.v0._2_0.channel.*;
import com.asyncapi.bindings.sqs.v0._2_0.message.SQSMessageBinding;
import com.asyncapi.bindings.sqs.v0._2_0.operation.SQSOperationBinding;
import com.asyncapi.bindings.sqs.v0._2_0.operation.*;
import com.asyncapi.bindings.sqs.v0._2_0.server.SQSServerBinding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

import java.util.LinkedHashMap;
import java.util.List;

@DisplayName("0.2.0")
public class SQSV0_2_0Test {

    public static SQSChannelBinding channelBinding () {
        var tags = new LinkedHashMap<String, Object>();
        tags.put("owner", "AsyncAPI.NET");
        tags.put("platform", "AsyncAPIOrg");

        return SQSChannelBinding.builder()
                .queue(SQSChannelQueue.builder()
                        .name("myQueue")
                        .fifoQueue(true)
                        .deduplicationScope(SQSChannelQueueDeduplicationScope.MESSAGE_GROUP)
                        .fifoThroughputLimit(SQSChannelQueueFifoThroughputLimit.PER_MESSAGE_GROUP_ID)
                        .deliveryDelay(15)
                        .visibilityTimeout(60)
                        .receiveMessageWaitTime(0)
                        .messageRetentionPeriod(86400)
                        .redrivePolicy(SQSChannelRedrivePolicy.builder()
                                .deadLetterQueue(new SQSChannelDeadLetterQueueIdentifier(
                                        "arn:aws:SQS:eu-west-1:0000000:123456789", null
                                ))
                                .maxReceiveCount(15)
                                .build()
                        )
                        .policy(SQSChannelQueuePolicy.builder()
                                .statements(List.of(
                                        SQSChannelQueuePolicyStatement.builder()
                                                .effect(SQSChannelQueuePolicyStatementEffect.DENY)
                                                .principal("arn:aws:iam::123456789012:user/dec.kolakowski")
                                                .action(List.of(
                                                        "sqs:SendMessage",
                                                        "sqs:ReceiveMessage"
                                                ))
                                                .build()
                                ))
                                .build()
                        )
                        .tags(tags)
                        .build()
                )
                .deadLetterQueue(SQSChannelQueue.builder()
                        .name("myQueue_error")
                        .deliveryDelay(0)
                        .visibilityTimeout(0)
                        .receiveMessageWaitTime(0)
                        .messageRetentionPeriod(604800)
                        .build()
                )
                .build();
    }

    public static SQSMessageBinding messageBinding () {
        return new SQSMessageBinding();
    }

    public static SQSOperationBinding operationBinding () {
        return SQSOperationBinding.builder()
                .queues(List.of(
                        SQSOperationQueue.builder()
                                .name("myQueue")
                                .fifoQueue(true)
                                .deduplicationScope(SQSOperationQueueDeduplicationScope.MESSAGE_GROUP)
                                .fifoThroughputLimit(SQSOperationQueueFifoThroughputLimit.PER_MESSAGE_GROUP_ID)
                                .deliveryDelay(10)
                                .redrivePolicy(SQSOperationRedrivePolicy.builder()
                                        .deadLetterQueue(new SQSOperationDeadLetterQueueIdentifier(
                                                null,
                                                "myQueue_error"
                                        ))
                                        .maxReceiveCount(15)
                                        .build()
                                )
                                .policy(SQSOperationQueuePolicy.builder()
                                        .statements(List.of(
                                                SQSOperationQueuePolicyStatement.builder()
                                                        .effect(SQSOperationQueuePolicyStatementEffect.DENY)
                                                        .principal("arn:aws:iam::123456789012:user/dec.kolakowski")
                                                        .action(List.of(
                                                                "sqs:SendMessage",
                                                                "sqs:ReceiveMessage"
                                                        ))
                                                        .build()
                                        ))
                                        .build()
                                )
                                .build(),
                        SQSOperationQueue.builder()
                                .name("myQueue_error")
                                .deliveryDelay(10)
                                .build()
                ))
                .build();
    }

    public static SQSServerBinding serverBinding () {
        return new SQSServerBinding();
    }

    @Nested
    @DisplayName("channel")
    class ChannelTest extends BindingTest<SQSChannelBinding> {{
        super.binding                          = channelBinding();
        super.bindingTypeClass                 = SQSChannelBinding.class;
        super.pathToBindingJson                = "/bindings/sqs/0.2.0/channel/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/sqs/0.2.0/channel/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/sqs/0.2.0/channel/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("message")
    class Message extends BindingTest<SQSMessageBinding> {{
        super.binding                          = messageBinding();
        super.bindingTypeClass                 = SQSMessageBinding.class;
        super.pathToBindingJson                = "/bindings/sqs/0.2.0/message/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/sqs/0.2.0/message/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/sqs/0.2.0/message/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("operation")
    class Operation extends BindingTest<SQSOperationBinding> {{
        super.binding                          = operationBinding();
        super.bindingTypeClass                 = SQSOperationBinding.class;
        super.pathToBindingJson                = "/bindings/sqs/0.2.0/operation/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/sqs/0.2.0/operation/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/sqs/0.2.0/operation/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("server")
    class Server extends BindingTest<SQSServerBinding> {{
        super.binding                          = serverBinding();
        super.bindingTypeClass                 = SQSServerBinding.class;
        super.pathToBindingJson                = "/bindings/sqs/0.2.0/server/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/sqs/0.2.0/server/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/sqs/0.2.0/server/binding - wrongly extended.json";
    }}

}
