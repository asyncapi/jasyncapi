package com.asyncapi.v3.binding.operation.http;

import com.asyncapi.v3.schema.AsyncAPISchema;
import com.asyncapi.bindings.OperationBinding;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Describes HTTP operation binding.
 * <p>
 * Contains information about the operation representation in HTTP.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/http#operation-binding-object">HTTP operation binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class HTTPOperationBinding extends OperationBinding {

    /**
     * Required.
     * <p>
     * Type of operation. Its value MUST be either request or response.
     */
    @NotNull
    @Builder.Default
    @javax.validation.constraints.NotNull
    @JsonProperty(value = "type", required = true)
    @JsonPropertyDescription("Type of operation. Its value MUST be either request or response.")
    private HTTPOperationType type = HTTPOperationType.REQUEST;

    /**
     * When type is request, this is the HTTP method, otherwise it MUST be ignored. Its value MUST be one of
     * GET, POST, PUT, PATCH, DELETE, HEAD, OPTIONS, CONNECT, and TRACE.
     */
    @Nullable
    @JsonProperty("method")
    @JsonPropertyDescription("When type is request, this is the HTTP method, otherwise it MUST be ignored. Its value MUST be one of GET, POST, PUT, PATCH, DELETE, HEAD, OPTIONS, CONNECT, and TRACE.")
    private HTTPOperationMethod method;

    /**
     * A Schema object containing the definitions for each query parameter. This schema MUST be of type object
     * and have a properties key.
     */
    @Nullable
    @JsonProperty("query")
    @JsonPropertyDescription("A Schema object containing the definitions for each query parameter. This schema MUST be of type object and have a properties key.")
    private AsyncAPISchema query;

    /**
     * The version of this binding. If omitted, "latest" MUST be assumed.
     */
    @Nullable
    @Builder.Default
    @JsonProperty("bindingVersion")
    @JsonPropertyDescription("The version of this binding.")
    private String bindingVersion = "0.1.0";

}
