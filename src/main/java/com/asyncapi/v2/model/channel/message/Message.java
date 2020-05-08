package com.asyncapi.v2.model.channel.message;

import com.asyncapi.v2.binding.MessageBinding;
import com.asyncapi.v2.binding.MessageBindingsDeserializer;
import com.asyncapi.v2.model.ExternalDocumentation;
import com.asyncapi.v2.model.Tag;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.CheckForNull;
import java.util.List;
import java.util.Map;

/**
 * Describes a message received on a given channel and operation.
 *
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message <HeadersType, CorrelationIdType> {

    /**
     * Schema definition of the application headers. Schema MUST be of type "object".
     * It MUST NOT define the protocol headers.
     *
     * MUST BE Schema Object | Reference Object
     */
    @CheckForNull
    private HeadersType headers;

    /**
     * TODO: Убедиться что верный тип для любого содержимого
     * Definition of the message payload. It can be of any type but defaults to Schema object.
     */
    @CheckForNull
    private Object payload;

    /**
     * Definition of the correlation ID used for message tracing or matching.
     *
     * MUST BE Correlation ID Object | Reference Object
     */
    @CheckForNull
    private CorrelationIdType correlationId;

    /**
     * TODO: clarify
     * A string containing the name of the schema format used to define the message payload. If omitted,
     * implementations should parse the payload as a Schema object. Check out the supported schema formats
     * table for more information. Custom values are allowed but their implementation is OPTIONAL.
     *
     * A custom value MUST NOT refer to one of the schema formats listed in the table.
     */
    @CheckForNull
    private String schemaFormat;

    /**
     * The content type to use when encoding/decoding a message's payload. The value MUST be a specific
     * media type (e.g. application/json). When omitted, the value MUST be the one specified on the
     * defaultContentType field.
     */
    @CheckForNull
    private String contentType;

    /**
     * A machine-friendly name for the message.
     */
    @CheckForNull
    private String name;

    /**
     * A human-friendly title for the message.
     */
    @CheckForNull
    private String title;

    /**
     * A short summary of what the message is about.
     */
    @CheckForNull
    private String summary;

    /**
     * A verbose explanation of the message. CommonMark syntax can be used for rich text representation.
     */
    @CheckForNull
    private String description;

    /**
     * A list of tags for API documentation control. Tags can be used for logical grouping of messages.
     */
    @CheckForNull
    private List<Tag> tags;

    /**
     * Additional external documentation for this message.
     */
    @CheckForNull
    private ExternalDocumentation externalDocs;

    /**
     * A map where the keys describe the name of the protocol and the values describe protocol-specific definitions
     * for the message.
     */
    @CheckForNull
    @JsonDeserialize(using = MessageBindingsDeserializer.class)
    private Map<String, ? extends MessageBinding> bindings;

    /**
     * An array with examples of valid message objects.
     */
    @CheckForNull
    private List<Map<String, Object>> examples;

    /**
     * A list of traits to apply to the message object. Traits MUST be merged into the message object using the JSON
     * Merge Patch algorithm in the same order they are defined here. The resulting object MUST be a valid Message
     *
     * TODO: reference or MessageTrait
     * Object.
     */
    @CheckForNull
    private List<Object> traits;

}
