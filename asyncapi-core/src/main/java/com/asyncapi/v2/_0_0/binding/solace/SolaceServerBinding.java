package com.asyncapi.v2._0_0.binding.solace;

import javax.annotation.CheckForNull;

import com.asyncapi.v2._0_0.binding.ServerBinding;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Describes Solace server binding.
 *
 * @version 0.2.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/solace#server-binding-object">Solace server binding</a>
 * @author Dennis Brinley
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SolaceServerBinding extends ServerBinding {

    /**
     * Binding version of the object
     *
     * e.g. bindingVersion: 0.2.0
     */
    @CheckForNull
    @JsonProperty
    protected String bindingVersion;

    /**
     * Message VPN of the Solace Broker
     *
     * e.g. msgVpn: solace-broker-msg-vpn
     */
    @CheckForNull
    @JsonProperty
    protected String msgVpn;
}
