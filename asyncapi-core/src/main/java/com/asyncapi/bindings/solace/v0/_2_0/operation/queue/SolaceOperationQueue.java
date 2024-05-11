package com.asyncapi.bindings.solace.v0._2_0.operation.queue;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Describes Solace queue.
 * <p>
 * Contains information about the queue in Solace PubSub+ Broker.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/solace#operation-binding-object">Solace operation binding</a>
 * @see <a href="https://solace.com">Solace</a>
 * @author Pavel Bodiachevskii
 * @version 0.2.0
 * @since 1.0.0-RC2
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonClassDescription("Describes Solace queue.")
public class SolaceOperationQueue {

    /**
     * The name of the queue, only applicable when destinationType is 'queue'.
     */
    @Nullable
    @JsonProperty("name")
    @JsonPropertyDescription("The name of the queue, only applicable when destinationType is 'queue'.")
    private String name;

    /**
     * A list of topics that the queue subscribes to, only applicable when destinationType is 'queue'.
     * If none is given, the queue subscribes to the topic as represented by the channel name.
     */
    @Nullable
    @JsonProperty("topicSubscriptions")
    @JsonPropertyDescription("A list of topics that the queue subscribes to, only applicable when destinationType is 'queue'. If none is given, the queue subscribes to the topic as represented by the channel name.")
    private List<String> topicSubscriptions;

    /**
     * 'exclusive' or 'nonexclusive'. This is documented <a href="https://docs.solace.com/Messaging/Guaranteed-Msg/Endpoints.htm#Queues">here</a>. Only applicable when destinationType is 'queue'.
     */
    @Nullable
    @JsonProperty("accessType")
    @JsonPropertyDescription("'exclusive' or 'nonexclusive'. This is documented at https://docs.solace.com/Messaging/Guaranteed-Msg/Endpoints.htm#Queues. Only applicable when destinationType is 'queue'.")
    private AccessType accessType;

    public enum AccessType {

        @JsonProperty("exclusive")
        EXCLUSIVE,
        @JsonProperty("non-exclusive")
        NON_EXCLUSIVE

    }

}
