package com.asyncapi.v2._6_0.binding.operation.http;

import com.asyncapi.v2._6_0.binding.operation.OperationBinding;
import lombok.*;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

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
    @Nonnull
    private String type;

    /**
     * When type is request, this is the HTTP method, otherwise it MUST be ignored. Its value MUST be one of
     * GET, POST, PUT, PATCH, DELETE, HEAD, OPTIONS, CONNECT, and TRACE.
     */
    @CheckForNull
    private String method;

    /**
     * A Schema object containing the definitions for each query parameter. This schema MUST be of type object
     * and have a properties key.
     *
     * @see <a href="https://www.asyncapi.com/docs/specifications/2.0.0/#schemaObject">Schema object</a>
     */
    @CheckForNull
    private Object query;

    /**
     * The version of this binding. If omitted, "latest" MUST be assumed.
     */
    @CheckForNull
    @Builder.Default
    private String bindingVersion = "0.1.0";

}
