package com.asyncapi.bindings.sqs.v0._2_0.operation;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Specifies whether message deduplication occurs at the message group or queue level.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/sqs#operation-binding-object">SQS operation binding</a>
 * @see <a href="https://aws.amazon.com/sqs/">Amazon SQS</a>
 * @author Pavel Bodiachevskii
 * @version 0.2.0
 * @since 1.0.0-RC2
 */
public enum SQSOperationQueueDeduplicationScope {

    @JsonProperty("queue")
    QUEUE,

    @JsonProperty("messageGroup")
    MESSAGE_GROUP

}
