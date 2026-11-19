package com.asyncapi.bindings.kafka.v0._6_0.channel;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * This objects contains information about the API relevant topic configuration in Kafka.
 * <p>
 * Every topic setting of Kafka 4.4 is typed, plus the 3 that Kafka 4.0 removed (deprecated, for documents that
 * describe a 3.x broker) and 4 Confluent ones. The binding accepts any other key too: such keys are kept in
 * {@link #getAdditionalProperties()} when read, and written back unchanged.
 * <p>
 * Generated from the 0.6.0 channel binding schema; the Java type of each key is Kafka's own (a Kafka {@code long}
 * is a {@link Long}).
 *
 * @see <a href="https://github.com/asyncapi/bindings/blob/master/kafka/README.md#topicConfiguration">Kafka channel binding</a>
 * @see <a href="https://kafka.apache.org/44/configuration/topic-configs/">Kafka topic configs</a>
 * @author Pavel Bodiachevskii
 * @version 0.6.0
 * @since 1.0.0-RC6
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"additionalProperties"})
public class KafkaChannelTopicConfiguration {

    /**
     * The <a href="https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_cleanup.policy">cleanup.policy</a> configuration option. The retention policy to use on log segments: <code>delete</code> discards old segments when their retention time or size limit has been reached, <code>compact</code> enables log compaction which retains the latest value for each key. Both policies may be specified.
     * <p>
     * Kafka's default: <code>["delete"]</code>.
     */
    @Nullable
    @JsonProperty("cleanup.policy")
    @JsonPropertyDescription("The [`cleanup.policy`](https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_cleanup.policy) configuration option. The retention policy to use on log segments: `delete` discards old segments when their retention time or size limit has been reached, `compact` enables log compaction which retains the latest value for each key. Both policies may be specified.")
    private List<KafkaChannelTopicCleanupPolicy> cleanupPolicy;

    /**
     * The <a href="https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_compression.gzip.level">compression.gzip.level</a> configuration option. The compression level to use if <code>compression.type</code> is set to <code>gzip</code>. Valid values are <code>-1</code> (default level) or <code>1</code> to <code>9</code>.
     * <p>
     * Kafka's default: <code>-1</code>.
     */
    @Nullable
    @jakarta.validation.constraints.Min(value = -1, message = "compression.gzip.level must be greater or equals to -1")
    @jakarta.validation.constraints.Max(value = 9, message = "compression.gzip.level must be less or equals to 9")
    @JsonProperty("compression.gzip.level")
    @JsonPropertyDescription("The [`compression.gzip.level`](https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_compression.gzip.level) configuration option. The compression level to use if `compression.type` is set to `gzip`. Valid values are `-1` (default level) or `1` to `9`.")
    private Integer compressionGzipLevel;

    /**
     * The <a href="https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_compression.lz4.level">compression.lz4.level</a> configuration option. The compression level to use if <code>compression.type</code> is set to <code>lz4</code>.
     * <p>
     * Kafka's default: <code>9</code>.
     */
    @Nullable
    @jakarta.validation.constraints.Min(value = 1, message = "compression.lz4.level must be greater or equals to 1")
    @jakarta.validation.constraints.Max(value = 17, message = "compression.lz4.level must be less or equals to 17")
    @JsonProperty("compression.lz4.level")
    @JsonPropertyDescription("The [`compression.lz4.level`](https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_compression.lz4.level) configuration option. The compression level to use if `compression.type` is set to `lz4`.")
    private Integer compressionLz4Level;

    /**
     * The <a href="https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_compression.type">compression.type</a> configuration option. The final compression type for the topic. <code>uncompressed</code> means no compression, <code>producer</code> means retain the original compression codec set by the producer.
     * <p>
     * Kafka's default: <code>"producer"</code>.
     */
    @Nullable
    @JsonProperty("compression.type")
    @JsonPropertyDescription("The [`compression.type`](https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_compression.type) configuration option. The final compression type for the topic. `uncompressed` means no compression, `producer` means retain the original compression codec set by the producer.")
    private KafkaChannelTopicCompressionType compressionType;

