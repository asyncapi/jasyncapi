package com.asyncapi.bindings.sqs.v0._2_0.channel;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A definition of a SQS channel queue policy statement effect.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/sqs#channel-binding-object">SQS channel binding</a>
 * @see <a href="https://aws.amazon.com/sqs/">Amazon SQS</a>
 * @author Pavel Bodiachevskii
 * @version 0.2.0
 * @since 1.0.0-RC2
 */
public enum SQSChannelQueuePolicyStatementEffect {

    @JsonProperty("Allow")
    ALLOW,

    @JsonProperty("Deny")
    DENY

}
