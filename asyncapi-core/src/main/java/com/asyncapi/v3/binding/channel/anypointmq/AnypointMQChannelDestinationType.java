package com.asyncapi.v3.binding.channel.anypointmq;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes Anypoint MQ channel destination type.
 *
 * @version 0.0.1
 * @see <a href="https://github.com/asyncapi/bindings/blob/master/anypointmq/README.md#channel-binding-object">Anypoint MQ channel binding</a>
 * @author Pavel Bodiachevskii
 */
@JsonClassDescription("Describes Anypoint MQ channel destination type.")
public enum AnypointMQChannelDestinationType {

    @JsonProperty("exchange")
    EXCHANGE,

    @JsonProperty("queue")
    QUEUE,

    @JsonProperty("fifo-queue")
    FIFO_QUEUE

}
