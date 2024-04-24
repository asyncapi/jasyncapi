package com.asyncapi.bindings.stomp.v0._1_0.server;

import com.asyncapi.bindings.ServerBinding;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

/**
 * This class <b>MUST NOT</b> contain any properties.
 * <p>
 * Its name is reserved for future use.
 * <p>
 * Describes STOMP server binding.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/sqs#server-binding-object">STOMP server binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class STOMPServerBinding extends com.asyncapi.bindings.stomp.STOMPServerBinding {

    public STOMPServerBinding() {
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
