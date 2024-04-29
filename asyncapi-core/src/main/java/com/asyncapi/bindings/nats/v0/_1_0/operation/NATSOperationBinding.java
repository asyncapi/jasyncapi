package com.asyncapi.bindings.nats.v0._1_0.operation;

import com.asyncapi.bindings.OperationBinding;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.*;
import org.jetbrains.annotations.Nullable;

/**
 * Describes NATS operation binding.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/nats#operation-binding-object">NATS operation binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonClassDescription("Describes NATS operation binding.")
public class NATSOperationBinding extends com.asyncapi.bindings.nats.NATSOperationBinding {

    /**
     * Defines the name of the queue to use. It MUST NOT exceed 255 characters.
     */
    @Nullable
    @javax.validation.constraints.Size(
            max = 255,
            message = "Queue name must be lower or equals to 255."
    )
    @JsonProperty("queue")
    @JsonPropertyDescription("Defines the name of the queue to use. It MUST NOT exceed 255 characters.")
    private String queue;

    @Override
    public String getBindingVersion() {
        return "0.1.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.1.0");
    }

}
