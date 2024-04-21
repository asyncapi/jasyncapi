package com.asyncapi.v3._0_0.model.channel.message;

import com.asyncapi.ExtendableObject;
import com.asyncapi.v3.Reference;
import com.asyncapi.v3._0_0.jackson.model.ExternalDocumentationDeserializer;
import com.asyncapi.v3._0_0.jackson.model.TagsDeserializer;
import com.asyncapi.v3._0_0.jackson.model.channel.message.MessageCorrelationIdDeserializer;
import com.asyncapi.v3._0_0.jackson.model.channel.message.MessageTraitsDeserializer;
import com.asyncapi.v3._0_0.jackson.model.channel.message.MessageHeadersDeserializer;
import com.asyncapi.v3._0_0.jackson.model.channel.message.MessagePayloadDeserializer;
import com.asyncapi.v3._0_0.model.ExternalDocumentation;
import com.asyncapi.v3._0_0.model.Tag;
import com.asyncapi.v3.jackson.binding.message.MessageBindingsDeserializer;
import com.asyncapi.v3.schema.multiformat.MultiFormatSchema;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

/**
 * Describes a message received on a given channel and operation.
 *
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#messageObject">Message</a>
 * @author Pavel Bodiachevskii
 * @version 3.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Message extends ExtendableObject {

    /**
     * Schema definition of the application headers.
     * <p>
     * Schema MUST be a map of key-value pairs.
     * <p>
     * It MUST NOT define the protocol headers.
     * <p>
     * If this is a {@link com.asyncapi.v3.schema.AsyncAPISchema}, then the schemaFormat will be assumed to
     * be "application/vnd.aai.asyncapi+json;version=asyncapi" where the version
     * is equal to the AsyncAPI Version String.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v3.schema.AsyncAPISchema}</li>
     *     <li>{@link MultiFormatSchema}</li>
     *     <li>{@link com.asyncapi.v3.Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = MessageHeadersDeserializer.class)
    private Object headers;

    /**
     * Definition of the message payload.
     * <p>
     * If this is a {@link com.asyncapi.v3.schema.AsyncAPISchema}, then the schemaFormat will be assumed to be
     * "application/vnd.aai.asyncapi+json;version=asyncapi" where the version is equal to the AsyncAPI Version String.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v3.schema.AsyncAPISchema}</li>
     *     <li>{@link MultiFormatSchema}</li>
     *     <li>{@link com.asyncapi.v3.Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = MessagePayloadDeserializer.class)
    private Object payload;

    /**
     * Definition of the correlation ID used for message tracing or matching.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link CorrelationId}</li>
     *     <li>{@link com.asyncapi.v3.Reference}</li>
     * </ul>
     */
    @JsonDeserialize(using = MessageCorrelationIdDeserializer.class)
    private Object correlationId;

    /**
     * The content type to use when encoding/decoding a message's payload.
     * <p>
     * The value MUST be a specific media type (e.g. application/json).
     * <p>
     * When omitted, the value MUST be the one specified on the {@link com.asyncapi.v3._0_0.model.AsyncAPI#getDefaultContentType()} field.
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
     * A verbose explanation of the message. <a href="https://spec.commonmark.org/">CommonMark syntax</a> can be used for rich text representation.
     */
    @Nullable
    private String description;

    /**
     * A map where the keys describe the name of the protocol and the values describe protocol-specific definitions for the message.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v3.binding.message.MessageBinding}</li>
     *     <li>{@link com.asyncapi.v3.Reference}</li>
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
     * A list of traits to apply to the message object. Traits MUST be merged using traits merge mechanism.
     * The resulting object MUST be a valid {@link Message}.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v3._0_0.model.channel.message.MessageTrait}</li>
     *     <li>{@link com.asyncapi.v3.Reference}</li>
     * </ul>
     *
     * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#traits-merge-mechanism">Traits Merge Mechanism</a>
     */
    @Nullable
    @JsonDeserialize(using = MessageTraitsDeserializer.class)
    private List<Object> traits;

    /**
     * A list of tags for logical grouping and categorization of messages.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link Tag}</li>
     *     <li>{@link com.asyncapi.v3.Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = TagsDeserializer.class)
    private List<Object> tags;

    /**
     * Additional external documentation for this message.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link ExternalDocumentation}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ExternalDocumentationDeserializer.class)
    private Object externalDocs;

}
