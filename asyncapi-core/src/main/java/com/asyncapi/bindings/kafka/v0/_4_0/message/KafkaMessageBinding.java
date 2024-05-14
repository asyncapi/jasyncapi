package com.asyncapi.bindings.kafka.v0._4_0.message;

import com.asyncapi.schemas.asyncapi.AsyncAPISchema;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

/**
 * Describes Kafka message binding.
 * <p>
 * Contains information about the message representation in Kafka.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/kafka#message-binding-object">Kafka message binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class KafkaMessageBinding extends com.asyncapi.bindings.kafka.KafkaMessageBinding {

    /**
     * The message key.
     */
    // TODO: Reference, AsyncAPISchema, AvroSchema
    @Nullable
    @JsonProperty("key")
    @JsonPropertyDescription("The message key.")
    private AsyncAPISchema key;

    /**
     * If a Schema Registry is used when performing this operation, tells where the id of schema is stored (e.g. header or payload).
     */
    @Nullable
    @JsonProperty("schemaIdLocation")
    @JsonPropertyDescription("If a Schema Registry is used when performing this operation, tells where the id of schema is stored (e.g. header or payload).")
    private KafkaMessageSchemaIdLocation schemaIdLocation;

    /**
     * Number of bytes or vendor specific values when schema id is encoded in payload (e.g confluent/ apicurio-legacy / apicurio-new).
     */
    @Nullable
    @JsonProperty("schemaIdPayloadEncoding")
    @JsonPropertyDescription("Number of bytes or vendor specific values when schema id is encoded in payload (e.g confluent/ apicurio-legacy / apicurio-new).")
    private String schemaIdPayloadEncoding;

    /**
     * Freeform string for any naming strategy class to use. Clients should default to the vendor default if not supplied.
     */
    @Nullable
    @JsonProperty("schemaLookupStrategy")
    @JsonPropertyDescription("Freeform string for any naming strategy class to use. Clients should default to the vendor default if not supplied.")
    private String schemaLookupStrategy;

    @Override
    public String getBindingVersion() {
        return "0.4.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.4.0");
    }

}
