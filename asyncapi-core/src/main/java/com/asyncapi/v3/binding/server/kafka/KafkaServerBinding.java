package com.asyncapi.v3.binding.server.kafka;

import com.asyncapi.v3.binding.server.ServerBinding;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.*;
import org.jetbrains.annotations.Nullable;

/**
 * Describes Kafka server binding.
 *
 * @version 0.4.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/kafka#server-binding-object">Kafka server binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonClassDescription("Describes Kafka server binding.")
public class KafkaServerBinding extends ServerBinding {

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

    /**
     * The version of this binding.
     */
    @Nullable
    @Builder.Default
    @JsonProperty("bindingVersion")
    @JsonPropertyDescription("The version of this binding.")
    private String bindingVersion = "0.4.0";

}
