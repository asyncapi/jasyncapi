package com.asyncapi.v2.binding.channel.kafka;

import com.asyncapi.v2.binding.channel.ChannelBinding;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Describes Kafka channel binding.
 *
 * @version 0.4.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/kafka#channel-binding-object">Kafka channel binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class KafkaChannelBinding extends ChannelBinding {

    /**
     * Kafka topic name if different from channel name.
     */
    @Nullable
    private String topic;

    /**
     * Number of partitions configured on this topic (useful to know how many parallel consumers you may run).
     * <p>
     * MUST be positive.
     */
    @Nullable
    private Integer partitions;

    /**
     * Number of replicas configured on this topic.
     * <p>
     * MUST be positive.
     */
    @Nullable
    private Integer replicas;

    /**
     * Topic configuration properties that are relevant for the API.
     */
    @Nullable
    private TopicConfiguration topicConfiguration;

    /**
     * The version of this binding. If omitted, "latest" MUST be assumed.
     */
    @Nullable
    @Builder.Default
    private String bindingVersion = "0.4.0";

    /**
     * This objects contains information about the API relevant topic configuration in Kafka.
     *
     * @version 0.4.0
     * @see <a href="https://github.com/asyncapi/bindings/blob/master/kafka/README.md#topicConfiguration">Kafka channel binding</a>
     * @author Pavel Bodiachevskii
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TopicConfiguration {

        /**
         * The <a href="https://kafka.apache.org/documentation/#topicconfigs_cleanup.policy">cleanup.policy</a> configuration option.
         * <p>
         * array may only contain delete and/or compact
         */
        @Nullable
        @JsonProperty("cleanup.policy")
        private List<String> cleanupPolicy;

        /**
         * The <a href="https://kafka.apache.org/documentation/#topicconfigs_retention.ms">retention.ms</a> configuration option.
         */
        @Nullable
        @JsonProperty("retention.ms")
        private Integer retentionMs;

        /**
         * The <a href="https://kafka.apache.org/documentation/#topicconfigs_retention.bytes">retention.bytes</a> configuration option.
         */
        @Nullable
        @JsonProperty("retention.bytes")
        private Integer retentionBytes;

        /**
         * The <a href="https://kafka.apache.org/documentation/#topicconfigs_delete.retention.ms">delete.retention.ms</a> configuration option.
         */
        @Nullable
        @JsonProperty("delete.retention.ms")
        private Integer deleteRetentionMs;

        /**
         * The <a href="https://kafka.apache.org/documentation/#topicconfigs_max.message.bytes">max.message.bytes</a> configuration option.
         */
        @Nullable
        @JsonProperty("max.message.bytes")
        private Integer maxMessageBytes;

    }

}
