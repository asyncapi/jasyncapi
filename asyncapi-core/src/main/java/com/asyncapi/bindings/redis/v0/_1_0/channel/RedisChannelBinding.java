package com.asyncapi.bindings.redis.v0._1_0.channel;

import com.asyncapi.bindings.ChannelBinding;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * This class MUST NOT contain any properties. Its name is reserved for future use.
 * <p>
 * Describes Redis channel binding.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/redis#channel-binding-object">Redis channel binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RedisChannelBinding extends ChannelBinding {
}
