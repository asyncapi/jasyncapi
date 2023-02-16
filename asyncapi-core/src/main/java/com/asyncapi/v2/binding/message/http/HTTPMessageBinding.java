package com.asyncapi.v2.binding.message.http;

import com.asyncapi.v2.binding.message.MessageBinding;
import lombok.*;

import javax.annotation.CheckForNull;

/**
 * Describes HTTP message binding.
 * <p>
 * Contains information about the message representation in HTTP.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/http#message-binding-object">HTTP message binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class HTTPMessageBinding extends MessageBinding {

    /**
     * A Schema object containing the definitions for each query parameter. This schema MUST be of type object
     * and have a properties key.
     *
     * @see <a href="https://www.asyncapi.com/docs/specifications/2.0.0/#schemaObject">Schema object</a>
     */
    @CheckForNull
    private Object headers;

    /**
     * The version of this binding. If omitted, "latest" MUST be assumed.
     */
    @CheckForNull
    @Builder.Default
    private String bindingVersion = "0.1.0";

}
