package com.asyncapi.bindings.sqs.v0._2_0.channel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

/**
 * A definition of a SQS channel dead letter queue identifier.
 * <p>
 * The SQS queue to use as a dead letter queue (DLQ).
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/sqs#channel-binding-object">SQS channel binding</a>
 * @see <a href="https://aws.amazon.com/sqs/">Amazon SQS</a>
 * @author Pavel Bodiachevskii
 * @version 0.2.0
 * @since 1.0.0-RC2
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SQSChannelDeadLetterQueueIdentifier {

    /**
     * The target is an ARN. For example, for SQS, the identifier may be an ARN,
     * which will be of the form: arn:aws:sqs:{region}:{account-id}:{queueName}
     */
    @Nullable
    private String arn;

    /**
     * The endpoint is identified by a name, which corresponds to an identifying field called <code>name</code>
     * of a binding for that protocol on this publish Operation Object.
     * <p>
     * For example, if the protocol is <code>sqs</code> then the name refers to the name field sqs binding.
     */
    @Nullable
    private String name;

}
