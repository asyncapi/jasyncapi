package com.asyncapi.v2._0_0.model.channel.operation;

import com.asyncapi.schemas.ExtendableObject;
import com.asyncapi.v2._0_0.model.ExternalDocumentation;
import com.asyncapi.v2._0_0.model.Tag;
import com.asyncapi.v2._0_0.model.channel.message.MessageTrait;
import com.asyncapi.bindings.OperationBinding;
import com.asyncapi.bindings.OperationBindingsDeserializer;
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
 * Describes a trait that MAY be applied to an Operation Object({@link Operation}).
 * <br>
 * This object MAY contain any property from the Operation Object({@link Operation}), except message and traits.
 * <br>
 * If you're looking to apply traits to a message, see the Message Trait Object({@link MessageTrait}.
 *
 * @version 2.0.0
 * @see <a href="https://www.asyncapi.com/docs/specifications/2.0.0/#operationObject">Operation</a>
 * @see <a href="https://www.asyncapi.com/docs/specifications/2.0.0/#operationTraitObject">OperationTrait</a>
 * @see <a href="https://www.asyncapi.com/docs/specifications/2.0.0/#messageTraitObject">MessageTrait</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OperationTrait extends ExtendableObject {

    /**
     * Unique string used to identify the operation.
     * <p>
     * The id MUST be unique among all operations described in the API. The operationId value is case-sensitive.
     * Tools and libraries MAY use the operationId to uniquely identify an operation, therefore, it is RECOMMENDED
     * to follow common programming naming conventions.
     */
    @Nullable
    private String operationId;

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
     * A list of tags for API documentation control. Tags can be used for logical grouping of operations.
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
     */
    @Nullable
    @JsonDeserialize(using = OperationBindingsDeserializer.class)
    private Map<String, ? extends OperationBinding> bindings;

}
