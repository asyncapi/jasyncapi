package com.asyncapi.bindings.kafka;

import com.asyncapi.bindings.MessageBinding;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;

/**
 * Describes Kafka message binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/kafka#message-binding-object">Kafka message binding</a>
 * @see <a href="https://kafka.apache.org">Kafka</a>
 * @author Pavel Bodiachevskii
 * @since 1.0.0-RC2
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        defaultImpl = com.asyncapi.bindings.kafka.v0._5_0.message.KafkaMessageBinding.class,
        property = "bindingVersion",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = com.asyncapi.bindings.kafka.v0._1_0.message.KafkaMessageBinding.class, name = "0.1.0"),
        @JsonSubTypes.Type(value = com.asyncapi.bindings.kafka.v0._3_0.message.KafkaMessageBinding.class, name = "0.3.0"),
        @JsonSubTypes.Type(value = com.asyncapi.bindings.kafka.v0._4_0.message.KafkaMessageBinding.class, name = "0.4.0"),
        @JsonSubTypes.Type(value = com.asyncapi.bindings.kafka.v0._5_0.message.KafkaMessageBinding.class, names = {
                "0.5.0",
                "latest"
        }),
})
@EqualsAndHashCode(callSuper = true)
public abstract class KafkaMessageBinding extends MessageBinding {}