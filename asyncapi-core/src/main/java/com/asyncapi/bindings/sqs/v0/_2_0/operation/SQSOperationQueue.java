package com.asyncapi.bindings.sqs.v0._2_0.operation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

/**
 * A definition of a SQS operation queue.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/sqs#operation-binding-object">SQS operation binding</a>
 * @see <a href="https://aws.amazon.com/sqs/">Amazon SQS</a>
 * @author Pavel Bodiachevskii
 * @version 0.2.0
 * @since 1.0.0-RC2
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SQSOperationQueue {

    /**
     * Allows for an external definition of a queue.
     * <p>
     * The referenced structure <b>MUST</b> be in the format of a Queue.
     * <p>
     * If there are conflicts between the referenced definition and this Queue's definition, the behavior is undefined.
     */
    @Nullable
    @JsonProperty("$ref")
    private String ref;

    /**
     * The name of the queue.
     * <p>
     * When an SNS Operation Binding Object references an SQS queue by name, the identifier should be the one in this field.
     */
    @NotNull
    @Builder.Default
    private String name = "";

    /**
     * Is this a FIFO queue?
     */
    @NotNull
    @Builder.Default
    private Boolean fifoQueue = false;

    /**
     * Specifies whether message deduplication occurs at the message group or queue level.
     * <p>
     * Valid values are messageGroup and queue (default).
     */
    @Nullable
    @Builder.Default
    private SQSOperationQueueDeduplicationScope deduplicationScope = SQSOperationQueueDeduplicationScope.QUEUE;

    /**
     * Specifies whether the FIFO queue throughput quota applies to the entire queue or per message group.
     * <p>
     * Valid values are perQueue (default) and perMessageGroupId.
     */
    @Nullable
    @Builder.Default
    private SQSOperationQueueFifoThroughputLimit fifoThroughputLimit = SQSOperationQueueFifoThroughputLimit.PER_QUEUE;

    /**
     * The number of seconds to delay before a message sent to the queue can be received. used to create a delay queue.
     */
    @Nullable
    @Builder.Default
    @javax.validation.constraints.Min(0)
    @javax.validation.constraints.Max(15)
    private Integer deliveryDelay = 0;

    /**
     * The length of time, in seconds, that a consumer locks a message - hiding it from reads - before it is unlocked and can be read again.
     */
    @Nullable
    @Builder.Default
    @javax.validation.constraints.Min(0)
    @javax.validation.constraints.Max(43200)
    private Integer visibilityTimeout = 30;

    /**
     * Determines if the queue uses short polling or long polling.
     * <p>
     * Set to zero the queue reads available messages and returns immediately.
     * <p>
     * Set to a non-zero integer, long polling waits the specified number of seconds for messages to arrive before returning.
     */
    @Nullable
    @Builder.Default
    private Integer receiveMessageWaitTime = 0;

    /**
     * How long to retain a message on the queue in seconds, unless deleted.
     */
    @Nullable
    @Builder.Default
    @javax.validation.constraints.Min(60)
    @javax.validation.constraints.Max(1209600)
    private Integer messageRetentionPeriod = 345600;

    /**
     * Prevent poison pill messages by moving un-processable messages to an SQS dead letter queue.
     */
    @Nullable
    private SQSOperationRedrivePolicy redrivePolicy;

    /**
     * The security policy for the SQS Queue.
     */
    @Nullable
    private SQSOperationQueuePolicy policy;

    /**
     * Key-value pairs that represent AWS tags on the queue.
     */
    @Nullable
    private Map<String, Object> tags;

}
