package com.asyncapi.bindings.http;

import com.asyncapi.bindings.OperationBinding;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;

/**
 * Contains information about the operation representation in HTTP.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/http#operation-binding-object">HTTP operation binding</a>
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Overview">MDN HTTP overview</a>
 * @author Pavel Bodiachevskii
 * @since 1.0.0-RC2
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        defaultImpl = com.asyncapi.bindings.http.v0._3_0.operation.HTTPOperationBinding.class,
        property = "bindingVersion",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = com.asyncapi.bindings.http.v0._1_0.operation.HTTPOperationBinding.class, names = "0.1.0"),
        @JsonSubTypes.Type(value = com.asyncapi.bindings.http.v0._2_0.operation.HTTPOperationBinding.class, names = "0.2.0"),
        @JsonSubTypes.Type(value = com.asyncapi.bindings.http.v0._3_0.operation.HTTPOperationBinding.class, names = {
                "0.3.0",
                "latest"
        }),
})
@EqualsAndHashCode(callSuper = true)
public abstract class HTTPOperationBinding extends OperationBinding {}