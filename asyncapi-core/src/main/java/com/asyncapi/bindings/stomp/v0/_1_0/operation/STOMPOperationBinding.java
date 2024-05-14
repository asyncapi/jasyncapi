package com.asyncapi.bindings.stomp.v0._1_0.operation;

import com.asyncapi.bindings.OperationBinding;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

/**
 * This class <b>MUST NOT</b> contain any properties.
 * <p>
 * Its name is reserved for future use.
 * <p>
 * Describes STOMP operation binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/sqs#operation-binding-object">STOMP operation binding</a>
 * @see <a href="https://stomp.github.io">STOMP</a>
 * @author Pavel Bodiachevskii
 * @version 0.1.0
 * @since 1.0.0-RC2
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class STOMPOperationBinding extends com.asyncapi.bindings.stomp.STOMPOperationBinding {

    public STOMPOperationBinding() {
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
