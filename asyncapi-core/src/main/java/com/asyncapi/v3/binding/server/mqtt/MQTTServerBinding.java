package com.asyncapi.v3.binding.server.mqtt;

import com.asyncapi.v3.binding.server.ServerBinding;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.*;
import org.jetbrains.annotations.Nullable;

/**
 * Describes MQTT server binding.
 * <p>
 * Contains information about the server representation in MQTT.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/mqtt#server-binding-object">MQTT server binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonClassDescription("Describes MQTT server binding.")
public class MQTTServerBinding extends ServerBinding {

    /**
     * The client identifier.
     */
    @Nullable
    @JsonProperty("clientId")
    @JsonPropertyDescription("The client identifier.")
    private String clientId;

    /**
     * Whether to create a persisten connection or not. When false, the connection will be persistent.
     */
    @Nullable
    @JsonProperty("cleanSession")
    @JsonPropertyDescription("Whether to create a persisten connection or not. When false, the connection will be persistent.")
    private Boolean cleanSession;

    /**
     * Last Will and Testament configuration.
     */
    @Nullable
    @JsonProperty("lastWill")
    @JsonPropertyDescription("Last Will and Testament configuration.")
    private MQTTServerLastWillConfiguration lastWill;

    /**
     * Interval in seconds of the longest period of time the broker and the client can endure without sending a message.
     */
    @Nullable
    @JsonProperty("keepAlive")
    @JsonPropertyDescription("Interval in seconds of the longest period of time the broker and the client can endure without sending a message.")
    private Integer keepAlive;

    /**
     * The version of this binding. If omitted, "latest" MUST be assumed.
     */
    @Nullable
    @Builder.Default
    @JsonProperty("bindingVersion")
    @JsonPropertyDescription("The version of this binding.")
    private String bindingVersion = "0.1.0";

}
