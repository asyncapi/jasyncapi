package com.asyncapi.bindings.stomp.v0._1_0.channel;

import com.asyncapi.bindings.ChannelBinding;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

/**
 * This class <b>MUST NOT</b> contain any properties.
 * <p>
 * Its name is reserved for future use.
 * <p>
 * Describes STOMP channel binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/stomp#channel-binding-object">STOMP channel binding</a>
 * @see <a href="https://stomp.github.io">STOMP</a>
 * @author Pavel Bodiachevskii
 * @version 0.1.0
 * @since 1.0.0-RC2
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class STOMPChannelBinding extends com.asyncapi.bindings.stomp.STOMPChannelBinding {

    public STOMPChannelBinding() {
        this.setBindingVersion("0.1.0");
    }

    @Override
    public String getBindingVersion() {
        return "0.1.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.1.0");
    }

}
