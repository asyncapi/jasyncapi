package com.asyncapi.bindings.kafka.v0._6_0.channel;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Kafka topic compression type: <code>compression.type</code>.
 * <p>
 * <code>producer</code> keeps the codec the producer used; <code>uncompressed</code> stores records uncompressed.
 *
 * @see <a href="https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_compression.type">compression.type</a>
 * @author Pavel Bodiachevskii
 * @version 0.6.0
 * @since 1.0.0-RC6
 */
public enum KafkaChannelTopicCompressionType {

    @JsonProperty("uncompressed")
    UNCOMPRESSED,

    @JsonProperty("zstd")
    ZSTD,

    @JsonProperty("lz4")
    LZ4,

    @JsonProperty("snappy")
    SNAPPY,

    @JsonProperty("gzip")
    GZIP,

    @JsonProperty("producer")
    PRODUCER

}
