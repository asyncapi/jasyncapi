package com.asyncapi.bindings.anypointmq.v0._0_1.operation;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

/**
 * This class MUST NOT contain any properties. Its name is reserved for future use.
 * <p>
 * Describes <a href="https://docs.mulesoft.com/mq/">Anypoint MQ</a> operation binding.
 *
 * @version 0.0.1
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/anypointmq#operation-binding-object">Anypoint MQ operation binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AnypointMQOperationBinding extends com.asyncapi.bindings.anypointmq.AnypointMQOperationBinding {

    @Override
    public String getBindingVersion() {
        return "0.0.1";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.0.1");
    }

}
