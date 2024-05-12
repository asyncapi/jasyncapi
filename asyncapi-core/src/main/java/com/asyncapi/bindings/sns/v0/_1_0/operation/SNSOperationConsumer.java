package com.asyncapi.bindings.sns.v0._1_0.operation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Describes SNS operation topic consumer.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/sns#operation-binding-object">SNS operation binding</a>
 * @see <a href="https://aws.amazon.com/sns/">SNS</a>
 * @author Pavel Bodiachevskii
 * @version 0.1.0
 * @since 1.0.0-RC2
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SNSOperationConsumer {

    /**
     * The protocol that this endpoint receives messages by.
     */
    @NotNull
    private SNSOperationConsumerProtocol protocol;

    /**
     * The endpoint messages are delivered to.
     */
    @NotNull
    private SNSOperationDestinationIdentifier endpoint;

    /**
     * Only receive a subset of messages from the channel, determined by this policy.
     * <p>
     * Depending on the FilterPolicyScope, a map of either a message attribute or message body to an array of possible matches.
     * <p>
     * The match may be a simple string for an exact match, but it may also be an object that represents a constraint and values for that constraint.
     * <p>
     * Possible variants:
     * <ul>
     *     <li>List&lt;String&gt;</li>
     *     <li>String</li>
     *     <li>Object</li>
     * </ul>
     */
    @Nullable
    private Object filterPolicy;

    /**
     * Determines whether the FilterPolicy applies to MessageAttributes or MessageBody.
     */
    @Nullable
    @Builder.Default
    private SNSOperationConsumerFilterPolicyScope filterPolicyScope = SNSOperationConsumerFilterPolicyScope.MESSAGE_ATTRIBUTES;

    /**
     * If true AWS SNS attributes are removed from the body, and for SQS, SNS message attributes are copied to SQS message attributes.
     * <p>
     * If false the SNS attributes are included in the body.
     */
    @NotNull
    private Boolean rawMessageDelivery;

    /**
     * Prevent poison pill messages by moving un-processable messages to an SQS dead letter queue.
     */
    @Nullable
    private SNSOperationConsumerRedrivePolicy redrivePolicy;

    /**
     * Policy for retries to HTTP. The parameter is for that SNS Subscription and overrides any policy on the SNS Topic.
     */
    @Nullable
    private SNSOperationConsumerDeliveryPolicy deliveryPolicy;

    /**
     * The display name to use with an SNS subscription
     */
    @Nullable
    private String displayName;

}
