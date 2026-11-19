package com.asyncapi.bindings.kafka.v0._6_0.channel;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Kafka topic message timestamp type: <code>message.timestamp.type</code>.
 *
 * @see <a href="https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_message.timestamp.type">message.timestamp.type</a>
 * @author Pavel Bodiachevskii
 * @version 0.6.0
 * @since 1.0.0-RC6
 */
public enum KafkaChannelTopicMessageTimestampType {

    /**
     * The timestamp the producer set.
     */
    @JsonProperty("CreateTime")
    CREATE_TIME,

    /**
     * The time the broker appended the record.
     */
    @JsonProperty("LogAppendTime")
    LOG_APPEND_TIME

}
