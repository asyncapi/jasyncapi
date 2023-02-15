package com.asyncapi.v2._6_0.binding.operation.nats;

import com.asyncapi.v2._6_0.binding.operation.OperationBinding;
import lombok.*;

import javax.annotation.CheckForNull;

/**
 * Describes NATS operation binding.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/nats#operation-binding-object">NATS operation binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class NATSOperationBinding extends OperationBinding {

    /**
     * Defines the name of the queue to use. It MUST NOT exceed 255 characters.
     */
    @CheckForNull
    private String queue;

    /**
     * The version of this binding. If omitted, "latest" MUST be assumed.
     */
    @CheckForNull
    @Builder.Default
    private String bindingVersion = "0.1.0";

}
