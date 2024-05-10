package com.asyncapi.bindings.sqs.v0._2_0.channel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Prevent poison pill messages by moving un-processable messages to an SQS dead letter queue.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/sqs#channel-binding-object">SQS channel binding</a>
 * @see <a href="https://aws.amazon.com/sqs/">SQS</a>
 * @author Pavel Bodiachevskii
 * @version 0.2.0
 * @since 1.0.0-RC2
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SQSChannelRedrivePolicy {

    /**
     * The SQS queue to use as a dead letter queue (DLQ).
     */
    @NotNull
    private SQSChannelDeadLetterQueueIdentifier deadLetterQueue;

    /**
     * The number of times a message is delivered to the source queue before being moved to the dead-letter queue.
     */
    @Nullable
    private Integer maxReceiveCount = 10;

}
