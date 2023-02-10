package com.asyncapi.v2._6_0.binding.message.pulsar;

import com.asyncapi.v2._6_0.binding.operation.OperationBinding;
import lombok.*;

/**
 * Describes Pulsar message binding.
 * <p>
 * This object MUST NOT contain any properties. Its name is reserved for future use.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/pulsar">Pulsar message binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PulsarMessageBinding extends OperationBinding {
}
