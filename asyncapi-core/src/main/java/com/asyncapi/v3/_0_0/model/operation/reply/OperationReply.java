package com.asyncapi.v3._0_0.model.operation.reply;

import com.asyncapi.schemas.asyncapi.ExtendableObject;
import com.asyncapi.schemas.asyncapi.Reference;
import com.asyncapi.v3._0_0.jackson.model.operation.reply.OperationReplyAddressDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Describes the reply part that MAY be applied to an {@link com.asyncapi.v3._0_0.model.operation.Operation}.
 * <p>
 * If an operation implements the request/reply pattern, the reply object represents the response message.
 *
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#operationObject">Operation</a>
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#operationReplyObject">Operation Reply</a>
 * @author Pavel Bodiachevskii
 * @version 3.0.0
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
     *     <li>{@link OperationReplyAddress}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = OperationReplyAddressDeserializer.class)
    private Object address;

    /**
     * A $ref pointer to the definition of the channel in which this operation is performed.
     * <p>
     * When address is specified, the address property of the channel referenced by this property MUST be either null or not defined.
     * <p>
     * If the operation reply is located inside a root Operation Object - {@link com.asyncapi.v3._0_0.model.AsyncAPI#getOperations()},
     * it MUST point to a channel definition located in the root Channels Object - {@link com.asyncapi.v3._0_0.model.AsyncAPI#getChannels()},
     * and MUST NOT point to a channel definition located in the Components Object - {@link com.asyncapi.v3._0_0.model.AsyncAPI#getComponents()} or anywhere else.
     * <p>
     * If the operation reply is located inside an Operation Object in the Components Object - {@link com.asyncapi.v3._0_0.model.AsyncAPI#getComponents()}
     * or in the Replies Object in the Components Object - {@link com.asyncapi.v3._0_0.model.AsyncAPI#getComponents()}, it MAY point to a Channel Object in any location.
     * <p>
     * Please note the channel property value MUST be a Reference Object and, therefore, MUST NOT contain a Channel Object.
     * <p>
     * However, it is RECOMMENDED that parsers (or other software) dereference this property for a better development experience.
     */
    @Nullable
    private Reference channel;

    /**
     * A list of $ref pointers pointing to the supported {@link com.asyncapi.v3._0_0.model.channel.message.Message} that can be processed by this operation as reply.
     * <p>
     * It MUST contain a subset of the messages defined in the channel referenced in this operation reply,
     * and MUST NOT point to a subset of message definitions located in the Components Object or anywhere else.
     * <p>
     * <b>Every message processed by this operation MUST be valid against one, and only one, of the message objects referenced in this list.</b>
     * <p>
     * Please note the messages property value MUST be a list of Reference Objects and, therefore, MUST NOT contain Message Objects.
     * <p>
     * However, it is RECOMMENDED that parsers (or other software) dereference this property for a better development experience.
     */
    @Nullable
    private List<Reference> messages;

}
