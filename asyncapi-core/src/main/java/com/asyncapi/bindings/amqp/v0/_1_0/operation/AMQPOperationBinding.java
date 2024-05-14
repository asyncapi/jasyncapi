package com.asyncapi.bindings.amqp.v0._1_0.operation;

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
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/amqp#operation-binding-object">AMQP operation binding</a>
 * @see <a href="https://www.amqp.org">AMQP</a>
 * @author Pavel Bodiachevskii
 * @version 0.1.0
 * @since 1.0.0-RC2
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonClassDescription("Describes AMQP 0-9-1 operation binding.")
public class AMQPOperationBinding extends com.asyncapi.bindings.amqp.AMQPOperationBinding {

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

    @Override
    public String getBindingVersion() {
        return "0.1.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.1.0");
    }

}
