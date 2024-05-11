package com.asyncapi.bindings.solace.v0._2_0.operation;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.*;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Describes Solace operation binding.
 * <p>
 * Contains information about the operation representation in Solace PubSub+ Broker.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/solace#operation-binding-object">Solace operation binding</a>
 * @see <a href="https://solace.com">Solace</a>
 * @author Pavel Bodiachevskii
 * @version 0.2.0
 * @since 1.0.0-RC2
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonClassDescription("Describes Solace operation binding.")
public class SolaceOperationBinding extends com.asyncapi.bindings.solace.SolaceOperationBinding {

    /**
     * List of destinations
     */
    @Nullable
    @JsonProperty("destinations")
    @JsonPropertyDescription("List of destinations")
    private List<SolaceOperationDestination> destinations;

    @Override
    public String getBindingVersion() {
        return "0.2.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.2.0");
    }

}
