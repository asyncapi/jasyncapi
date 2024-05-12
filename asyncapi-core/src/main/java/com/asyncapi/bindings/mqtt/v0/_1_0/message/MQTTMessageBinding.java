package com.asyncapi.bindings.mqtt.v0._1_0.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.*;
import org.jetbrains.annotations.Nullable;

/**
 * Describes MQTT message binding.
 * <p>
 * Contains information about the message representation in MQTT.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/mqtt#message-binding-object">MQTT message binding</a>
 * @see <a href="https://mqtt.org/mqtt-specification/">MQTT</a>
 * @version 0.1.0
 * @author Pavel Bodiachevskii
 * @since 1.0.0-RC2
 */
@Data
@Builder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MQTTMessageBinding extends com.asyncapi.bindings.mqtt.MQTTMessageBinding {

    @Override
    public String getBindingVersion() {
        return "0.1.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.1.0");
    }

}
