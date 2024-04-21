package com.asyncapi.v2.binding.server.solace;

import com.asyncapi.bindings.ServerBinding;
import com.fasterxml.jackson.annotation.JsonClassDescription;
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
 * @version 0.3.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/solace#server-binding-object">Solace server binding</a>
 * @author Dennis Brinley, Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonClassDescription("Describes Solace server binding.")
public class SolaceServerBinding extends ServerBinding {

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
     * The version of this binding.
     */
    @Nullable
    @Builder.Default
    @JsonProperty("bindingVersion")
    @JsonPropertyDescription("The version of this binding.")
    private String bindingVersion = "0.3.0";

}
