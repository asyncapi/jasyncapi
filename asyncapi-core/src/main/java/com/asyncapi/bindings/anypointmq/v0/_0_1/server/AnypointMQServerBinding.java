package com.asyncapi.bindings.anypointmq.v0._0_1.server;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

/**
 * This class MUST NOT contain any properties. Its name is reserved for future use.
 * <p>
 * Describes Anypoint MQ server binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/anypointmq#server-binding-object">Anypoint MQ server binding</a>
 * @see <a href="https://docs.mulesoft.com/mq/">Anypoint MQ</a>
 * @author Pavel Bodiachevskii
 * @version 0.0.1
 * @since 1.0.0-RC2
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AnypointMQServerBinding extends com.asyncapi.bindings.anypointmq.AnypointMQServerBinding {

    @Override
    public String getBindingVersion() {
        return "0.0.1";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.0.1");
    }

}
