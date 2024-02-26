package com.asyncapi.v2.binding.operation.solace;

import com.asyncapi.v2.binding.operation.OperationBinding;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Describes Solace operation binding.
 * <p>
 * Contains information about the operation representation in Solace PubSub+ Broker.
 *
 * @version 0.3.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/solace#operation-binding-object">Solace operation binding</a>
 * @author Dennis Brinley, Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonClassDescription("Describes Solace operation binding.")
public class SolaceOperationBinding extends OperationBinding {

    /**
     * List of destinations
     */
    @Nullable
    @JsonProperty("destinations")
    @JsonPropertyDescription("List of destinations")
    private List<SolaceOperationDestination> destinations;

    /**
     * The version of this binding. (e.g. bindingVersion: 0.3.0)
     */
    @Nullable
    @Builder.Default
    @JsonProperty("bindingVersion")
    @JsonPropertyDescription("The version of this binding.")
    private String bindingVersion = "0.3.0";

}
