package com.asyncapi.bindings.websockets.v0._1_0.channel;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The HTTP method to use when establishing the connection.
 * <p>
 * Its value <b>MUST</b> be either GET or POST.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/WebSockets_API">MDN WebSockets</a>
 * @author Pavel Bodiachevskii
 * @version 0.1.0
 * @since 1.0.0-RC2
 */
public enum WebSocketsChannelMethod {

    @JsonProperty("GET")
    GET,

    @JsonProperty("POST")
    POST

}
