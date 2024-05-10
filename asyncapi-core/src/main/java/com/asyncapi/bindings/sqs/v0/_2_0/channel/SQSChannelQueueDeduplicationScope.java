package com.asyncapi.bindings.sqs.v0._2_0.channel;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Specifies whether message deduplication occurs at the message group or queue level.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/sqs#channel-binding-object">SQS channel binding</a>
 * @see <a href="https://aws.amazon.com/sqs/">SQS</a>
 * @author Pavel Bodiachevskii
 * @version 0.2.0
 * @since 1.0.0-RC2
 */
public enum SQSChannelQueueDeduplicationScope {

    @JsonProperty("queue")
    QUEUE,

    @JsonProperty("messageGroup")
    MESSAGE_GROUP

}
