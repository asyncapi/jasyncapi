package com.asyncapi.bindings.mqtt.v0._2_0.server;

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
 * Describes MQTT server binding.
 * <p>
 * Contains information about the server representation in MQTT.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/mqtt#server-binding-object">MQTT server binding</a>
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
@JsonClassDescription("Describes MQTT server binding.")
public class MQTTServerBinding extends com.asyncapi.bindings.mqtt.MQTTServerBinding {

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
     * Interval time in seconds or a Schema Object containing the definition of the interval.
     * <p>
     * The broker maintains a session for a disconnected client until this interval expires.
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
    private Object sessionExpiryInterval;

    /**
     * Number of bytes or a Schema Object representing the Maximum Packet Size the Client is willing to accept.
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
    private Object maximumPacketSize;

    @Override
    public String getBindingVersion() {
        return "0.2.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.2.0");
    }

}
