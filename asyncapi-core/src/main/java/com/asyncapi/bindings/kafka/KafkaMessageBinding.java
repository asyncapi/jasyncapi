package com.asyncapi.bindings.kafka;

import com.asyncapi.bindings.MessageBinding;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;

/**
 * Describes Kafka message binding.
 * <p>
 * Contains information about the message representation in Kafka.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/kafka#message-binding-object">Kafka message binding</a>
 * @author Pavel Bodiachevskii
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        defaultImpl = com.asyncapi.bindings.kafka.v0._4_0.message.KafkaMessageBinding.class,
        property = "bindingVersion",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = com.asyncapi.bindings.kafka.v0._4_0.message.KafkaMessageBinding.class, names = {
                "0.4.0",
                "latest"
        }),
})
@EqualsAndHashCode(callSuper = true)
public class KafkaMessageBinding extends MessageBinding {}