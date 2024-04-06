package com.asyncapi.v3.schema.openapi.properties;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

/**
 * When request bodies or response payloads may be one of a number of different schemas,
 * a discriminator object can be used to aid in serialization, deserialization, and validation.
 * <p>
 * The discriminator is a specific object in a schema which is used to inform the consumer of the
 * specification of an alternative schema based on the value associated with it.
 * <p>
 * When using the discriminator, inline schemas will not be considered.
 * <p>
 * The discriminator attribute is legal only when using one of the composite keywords oneOf, anyOf, allOf.
 *
 * @see <a href="https://github.com/OAI/OpenAPI-Specification/blob/main/versions/3.0.0.md#discriminator-object">Discriminator Object</a>
 * @see <a href="https://github.com/swagger-api/swagger-core/blob/v2.1.13/modules/swagger-models/src/main/java/io/swagger/v3/oas/models/media/Discriminator.java">Discriminator</a>
 *
 * @author Pavel Bodiachevskii
 * @version 3.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Discriminator {

    /**
     * <b>REQUIRED</b>.
     * <p>
     * The name of the property in the payload that will hold the discriminator value.
     */
    @NotNull
    @JsonProperty("propertyName")
    @JsonPropertyDescription("The name of the property in the payload that will hold the discriminator value.")
    public String propertyName;

    /**
     * An object to hold mappings between payload values and schema names or references.
     */
    @Nullable
    @JsonProperty("mapping")
    @JsonPropertyDescription("An object to hold mappings between payload values and schema names or references.")
    public Map<String, String> mapping;

}
