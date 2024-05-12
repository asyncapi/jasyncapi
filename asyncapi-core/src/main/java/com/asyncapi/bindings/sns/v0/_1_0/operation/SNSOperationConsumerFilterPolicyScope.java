package com.asyncapi.bindings.sns.v0._1_0.operation;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum SNSOperationConsumerFilterPolicyScope {

    @JsonProperty("MessageAttributes")
    MESSAGE_ATTRIBUTES,

    @JsonProperty("MessageBody")
    MESSAGE_BODY

}
