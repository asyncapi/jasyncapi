package com.asyncapi.v2._6_0.binding.message.solace;

import com.asyncapi.v2._6_0.binding.message.MessageBinding;
import lombok.*;

/**
 * This class MUST NOT contain any properties. Its name is reserved for future use.
 * <p>
 * Describes Solace message binding.
 *
 * @version 0.3.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/solace">Solace message binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SolaceMessageBinding extends MessageBinding {
}
