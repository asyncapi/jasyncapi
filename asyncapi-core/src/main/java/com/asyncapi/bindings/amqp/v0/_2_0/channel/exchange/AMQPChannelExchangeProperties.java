package com.asyncapi.bindings.amqp.v0._2_0.channel.exchange;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.*;
import org.jetbrains.annotations.Nullable;

/**
 * Describes AMQP 0-9-1 channel exchange properties.
 * <p>
 * Contains information about the channel exchange properties in AMQP.
 *
 * @version 0.2.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/amqp#channel-binding-object">AMQP channel binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@JsonClassDescription("Describes AMQP 0-9-1 channel exchange properties.")
public class AMQPChannelExchangeProperties {

    /**
     * The name of the exchange. It MUST NOT exceed 255 characters long.
     */
    @Nullable
    @javax.validation.constraints.Size(
            max = 255,
            message = "Exchange name must not exceed 255 characters long."
    )
    @JsonProperty("name")
    @JsonPropertyDescription("The name of the exchange. It MUST NOT exceed 255 characters long.")
    private String name;

    /**
     * The type of the exchange. Can be either topic, direct, fanout, default or headers.
     */
    @Nullable
    @JsonProperty("type")
    @JsonPropertyDescription("The type of the exchange. Can be either topic, direct, fanout, default or headers.")
    private AMQPChannelExchangeType type;

    /**
     * Whether the exchange should survive broker restarts or not.
     */
    @Nullable
    @JsonProperty("durable")
    @JsonPropertyDescription("Whether the exchange should survive broker restarts or not.")
    private Boolean durable;

    /**
     * Whether the exchange should be deleted when the last queue is unbound from it.
     */
    @Nullable
    @JsonProperty("autoDelete")
    @JsonPropertyDescription("Whether the exchange should be deleted when the last queue is unbound from it.")
    private Boolean autoDelete;

    /**
     * The virtual host of the exchange. Defaults to /.
     */
    @Nullable
    @Builder.Default
    @JsonProperty(value = "vhost", defaultValue = "/")
    @JsonPropertyDescription("The virtual host of the exchange. Defaults to /.")
    private String vhost = "/";

}
