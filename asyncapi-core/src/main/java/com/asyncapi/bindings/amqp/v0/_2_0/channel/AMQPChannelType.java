package com.asyncapi.bindings.amqp.v0._2_0.channel;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes AMQP 0-9-1 channel type.
 * <p>
 * Contains information about the type of channel in AMQP.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/amqp#channel-binding-object">AMQP channel binding</a>
 * @see <a href="https://www.amqp.org">AMQP</a>
 * @author Pavel Bodiachevskii
 * @version 0.2.0
 * @since 1.0.0-RC2
 */
public enum AMQPChannelType {

    @JsonProperty("queue")
    QUEUE,

    @JsonProperty("routingKey")
    @JsonAlias("routingKey")
    ROUTING_KEY

}
