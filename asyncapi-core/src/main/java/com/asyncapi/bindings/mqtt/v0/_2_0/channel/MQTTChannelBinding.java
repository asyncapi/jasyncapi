package com.asyncapi.bindings.mqtt.v0._2_0.channel;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

/**
 * This class MUST NOT contain any properties. Its name is reserved for future use.
 * <p>
 * Describes MQTT channel binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/mqtt#channel-binding-object">MQTT channel binding</a>
 * @see <a href="https://mqtt.org/mqtt-specification/">MQTT</a>
 * @version 0.2.0
 * @author Pavel Bodiachevskii
 * @since 1.0.0-RC2
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MQTTChannelBinding extends com.asyncapi.bindings.mqtt.MQTTChannelBinding {

    @Override
    public String getBindingVersion() {
        return "0.2.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.2.0");
    }

}
