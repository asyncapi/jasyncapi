package com.asyncapi.v2.binding.operation.solace;

import com.asyncapi.v2.binding.operation.OperationBinding;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.annotation.CheckForNull;
import java.util.ArrayList;
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
public class SolaceOperationBinding extends OperationBinding {

    /**
     * List of destinations
     */
    @CheckForNull
    @Builder.Default
    private List<SolaceDestination> destinations = new ArrayList<>();

    /**
     * Version of the binding object (e.g. bindingVersion: 0.3.0)
     */
    @CheckForNull
    @Builder.Default
    private String bindingVersion = "0.3.0";

}
