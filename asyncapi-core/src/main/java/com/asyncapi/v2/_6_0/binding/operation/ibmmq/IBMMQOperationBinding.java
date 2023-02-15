package com.asyncapi.v2._6_0.binding.operation.ibmmq;

import com.asyncapi.v2._6_0.binding.operation.OperationBinding;
import lombok.*;

/**
 * Describes IBM MQ operation binding.
 * <p>
 * This object MUST NOT contain any properties. Its name is reserved for future use.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/ibmmq#operation-binding-object">IBM MQ operation binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class IBMMQOperationBinding extends OperationBinding {
}
