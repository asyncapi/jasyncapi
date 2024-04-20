package com.asyncapi.bindings.websockets.v0._1_0.channel;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The HTTP method to use when establishing the connection.
 * <p>
 * Its value <b>MUST</b> be either GET or POST.
 *
 * @version 0.1.0
 * @author Pavel Bodiachevskii
 */
public enum WebSocketsChannelMethod {

    @JsonProperty("GET")
    GET,

    @JsonProperty("POST")
    POST

}
