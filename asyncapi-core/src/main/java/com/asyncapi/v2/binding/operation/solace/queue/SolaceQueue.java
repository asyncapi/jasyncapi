package com.asyncapi.v2.binding.operation.solace.queue;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.CheckForNull;
import java.util.List;

/**
 * Describes Solace queue.
 * <p>
 * Contains information about the queue in Solace PubSub+ Broker.
 *
 * @version 0.3.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/solace#operation-binding-object">Solace operation binding</a>
 * @author Dennis Brinley, Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SolaceQueue {

    /**
     * The name of the queue, only applicable when destinationType is 'queue'.
     */
    @CheckForNull
    private String name;

    /**
     * A list of topics that the queue subscribes to, only applicable when destinationType is 'queue'.
     * If none is given, the queue subscribes to the topic as represented by the channel name.
     */
    @CheckForNull
    private List<String> topicSubscriptions;

    /**
     * 'exclusive' or 'nonexclusive'. This is documented <a href="https://docs.solace.com/Messaging/Guaranteed-Msg/Endpoints.htm#Queues">here</a>. Only applicable when destinationType is 'queue'.
     */
    @CheckForNull
    private AccessType accessType;

    /**
     * The maximum amount of message spool that the given queue may use. This is documented <a href="https://docs.solace.com/Messaging/Guaranteed-Msg/Message-Spooling.htm#max-spool-usage">here</a>.
     * Only applicable when destinationType is 'queue'.
     */
    @CheckForNull
    private String maxMsgSpoolSize;

    /**
     * The maximum TTL to apply to messages to be spooled. This is documented <a href="https://docs.solace.com/Messaging/Guaranteed-Msg/Configuring-Queues.htm">here</a>.
     * Only applicable when destinationType is 'queue'.
     */
    @CheckForNull
    private String maxTtl;

    public enum AccessType {

        @JsonProperty("exclusive")
        EXCLUSIVE,
        @JsonProperty("non-exclusive")
        NON_EXCLUSIVE;

    }

}
