package com.asyncapi.bindings.mqtt5.v0._1_0.server;

import lombok.*;
import org.jetbrains.annotations.Nullable;

/**
 * This class MUST NOT contain any properties. Its name is reserved for future use.
 * <p>
 * Describes MQTT 5 server binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/mqtt5#server-binding-object">MQTT 5 server binding</a>
 * @see <a href="https://docs.oasis-open.org/mqtt/mqtt/v5.0/mqtt-v5.0.html">MQTT 5</a>
 * @version 0.1.0
 * @author Pavel Bodiachevskii
 * @since 1.0.0-RC2
 */
@Data
@Builder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MQTT5ServerBinding extends com.asyncapi.bindings.mqtt5.MQTT5ServerBinding {

    @Override
    public String getBindingVersion() {
        return "0.1.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.1.0");
    }

}
