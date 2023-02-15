package com.asyncapi.v2._0_0.model.channel.operation;

import com.asyncapi.v2._0_0.binding.OperationBinding;
import com.asyncapi.v2._0_0.binding.OperationBindingsDeserializer;
import com.asyncapi.v2._0_0.jackson.OperationMessageDeserializer;
import com.asyncapi.v2._0_0.jackson.OperationTraitsDeserializer;
import com.asyncapi.v2._0_0.model.ExternalDocumentation;
import com.asyncapi.v2._0_0.model.Reference;
import com.asyncapi.v2._0_0.model.Tag;
import com.asyncapi.v2._0_0.model.channel.message.Message;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import javax.annotation.CheckForNull;
import java.util.List;
import java.util.Map;

/**
 * Describes a publish or a subscribe operation.
 * <br><br>
 * This provides a place to document how and why messages are sent and received.
 * <br>
 * For example, an operation might describe a chat application use case where a user sends a text message to a group.
 *
 * @version 2.0.0
 * @see <a href="https://www.asyncapi.com/docs/specifications/2.0.0/#operationObject">Operation</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Operation {

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
     * A map where the keys describe the name of the protocol and the values describe protocol-specific definitions
     * for the operation.
     *
     * Map describing protocol-specific definitions for an operation.
     */
    @CheckForNull
    @JsonDeserialize(using = OperationBindingsDeserializer.class)
    private Map<String, ? extends OperationBinding> bindings;

    /**
     * A list of traits to apply to the operation object. Traits MUST be merged into the operation object using the
     * JSON Merge Patch algorithm in the same order they are defined here.
     *
     * MUST BE:
     * <ul>
     *     <li>{@link Reference}</li>
     *     <li>{@link OperationTrait}</li>
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = OperationTraitsDeserializer.class)
    private List<Object> traits;

    /**
     * A definition of the message that will be published or received on this channel. oneOf is allowed here to
     * specify multiple messages, however, a message MUST be valid only against one of the referenced message objects.
     *
     * MUST BE:
     * <ul>
     *     <li>{@link Reference}</li>
     *     <li>{@link Message}</li>
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = OperationMessageDeserializer.class)
    private Object message;

}
