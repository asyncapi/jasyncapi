package com.asyncapi.bindings.sns.v0._1_0.operation;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum SNSOperationConsumerProtocol {

    @JsonProperty("http")
    HTTP,

    @JsonProperty("https")
    HTTPS,

    @JsonProperty("email")
    EMAIL,

    @JsonProperty("email-json")
    EMAIL_JSON,

    @JsonProperty("sms")
    SMS,

    @JsonProperty("sqs")
    SQS,

    @JsonProperty("application")
    APPLICATION,

    @JsonProperty("lambda")
    LAMBDA,

    @JsonProperty("firehose")
    FIREHOSE

}