    /**
     * The <a href="https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_compression.zstd.level">compression.zstd.level</a> configuration option. The compression level to use if <code>compression.type</code> is set to <code>zstd</code>.
     * <p>
     * Kafka's default: <code>3</code>.
     */
    @Nullable
    @jakarta.validation.constraints.Min(value = -131072, message = "compression.zstd.level must be greater or equals to -131072")
    @jakarta.validation.constraints.Max(value = 22, message = "compression.zstd.level must be less or equals to 22")
    @JsonProperty("compression.zstd.level")
    @JsonPropertyDescription("The [`compression.zstd.level`](https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_compression.zstd.level) configuration option. The compression level to use if `compression.type` is set to `zstd`.")
    private Integer compressionZstdLevel;

    /**
     * The <a href="https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_delete.retention.ms">delete.retention.ms</a> configuration option. The amount of time (in milliseconds) to retain delete tombstone markers for log compacted topics.
     * <p>
     * Kafka's default: <code>86400000</code>.
     */
    @Nullable
    @jakarta.validation.constraints.Min(value = 0L, message = "delete.retention.ms must be greater or equals to 0")
    @JsonProperty("delete.retention.ms")
    @JsonPropertyDescription("The [`delete.retention.ms`](https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_delete.retention.ms) configuration option. The amount of time (in milliseconds) to retain delete tombstone markers for log compacted topics.")
    private Long deleteRetentionMs;

    /**
     * The <a href="https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_errors.deadletterqueue.group.enable">errors.deadletterqueue.group.enable</a> configuration option. Whether share groups are allowed to use this topic as a dead-letter queue for undeliverable records. Since Kafka 4.4.
     * <p>
     * Kafka's default: <code>false</code>.
     */
    @Nullable
    @JsonProperty("errors.deadletterqueue.group.enable")
    @JsonPropertyDescription("The [`errors.deadletterqueue.group.enable`](https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_errors.deadletterqueue.group.enable) configuration option. Whether share groups are allowed to use this topic as a dead-letter queue for undeliverable records. Since Kafka 4.4.")
    private Boolean errorsDeadletterqueueGroupEnable;

    /**
     * The <a href="https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_file.delete.delay.ms">file.delete.delay.ms</a> configuration option. The time (in milliseconds) to wait before deleting a file from the filesystem.
     * <p>
     * Kafka's default: <code>60000</code>.
     */
    @Nullable
    @jakarta.validation.constraints.Min(value = 0L, message = "file.delete.delay.ms must be greater or equals to 0")
    @JsonProperty("file.delete.delay.ms")
    @JsonPropertyDescription("The [`file.delete.delay.ms`](https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_file.delete.delay.ms) configuration option. The time (in milliseconds) to wait before deleting a file from the filesystem.")
    private Long fileDeleteDelayMs;

    /**
     * The <a href="https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_flush.messages">flush.messages</a> configuration option. The number of messages written to a log partition before forcing an fsync on the log.
     * <p>
     * Kafka's default: <code>9223372036854775807</code>.
     */
    @Nullable
    @jakarta.validation.constraints.Min(value = 1L, message = "flush.messages must be greater or equals to 1")
    @JsonProperty("flush.messages")
    @JsonPropertyDescription("The [`flush.messages`](https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_flush.messages) configuration option. The number of messages written to a log partition before forcing an fsync on the log.")
    private Long flushMessages;

    /**
     * The <a href="https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_flush.ms">flush.ms</a> configuration option. The maximum time (in milliseconds) a message can sit in a log before forcing an fsync.
     * <p>
     * Kafka's default: <code>9223372036854775807</code>.
     */
    @Nullable
    @jakarta.validation.constraints.Min(value = 0L, message = "flush.ms must be greater or equals to 0")
    @JsonProperty("flush.ms")
    @JsonPropertyDescription("The [`flush.ms`](https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_flush.ms) configuration option. The maximum time (in milliseconds) a message can sit in a log before forcing an fsync.")
    private Long flushMs;

    /**
     * The <a href="https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_follower.replication.throttled.replicas">follower.replication.throttled.replicas</a> configuration option. A list of replicas for which log replication should be throttled on the follower side, in the form <code>[PartitionId]:[BrokerId]</code>, or the wildcard <code>*</code> to throttle all replicas for this topic.
     * <p>
     * Kafka's default: <code>[]</code>.
     */
    @Nullable
    @JsonProperty("follower.replication.throttled.replicas")
    @JsonPropertyDescription("The [`follower.replication.throttled.replicas`](https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_follower.replication.throttled.replicas) configuration option. A list of replicas for which log replication should be throttled on the follower side, in the form `[PartitionId]:[BrokerId]`, or the wildcard `*` to throttle all replicas for this topic.")
    private List<String> followerReplicationThrottledReplicas;

