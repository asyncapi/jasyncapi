package com.asyncapi.v2.binding.channel.ibmmq;

import com.asyncapi.v2.binding.channel.ChannelBinding;
import lombok.*;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * Describes IBM MQ channel binding.
 * <p>
 * This object contains information about the channel representation in IBM MQ. Each channel corresponds to a Queue or Topic within IBM MQ.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/ibmmq#channel-binding-object">IBM MQ channel binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class IBMMQChannelBinding extends ChannelBinding {

    /**
     * Defines the type of AsyncAPI channel.
     * <p>
     * MUST be either topic or queue. For type topic, the AsyncAPI channel name MUST be assumed for the IBM MQ topic string unless overridden.
     */
    @CheckForNull
    private String destinationType;

    /**
     * REQUIRED if destinationType = queue
     * <p>
     * queue and topic fields MUST NOT coexist within a channel binding
     */
    @CheckForNull
    private Queue queue;

    /**
     * Defines the properties of a topic.
     * <p>
     * OPTIONAL if destinationType = topic
     * <p>
     * queue and topic fields MUST NOT coexist within a channel binding.
     */
    @CheckForNull
    private Topic topic;

    /**
     * The maximum length of the physical message (in bytes) accepted by the Topic or Queue. Messages produced that are
     * greater in size than this value may fail to be delivered. More information on the maximum message length can be
     * found on this <a href="https://www.ibm.com/support/knowledgecenter/SSFKSJ_latest/com.ibm.mq.ref.adm.doc/q085520_.html#q085520___maxmsgl"></a>page in the IBM MQ Knowledge Center.
     * <p>
     * MUST be 0-104,857,600 bytes (100 MB).
     */
    @CheckForNull
    private Integer maxMsgLength;

    /**
     * The version of this binding.
     */
    @Builder.Default
    private String bindingVersion = "0.1.0";

    /**
     * Defines the properties of a queue.
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class Queue {

        /**
         * Defines the name of the IBM MQ queue associated with the channel.
         * <p>
         * A value MUST be specified. MUST NOT exceed 48 characters in length. MUST be a valid IBM MQ queue name
         */
        @Nonnull
        private String objectName;

        /**
         * Defines if the queue is a cluster queue and therefore partitioned. If true, a binding option MAY be specified
         * when accessing the queue. More information on binding options can be found on this page in the IBM MQ Knowledge Center.
         * <p>
         * If false, binding options SHOULD NOT be specified when accessing the queue.
         */
        @CheckForNull
        @Builder.Default
        private Boolean isPartitioned = false;

        /**
         * Specifies if it is recommended to open the queue exclusively.
         */
        @CheckForNull
        @Builder.Default
        private Boolean exclusive = false;

    }

    /**
     * Defines the properties of a topic.
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class Topic {

        /**
         * The value of the IBM MQ topic string to be used.
         * <p>
         * OPTIONAL
         * Note: if specified, SHALL override AsyncAPI channel name.
         * <p>
         * MUST NOT exceed 10240 characters in length. MAY coexist with topic.objectName
         */
        @CheckForNull
        private String string;

        /**
         * The name of the IBM MQ topic object.
         * <p>
         * OPTIONAL
         * Note: if specified, SHALL override AsyncAPI channel name.
         * <p>
         * MUST NOT exceed 48 characters in length. MAY coexist with topic.string
         */
        @CheckForNull
        private String objectName;

        /**
         * Defines if the subscription may be durable.
         */
        @CheckForNull
        @Builder.Default
        private Boolean durablePermitted = true;

        /**
         * Defines if the last message published will be made available to new subscriptions.
         */
        @CheckForNull
        @Builder.Default
        private Boolean lastMsgRetained = false;

    }

}
