package com.asyncapi.v2.binding.operation.mqtt;

import com.asyncapi.v2.binding.operation.OperationBinding;
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
public class MQTTOperationBinding extends OperationBinding {

    /**
     * Defines how hard the broker/client will try to ensure that a message is received.
     * Its value MUST be either 0, 1 or 2.
     * <p>
     * Applies to: publish, subscribe
     */
    @Nullable
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

    /**
     * The version of this binding. If omitted, "latest" MUST be assumed.
     * <p>
     * Applies to: publish, subscribe
     */
    @Nullable
    @Builder.Default
    @JsonProperty("bindingVersion")
    @JsonPropertyDescription("The version of this binding.")
    private String bindingVersion = "0.1.0";

}
