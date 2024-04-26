package com.asyncapi.bindings.amqp.v0._3_0.channel.exchange;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes AMQP 0-9-1 channel exchange type.
 * <p>
 * Contains information about the channel exchange type in AMQP.
 *
 * @version 0.3.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/amqp#channel-binding-object">AMQP channel binding</a>
 * @author Pavel Bodiachevskii
 */
@JsonClassDescription("Describes AMQP 0-9-1 channel exchange type.")
public enum AMQPChannelExchangeType {

    @JsonProperty("topic")
    TOPIC,

    @JsonProperty("direct")
    DIRECT,

    @JsonProperty("fanout")
    FANOUT,

    @JsonProperty("default")
    DEFAULT,

    @JsonProperty("headers")
    HEADERS

}
