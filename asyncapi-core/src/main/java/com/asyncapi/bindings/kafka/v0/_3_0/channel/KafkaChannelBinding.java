package com.asyncapi.bindings.kafka.v0._3_0.channel;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.*;
import org.jetbrains.annotations.Nullable;

/**
 * Describes Kafka channel binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/kafka#channel-binding-object">Kafka channel binding</a>
 * @see <a href="https://kafka.apache.org">Kafka</a>
 * @author Pavel Bodiachevskii
 * @version 0.3.0
 * @since 1.0.0-RC2
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonClassDescription("Describes Kafka channel binding.")
public class KafkaChannelBinding extends com.asyncapi.bindings.kafka.KafkaChannelBinding {

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

    @Override
    public String getBindingVersion() {
        return "0.3.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.3.0");
    }

}
