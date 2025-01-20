package com.asyncapi.bindings.kafka.v0._4_0.channel;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum KafkaChannelTopicCleanupPolicy {

    @JsonProperty("compact")
    COMPACT,

    @JsonProperty("delete")
    DELETE

}
