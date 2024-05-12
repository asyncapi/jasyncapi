package com.asyncapi.bindings.sns.v0._1_0.operation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

/**
 * Describes SNS operation delivery policy.
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
public class SNSOperationConsumerDeliveryPolicy {

    /**
     * The minimum delay for a retry in seconds.
     */
    @Nullable
    private Integer minDelayTarget;

    /**
     * The maximum delay for a retry in seconds.
     */
    @Nullable
    private Integer maxDelayTarget;

    /**
     * The total number of retries, including immediate, pre-backoff, backoff, and post-backoff retries.
     */
    @Nullable
    private Integer numRetries;

    /**
     * The number of immediate retries (with no delay).
     */
    @Nullable
    private Integer numNoDelayRetries;

    /**
     * The number of immediate retries (with delay).
     */
    @Nullable
    private Integer numMinDelayRetries;

    /**
     * The number of post-backoff phase retries, with the maximum delay between retries.
     */
    @Nullable
    private Integer numMaxDelayRetries;

    /**
     * The algorithm for backoff between retries.
     */
    @Nullable
    private SNSOperationConsumerDeliveryPolicyBackoffFunction backoffFunction;

    /**
     * The maximum number of deliveries per second, per subscription.
     */
    @Nullable
    private Integer maxReceivesPerSecond;

}
