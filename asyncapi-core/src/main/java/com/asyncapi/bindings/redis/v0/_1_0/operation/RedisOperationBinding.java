package com.asyncapi.bindings.redis.v0._1_0.operation;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

/**
 * This class MUST NOT contain any properties. Its name is reserved for future use.
 * <p>
 * Describes Redis operation binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/redis#operation-binding-object">Redis operation binding</a>
 * @see <a href="https://redis.io">Redis</a>
 * @author Pavel Bodiachevskii
 * @version 0.1.0
 * @since 1.0.0-RC2
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RedisOperationBinding extends com.asyncapi.bindings.redis.RedisOperationBinding {

    @Override
    public String getBindingVersion() {
        return "0.1.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.1.0");
    }

}
