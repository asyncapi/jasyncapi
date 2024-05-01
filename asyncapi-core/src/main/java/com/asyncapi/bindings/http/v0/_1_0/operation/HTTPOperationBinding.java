package com.asyncapi.bindings.http.v0._1_0.operation;

import com.asyncapi.schemas.AsyncAPISchema;
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
public class HTTPOperationBinding extends com.asyncapi.bindings.http.HTTPOperationBinding {

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

    @Override
    public String getBindingVersion() {
        return "0.1.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.1.0");
    }

}
