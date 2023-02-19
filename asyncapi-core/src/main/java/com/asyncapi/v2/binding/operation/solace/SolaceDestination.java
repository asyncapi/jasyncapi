package com.asyncapi.v2.binding.operation.solace;

import com.asyncapi.v2.binding.operation.solace.queue.SolaceQueue;
import com.asyncapi.v2.binding.operation.solace.topic.SolaceTopic;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class SolaceDestination {

    /**
     * 'queue' or 'topic'. If the type is queue, then the subscriber can bind to the queue, which in turn will
     * subscribe to the topic as represented by the channel name or to the provided topicSubscriptions.
     */
    @Nullable
    private Type destinationType;

    /**
     * 'direct' or 'persistent'. This determines the quality of service for publishing messages as documented <a href="https://docs.solace.com/Get-Started/Core-Concepts-Message-Delivery-Modes.htm">here</a>.
     * Default is 'persistent'.
     */
    @Nullable
    @Builder.Default
    private DeliveryMode deliveryMode = DeliveryMode.PERSISTENT;

    /**
     * Solace queue destination details.
     */
    @Nullable
    private SolaceQueue queue;

    /**
     * Solace topic destination details
     */
    @Nullable
    private SolaceTopic topic;

    public enum Type {

        @JsonProperty("queue")
        QUEUE,
        @JsonProperty("topic")
        TOPIC;

    }

    public enum DeliveryMode {

        @JsonProperty("direct")
        DIRECT,
        @JsonProperty("persistent")
        PERSISTENT;

    }

}
