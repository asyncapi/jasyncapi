package com.asyncapi.bindings.mqtt5;

import com.asyncapi.bindings.MessageBinding;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;

/**
 * Describes MQTT 5 message binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/mqtt5#message-binding-object">MQTT 5 message binding</a>
 * @see <a href="https://docs.oasis-open.org/mqtt/mqtt/v5.0/mqtt-v5.0.html">MQTT 5</a>
 * @author Pavel Bodiachevskii
 * @since 1.0.0-RC2
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        defaultImpl = com.asyncapi.bindings.mqtt5.v0._2_0.message.MQTT5MessageBinding.class,
        property = "bindingVersion",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = com.asyncapi.bindings.mqtt5.v0._1_0.message.MQTT5MessageBinding.class, name = "0.1.0"),
        @JsonSubTypes.Type(value = com.asyncapi.bindings.mqtt5.v0._2_0.message.MQTT5MessageBinding.class, names = {
                "0.2.0",
                "latest"
        }),
})
@EqualsAndHashCode(callSuper = true)
public abstract class MQTT5MessageBinding extends MessageBinding {}