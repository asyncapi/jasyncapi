package com.asyncapi.v2.binding.channel.amqp;

import com.asyncapi.v2.binding.channel.ChannelBinding;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.annotation.CheckForNull;

/**
 * Describes AMQP 0-9-1 channel binding.
 * <p>
 * Contains information about the channel representation in AMQP.
 *
 * @version 0.2.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/amqp#channel-binding-object">AMQP channel binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AMQPChannelBinding extends ChannelBinding {

    /**
     * Defines what type of channel is it. Can be either queue or routingKey (default).
     */
    @CheckForNull
    private String is;

    /**
     * When is=routingKey, this object defines the exchange properties.
     */
    @CheckForNull
    private ExchangeProperties exchange;

    /**
     * When is=queue, this object defines the queue properties.
     */
    @CheckForNull
    private QueueProperties queue;

    @CheckForNull
    @Builder.Default
    private String bindingVersion = "0.2.0";

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class ExchangeProperties {

        /**
         * The name of the exchange. It MUST NOT exceed 255 characters long.
         */
        @CheckForNull
        private String name;

        /**
         * The type of the exchange. Can be either topic, direct, fanout, default or headers.
         */
        @CheckForNull
        private String type;

        /**
         * Whether the exchange should survive broker restarts or not.
         */
        @CheckForNull
        private Boolean durable;

        /**
         * Whether the exchange should be deleted when the last queue is unbound from it.
         */
        @CheckForNull
        private Boolean autoDelete;

        /**
         * The virtual host of the exchange. Defaults to /.
         */
        @CheckForNull
        @Builder.Default
        private String vhost = "/";

    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class QueueProperties {

        /**
         * The name of the queue. It MUST NOT exceed 255 characters long.
         */
        @CheckForNull
        private String name;

        /**
         * Whether the queue should survive broker restarts or not.
         */
        @CheckForNull
        private Boolean durable;

        /**
         * Whether the queue should be used only by one connection or not.
         */
        @CheckForNull
        private Boolean exclusive;

        /**
         * Whether the queue should be deleted when the last consumer unsubscribes.
         */
        @CheckForNull
        private Boolean autoDelete;

        /**
         * The virtual host of the queue. Defaults to /.
         */
        @CheckForNull
        @Builder.Default
        private String vhost = "/";

    }

}
