package com.asyncapi.bindings.pulsar.v0._1_0.channel;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Describes Pulsar channel binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/pulsar#channel-binding-object">Pulsar channel binding</a>
 * @see <a href="https://pulsar.apache.org">Pulsar</a>
 * @author Pavel Bodiachevskii
 * @version 0.1.0
 * @since 1.0.0-RC2
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonClassDescription("Describes Pulsar channel binding.")
public class PulsarChannelBinding extends com.asyncapi.bindings.pulsar.PulsarChannelBinding {

    /**
     * The namespace the channel is associated with.
     */
    @NotNull
    @Builder.Default
    @javax.validation.constraints.NotNull
    @JsonProperty("namespace")
    @JsonPropertyDescription("The namespace the channel is associated with.")
    private String namespace = "";

    /**
     * Persistence of the topic in Pulsar. It MUST be either persistent or non-persistent.
     */
    @NotNull
    @Builder.Default
    @javax.validation.constraints.NotNull
    @JsonProperty(value = "persistence", defaultValue = "persistent")
    @JsonPropertyDescription("Persistence of the topic in Pulsar. It MUST be either persistent or non-persistent.")
    private PulsarChannelPersistence persistence = PulsarChannelPersistence.PERSISTENT;

    /**
     * Topic compaction threshold given in Megabytes.
     */
    @Nullable
    @javax.validation.constraints.Min(
            value = 0,
            message = "Topic compaction threshold must be greater or equals to 0."
    )
    @JsonProperty("compaction")
    @JsonPropertyDescription("Topic compaction threshold given in Megabytes.")
    private Integer compaction;

    /**
     * A list of clusters the topic is replicated to.
     */
    @Nullable
    @JsonProperty("geo-replication")
    @JsonPropertyDescription("A list of clusters the topic is replicated to.")
    private List<String> geoReplication;

    /**
     * Topic retention policy.
     */
    @Nullable
    @JsonProperty("retention")
    @JsonPropertyDescription("Topic retention policy.")
    private PulsarChannelRetentionDefinition retention;

    /**
     * Message time-to-live in seconds.
     */
    @Nullable
    @JsonProperty("ttl")
    @JsonPropertyDescription("Message time-to-live in seconds.")
    private Integer ttl;

    /**
     * Message deduplication. When true, it ensures that each message produced on Pulsar topics is persisted to disk only once.
     */
    @Nullable
    @JsonProperty("deduplication")
    @JsonPropertyDescription("Message deduplication. When true, it ensures that each message produced on Pulsar topics is persisted to disk only once.")
    private Boolean deduplication;

    @Override
    public String getBindingVersion() {
        return "0.1.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.1.0");
    }

}
