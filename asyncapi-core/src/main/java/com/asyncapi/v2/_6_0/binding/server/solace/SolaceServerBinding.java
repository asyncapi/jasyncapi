package com.asyncapi.v2._6_0.binding.server.solace;

import com.asyncapi.v2._6_0.binding.server.ServerBinding;
import lombok.*;

/**
 * This class MUST NOT contain any properties. Its name is reserved for future use.
 * <p>
 * Describes SNS server binding.
 *
 * @version 0.3.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/solace">SNS server binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SolaceServerBinding extends ServerBinding {

    /**
     * The Virtual Private Network name on the Solace broker.
     */
    private String msgVpn;

    /**
     * The version of this binding.
     */
    @Builder.Default
    private String bindingVersion = "0.3.0";

}
