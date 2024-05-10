package com.asyncapi.bindings.sqs.v0._2_0.channel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

/**
 * A definition of a SQS channel queue policy statement.
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
public class SQSChannelQueuePolicyStatement {

    /**
     * The SQS rule to allow or deny actions.
     */
    @NotNull
    private SQSChannelQueuePolicyStatementEffect effect;

    /**
     * The AWS account or resource ARN that this statement applies to.
     */
    @NotNull
    private Object principal;

    /**
     * The SQS permission being allowed or denied e.g. sqs:ReceiveMessage.
     */
    @NotNull
    private Object action;

}
