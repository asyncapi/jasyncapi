package com.asyncapi.bindings.http;

import com.asyncapi.bindings.ServerBinding;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;

/**
 * Describes HTTP server binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/http#server-binding-object">HTTP server binding</a>
 * @author Pavel Bodiachevskii
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        defaultImpl = com.asyncapi.bindings.http.v0._3_0.server.HTTPServerBinding.class,
        property = "bindingVersion",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = com.asyncapi.bindings.http.v0._1_0.server.HTTPServerBinding.class, names = "0.1.0"),
        @JsonSubTypes.Type(value = com.asyncapi.bindings.http.v0._2_0.server.HTTPServerBinding.class, names = "0.2.0"),
        @JsonSubTypes.Type(value = com.asyncapi.bindings.http.v0._3_0.server.HTTPServerBinding.class, names = {
                "0.3.0",
                "latest"
        }),
})
@EqualsAndHashCode(callSuper = true)
public abstract class HTTPServerBinding extends ServerBinding {}