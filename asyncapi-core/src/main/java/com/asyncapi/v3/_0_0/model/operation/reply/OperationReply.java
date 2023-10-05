package com.asyncapi.v3._0_0.model.operation.reply;

import com.asyncapi.v3.ExtendableObject;
import com.asyncapi.v3.Reference;
import com.asyncapi.v3._0_0.jackson.model.operation.reply.OperationReplyAddressDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Describes the reply part that MAY be applied to an Operation Object. If an operation implements the request/reply
 * pattern, the reply object represents the response message.
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
public class OperationReply extends ExtendableObject {

    /**
     * Definition of the address that implementations MUST use for the reply.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link Reference}</li>
     *     <li>{@link OperationReplyAddress}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = OperationReplyAddressDeserializer.class)
    private Object address;

    /**
     * A $ref pointer to the definition of the channel in which this operation is performed.
     * When address is specified, the address property of the channel referenced by this property MUST be either null
     * or not defined. Please note the channel property value MUST be a Reference Object and, therefore, MUST NOT contain
     * a Channel Object. However, it is RECOMMENDED that parsers (or other software) dereference this property for
     * a better development experience.
     */
    @Nullable
    private Reference channel;

    /**
     * A list of $ref pointers pointing to the supported Message Objects that can be processed by this operation as reply.
     * It MUST contain a subset of the messages defined in the channel referenced in this operation reply. Every message
     * processed by this operation MUST be valid against one, and only one, of the message objects referenced in this list.
     * Please note the messages property value MUST be a list of Reference Objects and, therefore, MUST NOT contain Message Objects.
     * However, it is RECOMMENDED that parsers (or other software) dereference this property for a better development experience.
     */
    @Nullable
    private List<Reference> messages;

}
