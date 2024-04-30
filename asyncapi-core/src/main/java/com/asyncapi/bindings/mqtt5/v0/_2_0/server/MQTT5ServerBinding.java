package com.asyncapi.bindings.mqtt5.v0._2_0.server;

import lombok.*;
import org.jetbrains.annotations.Nullable;

/**
 * Describes MQTT 5 server binding.
 *
 * @version 0.2.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/mqtt5#server-binding-object">MQTT 5 server binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MQTT5ServerBinding extends com.asyncapi.bindings.mqtt5.MQTT5ServerBinding {

    /**
     * TODO: support reference, Schema object
     * Session Expiry Interval in seconds or a Schema Object containing the definition of the interval.
     */
    private int sessionExpiryInterval;

    @Override
    public String getBindingVersion() {
        return "0.2.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.2.0");
    }

}
