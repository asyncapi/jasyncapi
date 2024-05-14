package com.asyncapi.bindings.sqs.v0._2_0.operation;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Specifies whether the FIFO queue throughput quota applies to the entire queue or per message group.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/sqs#operation-binding-object">SQS operation binding</a>
 * @see <a href="https://aws.amazon.com/sqs/">Amazon SQS</a>
 * @author Pavel Bodiachevskii
 * @version 0.2.0
 * @since 1.0.0-RC2
 */
public enum SQSOperationQueueFifoThroughputLimit {

    @JsonProperty("perQueue")
    PER_QUEUE,

    @JsonProperty("perMessageGroupId")
    PER_MESSAGE_GROUP_ID

}
