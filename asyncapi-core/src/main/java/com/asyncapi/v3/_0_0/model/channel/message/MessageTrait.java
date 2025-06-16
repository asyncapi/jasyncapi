package com.asyncapi.v3._0_0.model.channel.message;

import com.asyncapi.lsp.TextDocumentCompletion;
import com.asyncapi.schemas.asyncapi.AsyncAPISchema;
import com.asyncapi.schemas.asyncapi.ExtendableObject;
import com.asyncapi.schemas.asyncapi.Reference;
import com.asyncapi.v3._0_0.jackson.model.ExternalDocumentationDeserializer;
import com.asyncapi.v3._0_0.jackson.model.TagsDeserializer;
import com.asyncapi.v3._0_0.jackson.model.channel.message.MessageCorrelationIdDeserializer;
import com.asyncapi.v3._0_0.jackson.model.channel.message.MessageHeadersDeserializer;
import com.asyncapi.v3._0_0.model.ExternalDocumentation;
import com.asyncapi.v3._0_0.model.Tag;
import com.asyncapi.bindings.MessageBindingsDeserializer;
import com.asyncapi.schemas.asyncapi.multiformat.MultiFormatSchema;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

/**
 * Describes a trait that MAY be applied to a {@link Message}.
 * <p>
 * This object MAY contain any property from the {@link Message}, except {@link Message} payload and {@link Message} traits.
 *
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#messageTraitObject">Message Trait</a>
 * @author Pavel Bodiachevskii
 * @version 3.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MessageTrait extends ExtendableObject {

    /**
     * Schema definition of the application headers.
     * <p>
     * Schema MUST be a map of key-value pairs.
     * <p>
     * It MUST NOT define the protocol headers.
     * <p>
     * If this is a {@link AsyncAPISchema}, then the schemaFormat will be assumed to
     * be "application/vnd.aai.asyncapi+json;version=asyncapi" where the version
     * is equal to the AsyncAPI Version String.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link AsyncAPISchema}</li>
     *     <li>{@link MultiFormatSchema}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = MessageHeadersDeserializer.class)
    @TextDocumentCompletion(
            detail = "AsyncAPISchema | MultiFormatSchema | Reference",
            documentation = "Schema definition of the application headers\n\n" +
                    "Schema definition of the application headers. Schema MUST be a map of key-value pairs. It MUST NOT define the protocol headers.",
            variants = {AsyncAPISchema.class, MultiFormatSchema.class, Reference.class}
    )
    private Object headers;

    /**
     * Definition of the correlation ID used for message tracing or matching.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link CorrelationId}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @JsonDeserialize(using = MessageCorrelationIdDeserializer.class)
    @TextDocumentCompletion(
            detail = "CorrelationId | Reference",
            documentation = "Correlation ID for message tracing\n\n" +
                    "Definition of the correlation ID used for message tracing or matching.",
            variants = {CorrelationId.class, Reference.class}
    )
    private Object correlationId;

    /**
     * The content type to use when encoding/decoding a message's payload.
     * <p>
     * The value MUST be a specific media type (e.g. application/json).
     * <p>
     * When omitted, the value MUST be the one specified on the {@link com.asyncapi.v3._0_0.model.AsyncAPI#getDefaultContentType()} field.
     */
    @Nullable
    @TextDocumentCompletion(
            detail = "String",
            documentation = "Content type for message payload\n\n" +
                    "The content type to use when encoding/decoding a message's payload. The value MUST be a specific media type (e.g. application/json)."
    )
    private String contentType;

    /**
     * A machine-friendly name for the message.
     */
    @Nullable
    @TextDocumentCompletion(
            detail = "String",
            documentation = "A machine-friendly name for the message."
    )
    private String name;

    /**
     * A human-friendly title for the message.
     */
    @Nullable
    @TextDocumentCompletion(
            detail = "String",
            documentation = "A human-friendly title for the message."
    )
    private String title;

    /**
     * A short summary of what the message is about.
     */
    @Nullable
    @TextDocumentCompletion(
            detail = "String",
            documentation = "Summary of the message\n\n" +
                    "A short summary of what the message is about."
    )
    private String summary;

    /**
     * A verbose explanation of the message. <a href="https://spec.commonmark.org/">CommonMark syntax</a> can be used for rich text representation.
     */
    @Nullable
    @TextDocumentCompletion(
            detail = "String",
            documentation = "Description of the message\n\n" +
                    "A verbose explanation of the message. CommonMark syntax can be used for rich text representation."
    )
    private String description;

    /**
     * A map where the keys describe the name of the protocol and the values describe protocol-specific definitions for the message.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.bindings.MessageBinding}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = MessageBindingsDeserializer.class)
    @TextDocumentCompletion(
            detail = "Map<String, MessageBinding | Reference>",
            documentation = "Protocol-specific definitions for the message\n\n" +
                    "A map where the keys describe the name of the protocol and the values describe protocol-specific definitions for the message.",
            variants = {com.asyncapi.bindings.MessageBinding.class, Reference.class}
    )
    private Map<String, Object> bindings;

    /**
     * List of examples.
     */
    @Nullable
    @TextDocumentCompletion(
            detail = "List<MessageExample>",
            documentation = "List of examples for the message.",
            variants = {MessageExample.class}
    )
    private List<MessageExample> examples;

    /**
     * A list of tags for logical grouping and categorization of messages.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link Tag}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = TagsDeserializer.class)
    @TextDocumentCompletion(
            detail = "List<Tag | Reference>",
            documentation = "Tags for categorization of messages\n\n" +
                    "A list of tags for logical grouping and categorization of messages.",
            variants = {Tag.class, Reference.class}
    )
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
    @TextDocumentCompletion(
            detail = "ExternalDocumentation | Reference",
            documentation = "Additional external documentation for this message.",
            variants = {ExternalDocumentation.class, Reference.class}
    )
    private Object externalDocs;

}
