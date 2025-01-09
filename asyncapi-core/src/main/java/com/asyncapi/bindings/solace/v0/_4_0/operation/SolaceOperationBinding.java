package com.asyncapi.bindings.solace.v0._4_0.operation;

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
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/solace#operation-binding-object">Solace operation binding</a>
 * @see <a href="https://solace.com">Solace</a>
 * @author Pavel Bodiachevskii
 * @version 0.4.0
 * @since 1.0.0-RC2
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SolaceOperationBinding extends com.asyncapi.bindings.solace.SolaceOperationBinding {

    /**
     * List of destinations
     */
    @Nullable
    @JsonProperty("destinations")
    @JsonPropertyDescription("List of destinations")
    private List<SolaceOperationDestination> destinations;

    /**
     * Interval in milliseconds or a Schema Object containing the definition of the lifetime of the message.
     */
    @Nullable
    @JsonProperty("timeToLive")
    private Integer timeToLive;

    /**
     * The valid priority value range is 0-255 with 0 as the lowest priority and 255 as the highest or
     * a Schema Object containing the definition of the priority.
     */
    @Nullable
    @jakarta.validation.constraints.Min(0)
    @jakarta.validation.constraints.Max(255)
    private Integer priority;

    /**
     * Set the message to be eligible to be moved to a Dead Message Queue.
     * <p>
     * The default value is false.
     */
    @Nullable
    @Builder.Default
    private Boolean dmqEligible = false;

    @Override
    public String getBindingVersion() {
        return "0.4.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.4.0");
    }

}
