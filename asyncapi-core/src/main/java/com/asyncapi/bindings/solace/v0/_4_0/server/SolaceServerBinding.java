package com.asyncapi.bindings.solace.v0._4_0.server;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

/**
 * Describes Solace server binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/solace#server-binding-object">Solace server binding</a>
 * @see <a href="https://solace.com">Solace</a>
 * @author Pavel Bodiachevskii
 * @version 0.4.0
 * @since 1.0.0-RC2
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
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

    /**
     * A unique client name to use to register to the appliance.
     * <p>
     * If specified, it must be a valid Topic name, and a maximum of 160 bytes in length when encoded as UTF-8.
     */
    @Nullable
    @JsonProperty("clientName")
    @jakarta.validation.constraints.Size(min = 1, max = 160)
    private String clientName;

    @Override
    public String getBindingVersion() {
        return "0.4.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.4.0");
    }

}
