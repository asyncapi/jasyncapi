package com.asyncapi.bindings.solace.v0._3_0.server;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.*;
import org.jetbrains.annotations.Nullable;

/**
 * Describes Solace server binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/solace#server-binding-object">Solace server binding</a>
 * @see <a href="https://solace.com">Solace</a>
 * @author Dennis Brinley, Pavel Bodiachevskii
 * @version 0.3.0
 * @since 1.0.0-RC2
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonClassDescription("Describes Solace server binding.")
public class SolaceServerBinding extends com.asyncapi.bindings.solace.SolaceServerBinding {

    /**
     * Message VPN of the Solace Broker
     * <p>
     * e.g. msgVpn: solace-broker-msg-vpn
     */
    @Nullable
    @JsonProperty("msgVpn")
    @JsonPropertyDescription("Message VPN of the Solace Broker")
    private String msgVpn;

    @Override
    public String getBindingVersion() {
        return "0.3.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.3.0");
    }

}
