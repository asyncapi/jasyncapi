package com.asyncapi.v2.binding.channel.ws;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum WebSocketsChannelMethod {

    @JsonProperty("GET")
    GET,

    @JsonProperty("POST")
    POST

}
