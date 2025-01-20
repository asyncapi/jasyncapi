package com.asyncapi.bindings.http.v0._1_0.operation;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes HTTP operation type.
 * <p>
 * Contains information about the operation type.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/http#operation-binding-object">HTTP operation binding</a>
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Overview">MDN HTTP overview</a>
 * @author Pavel Bodiachevskii
 * @version 0.1.0
 * @since 1.0.0-RC2
 */
public enum HTTPOperationType {

    @JsonProperty("request")
    REQUEST,

    @JsonProperty("response")
    RESPONSE

}
