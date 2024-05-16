package com.asyncapi.bindings.sns.v0._1_0.operation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Describes SNS operation consumer redrive policy.
 * <p>
 * Prevent poison pill messages by moving un-processable messages to an SQS dead letter queue.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/sns#operation-binding-object">SNS operation binding</a>
 * @see <a href="https://aws.amazon.com/sns/">Amazon SNS</a>
 * @author Pavel Bodiachevskii
 * @version 0.1.0
 * @since 1.0.0-RC2
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SNSOperationConsumerRedrivePolicy {

    /**
     * The SQS queue to use as a dead letter queue (DLQ).
     */
    @NotNull
    private SNSOperationDestinationIdentifier deadLetterQueue;

    /**
     * The number of times a message is delivered to the source queue before being moved to the dead-letter queue.
     */
    @Nullable
    @Builder.Default
    private Integer maxReceiveCount = 10;

}
