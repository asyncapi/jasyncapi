package com.asyncapi.bindings.amqp;

import com.asyncapi.bindings.MessageBinding;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Describes AMQP 0-9-1 message binding.
 * <p>
 * Contains information about the message representation in AMQP.
 *
 * @since 1.0.0-RC2
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/amqp#message-binding-object">AMQP message binding</a>
 * @author Pavel Bodiachevskii
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        defaultImpl = com.asyncapi.bindings.amqp.v0._3_0.message.AMQPMessageBinding.class,
        property = "bindingVersion",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = com.asyncapi.bindings.amqp.v0._1_0.message.AMQPMessageBinding.class, name = "0.1.0"),
        @JsonSubTypes.Type(value = com.asyncapi.bindings.amqp.v0._2_0.message.AMQPMessageBinding.class, name = "0.2.0"),
        @JsonSubTypes.Type(value = com.asyncapi.bindings.amqp.v0._3_0.message.AMQPMessageBinding.class, names = {
                "0.3.0",
                "latest"
        }),
})
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class AMQPMessageBinding extends MessageBinding {}