package com.asyncapi.v3.binding.server.pulsar;

import com.asyncapi.v3.binding.server.ServerBinding;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.*;
import org.jetbrains.annotations.Nullable;

/**
 * Describes Pulsar server binding.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/pulsar#server-binding-object">Redis server binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonClassDescription("Describes Pulsar server binding.")
public class PulsarServerBinding extends ServerBinding {

    /**
     * The pulsar tenant. If omitted, "public" MUST be assumed.
     */
    @Nullable
    @Builder.Default
    @JsonProperty(value = "tenant", defaultValue = "public")
    @JsonPropertyDescription("The pulsar tenant. If omitted, \"public\" MUST be assumed.")
    private String tenant = "public";

    /**
     * The version of this binding.
     */
    @Nullable
    @Builder.Default
    @JsonProperty("bindingVersion")
    @JsonPropertyDescription("The version of this binding.")
    private String bindingVersion = "0.1.0";

}
