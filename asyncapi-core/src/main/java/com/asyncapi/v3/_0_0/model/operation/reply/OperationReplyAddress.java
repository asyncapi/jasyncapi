package com.asyncapi.v3._0_0.model.operation.reply;

import com.asyncapi.v3.ExtendableObject;
import lombok.*;
import org.jetbrains.annotations.Nullable;

/**
 * An object that specifies where an operation has to send the reply.
 * <p>
 * For specifying and computing the location of a reply address, a runtime expression is used.
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
public class OperationReplyAddress extends ExtendableObject {

    /**
     * An optional description of the address. CommonMark syntax can be used for rich text representation.
     */
    @Nullable
    private String description;

    /**
     * REQUIRED.
     * <p>
     * A runtime expression that specifies the location of the reply address.
     */
    @Nullable
    private String location;

}
