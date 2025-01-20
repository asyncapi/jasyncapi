package com.asyncapi.bindings.mercure.v0._1_0.message;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

/**
 * This class MUST NOT contain any properties. Its name is reserved for future use.
 * <p>
 * Describes Mercure message binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/mercure#message-binding-object">Mercure message binding</a>
 * @see <a href="https://mercure.rocks">Mercure</a>
 * @author Pavel Bodiachevskii
 * @version 0.1.0
 * @since 1.0.0-RC2
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MercureMessageBinding extends com.asyncapi.bindings.mercure.MercureMessageBinding {

    @Override
    public String getBindingVersion() {
        return "0.1.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.1.0");
    }

}