    /**
     * The <a href="https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_index.interval.bytes">index.interval.bytes</a> configuration option. How frequently (in bytes of log data) Kafka adds an entry to its offset and time index.
     * <p>
     * Kafka's default: <code>4096</code>.
     */
    @Nullable
    @jakarta.validation.constraints.Min(value = 0, message = "index.interval.bytes must be greater or equals to 0")
    @JsonProperty("index.interval.bytes")
    @JsonPropertyDescription("The [`index.interval.bytes`](https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_index.interval.bytes) configuration option. How frequently (in bytes of log data) Kafka adds an entry to its offset and time index.")
    private Integer indexIntervalBytes;

    /**
     * The <a href="https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_leader.replication.throttled.replicas">leader.replication.throttled.replicas</a> configuration option. A list of replicas for which log replication should be throttled on the leader side, in the form <code>[PartitionId]:[BrokerId]</code>, or the wildcard <code>*</code> to throttle all replicas for this topic.
     * <p>
     * Kafka's default: <code>[]</code>.
     */
    @Nullable
    @JsonProperty("leader.replication.throttled.replicas")
    @JsonPropertyDescription("The [`leader.replication.throttled.replicas`](https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_leader.replication.throttled.replicas) configuration option. A list of replicas for which log replication should be throttled on the leader side, in the form `[PartitionId]:[BrokerId]`, or the wildcard `*` to throttle all replicas for this topic.")
    private List<String> leaderReplicationThrottledReplicas;

    /**
     * The <a href="https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_local.retention.bytes">local.retention.bytes</a> configuration option. The maximum size local log segments can grow for a partition before old segments are deleted (tiered storage). <code>-2</code> means the value of <code>retention.bytes</code> is used.
     * <p>
     * Kafka's default: <code>-2</code>.
     */
    @Nullable
    @jakarta.validation.constraints.Min(value = -2L, message = "local.retention.bytes must be greater or equals to -2")
    @JsonProperty("local.retention.bytes")
    @JsonPropertyDescription("The [`local.retention.bytes`](https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_local.retention.bytes) configuration option. The maximum size local log segments can grow for a partition before old segments are deleted (tiered storage). `-2` means the value of `retention.bytes` is used.")
    private Long localRetentionBytes;

    /**
     * The <a href="https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_local.retention.ms">local.retention.ms</a> configuration option. The time (in milliseconds) to retain a local log segment before it is deleted (tiered storage). <code>-2</code> means the value of <code>retention.ms</code> is used.
     * <p>
     * Kafka's default: <code>-2</code>.
     */
    @Nullable
    @jakarta.validation.constraints.Min(value = -2L, message = "local.retention.ms must be greater or equals to -2")
    @JsonProperty("local.retention.ms")
    @JsonPropertyDescription("The [`local.retention.ms`](https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_local.retention.ms) configuration option. The time (in milliseconds) to retain a local log segment before it is deleted (tiered storage). `-2` means the value of `retention.ms` is used.")
    private Long localRetentionMs;

    /**
     * The <a href="https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_max.compaction.lag.ms">max.compaction.lag.ms</a> configuration option. The maximum time (in milliseconds) a message will remain ineligible for compaction in the log.
     * <p>
     * Kafka's default: <code>9223372036854775807</code>.
     */
    @Nullable
    @jakarta.validation.constraints.Min(value = 1L, message = "max.compaction.lag.ms must be greater or equals to 1")
    @JsonProperty("max.compaction.lag.ms")
    @JsonPropertyDescription("The [`max.compaction.lag.ms`](https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_max.compaction.lag.ms) configuration option. The maximum time (in milliseconds) a message will remain ineligible for compaction in the log.")
    private Long maxCompactionLagMs;

