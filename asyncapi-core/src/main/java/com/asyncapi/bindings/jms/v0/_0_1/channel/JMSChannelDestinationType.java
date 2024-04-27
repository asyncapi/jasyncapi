package com.asyncapi.bindings.jms.v0._0_1.channel;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum JMSChannelDestinationType {

    @JsonProperty("queue")
    QUEUE,

    @JsonProperty("fifo-queue")
    FIFO_QUEUE

}
