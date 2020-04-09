package com.asyncapi.v2.model.channel.operation;

import com.asyncapi.v2.model.ExternalDocumentation;
import com.asyncapi.v2.model.Tag;
import lombok.*;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;

/**
 * Describes a trait that MAY be applied to an Operation Object.
 * This object MAY contain any property from the {@link Operation} Object, except message and traits.
 *
 * If you're looking to apply traits to a message, see the Message Trait Object.
 *
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OperationTrait {

    /**
     * Unique string used to identify the operation.
     *
     * The id MUST be unique among all operations described in the API. The operationId value is case-sensitive.
     * Tools and libraries MAY use the operationId to uniquely identify an operation, therefore, it is RECOMMENDED
     * to follow common programming naming conventions.
     */
    @CheckForNull
    private String operationId;

    /**
     * A short summary of what the operation is about.
     */
    @CheckForNull
    private String summary;

    /**
     * A verbose explanation of the operation. CommonMark syntax can be used for rich text representation.
     */
    @CheckForNull
    private String description;

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
     * TODO: разобраться со связыванием
     *  https://github.com/asyncapi/asyncapi/blob/master/versions/2.0.0/asyncapi.md#operation-bindings-object
     * A map where the keys describe the name of the protocol and the values describe protocol-specific definitions for the operation.
     */
    @CheckForNull
    private Map<String, Object> bindings;

}
