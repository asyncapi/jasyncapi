package com.asyncapi.v2._6_0.binding.server.mqtt5;

import com.asyncapi.v2._6_0.binding.server.ServerBinding;
import lombok.*;

/**
 * This class MUST NOT contain any properties. Its name is reserved for future use.
 * <p>
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
public class MQTT5ServerBinding extends ServerBinding {

    /**
     * TODO: support reference, Schema object
     * Session Expiry Interval in seconds or a Schema Object containing the definition of the interval.
     */
    private int sessionExpiryInterval;

    @Builder.Default
    private String bindingVersion = "0.2.0";

}
