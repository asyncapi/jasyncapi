package com.asyncapi.v3.binding.operation.solace;

import com.asyncapi.v3.binding.operation.solace.queue.SolaceOperationQueue;
import com.asyncapi.v3.binding.operation.solace.topic.SolaceOperationTopic;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

/**
 * Describes Solace destination.
 * <p>
 * Contains information about the destination in Solace PubSub+ Broker.
 *
 * @version 0.3.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/solace#operation-binding-object">Solace operation binding</a>
 * @author Dennis Brinley, Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonClassDescription("Describes Solace destination.")
public class SolaceOperationDestination {

    /**
     * 'queue' or 'topic'. If the type is queue, then the subscriber can bind to the queue, which in turn will
     * subscribe to the topic as represented by the channel name or to the provided topicSubscriptions.
     */
    @Nullable
    @JsonProperty("destinationType")
    @JsonPropertyDescription("'queue' or 'topic'. If the type is queue, then the subscriber can bind to the queue, which in turn will subscribe to the topic as represented by the channel name or to the provided topicSubscriptions.")
    private Type destinationType;

    /**
     * 'direct' or 'persistent'. This determines the quality of service for publishing messages as documented <a href="https://docs.solace.com/Get-Started/Core-Concepts-Message-Delivery-Modes.htm">here</a>.
     * Default is 'persistent'.
     */
    @Nullable
    @Builder.Default
    @JsonProperty(value = "deliveryMode", defaultValue = "persistent")
    @JsonPropertyDescription("'direct' or 'persistent'. This determines the quality of service for publishing messages as documented at https://docs.solace.com/Get-Started/Core-Concepts-Message-Delivery-Modes.htm. Default is 'persistent'.")
    private DeliveryMode deliveryMode = DeliveryMode.PERSISTENT;

    /**
     * Solace queue destination details.
     */
    @Nullable
    @JsonProperty("queue")
    @JsonPropertyDescription("Solace queue destination details.")
    private SolaceOperationQueue queue;

    /**
     * Solace topic destination details.
     */
    @Nullable
    @JsonProperty("topic")
    @JsonPropertyDescription("Solace topic destination details.")
    private SolaceOperationTopic topic;

    public enum Type {

        @JsonProperty("queue")
        QUEUE,
        @JsonProperty("topic")
        TOPIC

    }

    public enum DeliveryMode {

        @JsonProperty("direct")
        DIRECT,
        @JsonProperty("persistent")
        PERSISTENT

    }

}
