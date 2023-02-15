package com.asyncapi.v2._0_0.binding.mqtt;

import com.asyncapi.v2._0_0.binding.OperationBinding;
import lombok.*;

import javax.annotation.CheckForNull;
import javax.annotation.Nullable;

/**
 * Describes MQTT operation binding.
 *
 * Contains information about the operation representation in MQTT.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/mqtt#operation-binding-object">MQTT operation binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MQTTOperationBinding extends OperationBinding {

    /**
     * Defines how hard the broker/client will try to ensure that a message is received.
     * Its value MUST be either 0, 1 or 2.
     *
     * Applies to: publish, subscribe
     */
    private int qos;

    /**
     * Whether the broker should retain the message or not.
     *
     * Applies to: publish, subscribe
     */
    private boolean retain;

    /**
     * The version of this binding. If omitted, "latest" MUST be assumed.
     *
     * Applies to: publish, subscribe
     */
    @Nullable
    @CheckForNull
    private String bindingVersion;

}
