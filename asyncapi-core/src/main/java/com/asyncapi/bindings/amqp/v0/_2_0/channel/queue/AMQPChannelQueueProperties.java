package com.asyncapi.bindings.amqp.v0._2_0.channel.queue;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.*;
import org.jetbrains.annotations.Nullable;

/**
 * Describes AMQP 0-9-1 channel queue properties.
 * <p>
 * Contains information about the queue exchange properties in AMQP.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/amqp#channel-binding-object">AMQP channel binding</a>
 * @see <a href="https://www.amqp.org">AMQP</a>
 * @author Pavel Bodiachevskii
 * @version 0.1.0
 * @since 1.0.0-RC2
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@JsonClassDescription("Describes AMQP 0-9-1 channel queue properties.")
public class AMQPChannelQueueProperties {

    /**
     * The name of the queue. It MUST NOT exceed 255 characters long.
     */
    @Nullable
    @javax.validation.constraints.Size(
            max = 255,
            message = "Queue name must not exceed 255 characters long."
    )
    @JsonProperty("name")
    @JsonPropertyDescription("The name of the queue. It MUST NOT exceed 255 characters long.")
    private String name;

    /**
     * Whether the queue should survive broker restarts or not.
     */
    @Nullable
    @JsonProperty("durable")
    @JsonPropertyDescription("Whether the queue should survive broker restarts or not.")
    private Boolean durable;

    /**
     * Whether the queue should be used only by one connection or not.
     */
    @Nullable
    @JsonProperty("exclusive")
    @JsonPropertyDescription("Whether the queue should be used only by one connection or not.")
    private Boolean exclusive;

    /**
     * Whether the queue should be deleted when the last consumer unsubscribes.
     */
    @Nullable
    @JsonProperty("autoDelete")
    @JsonPropertyDescription("Whether the queue should be deleted when the last consumer unsubscribes.")
    private Boolean autoDelete;

    /**
     * The virtual host of the queue. Defaults to /.
     */
    @Nullable
    @Builder.Default
    @JsonProperty(value = "vhost", defaultValue = "/")
    @JsonPropertyDescription("The virtual host of the queue. Defaults to /.")
    private String vhost = "/";

}
