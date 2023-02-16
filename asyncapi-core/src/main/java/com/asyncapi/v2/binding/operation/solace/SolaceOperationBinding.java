package com.asyncapi.v2.binding.operation.solace;

import com.asyncapi.v2.binding.operation.OperationBinding;
import lombok.*;

import javax.annotation.CheckForNull;
import java.util.List;

/**
 * Describes Solace operation binding.
 *
 * @version 0.3.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/solace#operation-binding-object">Solace operation binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SolaceOperationBinding extends OperationBinding {

    @CheckForNull
    private List<Destination> destinations;

    /**
     * The version of this binding.
     */
    @CheckForNull
    @Builder.Default
    private String bindingVersion = "0.3.0";

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class Destination {

        /**
         * 'queue' or 'topic'. If the type is queue, then the subscriber can bind to the queue, which in turn will
         * subscribe to the topic as represented by the channel name or to the provided topicSubscriptions.
         */
        @CheckForNull
        private String destinationType;

        @CheckForNull
        private Queue queue;

        @CheckForNull
        private Topic topic;

        /**
         * 'direct' or 'persistent'. This determines the quality of service for publishing messages as documented <a href="https://docs.solace.com/Get-Started/Core-Concepts-Message-Delivery-Modes.htm">here</a>.
         * Default is 'persistent'.
         */
        @CheckForNull
        private String deliveryMode;

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        @EqualsAndHashCode
        public static class Queue {

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
            private String accessType;

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

        }

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        @EqualsAndHashCode
        public static class Topic {

            /**
             * A list of topics that the client subscribes to, only applicable when destinationType is 'topic'.
             * If none is given, the client subscribes to the topic as represented by the channel name.
             */
            @CheckForNull
            private List<String> topicSubscriptions;

        }

    }

}
