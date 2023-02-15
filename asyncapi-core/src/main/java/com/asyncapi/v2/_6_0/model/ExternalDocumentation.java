package com.asyncapi.v2._6_0.model;

import lombok.*;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * TODO: This object can be extended with Specification Extensions.
 *  https://www.asyncapi.com/docs/reference/specification/v2.6.0#specificationExtensions
 * <p>
 * Allows referencing an external resource for extended documentation.
 *
 * @version 2.6.0
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0#externalDocumentationObject">ExternalDocumentation</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ExternalDocumentation {

    /**
     * A short description of the target documentation. <a href="https://spec.commonmark.org/">CommonMark syntax</a> can be used for rich text representation.
     */
    @CheckForNull
    private String description;

    /**
     * Required.
     * <p>
     * The URL for the target documentation. Value MUST be in the format of a URL.
     */
    @Nonnull
    @NonNull
    private String url;

}
