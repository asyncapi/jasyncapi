package com.asyncapi.v2.binding.server.solace;

import javax.annotation.CheckForNull;

import com.asyncapi.v2.binding.server.ServerBinding;

import lombok.*;

/**
 * Describes Solace server binding.
 *
 * @version 0.3.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/solace#server-binding-object">Solace server binding</a>
 * @author Dennis Brinley, Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SolaceServerBinding extends ServerBinding {

    /**
     * Message VPN of the Solace Broker
     * <p>
     * e.g. msgVpn: solace-broker-msg-vpn
     */
    @CheckForNull
    private String msgVpn;

    /**
     * The version of this binding.
     */
    @CheckForNull
    @Builder.Default
    private String bindingVersion = "0.3.0";

}
