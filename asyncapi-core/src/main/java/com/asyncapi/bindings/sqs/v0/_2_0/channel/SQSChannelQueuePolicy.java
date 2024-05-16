package com.asyncapi.bindings.sqs.v0._2_0.channel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * A definition of a SQS channel queue policy.
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
public class SQSChannelQueuePolicy {

    /**
     * An array of statement objects, each of which controls a permission for this queue.
     */
    @NotNull
    private List<@NotNull SQSChannelQueuePolicyStatement> statements;

}
