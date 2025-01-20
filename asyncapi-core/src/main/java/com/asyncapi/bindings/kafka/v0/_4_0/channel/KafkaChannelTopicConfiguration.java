package com.asyncapi.bindings.kafka.v0._4_0.channel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

import java.util.List;

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
public class KafkaChannelTopicConfiguration {

    /**
     * The <a href="https://kafka.apache.org/documentation/#topicconfigs_cleanup.policy">cleanup.policy</a> configuration option.
     * <p>
     * array may only contain delete and/or compact
     */
    @Nullable
    @JsonProperty("cleanup.policy")
    private List<KafkaChannelTopicCleanupPolicy> cleanupPolicy;

    /**
     * The <a href="https://kafka.apache.org/documentation/#topicconfigs_retention.ms">retention.ms</a> configuration option.
     */
    @Nullable
    @javax.validation.constraints.Min(
            value = -1,
            message = "retention.ms must be greater or equals to -1"
    )
    @JsonProperty("retention.ms")
    @JsonPropertyDescription("The [`retention.ms`](https://kafka.apache.org/documentation/#topicconfigs_retention.ms) configuration option.")
    private Integer retentionMs;

    /**
     * The <a href="https://kafka.apache.org/documentation/#topicconfigs_retention.bytes">retention.bytes</a> configuration option.
     */
    @Nullable
    @javax.validation.constraints.Min(
            value = -1,
            message = "retention.bytes must be greater or equals to -1"
    )
    @JsonProperty("retention.bytes")
    @JsonPropertyDescription("The [`retention.bytes`](https://kafka.apache.org/documentation/#topicconfigs_retention.bytes) configuration option.")
    private Integer retentionBytes;

    /**
     * The <a href="https://kafka.apache.org/documentation/#topicconfigs_delete.retention.ms">delete.retention.ms</a> configuration option.
     */
    @Nullable
    @javax.validation.constraints.Min(
            value = 0,
            message = "delete.retention.ms must be greater or equals to 0"
    )
    @JsonProperty("delete.retention.ms")
    @JsonPropertyDescription("The [`delete.retention.ms`](https://kafka.apache.org/documentation/#topicconfigs_delete.retention.ms) configuration option.")
    private Integer deleteRetentionMs;

    /**
     * The <a href="https://kafka.apache.org/documentation/#topicconfigs_max.message.bytes">max.message.bytes</a> configuration option.
     */
    @Nullable
    @javax.validation.constraints.Min(
            value = 0,
            message = "max.message.bytes must be greater or equals to 0"
    )
    @JsonProperty("max.message.bytes")
    @JsonPropertyDescription("The [`max.message.bytes`](https://kafka.apache.org/documentation/#topicconfigs_max.message.bytes) configuration option.")
    private Integer maxMessageBytes;

}
