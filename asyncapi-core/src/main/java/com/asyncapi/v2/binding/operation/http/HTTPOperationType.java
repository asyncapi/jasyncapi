package com.asyncapi.v2.binding.operation.http;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum HTTPOperationType {

    @JsonProperty("request")
    REQUEST,

    @JsonProperty("response")
    RESPONSE

}
