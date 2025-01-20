package com.asyncapi.bindings.pulsar.v0._1_0.channel;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

/**
 * Describes Pulsar channel retention definition.
 * <p>
 * The Retention Definition Object is used to describe the Pulsar <a href="https://pulsar.apache.org/docs/cookbooks-retention-expiry/">Retention</a> policy.
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
@EqualsAndHashCode
@JsonClassDescription("Describes Pulsar channel retention definition.")
public class PulsarChannelRetentionDefinition {

    /**
     * Time given in Minutes.
     */
    @Nullable
    @Builder.Default
    @JsonProperty("time")
    @JsonPropertyDescription("Time given in Minutes.")
    private Integer time = 0;

    /**
     * Size given in MegaBytes.
     */
    @Nullable
    @Builder.Default
    @JsonProperty("size")
    @JsonPropertyDescription("Size given in MegaBytes.")
    private Integer size = 0;

}
