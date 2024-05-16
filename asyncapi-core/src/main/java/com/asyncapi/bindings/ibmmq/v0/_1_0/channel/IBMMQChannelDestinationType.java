package com.asyncapi.bindings.ibmmq.v0._1_0.channel;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes IBM MQ channel destination type.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/ibmmq#channel-binding-object">IBM MQ channel binding</a>
 * @see <a href="https://www.ibm.com/products/mq">IBM MQ</a>
 * @author Pavel Bodiachevskii
 * @version 0.1.0
 * @since 1.0.0-RC2
 */
public enum IBMMQChannelDestinationType {

    @JsonProperty("topic")
    TOPIC,

    @JsonProperty("queue")
    QUEUE

}
