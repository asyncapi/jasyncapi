package com.asyncapi.bindings.amqp1.v0._1_0.message;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

/**
 * This class MUST NOT contain any properties. Its name is reserved for future use.
 * <p>
 * Describes AMQP 1.0 message binding.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/amqp1#message-binding-object">AMQP message binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AMQP1MessageBinding extends com.asyncapi.bindings.amqp1.AMQP1MessageBinding {

    @Override
    public String getBindingVersion() {
        return "0.1.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.1.0");
    }

}
