package com.asyncapi.v2._6_0.model.channel.operation;

import com.asyncapi.v2.ExtendableObject;
import com.asyncapi.v2.OperationBindingValue;
import com.asyncapi.v2.OperationTraitValue;
import com.asyncapi.v2._6_0.jackson.model.channel.operation.OperationMessageDeserializer;
import com.asyncapi.v2._6_0.jackson.model.channel.operation.OperationTraitsDeserializer;
import com.asyncapi.v2._6_0.model.ExternalDocumentation;
import com.asyncapi.v2._6_0.model.Tag;
import com.asyncapi.v2.binding.operation.OperationBinding;
import com.asyncapi.v2.jackson.binding.operation.OperationBindingsDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

/**
 * Describes a publish or a subscribe operation. This provides a place to document how and why messages are sent and received.
 * <p>
 * For example, an operation might describe a chat application use case where a user sends a text message to a group.
 * A publish operation describes messages that are received by the chat application, whereas a subscribe operation describes messages that are sent by the chat application.
 *
 * @version 2.6.0
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
     * Unique string used to identify the operation.
     * <p>
     * The id MUST be unique among all operations described in the API. The operationId value is case-sensitive.
     * Tools and libraries MAY use the operationId to uniquely identify an operation, therefore, it is RECOMMENDED to
     * follow common programming naming conventions.
     */
    @Nullable
    private String operationId;

    /**
     * A short summary of what the operation is about.
     */
    @Nullable
    private String summary;

    /**
     * A verbose explanation of the operation. <a href="http://spec.commonmark.org/">CommonMark syntax</a> can be used for rich text representation.
     */
    @Nullable
    private String description;

    /**
     * A declaration of which security mechanisms are associated with this operation. Only one of the security
     * requirement objects MUST be satisfied to authorize an operation. In cases where Server Security also applies,
     * it MUST also be satisfied.
     * <p>
     * Each name MUST correspond to a security scheme which is declared in the {@link com.asyncapi.v2._6_0.model.component.Components#getSecuritySchemes()} Security Schemes under the {@link com.asyncapi.v2._6_0.model.component.Components} Object.
     * If the security scheme is of type "oauth2" or "openIdConnect", then the value is a list of scope names.
     * Provide scopes that are required to establish successful connection with the server.
     * If scopes are not needed, the list can be empty. For other security scheme types, the array MUST be empty.
     */
    @Nullable
    private List<Map<String, List<String>>> security;

    /**
     * A list of tags for logical grouping and categorization of operations.
     */
    @Nullable
    private List<Tag> tags;

    /**
     * Additional external documentation for this operation.
     */
    @Nullable
    private ExternalDocumentation externalDocs;

    /**
     * A map where the keys describe the name of the protocol and the values describe protocol-specific definitions for the operation.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2._6_0.model.Reference}</li>
     *     <li>{@link OperationBinding}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = OperationBindingsDeserializer.class)
    private Map<String, OperationBindingValue> bindings;

    /**
     * A list of traits to apply to the operation object.
     * Traits MUST be merged into the operation object using the <a href="https://tools.ietf.org/html/rfc7386">JSON Merge Patch</a> algorithm in the same order they are defined here.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2._6_0.model.Reference}</li>
     *     <li>{@link com.asyncapi.v2._6_0.model.channel.operation.OperationTrait}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = OperationTraitsDeserializer.class)
    private List<OperationTraitValue> traits;

    /**
     * A definition of the message that will be published or received by this operation.
     * Map containing a single oneOf key is allowed here to specify multiple messages.
     * However, a message MUST be valid only against one of the message objects.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2._6_0.model.Reference}</li>
     *     <li>{@link com.asyncapi.v2._6_0.model.channel.message.Message}</li>
     *     <li>{@link com.asyncapi.v2._6_0.model.channel.message.OneOfMessages}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = OperationMessageDeserializer.class)
    private Object message;
}
