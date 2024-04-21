package com.asyncapi.v2.binding.channel.amqp;

import com.asyncapi.bindings.ChannelBinding;
import com.asyncapi.v2.binding.channel.amqp.exchange.AMQPChannelExchangeProperties;
import com.asyncapi.v2.binding.channel.amqp.queue.AMQPChannelQueueProperties;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Describes AMQP 0-9-1 channel binding.
 * <p>
 * Contains information about the channel representation in AMQP.
 *
 * @version 0.2.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/amqp#channel-binding-object">AMQP channel binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonClassDescription("Describes AMQP 0-9-1 channel binding.")
public class AMQPChannelBinding extends ChannelBinding {

    /**
     * Defines what type of channel is it. Can be either queue or routingKey (default).
     */
    @NotNull
    @Builder.Default
    @javax.validation.constraints.NotNull
    @JsonProperty(value = "is", required = true, defaultValue = "routingKey")
    @JsonPropertyDescription("Defines what type of channel is it. Can be either queue or routingKey (default).")
    private AMQPChannelType is = AMQPChannelType.ROUTING_KEY;

    /**
     * When is=routingKey, this object defines the exchange properties.
     */
    @Nullable
    @JsonProperty("exchange")
    @JsonPropertyDescription("When is=routingKey, this object defines the exchange properties.")
    private AMQPChannelExchangeProperties exchange;

    /**
     * When is=queue, this object defines the queue properties.
     */
    @Nullable
    @JsonProperty("queue")
    @JsonPropertyDescription("When is=queue, this object defines the queue properties.")
    private AMQPChannelQueueProperties queue;

    @Nullable
    @Builder.Default
    @JsonProperty(value = "bindingVersion")
    @JsonPropertyDescription("The version of this binding.")
    private final String bindingVersion = "0.2.0";

}
