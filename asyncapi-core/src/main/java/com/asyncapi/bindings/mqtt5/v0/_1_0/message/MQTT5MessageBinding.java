package com.asyncapi.bindings.mqtt5.v0._1_0.message;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

/**
 * This class MUST NOT contain any properties. Its name is reserved for future use.
 * <p>
 * Describes MQTT 5 message binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/mqtt5#message-binding-object">MQTT 5 message binding</a>
 * @see <a href="https://docs.oasis-open.org/mqtt/mqtt/v5.0/mqtt-v5.0.html">MQTT 5</a>
 * @version 0.1.0
 * @author Pavel Bodiachevskii
 * @since 1.0.0-RC2
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MQTT5MessageBinding extends com.asyncapi.bindings.mqtt5.MQTT5MessageBinding {

    @Override
    public String getBindingVersion() {
        return "0.1.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.1.0");
    }

}
