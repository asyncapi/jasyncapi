package com.asyncapi.bindings.amqp.v0._1_0.channel;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes AMQP 0-9-1 channel type.
 * <p>
 * Contains information about the type of channel in AMQP.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/amqp#channel-binding-object">AMQP channel binding</a>
 * @author Pavel Bodiachevskii
 */
public enum AMQPChannelType {

    @JsonProperty("queue")
    QUEUE,

    @JsonProperty("routingKey")
    @JsonAlias("routingKey")
    ROUTING_KEY

}
