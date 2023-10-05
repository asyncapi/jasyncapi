package com.asyncapi.v3.binding.channel.kafka;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum KafkaChannelTopicCleanupPolicy {

    @JsonProperty("compact")
    COMPACT,

    @JsonProperty("delete")
    DELETE

}
