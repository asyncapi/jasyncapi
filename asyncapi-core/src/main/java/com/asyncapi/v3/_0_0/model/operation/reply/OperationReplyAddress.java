package com.asyncapi.v3._0_0.model.operation.reply;

import com.asyncapi.v3.ExtendableObject;
import lombok.*;
import org.jetbrains.annotations.Nullable;

/**
 * An object that specifies where an operation has to send the reply.
 * <p>
 * For specifying and computing the location of a reply address, a runtime expression is used.
 *
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#operationReplyAddressObject">Operation Reply Address</a>
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#runtimeExpression">Runtime Expression</a>
 * @author Pavel Bodiachevskii
 * @version 3.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OperationReplyAddress extends ExtendableObject {

    /**
     * An optional description of the address. <a href="https://spec.commonmark.org/">CommonMark syntax</a> can be used for rich text representation.
     */
    @Nullable
    private String description;

    /**
     * <b>REQUIRED</b>.
     * <p>
     * A runtime expression that specifies the location of the reply address.
     *
     * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#runtimeExpression">Runtime Expression</a>
     */
    @Nullable
    private String location;

}
