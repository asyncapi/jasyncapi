package com.asyncapi.bindings.kafka.v0._1_0.server;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import lombok.*;
import org.jetbrains.annotations.Nullable;

/**
 * Describes Kafka server binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/kafka#server-binding-object">Kafka server binding</a>
 * @see <a href="https://kafka.apache.org">Kafka</a>
 * @author Pavel Bodiachevskii
 * @version 0.1.0
 * @since 1.0.0-RC2
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonClassDescription("Describes Kafka server binding.")
public class KafkaServerBinding extends com.asyncapi.bindings.kafka.KafkaServerBinding {

    @Override
    public String getBindingVersion() {
        return "0.1.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.1.0");
    }

}
