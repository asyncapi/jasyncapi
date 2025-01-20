package com.asyncapi.bindings.mqtt.v0._2_0.server;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

/**
 * Describes MQTT server last will configuration.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/mqtt#server-binding-object">MQTT server binding</a>
 * @see <a href="https://mqtt.org/mqtt-specification/">MQTT</a>
 * @version 0.2.0
 * @author Pavel Bodiachevskii
 * @since 1.0.0-RC2
 */
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class MQTTServerLastWillConfiguration {

    /**
     * The topic where the Last Will and Testament message will be sent.
     */
    @Nullable
    @JsonProperty("topic")
    @JsonPropertyDescription("The topic where the Last Will and Testament message will be sent.")
    private String topic;

    /**
     * Defines how hard the broker/client will try to ensure that the Last Will and Testament message is received.
     * Its value MUST be either 0, 1 or 2.
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
    @JsonPropertyDescription("Defines how hard the broker/client will try to ensure that the Last Will and Testament message is received. Its value MUST be either 0, 1 or 2.")
    private Integer qos;

    /**
     * Last Will message.
     */
    @Nullable
    @JsonProperty("message")
    @JsonPropertyDescription("Last Will message.")
    private String message;

    /**
     * Whether the broker should retain the Last Will and Testament message or not.
     */
    @Nullable
    @JsonProperty("retain")
    @JsonPropertyDescription("Whether the broker should retain the Last Will and Testament message or not.")
    private Boolean retain;

}
