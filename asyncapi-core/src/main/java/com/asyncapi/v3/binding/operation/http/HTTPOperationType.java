package com.asyncapi.v3.binding.operation.http;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum HTTPOperationType {

    @JsonProperty("request")
    REQUEST,

    @JsonProperty("response")
    RESPONSE

}
