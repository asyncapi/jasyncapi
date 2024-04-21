package com.asyncapi.bindings.pulsar.v0._1_0.operation;

import com.asyncapi.bindings.OperationBinding;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Describes Pulsar operation binding.
 * <p>
 * This object MUST NOT contain any properties. Its name is reserved for future use.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/pulsar#operation-binding-object">Pulsar operation binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PulsarOperationBinding extends OperationBinding {
}
