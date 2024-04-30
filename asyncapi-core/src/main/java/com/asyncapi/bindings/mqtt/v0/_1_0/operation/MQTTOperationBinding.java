package com.asyncapi.bindings.mqtt.v0._1_0.operation;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.*;
import org.jetbrains.annotations.Nullable;

/**
 * Describes MQTT operation binding.
 * <p>
 * Contains information about the operation representation in MQTT.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/mqtt#operation-binding-object">MQTT operation binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonClassDescription("Describes MQTT operation binding.")
public class MQTTOperationBinding extends com.asyncapi.bindings.mqtt.MQTTOperationBinding {

    /**
     * Defines how hard the broker/client will try to ensure that a message is received.
     * Its value MUST be either 0, 1 or 2.
     * <p>
     * Applies to: publish, subscribe
     */
    @Nullable
    @javax.validation.constraints.Min(
            value = 0,
            message = "QoS must be greater or equals to 0."
    )
    @javax.validation.constraints.Max(
            value = 2,
            message = "QoS must be lower or equals to 0."
    )
    @JsonProperty("qos")
    @JsonPropertyDescription("Defines the Quality of Service (QoS) levels for the message flow between client and server. Its value MUST be either 0 (At most once delivery), 1 (At least once delivery), or 2 (Exactly once delivery).")
    private Integer qos;

    /**
     * Whether the broker should retain the message or not.
     * <p>
     * Applies to: publish, subscribe
     */
    @Nullable
    @JsonProperty("retain")
    @JsonPropertyDescription("Whether the broker should retain the message or not.")
    private Boolean retain;

    @Override
    public String getBindingVersion() {
        return "0.1.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.1.0");
    }

}
