package com.asyncapi.bindings.kafka;

import com.asyncapi.bindings.BindingTest;
import com.asyncapi.bindings.kafka.v0._6_0.channel.KafkaChannelBinding;
import com.asyncapi.bindings.kafka.v0._6_0.channel.KafkaChannelTopicCleanupPolicy;
import com.asyncapi.bindings.kafka.v0._6_0.channel.KafkaChannelTopicCompressionType;
import com.asyncapi.bindings.kafka.v0._6_0.channel.KafkaChannelTopicConfiguration;
import com.asyncapi.bindings.kafka.v0._6_0.channel.KafkaChannelTopicMessageTimestampType;
import com.asyncapi.bindings.kafka.v0._6_0.message.KafkaMessageBinding;
import com.asyncapi.bindings.kafka.v0._6_0.message.KafkaMessageSchemaIdLocation;
import com.asyncapi.bindings.kafka.v0._6_0.operation.KafkaOperationBinding;
import com.asyncapi.bindings.kafka.v0._6_0.operation.KafkaOperationGroupType;
import com.asyncapi.bindings.kafka.v0._6_0.operation.KafkaOperationIsolationLevel;
import com.asyncapi.bindings.kafka.v0._6_0.server.KafkaServerBinding;
import com.asyncapi.schemas.Type;
import com.asyncapi.schemas.asyncapi.AsyncAPISchema;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@DisplayName("0.6.0")
public class KafkaV0_6_0Test {

    /**
     * Every typed key, with values that only fit the Java type Kafka gives the key (a {@code long} beyond
     * {@link Integer#MAX_VALUE}, for example), plus two keys the binding does not type.
     */
    @SuppressWarnings("deprecation")
    public static KafkaChannelBinding channelBinding () {
        Map<String, Object> untyped = new LinkedHashMap<>();
        untyped.put("future.topic.setting", "a value");
        untyped.put("vendor.topic.flag", true);

        return KafkaChannelBinding.builder()
                .topic("my-specific-topic-name")
                .partitions(20)
                .replicas(3)
                .topicConfiguration(KafkaChannelTopicConfiguration.builder()
                        .cleanupPolicy(List.of(
                                KafkaChannelTopicCleanupPolicy.DELETE,
                                KafkaChannelTopicCleanupPolicy.COMPACT
                        ))
                        .compressionGzipLevel(6)
                        .compressionLz4Level(9)
                        .compressionType(KafkaChannelTopicCompressionType.ZSTD)
                        .compressionZstdLevel(3)
                        .deleteRetentionMs(86_400_000L)
                        .errorsDeadletterqueueGroupEnable(false)
                        .fileDeleteDelayMs(60_000L)
                        .flushMessages(Long.MAX_VALUE)
                        .flushMs(Long.MAX_VALUE)
                        .followerReplicationThrottledReplicas(List.of("0:1", "1:2"))
                        .indexIntervalBytes(4096)
                        .leaderReplicationThrottledReplicas(List.of("*"))
                        .localRetentionBytes(-2L)
                        .localRetentionMs(-2L)
                        .maxCompactionLagMs(Long.MAX_VALUE)
                        .maxDecompressedMessageBytes(2_147_483_639)
                        .maxMessageBytes(1_048_588)
                        .messageDownconversionEnable(true)
                        .messageFormatVersion("3.0-IV1")
                        .messageTimestampAfterMaxMs(3_600_000L)
                        .messageTimestampBeforeMaxMs(Long.MAX_VALUE)
                        .messageTimestampDifferenceMaxMs(Long.MAX_VALUE)
                        .messageTimestampType(KafkaChannelTopicMessageTimestampType.CREATE_TIME)
                        .minCleanableDirtyRatio(0.5)
                        .minCompactionLagMs(0L)
                        .minInsyncReplicas(2)
                        .preallocate(false)
                        .remoteCopyLagBytes(-1L)
                        .remoteCopyLagMs(0L)
                        .remoteLogCopyDisable(false)
                        .remoteLogDeleteOnDisable(false)
                        .remoteStorageEnable(false)
                        .retentionBytes(1_000_000_000_000L)
                        .retentionMs(604_800_000L)
                        .segmentBytes(1_073_741_824)
                        .segmentIndexBytes(10_485_760)
                        .segmentJitterMs(0L)
                        .segmentMs(604_800_000L)
                        .uncleanLeaderElectionEnable(false)
                        .confluentKeySchemaValidation(true)
                        .confluentKeySubjectNameStrategy("TopicNameStrategy")
                        .confluentValueSchemaValidation(true)
                        .confluentValueSubjectNameStrategy("TopicNameStrategy")
                        .additionalProperties(untyped)
                        .build()
                )
                .build();
    }

    public static KafkaMessageBinding messageBinding () {
        return KafkaMessageBinding.builder()
                .key(AsyncAPISchema.builder()
                        .type(Type.STRING)
                        .enumValue(List.of("myKey"))
                        .build())
                .schemaIdLocation(KafkaMessageSchemaIdLocation.PAYLOAD)
                .schemaIdPayloadEncoding("apicurio-new")
                .schemaLookupStrategy("TopicIdStrategy")
                .build();
    }

    public static KafkaOperationBinding operationBinding () {
        return KafkaOperationBinding.builder()
                .clientId(AsyncAPISchema.builder()
                        .type(Type.STRING)
                        .pattern("^payments-api-")
                        .build())
                .groupId(AsyncAPISchema.builder()
                        .type(Type.STRING)
                        .constValue("payments-ledger")
                        .build())
                .groupType(KafkaOperationGroupType.CONSUMER)
                .isolationLevel(KafkaOperationIsolationLevel.READ_COMMITTED)
                .principal(AsyncAPISchema.builder()
                        .type(Type.STRING)
                        .constValue("User:payments-service")
                        .build())
                .transactionalId(AsyncAPISchema.builder()
                        .type(Type.STRING)
                        .pattern("^payments-tx-")
                        .build())
                .build();
    }

    public static KafkaServerBinding serverBinding () {
        return KafkaServerBinding.builder()
                .schemaRegistryUrl("https://my-schema-registry.com")
                .schemaRegistryVendor("confluent")
                .build();
    }

    @Nested
    @DisplayName("channel")
    class ChannelTest extends BindingTest<KafkaChannelBinding> {{
        super.binding                          = channelBinding();
        super.bindingTypeClass                 = KafkaChannelBinding.class;
        super.pathToBindingJson                = "/bindings/kafka/0.6.0/channel/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/kafka/0.6.0/channel/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/kafka/0.6.0/channel/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("message")
    class Message extends BindingTest<KafkaMessageBinding> {{
        super.binding                          = messageBinding();
        super.bindingTypeClass                 = KafkaMessageBinding.class;
        super.pathToBindingJson                = "/bindings/kafka/0.6.0/message/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/kafka/0.6.0/message/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/kafka/0.6.0/message/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("operation")
    class Operation extends BindingTest<KafkaOperationBinding> {{
        super.binding                          = operationBinding();
        super.bindingTypeClass                 = KafkaOperationBinding.class;
        super.pathToBindingJson                = "/bindings/kafka/0.6.0/operation/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/kafka/0.6.0/operation/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/kafka/0.6.0/operation/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("server")
    class Server extends BindingTest<KafkaServerBinding> {{
        super.binding                          = serverBinding();
        super.bindingTypeClass                 = KafkaServerBinding.class;
        super.pathToBindingJson                = "/bindings/kafka/0.6.0/server/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/kafka/0.6.0/server/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/kafka/0.6.0/server/binding - wrongly extended.json";
    }}

}
