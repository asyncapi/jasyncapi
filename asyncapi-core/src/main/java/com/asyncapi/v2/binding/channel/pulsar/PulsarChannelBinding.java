package com.asyncapi.v2.binding.channel.pulsar;

import com.asyncapi.v2.binding.channel.ChannelBinding;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Describes Pulsar channel binding.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/pulsar#channel-binding-object">Pulsar channel binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PulsarChannelBinding extends ChannelBinding {

    /**
     * The namespace the channel is associated with.
     */
    @NotNull
    private String namespace;

    /**
     * Persistence of the topic in Pulsar. It MUST be either persistent or non-persistent.
     */
    @NotNull
    private String persistence;

    /**
     * Topic compaction threshold given in Megabytes.
     */
    @Nullable
    private Integer compaction;

    /**
     * A list of clusters the topic is replicated to.
     */
    @Nullable
    @JsonProperty("geo-replication")
    private List<String> geoReplication;

    /**
     * Topic retention policy.
     */
    @Nullable
    private RetentionDefinition retention;

    /**
     * Message time-to-live in seconds.
     */
    @Nullable
    private Integer ttl;

    /**
     * Message deduplication. When true, it ensures that each message produced on Pulsar topics is persisted to disk only once.
     */
    @Nullable
    private Boolean deduplication;

    /**
     * The version of this binding. If omitted, "latest" MUST be assumed.
     */
    @Nullable
    @Builder.Default
    private String bindingVersion = "0.1.0";

    /**
     * The Retention Definition Object is used to describe the Pulsar <a href="https://pulsar.apache.org/docs/cookbooks-retention-expiry/">Retention</a> policy.
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class RetentionDefinition {

        /**
         * Time given in Minutes.
         */
        @Nullable
        @Builder.Default
        private Integer time = 0;

        /**
         * Size given in MegaBytes.
         */
        @Nullable
        @Builder.Default
        private Integer size = 0;

    }

}
