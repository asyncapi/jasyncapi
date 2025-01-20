package com.asyncapi.bindings.anypointmq.v0._0_1.channel;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes Anypoint MQ channel destination type.
 *
 * @see <a href="https://github.com/asyncapi/bindings/blob/master/anypointmq/README.md#channel-binding-object">Anypoint MQ channel binding</a>
 * @see <a href="https://docs.mulesoft.com/mq/">Anypoint MQ</a>
 * @author Pavel Bodiachevskii
 * @version 0.0.1
 * @since 1.0.0-RC2
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
