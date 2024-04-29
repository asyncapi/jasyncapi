package com.asyncapi.bindings.anypointmq;

import com.asyncapi.bindings.MessageBinding;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

/**
 * Describes Anypoint MQ message binding.
 *
 * @version 0.0.1
 * @see <a href="https://github.com/asyncapi/bindings/blob/master/anypointmq/README.md#message-binding-object">Anypoint MQ message binding</a>
 * @author Pavel Bodiachevskii
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