package com.asyncapi.bindings.sns.v0._1_0.operation;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes SNS consumer protocol.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/sns#operation-binding-object">SNS operation binding</a>
 * @see <a href="https://aws.amazon.com/sns/">Amazon SNS</a>
 * @author Pavel Bodiachevskii
 * @version 0.1.0
 * @since 1.0.0-RC2
 */
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
