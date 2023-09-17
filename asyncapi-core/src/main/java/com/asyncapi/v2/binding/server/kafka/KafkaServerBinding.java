package com.asyncapi.v2.binding.server.kafka;

import com.asyncapi.v2.binding.server.ServerBinding;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
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
public class KafkaServerBinding extends ServerBinding {

    /**
     * API URL for the Schema Registry used when producing Kafka messages (if a Schema Registry was used)
     */
    @Nullable
    private String schemaRegistryUrl;

    /**
     * MUST NOT be specified if schemaRegistryUrl is not specified
     * <p>
     * The vendor of Schema Registry and Kafka serdes library that should be used (e.g. apicurio, confluent, ibm, or karapace)
     */
    @Nullable
    private String schemaRegistryVendor;

    /**
     * The version of this binding.
     */
    @Nullable
    @Builder.Default
    private String bindingVersion = "0.4.0";

}