    /**
     * The <a href="https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_max.decompressed.message.bytes">max.decompressed.message.bytes</a> configuration option. The maximum decompressed size (in bytes) of a single record that the broker accepts. Since Kafka 4.2.
     * <p>
     * Kafka's default: <code>2147483639</code>.
     */
    @Nullable
    @jakarta.validation.constraints.Min(value = 1, message = "max.decompressed.message.bytes must be greater or equals to 1")
    @jakarta.validation.constraints.Max(value = 2147483639, message = "max.decompressed.message.bytes must be less or equals to 2147483639")
    @JsonProperty("max.decompressed.message.bytes")
    @JsonPropertyDescription("The [`max.decompressed.message.bytes`](https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_max.decompressed.message.bytes) configuration option. The maximum decompressed size (in bytes) of a single record that the broker accepts. Since Kafka 4.2.")
    private Integer maxDecompressedMessageBytes;

    /**
     * The <a href="https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_max.message.bytes">max.message.bytes</a> configuration option. The largest record batch size (in bytes, after compression if enabled) allowed by Kafka.
     * <p>
     * Kafka's default: <code>1048588</code>.
     */
    @Nullable
    @jakarta.validation.constraints.Min(value = 0, message = "max.message.bytes must be greater or equals to 0")
    @JsonProperty("max.message.bytes")
    @JsonPropertyDescription("The [`max.message.bytes`](https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_max.message.bytes) configuration option. The largest record batch size (in bytes, after compression if enabled) allowed by Kafka.")
    private Integer maxMessageBytes;

    /**
     * The <a href="https://kafka.apache.org/39/documentation.html#topicconfigs_message.downconversion.enable">message.downconversion.enable</a> configuration option. Whether down-conversion of message formats is enabled to satisfy consume requests from older clients. Removed in Kafka 4.0.
     * <p>
     * Kafka's default: <code>true</code>.
     *
     * @deprecated since Kafka 3.0, removed in Kafka 4.0. Removed in Kafka 4.0 (KIP-724/KIP-896). Clients older than 0.11 are no longer supported; upgrade consumers instead of relying on down-conversion and drop this setting.
     */
    @Nullable
    @Deprecated
    @JsonProperty("message.downconversion.enable")
    @JsonPropertyDescription("The [`message.downconversion.enable`](https://kafka.apache.org/39/documentation.html#topicconfigs_message.downconversion.enable) configuration option. Whether down-conversion of message formats is enabled to satisfy consume requests from older clients. Removed in Kafka 4.0.")
    private Boolean messageDownconversionEnable;

    /**
     * The <a href="https://kafka.apache.org/39/documentation.html#topicconfigs_message.format.version">message.format.version</a> configuration option. The message format version the broker uses to append messages to the logs (e.g. <code>0.10.0</code>, <code>2.8-IV1</code>, <code>3.0-IV1</code>). Removed in Kafka 4.0.
     * <p>
     * Kafka's default: <code>"3.0-IV1"</code>.
     *
     * @deprecated since Kafka 3.0, removed in Kafka 4.0. Removed in Kafka 4.0 (KIP-724). The broker always writes message format v2 (record batches); drop this setting.
     */
    @Nullable
    @Deprecated
    @JsonProperty("message.format.version")
    @JsonPropertyDescription("The [`message.format.version`](https://kafka.apache.org/39/documentation.html#topicconfigs_message.format.version) configuration option. The message format version the broker uses to append messages to the logs (e.g. `0.10.0`, `2.8-IV1`, `3.0-IV1`). Removed in Kafka 4.0.")
    private String messageFormatVersion;

    /**
     * The <a href="https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_message.timestamp.after.max.ms">message.timestamp.after.max.ms</a> configuration option. The maximum allowed difference (in milliseconds) by which a message timestamp may be later than the broker's timestamp when <code>message.timestamp.type</code> is <code>CreateTime</code>. The default changed in Kafka 4.0 from <code>9223372036854775807</code> to <code>3600000</code>; choose the value that matches your broker version.
     * <p>
     * Kafka's default: <code>3600000</code>.
     */
    @Nullable
    @jakarta.validation.constraints.Min(value = 0L, message = "message.timestamp.after.max.ms must be greater or equals to 0")
    @JsonProperty("message.timestamp.after.max.ms")
    @JsonPropertyDescription("The [`message.timestamp.after.max.ms`](https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_message.timestamp.after.max.ms) configuration option. The maximum allowed difference (in milliseconds) by which a message timestamp may be later than the broker's timestamp when `message.timestamp.type` is `CreateTime`. The default changed in Kafka 4.0 from `9223372036854775807` to `3600000`; choose the value that matches your broker version.")
    private Long messageTimestampAfterMaxMs;

