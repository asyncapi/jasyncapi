package com.asyncapi.bindings.sns.v0._1_0.channel;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The security policy effect for the SNS Topic.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/sns#channel-binding-object">SNS channel binding</a>
 * @see <a href="https://aws.amazon.com/sns/">Amazon SNS</a>
 * @author Pavel Bodiachevskii
 * @version 0.1.0
 * @since 1.0.0-RC2
 */
public enum SNSChannelPolicyStatementEffect {

    @JsonProperty("Allow")
    ALLOW,

    @JsonProperty("Deny")
    DENY

}
