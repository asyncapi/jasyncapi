package com.asyncapi.v2.binding.amqp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.CheckForNull;
import javax.annotation.Nullable;
import java.util.List;

/**
 * This class MUST NOT contain any properties. Its name is reserved for future use.
 *
 * This class defines how to describe AMQP 0-9-1 operation binding.
 *
 * @author Pavel Bodiachevskii
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AMQPOperationBinding {

    /**
     * TTL (Time-To-Live) for the message. It MUST be greater than or equal to zero.
     */
    private int expiration;

    /**
     * Identifies the user who has sent the message.
     *
     * Applies to: publish, subscribe
     */
    @Nullable
    @CheckForNull
    private String userId;

    /**
     * The routing keys the message should be routed to at the time of publishing.
     *
     * Applies to: publish, subscribe
     */
    @Nullable
    @CheckForNull
    private List<String> cc;

    /**
     * A priority for the message.
     *
     * Applies to: publish, subscribe
     */
    private int priority;

    /**
     * Delivery mode of the message. Its value MUST be either 1 (transient) or 2 (persistent).
     *
     * Applies to: publish, subscribe
     */
    private int deliveryMode;

    /**
     * Whether the message is mandatory or not.
     *
     * Applies to: publish
     */
    private boolean mandatory;

    /**
     * Like {@link #cc} but consumers will not receive this information.
     *
     * Applies to: publish
     */
    @Nullable
    @CheckForNull
    private List<String> bcc;

    /**
     * Name of the queue where the consumer should send the response.
     *
     * Applies to: publish, subscribe
     */
    @Nullable
    @CheckForNull
    private String replyTo;

    /**
     * Whether the message should include a timestamp or not.
     *
     * Applies to: publish, subscribe
     */
    private boolean timestamp;

    /**
     * Whether the consumer should ack the message or not.
     *
     * Applies to: subscribe
     */
    private boolean ack;

    /**
     * The version of this binding. If omitted, "latest" MUST be assumed.
     */
    @Nullable
    @CheckForNull
    private String bindingVersion;

}