    /**
     * The <a href="https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_message.timestamp.before.max.ms">message.timestamp.before.max.ms</a> configuration option. The maximum allowed difference (in milliseconds) by which a message timestamp may be earlier than the broker's timestamp when <code>message.timestamp.type</code> is <code>CreateTime</code>.
     * <p>
     * Kafka's default: <code>9223372036854775807</code>.
     */
    @Nullable
    @jakarta.validation.constraints.Min(value = 0L, message = "message.timestamp.before.max.ms must be greater or equals to 0")
    @JsonProperty("message.timestamp.before.max.ms")
    @JsonPropertyDescription("The [`message.timestamp.before.max.ms`](https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_message.timestamp.before.max.ms) configuration option. The maximum allowed difference (in milliseconds) by which a message timestamp may be earlier than the broker's timestamp when `message.timestamp.type` is `CreateTime`.")
    private Long messageTimestampBeforeMaxMs;

    /**
     * The <a href="https://kafka.apache.org/39/documentation.html#topicconfigs_message.timestamp.difference.max.ms">message.timestamp.difference.max.ms</a> configuration option. The maximum difference (in milliseconds) allowed between the timestamp when a broker receives a message and the timestamp specified in the message. Removed in Kafka 4.0.
     * <p>
     * Kafka's default: <code>9223372036854775807</code>.
     *
     * @deprecated since Kafka 3.6, removed in Kafka 4.0. Removed in Kafka 4.0 (KIP-937). Use <code>message.timestamp.before.max.ms</code> and <code>message.timestamp.after.max.ms</code> instead.
     */
    @Nullable
    @Deprecated
    @jakarta.validation.constraints.Min(value = 0L, message = "message.timestamp.difference.max.ms must be greater or equals to 0")
    @JsonProperty("message.timestamp.difference.max.ms")
    @JsonPropertyDescription("The [`message.timestamp.difference.max.ms`](https://kafka.apache.org/39/documentation.html#topicconfigs_message.timestamp.difference.max.ms) configuration option. The maximum difference (in milliseconds) allowed between the timestamp when a broker receives a message and the timestamp specified in the message. Removed in Kafka 4.0.")
    private Long messageTimestampDifferenceMaxMs;

    /**
     * The <a href="https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_message.timestamp.type">message.timestamp.type</a> configuration option. Whether the timestamp in the message is the message create time (<code>CreateTime</code>) or the log append time (<code>LogAppendTime</code>).
     * <p>
     * Kafka's default: <code>"CreateTime"</code>.
     */
    @Nullable
    @JsonProperty("message.timestamp.type")
    @JsonPropertyDescription("The [`message.timestamp.type`](https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_message.timestamp.type) configuration option. Whether the timestamp in the message is the message create time (`CreateTime`) or the log append time (`LogAppendTime`).")
    private KafkaChannelTopicMessageTimestampType messageTimestampType;

    /**
     * The <a href="https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_min.cleanable.dirty.ratio">min.cleanable.dirty.ratio</a> configuration option. The minimum ratio of dirty log to total log for the log compactor to attempt to clean the log.
     * <p>
     * Kafka's default: <code>0.5</code>.
     */
    @Nullable
    @jakarta.validation.constraints.DecimalMin(value = "0", message = "min.cleanable.dirty.ratio must be greater or equals to 0")
    @jakarta.validation.constraints.DecimalMax(value = "1", message = "min.cleanable.dirty.ratio must be less or equals to 1")
    @JsonProperty("min.cleanable.dirty.ratio")
    @JsonPropertyDescription("The [`min.cleanable.dirty.ratio`](https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_min.cleanable.dirty.ratio) configuration option. The minimum ratio of dirty log to total log for the log compactor to attempt to clean the log.")
    private Double minCleanableDirtyRatio;

