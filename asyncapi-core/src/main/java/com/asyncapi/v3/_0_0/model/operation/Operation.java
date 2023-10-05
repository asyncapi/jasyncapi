package com.asyncapi.v3._0_0.model.operation;

import com.asyncapi.v3.ExtendableObject;
import com.asyncapi.v3.Reference;
import com.asyncapi.v3._0_0.jackson.model.ExternalDocumentationDeserializer;
import com.asyncapi.v3._0_0.jackson.model.TagsDeserializer;
import com.asyncapi.v3._0_0.jackson.model.operation.OperationTraitsDeserializer;
import com.asyncapi.v3._0_0.jackson.model.operation.reply.OperationReplyDeserializer;
import com.asyncapi.v3._0_0.model.ExternalDocumentation;
import com.asyncapi.v3._0_0.model.Tag;
import com.asyncapi.v3._0_0.model.operation.reply.OperationReply;
import com.asyncapi.v3.binding.operation.OperationBinding;
import com.asyncapi.v3.jackson.binding.operation.OperationBindingsDeserializer;
import com.asyncapi.v3.jackson.security_scheme.SecuritySchemesDeserializer;
import com.asyncapi.v3.security_scheme.SecurityScheme;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

/**
 * Describes a specific operation.
 *
 * @version 3.0.0
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0#operationObject">Operation</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Operation extends ExtendableObject {

    /**
     * Required.
     * <p>
     * Use send when it's expected that the application will send a message to the given channel, and receive when
     * the application should expect receiving messages from the given channel.
     */
    @NotNull
    private OperationAction action;

    /**
     * Required.
     * <p>
     * A $ref pointer to the definition of the channel in which this operation is performed.
     * Please note the channel property value MUST be a Reference Object and, therefore, MUST NOT contain a Channel Object.
     * However, it is RECOMMENDED that parsers (or other software) dereference this property for a better development experience.
     */
    @NotNull
    private Reference channel;

    /**
     * A human-friendly title for the operation.
     */
    @Nullable
    private String title;

    /**
     * A short summary of what the operation is about.
     */
    @Nullable
    private String summary;

    /**
     * A verbose explanation of the operation. CommonMark syntax can be used for rich text representation.
     */
    @Nullable
    private String description;

    /**
     * A declaration of which security schemes are associated with this operation.
     * Only one of the security scheme objects MUST be satisfied to authorize an operation.
     * In cases where Server Security also applies, it MUST also be satisfied.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link Reference}</li>
     *     <li>{@link SecurityScheme}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = SecuritySchemesDeserializer.class)
    private List<Object> security;

    /**
     * A list of tags for logical grouping and categorization of operations.
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

    /**
     * A map where the keys describe the name of the protocol and the values describe protocol-specific definitions for the operation.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link Reference}</li>
     *     <li>{@link OperationBinding}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = OperationBindingsDeserializer.class)
    private Map<String, Object> bindings;

    /**
     * A list of traits to apply to the operation object. Traits MUST be merged using traits merge mechanism.
     * The resulting object MUST be a valid Operation Object.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link Reference}</li>
     *     <li>{@link OperationTrait}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = OperationTraitsDeserializer.class)
    private List<Object> traits;

    /**
     * A list of $ref pointers pointing to the supported Message Objects that can be processed by this operation.
     * It MUST contain a subset of the messages defined in the channel referenced in this operation.
     * Every message processed by this operation MUST be valid against one, and only one, of the message objects
     * referenced in this list. Please note the messages property value MUST be a list of Reference Objects and,
     * therefore, MUST NOT contain Message Objects. However, it is RECOMMENDED that parsers (or other software)
     * dereference this property for a better development experience.
     */
    @Nullable
    private List<Reference> messages;

    /**
     * The definition of the reply in a request-reply operation.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link Reference}</li>
     *     <li>{@link OperationReply}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = OperationReplyDeserializer.class)
    private Object reply;

}
