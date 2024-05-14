package com.asyncapi.bindings.pulsar.v0._1_0.server;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.*;
import org.jetbrains.annotations.Nullable;

/**
 * Describes Pulsar server binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/pulsar#server-binding-object">Redis server binding</a>
 * @see <a href="https://pulsar.apache.org">Pulsar</a>
 * @author Pavel Bodiachevskii
 * @version 0.1.0
 * @since 1.0.0-RC2
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonClassDescription("Describes Pulsar server binding.")
public class PulsarServerBinding extends com.asyncapi.bindings.pulsar.PulsarServerBinding {

    /**
     * The pulsar tenant. If omitted, "public" MUST be assumed.
     */
    @Nullable
    @Builder.Default
    @JsonProperty(value = "tenant", defaultValue = "public")
    @JsonPropertyDescription("The pulsar tenant. If omitted, \"public\" MUST be assumed.")
    private String tenant = "public";

    @Override
    public String getBindingVersion() {
        return "0.1.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.1.0");
    }

}
