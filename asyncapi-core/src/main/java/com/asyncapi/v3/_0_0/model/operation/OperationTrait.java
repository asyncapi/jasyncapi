package com.asyncapi.v3._0_0.model.operation;

import com.asyncapi.schemas.ExtendableObject;
import com.asyncapi.schemas.Reference;
import com.asyncapi.v3._0_0.jackson.model.ExternalDocumentationDeserializer;
import com.asyncapi.v3._0_0.jackson.model.TagsDeserializer;
import com.asyncapi.v3._0_0.model.ExternalDocumentation;
import com.asyncapi.v3._0_0.model.Tag;
import com.asyncapi.bindings.OperationBinding;
import com.asyncapi.bindings.OperationBindingsDeserializer;
import com.asyncapi.v3.jackson.security_scheme.SecuritySchemesDeserializer;
import com.asyncapi.schemas.security.SecurityScheme;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

/**
 * Describes a trait that MAY be applied to an {@link Operation}. This object MAY contain any property from the
 * {@link Operation}, except the action, channel and traits ones.
 *
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#operationObject">Operation</a>
 * @author Pavel Bodiachevskii
 * @version 3.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OperationTrait extends ExtendableObject {

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
     * A verbose explanation of the operation. <a href="https://spec.commonmark.org/">CommonMark syntax</a> can be used for rich text representation.
     */
    @Nullable
    private String description;

    /**
     * A declaration of which security schemes are associated with this operation.
     * <p>
     * Only one of the {@link SecurityScheme} objects MUST be satisfied to authorize an operation.
     * <p>
     * In cases where Server Security also applies, it MUST also be satisfied.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link SecurityScheme}</li>
     *     <li>{@link Reference}</li>
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
     *     <li>{@link Tag}</li>
     *     <li>{@link Reference}</li>
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
     *     <li>{@link ExternalDocumentation}</li>
     *     <li>{@link Reference}</li>
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
     *     <li>{@link OperationBinding}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = OperationBindingsDeserializer.class)
    private Map<String, Object> bindings;

}
