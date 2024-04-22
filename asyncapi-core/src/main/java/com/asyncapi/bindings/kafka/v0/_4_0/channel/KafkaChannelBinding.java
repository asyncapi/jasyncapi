package com.asyncapi.bindings.kafka.v0._4_0.channel;

import com.asyncapi.bindings.ChannelBinding;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.*;
import org.jetbrains.annotations.Nullable;

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
@JsonClassDescription("Describes Kafka channel binding.")
public class KafkaChannelBinding extends ChannelBinding {

    /**
     * Kafka topic name if different from channel name.
     */
    @Nullable
    @JsonProperty("topic")
    @JsonPropertyDescription("Kafka topic name if different from channel name.")
    private String topic;

    /**
     * Number of partitions configured on this topic (useful to know how many parallel consumers you may run).
     * <p>
     * MUST be positive.
     */
    @Nullable
    @javax.validation.constraints.Min(
            value = 1,
            message = "Number of partitions must be greater or equals to 1"
    )
    @JsonProperty("partitions")
    @JsonPropertyDescription("Number of partitions configured on this topic (useful to know how many parallel consumers you may run).")
    private Integer partitions;

    /**
     * Number of replicas configured on this topic.
     * <p>
     * MUST be positive.
     */
    @Nullable
    @javax.validation.constraints.Min(
            value = 1,
            message = "Number of replicas must be greater or equals to 1"
    )
    @JsonProperty("replicas")
    @JsonPropertyDescription("Number of replicas configured on this topic.")
    private Integer replicas;

    /**
     * Topic configuration properties that are relevant for the API.
     */
    @Nullable
    @JsonProperty("topicConfiguration")
    @JsonPropertyDescription("Topic configuration properties that are relevant for the API.")
    private KafkaChannelTopicConfiguration topicConfiguration;

    /**
     * The version of this binding. If omitted, "latest" MUST be assumed.
     */
    @Nullable
    @Builder.Default
    private String bindingVersion = "0.4.0";

}
