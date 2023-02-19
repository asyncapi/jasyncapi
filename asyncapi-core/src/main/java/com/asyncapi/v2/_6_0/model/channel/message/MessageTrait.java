package com.asyncapi.v2._6_0.model.channel.message;

import com.asyncapi.v2._6_0.jackson.model.channel.message.MessageCorrelationIdDeserializer;
import com.asyncapi.v2._6_0.jackson.model.channel.message.MessageHeadersDeserializer;
import com.asyncapi.v2._6_0.model.ExternalDocumentation;
import com.asyncapi.v2._6_0.model.Tag;
import com.asyncapi.v2.binding.message.MessageBinding;
import com.asyncapi.v2.jackson.binding.message.MessageBindingsDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.annotation.CheckForNull;
import java.util.List;
import java.util.Map;

/**
 * Describes a trait that MAY be applied to a Message Object({@link com.asyncapi.v2._6_0.model.channel.message.Message}).
 * <br><br>
 * This object MAY contain any property from the Message Object({@link com.asyncapi.v2._6_0.model.channel.message.Message}), except payload and traits.
 * <br><br>
 * If you're looking to apply traits to an operation, see the Operation Trait Object({@link com.asyncapi.v2._6_0.model.channel.operation.OperationTrait}).
 *
 * @version 2.6.0
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0/#messageObject">Message</a>
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0/#messageTraitObject">MessageTrait</a>
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0/#operationTraitObject">OperationTrait</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MessageTrait {

    /**
     * Unique string used to identify the message.
     * <p>
     * The id MUST be unique among all messages described in the API. The messageId value is case-sensitive.
     * Tools and libraries MAY use the messageId to uniquely identify a message, therefore, it is RECOMMENDED to
     * follow common programming naming conventions.
     */
    @CheckForNull
    private String messageId;

    /**
     * Schema definition of the application headers. Schema MUST be of type "object".
     * It MUST NOT define the protocol headers.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2._6_0.model.schema.Schema}</li>
     *     <li>{@link com.asyncapi.v2._6_0.model.Reference}</li>
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = MessageHeadersDeserializer.class)
    private Object headers;

    /**
     * Definition of the correlation ID used for message tracing or matching.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2._6_0.model.channel.message.CorrelationId}</li>
     *     <li>{@link com.asyncapi.v2._6_0.model.Reference}</li>
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = MessageCorrelationIdDeserializer.class)
    private Object correlationId;

    /**
     * A string containing the name of the schema format used to define the message payload.
     * If omitted, implementations should parse the payload as a {@link com.asyncapi.v2._6_0.model.schema.Schema} object. When the payload is defined using a
     * $ref to a remote file, it is RECOMMENDED the schema format includes the file encoding type to allow implementations
     * to parse the file correctly. E.g., adding +yaml if content type is application/vnd.apache.avro results in
     * application/vnd.apache.avro+yaml.
     * <p>
     * Check out the <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0#messageObjectSchemaFormatTable">supported schema formats table</a> for more information.
     * Custom values are allowed but their implementation is OPTIONAL.
     * A custom value MUST NOT refer to one of the schema formats listed in the <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0#messageObjectSchemaFormatTable">table<a/>.
     */
    @CheckForNull
    private String schemaFormat;

    /**
     * The content type to use when encoding/decoding a message's payload. The value MUST be a specific
     * media type (e.g. application/json). When omitted, the value MUST be the one specified on the
     * {@link com.asyncapi.v2._6_0.model.AsyncAPI#getDefaultContentType()} field.
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
     * A verbose explanation of the message. <a href="https://spec.commonmark.org/">CommonMark syntax</a> can be used for rich text representation.
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
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2._6_0.model.Reference}</li>
     *     <li>{@link MessageBinding}</li>
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = MessageBindingsDeserializer.class)
    private Map<String, Object> bindings;

    /**
     * List of examples.
     */
    @CheckForNull
    private List<MessageExample> examples;

}
