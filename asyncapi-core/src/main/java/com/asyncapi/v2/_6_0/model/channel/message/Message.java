package com.asyncapi.v2._6_0.model.channel.message;

import com.asyncapi.v2._6_0.jackson.binding.message.MessageBindingsDeserializer;
import com.asyncapi.v2._6_0.jackson.model.channel.message.MessageCorrelationIdDeserializer;
import com.asyncapi.v2._6_0.jackson.model.channel.message.MessageHeadersDeserializer;
import com.asyncapi.v2._6_0.jackson.model.channel.message.MessagePayloadDeserializer;
import com.asyncapi.v2._6_0.jackson.model.channel.message.MessageTraitsDeserializer;
import com.asyncapi.v2._6_0.model.ExternalDocumentation;
import com.asyncapi.v2._6_0.model.Tag;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import javax.annotation.CheckForNull;
import java.util.List;
import java.util.Map;

/**
 * Describes a message received on a given channel and operation.
 *
 * @version 2.6.0
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0#messageObject">Message</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Message {

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
     * Definition of the message payload. It can be of any type but defaults to Schema object.
     * It must match the schema format, including encoding type - e.g Avro should be inlined as either a YAML or JSON object
     * NOT a string to be parsed as YAML or JSON.
     * <p>
     * WILL BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2._6_0.model.schema.Schema}</li>
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = MessagePayloadDeserializer.class)
    private Object payload;

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
     *     <li>{@link com.asyncapi.v2._6_0.binding.message.MessageBinding}</li>
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

    /**
     * A list of traits to apply to the message object. Traits MUST be merged into the message object using the
     * <a href="https://tools.ietf.org/html/rfc7386">JSON Merge Patch</a> algorithm in the same order they are defined here.
     * The resulting object MUST be a valid Message Object.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2._6_0.model.Reference}</li>
     *     <li>{@link com.asyncapi.v2._6_0.model.channel.message.MessageTrait}</li>
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = MessageTraitsDeserializer.class)
    private List<Object> traits;

}
