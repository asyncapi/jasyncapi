package com.asyncapi.v2._6_0.model.channel.operation;

import com.asyncapi.v2._6_0.jackson.binding.operation.OperationBindingsDeserializer;
import com.asyncapi.v2._6_0.model.ExternalDocumentation;
import com.asyncapi.v2._6_0.model.Tag;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.CheckForNull;
import java.util.List;
import java.util.Map;

/**
 * Describes a trait that MAY be applied to an Operation Object({@link com.asyncapi.v2._6_0.model.channel.operation.Operation}).
 * <p>
 * This object MAY contain any property from the Operation Object({@link com.asyncapi.v2._6_0.model.channel.operation.Operation}), except:
 * <ul>
 *     <li>{@link com.asyncapi.v2._6_0.model.channel.operation.Operation#getMessage()}</li>
 *     <li>{@link com.asyncapi.v2._6_0.model.channel.operation.Operation#getTraits()}</li>
 * </ul>
 * <p>
 * If you're looking to apply traits to a message, see the Message Trait Object({@link com.asyncapi.v2._6_0.model.channel.message.MessageTrait}.
 *
 * @version 2.0.0
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0/#operationObject">Operation</a>
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0/#operationTraitObject">OperationTrait</a>
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0/#messageTraitObject">MessageTrait</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OperationTrait {

    /**
     * Unique string used to identify the operation.
     * <p>
     * The id MUST be unique among all operations described in the API. The operationId value is case-sensitive.
     * Tools and libraries MAY use the operationId to uniquely identify an operation, therefore, it is RECOMMENDED to
     * follow common programming naming conventions.
     */
    @CheckForNull
    private String operationId;

    /**
     * A short summary of what the operation is about.
     */
    @CheckForNull
    private String summary;

    /**
     * A verbose explanation of the operation. <a href="https://spec.commonmark.org/"CommonMark syntax></a> can be used for rich text representation.
     */
    @CheckForNull
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
    @CheckForNull
    private List<Map<String, List<String>>> security;

    /**
     * A list of tags for API documentation control. Tags can be used for logical grouping of operations.
     */
    @CheckForNull
    private List<Tag> tags;

    /**
     * Additional external documentation for this operation.
     */
    @CheckForNull
    private ExternalDocumentation externalDocs;

    /**
     * A map where the keys describe the name of the protocol and the values describe protocol-specific definitions for the operation.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2._6_0.model.Reference}</li>
     *     <li>{@link com.asyncapi.v2._6_0.binding.operation.OperationBinding}</li>
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = OperationBindingsDeserializer.class)
    private Map<String, Object> bindings;

}