    /**
     * The <a href="https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_min.compaction.lag.ms">min.compaction.lag.ms</a> configuration option. The minimum time (in milliseconds) a message will remain uncompacted in the log.
     * <p>
     * Kafka's default: <code>0</code>.
     */
    @Nullable
    @jakarta.validation.constraints.Min(value = 0L, message = "min.compaction.lag.ms must be greater or equals to 0")
    @JsonProperty("min.compaction.lag.ms")
    @JsonPropertyDescription("The [`min.compaction.lag.ms`](https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_min.compaction.lag.ms) configuration option. The minimum time (in milliseconds) a message will remain uncompacted in the log.")
    private Long minCompactionLagMs;

    /**
     * The <a href="https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_min.insync.replicas">min.insync.replicas</a> configuration option. The minimum number of replicas that must acknowledge a write for it to be considered successful when the producer sets <code>acks</code> to <code>all</code>.
     * <p>
     * Kafka's default: <code>1</code>.
     */
    @Nullable
    @jakarta.validation.constraints.Min(value = 1, message = "min.insync.replicas must be greater or equals to 1")
    @JsonProperty("min.insync.replicas")
    @JsonPropertyDescription("The [`min.insync.replicas`](https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_min.insync.replicas) configuration option. The minimum number of replicas that must acknowledge a write for it to be considered successful when the producer sets `acks` to `all`.")
    private Integer minInsyncReplicas;

    /**
     * The <a href="https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_preallocate">preallocate</a> configuration option. Whether to preallocate the file on disk when creating a new log segment.
     * <p>
     * Kafka's default: <code>false</code>.
     */
    @Nullable
    @JsonProperty("preallocate")
    @JsonPropertyDescription("The [`preallocate`](https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_preallocate) configuration option. Whether to preallocate the file on disk when creating a new log segment.")
    private Boolean preallocate;

    /**
     * The <a href="https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_remote.copy.lag.bytes">remote.copy.lag.bytes</a> configuration option. The size-based threshold (in bytes) for copying non-active log segments to remote storage (tiered storage). Since Kafka 4.4.
     * <p>
     * Kafka's default: <code>-1</code>.
     */
    @Nullable
    @jakarta.validation.constraints.Min(value = -1L, message = "remote.copy.lag.bytes must be greater or equals to -1")
    @JsonProperty("remote.copy.lag.bytes")
    @JsonPropertyDescription("The [`remote.copy.lag.bytes`](https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_remote.copy.lag.bytes) configuration option. The size-based threshold (in bytes) for copying non-active log segments to remote storage (tiered storage). Since Kafka 4.4.")
    private Long remoteCopyLagBytes;

    /**
     * The <a href="https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_remote.copy.lag.ms">remote.copy.lag.ms</a> configuration option. The time-based threshold (in milliseconds) for copying non-active log segments to remote storage (tiered storage). Since Kafka 4.4.
     * <p>
     * Kafka's default: <code>0</code>.
     */
    @Nullable
    @jakarta.validation.constraints.Min(value = -1L, message = "remote.copy.lag.ms must be greater or equals to -1")
    @JsonProperty("remote.copy.lag.ms")
    @JsonPropertyDescription("The [`remote.copy.lag.ms`](https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_remote.copy.lag.ms) configuration option. The time-based threshold (in milliseconds) for copying non-active log segments to remote storage (tiered storage). Since Kafka 4.4.")
    private Long remoteCopyLagMs;

    /**
     * The <a href="https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_remote.log.copy.disable">remote.log.copy.disable</a> configuration option. Whether to disable copying of log segments to remote storage, making the tiered data read-only.
     * <p>
     * Kafka's default: <code>false</code>.
     */
    @Nullable
    @JsonProperty("remote.log.copy.disable")
    @JsonPropertyDescription("The [`remote.log.copy.disable`](https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_remote.log.copy.disable) configuration option. Whether to disable copying of log segments to remote storage, making the tiered data read-only.")
    private Boolean remoteLogCopyDisable;

    /**
     * The <a href="https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_remote.log.delete.on.disable">remote.log.delete.on.disable</a> configuration option. Whether tiered data is deleted when tiered storage is disabled on the topic. Must be <code>true</code> when setting <code>remote.storage.enable</code> to <code>false</code>.
     * <p>
     * Kafka's default: <code>false</code>.
     */
    @Nullable
    @JsonProperty("remote.log.delete.on.disable")
    @JsonPropertyDescription("The [`remote.log.delete.on.disable`](https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_remote.log.delete.on.disable) configuration option. Whether tiered data is deleted when tiered storage is disabled on the topic. Must be `true` when setting `remote.storage.enable` to `false`.")
    private Boolean remoteLogDeleteOnDisable;

