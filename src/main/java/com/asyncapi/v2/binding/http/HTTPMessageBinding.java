package com.asyncapi.v2.binding.http;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * This class defines how to describe HTTP message binding.
 *
 * TODO: https://github.com/asyncapi/bindings/issues/19
 *
 * @author Pavel Bodiachevskii
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HTTPMessageBinding {

    /**
     * A Schema object containing the definitions for each query parameter. This schema MUST be of type object
     * and have a properties key.
     *
     * @see <a href="https://www.asyncapi.com/docs/specifications/2.0.0/#schemaObject">Schema object</a>
     */
    @Nullable
    @CheckForNull
    private Object headers;

    /**
     * The version of this binding. If omitted, "latest" MUST be assumed.
     */
    @Nullable
    @CheckForNull
    private String bindingVersion;

}
