package com.asyncapi.bindings.sns.v0._1_0.channel;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum SNSChannelPolicyStatementEffect {

    @JsonProperty("Allow")
    ALLOW,

    @JsonProperty("Deny")
    DENY

}
