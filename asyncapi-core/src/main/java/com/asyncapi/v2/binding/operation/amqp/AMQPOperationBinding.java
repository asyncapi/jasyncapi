package com.asyncapi.v2.binding.operation.amqp;

import com.asyncapi.v2.binding.operation.OperationBinding;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
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
@JsonClassDescription("Describes AMQP 0-9-1 operation binding.")
public class AMQPOperationBinding extends OperationBinding {

    /**
     * TTL (Time-To-Live) for the message. It MUST be greater than or equal to zero.
     * <p>
     * Applies to: publish, subscribe
     */
    @Nullable
    @javax.validation.constraints.Min(
            value = 0,
            message = "TTL (Time-To-Live) for the message must be greater than or equal to zero"
    )
    @JsonProperty("expiration")
    @JsonPropertyDescription("TTL (Time-To-Live) for the message. It MUST be greater than or equal to zero.")
    private Integer expiration;

    /**
     * Identifies the user who has sent the message.
     * <p>
     * Applies to: publish, subscribe
     */
    @Nullable
    @JsonProperty("userId")
    @JsonPropertyDescription("Identifies the user who has sent the message.")
    private String userId;

    /**
     * The routing keys the message should be routed to at the time of publishing.
     * <p>
     * Applies to: publish, subscribe
     */
    @Nullable
    @JsonProperty("cc")
    @JsonPropertyDescription("The routing keys the message should be routed to at the time of publishing.")
    private List<String> cc;

    /**
     * A priority for the message.
     * <p>
     * Applies to: publish, subscribe
     */
    @Nullable
    @JsonProperty("priority")
    @JsonPropertyDescription("A priority for the message.")
    private Integer priority;

    /**
     * Delivery mode of the message. Its value MUST be either 1 (transient) or 2 (persistent).
     * <p>
     * Applies to: publish, subscribe
     */
    @Nullable
    @javax.validation.constraints.Min(
            value = 1,
            message = "Delivery mode of the message must be either 1 (transient) or 2 (persistent)"
    )
    @javax.validation.constraints.Max(
            value = 2,
            message = "Delivery mode of the message must be either 1 (transient) or 2 (persistent)"
    )
    @JsonProperty("deliveryMode")
    @JsonPropertyDescription("Delivery mode of the message. Its value MUST be either 1 (transient) or 2 (persistent).")
    private Integer deliveryMode;

    /**
     * Whether the message is mandatory or not.
     * <p>
     * Applies to: publish
     */
    @Nullable
    @JsonProperty("mandatory")
    @JsonPropertyDescription("Whether the message is mandatory or not.")
    private Boolean mandatory;

    /**
     * Like {@link #cc} but consumers will not receive this information.
     * <p>
     * Applies to: publish
     */
    @Nullable
    @JsonProperty("bcc")
    @JsonPropertyDescription("Like cc but consumers will not receive this information.")
    private List<String> bcc;

    /**
     * Name of the queue where the consumer should send the response.
     * <p>
     * Applies to: publish, subscribe
     */
    @Nullable
    @JsonProperty("replyTo")
    @JsonPropertyDescription("Name of the queue where the consumer should send the response.")
    private String replyTo;

    /**
     * Whether the message should include a timestamp or not.
     * <p>
     * Applies to: publish, subscribe
     */
    @Nullable
    @JsonProperty("timestamp")
    @JsonPropertyDescription("Whether the message should include a timestamp or not.")
    private Boolean timestamp;

    /**
     * Whether the consumer should ack the message or not.
     * <p>
     * Applies to: subscribe
     */
    @Nullable
    @JsonProperty("ack")
    @JsonPropertyDescription("Whether the consumer should ack the message or not.")
    private Boolean ack;

    /**
     * The version of this binding. If omitted, "latest" MUST be assumed.
     */
    @Nullable
    @Builder.Default
    @JsonProperty(value = "bindingVersion")
    @JsonPropertyDescription("The version of this binding.")
    private String bindingVersion = "0.2.0";

}
