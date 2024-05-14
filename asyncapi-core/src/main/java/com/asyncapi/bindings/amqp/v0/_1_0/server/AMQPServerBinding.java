package com.asyncapi.bindings.amqp.v0._1_0.server;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

/**
 * This class MUST NOT contain any properties. Its name is reserved for future use.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/amqp#server-binding-object">AMQP server binding</a>
 * @see <a href="https://www.amqp.org">AMQP</a>
 * @author Pavel Bodiachevskii
 * @version 0.1.0
 * @since 1.0.0-RC2
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AMQPServerBinding extends com.asyncapi.bindings.amqp.AMQPServerBinding {

    @Override
    public String getBindingVersion() {
        return "0.1.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.1.0");
    }

}
