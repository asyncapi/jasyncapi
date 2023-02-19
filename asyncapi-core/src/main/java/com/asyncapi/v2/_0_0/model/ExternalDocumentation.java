package com.asyncapi.v2._0_0.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * TODO: This object can be extended with Specification Extensions.
 *  https://www.asyncapi.com/docs/specifications/2.0.0/#specificationExtensions
 *
 * Allows referencing an external resource for extended documentation.
 *
 * @version 2.0.0
 * @see <a href="https://www.asyncapi.com/docs/specifications/2.0.0/#externalDocumentationObject">ExternalDocumentation</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExternalDocumentation {

    /**
     * A short description of the target documentation. CommonMark syntax can be used for rich text representation.
     */
    @CheckForNull
    private String description;

    /**
     * Required.
     *
     * The URL for the target documentation. Value MUST be in the format of a URL.
     */
    @Nonnull
    @NonNull
    private String url;

}
