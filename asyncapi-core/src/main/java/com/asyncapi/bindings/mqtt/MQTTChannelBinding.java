package com.asyncapi.bindings.mqtt;

import com.asyncapi.bindings.ChannelBinding;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;

/**
 * Describes MQTT channel binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/mqtt#channel-binding-object">MQTT channel binding</a>
 * @see <a href="https://mqtt.org/mqtt-specification/">MQTT</a>
 * @author Pavel Bodiachevskii
 * @since 1.0.0-RC2
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        defaultImpl = com.asyncapi.bindings.mqtt.v0._2_0.channel.MQTTChannelBinding.class,
        property = "bindingVersion",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = com.asyncapi.bindings.mqtt.v0._1_0.channel.MQTTChannelBinding.class, name = "0.1.0"),
        @JsonSubTypes.Type(value = com.asyncapi.bindings.mqtt.v0._2_0.channel.MQTTChannelBinding.class, names = {
                "0.2.0",
                "latest"
        }),
})
@EqualsAndHashCode(callSuper = true)
public abstract class MQTTChannelBinding extends ChannelBinding {}