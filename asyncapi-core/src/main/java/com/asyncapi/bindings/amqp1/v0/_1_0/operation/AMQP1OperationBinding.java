package com.asyncapi.bindings.amqp1.v0._1_0.operation;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

/**
 * This class MUST NOT contain any properties. Its name is reserved for future use.
 * <p>
 * Describes AMQP 1.0 operation binding.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/amqp1#operation-binding-object">AMQP operation binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AMQP1OperationBinding extends com.asyncapi.bindings.amqp1.AMQP1OperationBinding {

    @Override
    public String getBindingVersion() {
        return "0.1.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.1.0");
    }

}
