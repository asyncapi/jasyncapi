package com.asyncapi.v2.binding.amqp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.CheckForNull;
import javax.annotation.Nullable;
import java.util.Map;

/**
 * This class MUST NOT contain any properties. Its name is reserved for future use.
 *
 * This class defines how to describe AMQP 0-9-1 channel binding.
 *
 * @author Pavel Bodiachevskii
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AMQPChannelBinding {

    /**
     * Defines what type of channel is it. Can be either queue or routingKey (default).
     */
    @Nullable
    @CheckForNull
    private String is;

    /**
     * When is=routingKey, this object defines the exchange properties.
     */
    @Nullable
    @CheckForNull
    private ExchangeProperties exchange;

    /**
     * When is=queue, this object defines the queue properties.
     */
    @Nullable
    @CheckForNull
    private Map<String, Object> queue;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ExchangeProperties {

        /**
         * The name of the exchange. It MUST NOT exceed 255 characters long.
         */
        @Nullable
        @CheckForNull
        private String name;

        /**
         * The type of the exchange. Can be either topic, direct, fanout, default or headers.
         */
        @Nullable
        @CheckForNull
        private String type;

        /**
         * Whether the exchange should survive broker restarts or not.
         */
        @Nullable
        @CheckForNull
        private String durable;

        /**
         * Whether the exchange should be deleted when the last queue is unbound from it.
         */
        private boolean autoDelete;

        /**
         * The virtual host of the exchange. Defaults to /.
         */
        @Nullable
        @CheckForNull
        private String vhost;

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class QueueProperties {

        /**
         * The name of the queue. It MUST NOT exceed 255 characters long.
         */
        @Nullable
        @CheckForNull
        private String name;

        /**
         * Whether the queue should survive broker restarts or not.
         */
        private boolean durable;

        /**
         * Whether the queue should be used only by one connection or not.
         */
        private boolean exclusive;

        /**
         * Whether the queue should be deleted when the last consumer unsubscribes.
         */
        private boolean autoDelete;

        /**
         * The virtual host of the queue. Defaults to /.
         */
        @Nullable
        @CheckForNull
        private String vhost;

    }

}
