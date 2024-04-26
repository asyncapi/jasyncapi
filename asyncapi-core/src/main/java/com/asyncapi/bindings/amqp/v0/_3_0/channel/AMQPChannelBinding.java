package com.asyncapi.bindings.amqp.v0._3_0.channel;

import com.asyncapi.bindings.amqp.v0._3_0.channel.exchange.AMQPChannelExchangeProperties;
import com.asyncapi.bindings.amqp.v0._3_0.channel.queue.AMQPChannelQueueProperties;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Describes AMQP 0-9-1 channel binding.
 * <p>
 * Contains information about the channel representation in AMQP.
 *
 * @version 0.3.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/amqp#channel-binding-object">AMQP channel binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonClassDescription("Describes AMQP 0-9-1 channel binding.")
public class AMQPChannelBinding extends com.asyncapi.bindings.amqp.AMQPChannelBinding {

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

    @Override
    public String getBindingVersion() {
        return "0.3.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.3.0");
    }

}
