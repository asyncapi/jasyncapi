package com.asyncapi.v2.model.channel.message;

import com.asyncapi.v2.binding.MessageBinding;
import com.asyncapi.v2.binding.MessageBindingsDeserializer;
import com.asyncapi.v2.jackson.MessageTraitCorrelationIdDeserializer;
import com.asyncapi.v2.jackson.MessageTraitHeadersDeserializer;
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
 * Describes a trait that MAY be applied to a Message Object({@link Message}).
 * <br><br>
 * This object MAY contain any property from the Message Object({@link Message}), except payload and traits.
 * <br><br>
 * If you're looking to apply traits to an operation, see the Operation Trait Object({@link com.asyncapi.v2.model.channel.operation.OperationTrait}).
 *
 * @version 2.0.0
 * @see <a href="https://www.asyncapi.com/docs/specifications/2.0.0/#messageObject">Message</a>
 * @see <a href="https://www.asyncapi.com/docs/specifications/2.0.0/#messageTraitObject">MessageTrait</a>
 * @see <a href="https://www.asyncapi.com/docs/specifications/2.0.0/#operationTraitObject">OperationTrait</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageTrait {

    /**
     * Schema definition of the application headers. Schema MUST be of type "object".
     * It MUST NOT define the protocol headers.
     *
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2.model.schema.Schema}</li>
     *     <li>{@link com.asyncapi.v2.model.Reference}</li>
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = MessageTraitHeadersDeserializer.class)
    private Object headers;

    /**
     * Definition of the correlation ID used for message tracing or matching.
     *
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2.model.channel.message.CorrelationId}</li>
     *     <li>{@link com.asyncapi.v2.model.Reference}</li>
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = MessageTraitCorrelationIdDeserializer.class)
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
