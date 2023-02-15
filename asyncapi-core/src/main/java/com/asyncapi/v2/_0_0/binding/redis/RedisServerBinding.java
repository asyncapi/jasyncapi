package com.asyncapi.v2._0_0.binding.redis;

import com.asyncapi.v2._0_0.binding.ServerBinding;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * This class MUST NOT contain any properties. Its name is reserved for future use.
 *
 * Describes Redis server binding.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/redis#server-binding-object">Redis server binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RedisServerBinding extends ServerBinding {
}
