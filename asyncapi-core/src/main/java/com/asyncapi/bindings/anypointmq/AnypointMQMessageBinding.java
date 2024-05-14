package com.asyncapi.bindings.anypointmq;

import com.asyncapi.bindings.MessageBinding;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

/**
 * Describes Anypoint MQ message binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/blob/master/anypointmq/README.md#message-binding-object">Anypoint MQ message binding</a>
 * @see <a href="https://docs.mulesoft.com/mq/">Anypoint MQ</a>
 * @author Pavel Bodiachevskii
 * @version 0.0.1
 * @since 1.0.0-RC2
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        defaultImpl = com.asyncapi.bindings.anypointmq.v0._0_1.message.AnypointMQMessageBinding.class,
        property = "bindingVersion",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = com.asyncapi.bindings.anypointmq.v0._0_1.message.AnypointMQMessageBinding.class, names = {
                "0.0.1",
                "latest"
        }),
})
@EqualsAndHashCode(callSuper = true)
public abstract class AnypointMQMessageBinding extends MessageBinding {}