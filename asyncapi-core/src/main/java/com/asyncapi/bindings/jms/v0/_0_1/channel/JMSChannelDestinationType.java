package com.asyncapi.bindings.jms.v0._0_1.channel;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes JMS channel destination type.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/jms#channel-binding-object">JMS channel binding</a>
 * @see <a href="https://www.oracle.com/java/technologies/java-message-service.html">Java Message Service</a>
 * @author Pavel Bodiachevskii
 * @version 0.0.1
 * @since 1.0.0-RC2
 */
public enum JMSChannelDestinationType {

    @JsonProperty("queue")
    QUEUE,

    @JsonProperty("fifo-queue")
    FIFO_QUEUE

}
