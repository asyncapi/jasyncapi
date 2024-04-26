package com.asyncapi.bindings.amqp.v0._2_0.server;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

/**
 * This class MUST NOT contain any properties. Its name is reserved for future use.
 * <p>
 * Describes AMQP 0-9-1 server binding.
 *
 * @version 0.2.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/amqp#server-binding-object">AMQP server binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AMQPServerBinding extends com.asyncapi.bindings.amqp.AMQPServerBinding {

    @Override
    public String getBindingVersion() {
        return "0.2.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.2.0");
    }

}
