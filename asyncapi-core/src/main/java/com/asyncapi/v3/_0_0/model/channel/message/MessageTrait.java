package com.asyncapi.v3._0_0.model.channel.message;

import com.asyncapi.v3.ExtendableObject;
import com.asyncapi.v3.Reference;
import com.asyncapi.v3._0_0.jackson.model.ExternalDocumentationDeserializer;
import com.asyncapi.v3._0_0.jackson.model.TagsDeserializer;
import com.asyncapi.v3._0_0.jackson.model.channel.message.MessageCorrelationIdDeserializer;
import com.asyncapi.v3._0_0.jackson.model.channel.message.MessageHeadersDeserializer;
import com.asyncapi.v3._0_0.model.ExternalDocumentation;
import com.asyncapi.v3._0_0.model.Tag;
import com.asyncapi.v3.binding.message.MessageBinding;
import com.asyncapi.v3.jackson.binding.message.MessageBindingsDeserializer;
import com.asyncapi.v3.schema.MultiFormatSchema;
import com.asyncapi.v3.schema.Schema;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

/**
 * Describes a message received on a given channel and operation.
 *
 * @version 3.0.0
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0#messageObject">Message</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MessageTrait extends ExtendableObject {

    /**
     * Unique string used to identify the message.
     * <p>
     * The id MUST be unique among all messages described in the API. The messageId value is case-sensitive.
     * Tools and libraries MAY use the messageId to uniquely identify a message, therefore, it is RECOMMENDED to
     * follow common programming naming conventions.
     */
    @Nullable
    private String messageId;

    /**
     * Schema definition of the application headers.
     * <p>
     * Schema MUST be a map of key-value pairs.
     * <p>
     * It MUST NOT define the protocol headers.
     * <p>
     * If this is a Schema Object, then the schemaFormat will be assumed to
     * be "application/vnd.aai.asyncapi+json;version=asyncapi" where the version
     * is equal to the AsyncAPI Version String.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link Reference}</li>
     *     <li>{@link Schema}</li>
     *     <li>{@link MultiFormatSchema}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = MessageHeadersDeserializer.class)
    private Object headers;

    /**
     * Definition of the correlation ID used for message tracing or matching.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link Reference}</li>
     *     <li>{@link CorrelationId}</li>
     * </ul>
     */
    @JsonDeserialize(using = MessageCorrelationIdDeserializer.class)
    private Object correlationId;

    /**
     * The content type to use when encoding/decoding a message's payload. The value MUST be a specific media type
     * (e.g. application/json). When omitted, the value MUST be the one specified on the defaultContentType field.
     */
    @Nullable
    private String contentType;

    /**
     * A machine-friendly name for the message.
     */
    @Nullable
    private String name;

    /**
     * A human-friendly title for the message.
     */
    @Nullable
    private String title;

    /**
     * A short summary of what the message is about.
     */
    @Nullable
    private String summary;

    /**
     * A verbose explanation of the message. CommonMark syntax can be used for rich text representation.
     */
    @Nullable
    private String description;

    /**
     * A map where the keys describe the name of the protocol and the values describe protocol-specific definitions for the message.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link Reference}</li>
     *     <li>{@link MessageBinding}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = MessageBindingsDeserializer.class)
    private Map<String, Object> bindings;

    /**
     * List of examples.
     */
    @Nullable
    private List<MessageExample> examples;

    /**
     * A list of tags for logical grouping and categorization of messages.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link Reference}</li>
     *     <li>{@link Tag}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = TagsDeserializer.class)
    private List<Object> tags;

    /**
     * Additional external documentation for this channel.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link Reference}</li>
     *     <li>{@link ExternalDocumentation}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ExternalDocumentationDeserializer.class)
    private Object externalDocs;

}
