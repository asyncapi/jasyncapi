package com.asyncapi.bindings.redis;

import com.asyncapi.bindings.ServerBinding;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * This class MUST NOT contain any properties. Its name is reserved for future use.
 * <p>
 * Describes Redis server binding.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/redis#server-binding-object">Redis server binding</a>
 * @author Pavel Bodiachevskii
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        defaultImpl = com.asyncapi.bindings.redis.v0._1_0.server.RedisServerBinding.class,
        property = "bindingVersion",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = com.asyncapi.bindings.redis.v0._1_0.server.RedisServerBinding.class, names = {
                "0.1.0",
                "latest"
        }),
})
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class RedisServerBinding extends ServerBinding {}