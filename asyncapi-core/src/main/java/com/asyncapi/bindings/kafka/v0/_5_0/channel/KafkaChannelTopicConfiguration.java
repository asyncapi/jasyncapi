package com.asyncapi.bindings.kafka.v0._5_0.channel;

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
 * @see <a href="https://github.com/asyncapi/bindings/blob/master/kafka/README.md#topicConfiguration">Kafka channel binding</a>
 * @see <a href="https://kafka.apache.org">Kafka</a>
 * @author Pavel Bodiachevskii
 * @version 0.5.0
 * @since 1.0.0-RC2
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

    /**
     * It shows whether the schema validation for the message key is enabled.
     * <p>
     * Vendor specific config.
     * For more details: <a href="https://docs.confluent.io/platform/current/installation/configuration/topic-configs.html#confluent-key-schema-validation">confluent.key.schema.validation</a>
     */
    @Nullable
    @JsonProperty("confluent.key.schema.validation")
    private Boolean confluentKeySchemaValidation;

    /**
     * The name of the schema lookup strategy for the message key.
     * <p>
     * Vendor specific config.
     * For more details: <a href="https://docs.confluent.io/platform/current/installation/configuration/topic-configs.html#confluent-key-subject-name-strategy">confluent.key.subject.name.strategy</a>
     */
    @Nullable
    @JsonProperty("confluent.key.subject.name.strategy")
    private String confluentKeySubjectNameStrategy;

    /**
     * It shows whether the schema validation for the message value is enabled.
     * <p>
     * Vendor specific config.
     * For more details: <a href="https://docs.confluent.io/platform/current/installation/configuration/topic-configs.html#confluent-value-schema-validation">confluent.value.schema.validation</a>
     */
    @Nullable
    @JsonProperty("confluent.value.schema.validation")
    private Boolean confluentValueSchemaValidation;

    /**
     * The name of the schema lookup strategy for the message value.
     * <p>
     * Vendor specific config.
     * For more details: <a href="https://docs.confluent.io/platform/current/installation/configuration/topic-configs.html#confluent-value-subject-name-strategy">confluent.value.subject.name.strategy</a>
     */
    @Nullable
    @JsonProperty("confluent.value.subject.name.strategy")
    private String confluentValueSubjectNameStrategy;

}
