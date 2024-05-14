package com.asyncapi.bindings.kafka.v0._5_0.server;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

/**
 * Describes Kafka server binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/kafka#server-binding-object">Kafka server binding</a>
 * @see <a href="https://kafka.apache.org">Kafka</a>
 * @author Pavel Bodiachevskii
 * @version 0.5.0
 * @since 1.0.0-RC2
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonClassDescription("Describes Kafka server binding.")
public class KafkaServerBinding extends com.asyncapi.bindings.kafka.KafkaServerBinding {

    /**
     * API URL for the Schema Registry used when producing Kafka messages (if a Schema Registry was used)
     */
    @Nullable
    @JsonProperty("schemaRegistryUrl")
    @JsonPropertyDescription("API URL for the Schema Registry used when producing Kafka messages (if a Schema Registry was used)")
    private String schemaRegistryUrl;

    /**
     * MUST NOT be specified if schemaRegistryUrl is not specified
     * <p>
     * The vendor of Schema Registry and Kafka serdes library that should be used (e.g. apicurio, confluent, ibm, or karapace)
     */
    @Nullable
    @JsonProperty("schemaRegistryVendor")
    @JsonPropertyDescription("The vendor of Schema Registry and Kafka serdes library that should be used (e.g. apicurio, confluent, ibm, or karapace)")
    private String schemaRegistryVendor;

    @Override
    public String getBindingVersion() {
        return "0.5.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.5.0");
    }

}
