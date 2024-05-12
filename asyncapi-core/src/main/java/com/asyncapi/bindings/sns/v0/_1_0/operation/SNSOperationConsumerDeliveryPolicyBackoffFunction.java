package com.asyncapi.bindings.sns.v0._1_0.operation;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum SNSOperationConsumerDeliveryPolicyBackoffFunction {

    @JsonProperty("arithmetic")
    ARITHMETIC,

    @JsonProperty("exponential")
    EXPONENTIAL,

    @JsonProperty("geometric")
    GEOMETRIC,

    @JsonProperty("linear")
    LINEAR

}
