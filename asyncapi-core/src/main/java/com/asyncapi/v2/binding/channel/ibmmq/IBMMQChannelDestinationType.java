package com.asyncapi.v2.binding.channel.ibmmq;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes IBM MQ channel destination type.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/ibmmq#channel-binding-object">IBM MQ channel binding</a>
 * @author Pavel Bodiachevskii
 */
public enum IBMMQChannelDestinationType {

    @JsonProperty("topic")
    TOPIC,

    @JsonProperty("queue")
    QUEUE

}
