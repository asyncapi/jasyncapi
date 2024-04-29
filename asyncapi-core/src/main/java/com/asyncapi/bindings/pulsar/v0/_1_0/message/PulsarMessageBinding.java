package com.asyncapi.bindings.pulsar.v0._1_0.message;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

/**
 * Describes Pulsar message binding.
 * <p>
 * This object MUST NOT contain any properties. Its name is reserved for future use.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/pulsar#message-binding-object">Pulsar message binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PulsarMessageBinding extends com.asyncapi.bindings.pulsar.PulsarMessageBinding {

    @Override
    public String getBindingVersion() {
        return "0.1.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.1.0");
    }

}
