package com.asyncapi.bindings.solace.v0._3_0.message;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

/**
 * This class MUST NOT contain any properties. Its name is reserved for future use.
 * <p>
 * Describes Solace message binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/solace#message-binding-object">Solace message binding</a>
 * @see <a href="https://solace.com">Solace</a>
 * @author Pavel Bodiachevskii
 * @version 0.3.0
 * @since 1.0.0-RC2
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SolaceMessageBinding extends com.asyncapi.bindings.solace.SolaceMessageBinding {

    @Override
    public String getBindingVersion() {
        return "0.3.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.3.0");
    }

}
