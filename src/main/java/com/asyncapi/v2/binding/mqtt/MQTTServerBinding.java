package com.asyncapi.v2.binding.mqtt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.CheckForNull;
import javax.annotation.Nullable;

/**
 * This class MUST NOT contain any properties. Its name is reserved for future use.
 *
 * This class defines how to describe MQTT channel binding.
 *
 * @author Pavel Bodiachevskii
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MQTTServerBinding {

    /**
     * The client identifier.
     */
    @Nullable
    @CheckForNull
    private String clientId;

    /**
     * Whether to create a persisten connection or not. When false, the connection will be persistent.
     */
    private boolean cleanSession;

    /**
     * Last Will and Testament configuration.
     */
    @Nullable
    @CheckForNull
    private LastWillConfiguration lastWill;

    /**
     * Interval in seconds of the longest period of time the broker and the client can endure without sending a message.
     */
    private int keepAlive;

    /**
     * The version of this binding. If omitted, "latest" MUST be assumed.
     */
    @Nullable
    @CheckForNull
    private String bindingVersion;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LastWillConfiguration {

        /**
         * The topic where the Last Will and Testament message will be sent.
         */
        @Nullable
        @CheckForNull
        private String topic;

        /**
         * Defines how hard the broker/client will try to ensure that the Last Will and Testament message is received.
         * Its value MUST be either 0, 1 or 2.
         */
        private int qos;

        /**
         * Whether the broker should retain the Last Will and Testament message or not.
         */
        private boolean retain;

    }

}
