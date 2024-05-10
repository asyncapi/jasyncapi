package com.asyncapi.bindings.sqs.v0._2_0.operation;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum SQSOperationQueuePolicyStatementEffect {

    @JsonProperty("Allow")
    ALLOW,

    @JsonProperty("Deny")
    DENY

}
