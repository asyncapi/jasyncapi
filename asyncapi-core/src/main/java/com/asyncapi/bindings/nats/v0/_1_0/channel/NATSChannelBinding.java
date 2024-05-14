package com.asyncapi.bindings.nats.v0._1_0.channel;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

/**
 * This class MUST NOT contain any properties. Its name is reserved for future use.
 * <p>
 * Describes NATS channel binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/nats#channel-binding-object">NATS channel binding</a>
 * @see <a href="https://nats.io">NATS</a>
 * @author Pavel Bodiachevskii
 * @version 0.1.0
 * @since 1.0.0-RC2
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class NATSChannelBinding extends com.asyncapi.bindings.nats.NATSChannelBinding {

    @Override
    public String getBindingVersion() {
        return "0.1.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.1.0");
    }

}
