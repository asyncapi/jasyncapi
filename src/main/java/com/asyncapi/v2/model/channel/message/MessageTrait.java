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
 * Describes a trait that MAY be applied to a Message Object. This object MAY contain any property from the Message Object, except payload and traits.
 *
 * If you're looking to apply traits to an operation, see the Operation Trait Object.
 *
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageTrait {

    /**
     * TODO: Придумать как ограничить только: Schema Object | Reference Object
     * Schema definition of the application headers. Schema MUST be of type "object".
     * It MUST NOT define the protocol headers.
     */
    @CheckForNull
    private Object headers;

    /**
     * TODO: Придумать как ограничить только: Correlation ID Object | Reference Object
     * Definition of the correlation ID used for message tracing or matching.
     */
    @CheckForNull
    private Object correlationId;

    /**
     * TODO: clarify
     * A string containing the name of the schema format used to define the message payload. If omitted,
     * implementations should parse the payload as a Schema object. Check out the supported schema formats
     * table for more information. Custom values are allowed but their implementation is OPTIONAL. A custom
     * value MUST NOT refer to one of the schema formats listed in the table.
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
     * A map where the keys describe the name of the protocol and the values describe protocol-specific definitions for the message.
     */
    @CheckForNull
    @JsonDeserialize(using = MessageBindingsDeserializer.class)
    private Map<String, ? extends MessageBinding> bindings;

    /**
     * An array with examples of valid message objects.
     */
    @CheckForNull
    private List<Map<String, Object>> examples;

}
