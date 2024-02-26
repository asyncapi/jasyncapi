package com.asyncapi.v3.binding.channel.pulsar;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.*;
import org.jetbrains.annotations.Nullable;

/**
 * Describes Pulsar channel retention definition.
 * <p>
 * The Retention Definition Object is used to describe the Pulsar <a href="https://pulsar.apache.org/docs/cookbooks-retention-expiry/">Retention</a> policy.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/pulsar#channel-binding-object">Pulsar channel binding</a>
 * @author Pavel Bodiachevskii
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
