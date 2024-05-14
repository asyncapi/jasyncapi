package com.asyncapi.bindings.solace.v0._3_0.channel;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

/**
 * This class MUST NOT contain any properties. Its name is reserved for future use.
 * <p>
 * Describes Solace channel binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/solace#channel-binding-object">Solace channel binding</a>
 * @see <a href="https://solace.com">Solace</a>
 * @author Dennis Brinley, Pavel Bodiachevskii
 * @version 0.3.0
 * @since 1.0.0-RC2
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SolaceChannelBinding extends com.asyncapi.bindings.solace.SolaceChannelBinding {

    @Override
    public String getBindingVersion() {
        return "0.3.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.3.0");
    }

}
