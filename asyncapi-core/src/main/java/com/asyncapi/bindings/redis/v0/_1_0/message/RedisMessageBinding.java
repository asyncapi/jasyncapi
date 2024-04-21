package com.asyncapi.bindings.redis.v0._1_0.message;

import com.asyncapi.bindings.MessageBinding;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * This class MUST NOT contain any properties. Its name is reserved for future use.
 * <p>
 * Describes Redis message binding.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/redis#message-binding-object">Redis message binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RedisMessageBinding extends MessageBinding {
}
