package com.asyncapi.bindings.jms.v0._0_1.operation;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

/**
 * This class MUST NOT contain any properties. Its name is reserved for future use.
 * <p>
 * Describes JMS operation binding.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/jms#operation-binding-object">JMS operation binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class JMSOperationBinding extends com.asyncapi.bindings.jms.JMSOperationBinding {

    @Override
    public String getBindingVersion() {
        return "0.0.1";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.0.1");
    }

}
