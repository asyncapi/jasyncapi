package com.asyncapi.schemas.openapi.v3._0_0.properties;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Allows referencing an external resource for extended documentation.
 *
 * @see <a href="https://github.com/OAI/OpenAPI-Specification/blob/main/versions/3.0.0.md#external-documentation-object">Schema Object</a>
 * @see <a href="https://github.com/swagger-api/swagger-core/blob/v2.1.13/modules/swagger-models/src/main/java/io/swagger/v3/oas/models/ExternalDocumentation.java">ExternalDocumentation</a>
 *
 * @author Pavel Bodiachevskii
 * @version 3.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ExternalDocumentation extends Extensions {

    /**
     * A short description of the target documentation.
     * <p>
     * <a href="http://spec.commonmark.org/">CommonMark syntax</a> <b>MAY</b> be used for rich text representation.
     */
    @Nullable
    @JsonProperty("description")
    @JsonPropertyDescription("A short description of the target documentation.")
    public String description;

    /**
     * <b>REQUIRED</b>.
     * <p>
     * The URL for the target documentation. Value <b>MUST</b> be in the format of a URL.
     */
    @NotNull
    @JsonProperty("url")
    @JsonPropertyDescription("The URL for the target documentation.")
    public String url;

}
