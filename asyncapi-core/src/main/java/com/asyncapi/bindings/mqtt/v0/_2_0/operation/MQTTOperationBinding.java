package com.asyncapi.bindings.mqtt.v0._2_0.operation;

import com.asyncapi.schemas.serde.asyncapi.ReferenceOrAsyncAPISchemaOrNumberDeserializer;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/mqtt#operation-binding-object">MQTT operation binding</a>
 * @see <a href="https://mqtt.org/mqtt-specification/">MQTT</a>
 * @version 0.2.0
 * @author Pavel Bodiachevskii
 * @since 1.0.0-RC2
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
            message = "QoS must be lower or equals to 2."
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

    /**
     * Lifetime of the message in seconds.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link Number}</li>
     *     <li>{@link com.asyncapi.schemas.asyncapi.Reference}</li>
     *     <li>{@link com.asyncapi.schemas.asyncapi.AsyncAPISchema}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ReferenceOrAsyncAPISchemaOrNumberDeserializer.class)
    private Object messageExpiryInterval;

    @Override
    public String getBindingVersion() {
        return "0.2.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.2.0");
    }

}
