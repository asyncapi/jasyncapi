package com.asyncapi.v2.model.schema;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum  Type {

    @JsonProperty("null")
    NULL,
    @JsonProperty("boolean")
    BOOLEAN,
    @JsonProperty("object")
    OBJECT,
    @JsonProperty("array")
    ARRAY,
    @JsonProperty("number")
    NUMBER,
    @JsonProperty("string")
    STRING,
    @JsonProperty("integer")
    INTEGER

}
