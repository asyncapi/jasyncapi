package com.asyncapi.bindings.amqp1;

import com.asyncapi.bindings.ChannelBinding;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;

/**
 * This class MUST NOT contain any properties. Its name is reserved for future use.
 * <p>
 * Describes AMQP 1.0 channel binding.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/amqp1#channel-binding-object">AMQP 1.0 channel binding</a>
 * @author Pavel Bodiachevskii
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        defaultImpl = com.asyncapi.bindings.amqp1.v0._1_0.channel.AMQP1ChannelBinding.class,
        property = "bindingVersion",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = com.asyncapi.bindings.amqp1.v0._1_0.channel.AMQP1ChannelBinding.class, names = {
                "0.1.0",
                "latest"
        }),
})
@EqualsAndHashCode(callSuper = true)
public abstract class AMQP1ChannelBinding extends ChannelBinding {}