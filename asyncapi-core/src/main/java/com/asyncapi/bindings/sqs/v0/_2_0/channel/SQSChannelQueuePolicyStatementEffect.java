package com.asyncapi.bindings.sqs.v0._2_0.channel;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum SQSChannelQueuePolicyStatementEffect {

    @JsonProperty("Allow")
    ALLOW,

    @JsonProperty("Deny")
    DENY

}
