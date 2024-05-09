package com.asyncapi.bindings.http.v0._3_0.message;

import com.asyncapi.schemas.asyncapi.AsyncAPISchema;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.*;
import org.jetbrains.annotations.Nullable;

/**
 * Describes HTTP message binding.
 * <p>
 * Contains information about the message representation in HTTP.
 *
 * @version 0.3.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/http#message-binding-object">HTTP message binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class HTTPMessageBinding extends com.asyncapi.bindings.http.HTTPMessageBinding {

    /**
     * A Schema object containing the definitions for each query parameter. This schema MUST be of type object
     * and have a properties key.*
     */
    @Nullable
    @JsonProperty("headers")
    @JsonPropertyDescription("A Schema object containing the definitions for each query parameter. This schema MUST be of type object and have a properties key.")
    private AsyncAPISchema headers;

    /**
     * The HTTP response status code according to <a href="https://httpwg.org/specs/rfc9110.html#overview.of.status.codes">RFC 9110</a>.
     * <p>
     * `statusCode` is only relevant for messages referenced by the <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#operationReplyObject">Operation Reply Object</a>,
     * as it defines the status code for the response.
     * <p>
     * In all other cases, this value can be safely ignored.
     */
    @Nullable
    @JsonProperty("statusCode")
    private Integer statusCode;

    @Override
    public String getBindingVersion() {
        return "0.3.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.3.0");
    }

}
