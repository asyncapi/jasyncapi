package com.asyncapi.bindings.anypointmq;

import com.asyncapi.bindings.ServerBinding;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Describes <a href="https://docs.mulesoft.com/mq/">Anypoint MQ</a> server binding.
 *
 * @version 0.0.1
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/anypointmq#server-binding-object">Anypoint MQ server binding</a>
 * @author Pavel Bodiachevskii
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        defaultImpl = com.asyncapi.bindings.anypointmq.v0._0_1.server.AnypointMQServerBinding.class,
        property = "bindingVersion",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = com.asyncapi.bindings.anypointmq.v0._0_1.server.AnypointMQServerBinding.class, names = {
                "0.0.1",
                "latest"
        }),
})
@EqualsAndHashCode(callSuper = true)
public class AnypointMQServerBinding extends ServerBinding {}