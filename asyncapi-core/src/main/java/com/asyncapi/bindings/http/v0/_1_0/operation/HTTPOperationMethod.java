package com.asyncapi.bindings.http.v0._1_0.operation;

/**
 * Describes HTTP operation type.
 * <p>
 * Contains information about the operation type.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/http#operation-binding-object">HTTP operation binding</a>
 * @author Pavel Bodiachevskii
 */
public enum HTTPOperationMethod {
    GET,
    PUT,
    POST,
    PATCH,
    DELETE,
    HEAD,
    OPTIONS,
    CONNECT,
    TRACE
}
