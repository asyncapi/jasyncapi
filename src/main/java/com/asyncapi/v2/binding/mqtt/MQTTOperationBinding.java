package com.asyncapi.v2.binding.mqtt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.CheckForNull;
import javax.annotation.Nullable;

/**
 * This class MUST NOT contain any properties. Its name is reserved for future use.
 *
 * This class defines how to describe MQTT operation binding.
 *
 * @author Pavel Bodiachevskii
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MQTTOperationBinding {

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