    /**
     * The <a href="https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_remote.storage.enable">remote.storage.enable</a> configuration option. Whether tiered storage is enabled for the topic.
     * <p>
     * Kafka's default: <code>false</code>.
     */
    @Nullable
    @JsonProperty("remote.storage.enable")
    @JsonPropertyDescription("The [`remote.storage.enable`](https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_remote.storage.enable) configuration option. Whether tiered storage is enabled for the topic.")
    private Boolean remoteStorageEnable;

    /**
     * The <a href="https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_retention.bytes">retention.bytes</a> configuration option. The maximum size (in bytes) a partition can grow to before old log segments are discarded when using the <code>delete</code> retention policy. <code>-1</code> means no size limit.
     * <p>
     * Kafka's default: <code>-1</code>.
     */
    @Nullable
    @jakarta.validation.constraints.Min(value = -1L, message = "retention.bytes must be greater or equals to -1")
    @JsonProperty("retention.bytes")
    @JsonPropertyDescription("The [`retention.bytes`](https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_retention.bytes) configuration option. The maximum size (in bytes) a partition can grow to before old log segments are discarded when using the `delete` retention policy. `-1` means no size limit.")
    private Long retentionBytes;

    /**
     * The <a href="https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_retention.ms">retention.ms</a> configuration option. The maximum time (in milliseconds) a log is retained before old log segments are discarded when using the <code>delete</code> retention policy. <code>-1</code> means no time limit.
     * <p>
     * Kafka's default: <code>604800000</code>.
     */
    @Nullable
    @jakarta.validation.constraints.Min(value = -1L, message = "retention.ms must be greater or equals to -1")
    @JsonProperty("retention.ms")
    @JsonPropertyDescription("The [`retention.ms`](https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_retention.ms) configuration option. The maximum time (in milliseconds) a log is retained before old log segments are discarded when using the `delete` retention policy. `-1` means no time limit.")
    private Long retentionMs;

    /**
     * The <a href="https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_segment.bytes">segment.bytes</a> configuration option. The segment file size (in bytes) for the log. Validation follows Kafka 4.1+ (<code>>= 1048576</code>); Kafka versions before 4.1 accept values <code>>= 14</code>, so choose the value that matches your broker version at runtime.
     * <p>
     * Kafka's default: <code>1073741824</code>.
     */
    @Nullable
    @jakarta.validation.constraints.Min(value = 1048576, message = "segment.bytes must be greater or equals to 1048576")
    @JsonProperty("segment.bytes")
    @JsonPropertyDescription("The [`segment.bytes`](https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_segment.bytes) configuration option. The segment file size (in bytes) for the log. Validation follows Kafka 4.1+ (`>= 1048576`); Kafka versions before 4.1 accept values `>= 14`, so choose the value that matches your broker version at runtime.")
    private Integer segmentBytes;

    /**
     * The <a href="https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_segment.index.bytes">segment.index.bytes</a> configuration option. The size (in bytes) of the index that maps offsets to file positions.
     * <p>
     * Kafka's default: <code>10485760</code>.
     */
    @Nullable
    @jakarta.validation.constraints.Min(value = 4, message = "segment.index.bytes must be greater or equals to 4")
    @JsonProperty("segment.index.bytes")
    @JsonPropertyDescription("The [`segment.index.bytes`](https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_segment.index.bytes) configuration option. The size (in bytes) of the index that maps offsets to file positions.")
    private Integer segmentIndexBytes;

    /**
     * The <a href="https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_segment.jitter.ms">segment.jitter.ms</a> configuration option. The maximum random jitter (in milliseconds) subtracted from the scheduled segment roll time to avoid thundering herds of segment rolling.
     * <p>
     * Kafka's default: <code>0</code>.
     */
    @Nullable
    @jakarta.validation.constraints.Min(value = 0L, message = "segment.jitter.ms must be greater or equals to 0")
    @JsonProperty("segment.jitter.ms")
    @JsonPropertyDescription("The [`segment.jitter.ms`](https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_segment.jitter.ms) configuration option. The maximum random jitter (in milliseconds) subtracted from the scheduled segment roll time to avoid thundering herds of segment rolling.")
    private Long segmentJitterMs;

