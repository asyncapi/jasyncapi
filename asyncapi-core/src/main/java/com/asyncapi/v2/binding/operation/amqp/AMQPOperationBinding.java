package com.asyncapi.v2.binding.operation.amqp;

import com.asyncapi.v2.binding.operation.OperationBinding;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Describes AMQP 0-9-1 operation binding.
 * <p>
 * Contains information about the operation representation in AMQP.
 *
 * @version 0.2.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/amqp#operation-binding-object">AMQP operation binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AMQPOperationBinding extends OperationBinding {

    /**
     * TTL (Time-To-Live) for the message. It MUST be greater than or equal to zero.
     */
    @Nullable
    private Integer expiration;

    /**
     * Identifies the user who has sent the message.
     * <p>
     * Applies to: publish, subscribe
     */
    @Nullable
    private String userId;

    /**
     * The routing keys the message should be routed to at the time of publishing.
     * <p>
     * Applies to: publish, subscribe
     */
    @Nullable
    private List<String> cc;

    /**
     * A priority for the message.
     * <p>
     * Applies to: publish, subscribe
     */
    @Nullable
    private Integer priority;

    /**
     * Delivery mode of the message. Its value MUST be either 1 (transient) or 2 (persistent).
     * <p>
     * Applies to: publish, subscribe
     */
    @Nullable
    private Integer deliveryMode;

    /**
     * Whether the message is mandatory or not.
     * <p>
     * Applies to: publish
     */
    @Nullable
    private Boolean mandatory;

    /**
     * Like {@link #cc} but consumers will not receive this information.
     * <p>
     * Applies to: publish
     */
    @Nullable
    private List<String> bcc;

    /**
     * Name of the queue where the consumer should send the response.
     * <p>
     * Applies to: publish, subscribe
     */
    @Nullable
    private String replyTo;

    /**
     * Whether the message should include a timestamp or not.
     * <p>
     * Applies to: publish, subscribe
     */
    @Nullable
    private Boolean timestamp;

    /**
     * Whether the consumer should ack the message or not.
     * <p>
     * Applies to: subscribe
     */
    @Nullable
    private Boolean ack;

    /**
     * The version of this binding. If omitted, "latest" MUST be assumed.
     */
    @Nullable
    @Builder.Default
    private String bindingVersion = "0.2.0";

}