    /**
     * The <a href="https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_segment.ms">segment.ms</a> configuration option. The period of time (in milliseconds) after which Kafka forces the log to roll even if the segment file is not full.
     * <p>
     * Kafka's default: <code>604800000</code>.
     */
    @Nullable
    @jakarta.validation.constraints.Min(value = 1L, message = "segment.ms must be greater or equals to 1")
    @JsonProperty("segment.ms")
    @JsonPropertyDescription("The [`segment.ms`](https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_segment.ms) configuration option. The period of time (in milliseconds) after which Kafka forces the log to roll even if the segment file is not full.")
    private Long segmentMs;

    /**
     * The <a href="https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_unclean.leader.election.enable">unclean.leader.election.enable</a> configuration option. Whether to enable replicas not in the ISR set to be elected as leader as a last resort, even though doing so may result in data loss.
     * <p>
     * Kafka's default: <code>false</code>.
     */
    @Nullable
    @JsonProperty("unclean.leader.election.enable")
    @JsonPropertyDescription("The [`unclean.leader.election.enable`](https://kafka.apache.org/44/configuration/topic-configs/#topicconfigs_unclean.leader.election.enable) configuration option. Whether to enable replicas not in the ISR set to be elected as leader as a last resort, even though doing so may result in data loss.")
    private Boolean uncleanLeaderElectionEnable;

    /**
     * It shows whether the schema validation for the message key is enabled. Vendor specific config. For more details: (https://docs.confluent.io/platform/current/installation/configuration/topic-configs.html#confluent-key-schema-validation)
     */
    @Nullable
    @JsonProperty("confluent.key.schema.validation")
    @JsonPropertyDescription("It shows whether the schema validation for the message key is enabled. Vendor specific config. For more details: (https://docs.confluent.io/platform/current/installation/configuration/topic-configs.html#confluent-key-schema-validation)")
    private Boolean confluentKeySchemaValidation;

    /**
     * The name of the schema lookup strategy for the message key. Vendor specific config. For more details: (https://docs.confluent.io/platform/current/installation/configuration/topic-configs.html#confluent-key-subject-name-strategy)
     */
    @Nullable
    @JsonProperty("confluent.key.subject.name.strategy")
    @JsonPropertyDescription("The name of the schema lookup strategy for the message key. Vendor specific config. For more details: (https://docs.confluent.io/platform/current/installation/configuration/topic-configs.html#confluent-key-subject-name-strategy)")
    private String confluentKeySubjectNameStrategy;

    /**
     * It shows whether the schema validation for the message value is enabled. Vendor specific config. For more details: (https://docs.confluent.io/platform/current/installation/configuration/topic-configs.html#confluent-value-schema-validation)
     */
    @Nullable
    @JsonProperty("confluent.value.schema.validation")
    @JsonPropertyDescription("It shows whether the schema validation for the message value is enabled. Vendor specific config. For more details: (https://docs.confluent.io/platform/current/installation/configuration/topic-configs.html#confluent-value-schema-validation)")
    private Boolean confluentValueSchemaValidation;

    /**
     * The name of the schema lookup strategy for the message value. Vendor specific config. For more details: (https://docs.confluent.io/platform/current/installation/configuration/topic-configs.html#confluent-value-subject-name-strategy)
     */
    @Nullable
    @JsonProperty("confluent.value.subject.name.strategy")
    @JsonPropertyDescription("The name of the schema lookup strategy for the message value. Vendor specific config. For more details: (https://docs.confluent.io/platform/current/installation/configuration/topic-configs.html#confluent-value-subject-name-strategy)")
    private String confluentValueSubjectNameStrategy;

    /**
     * Topic configuration keys this binding version does not type, as read: Kafka settings newer than the
     * binding, vendor settings, or anything else. Written back after the typed keys, in the order they were read.
     */
    @Nullable
    @JsonAnyGetter
    private Map<String, Object> additionalProperties;

    /**
     * Keeps a key this binding version does not type.
     *
     * @param name  the topic configuration key
     * @param value its value, as read
     */
    @JsonAnySetter
    public void setAdditionalProperty(@NotNull String name, @Nullable Object value) {
        if (additionalProperties == null) {
            additionalProperties = new LinkedHashMap<>();
        }

        additionalProperties.put(name, value);
    }

}
