package com.asyncapi.v2._6_0.model;

import lombok.*;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * Allows adding meta data to a single tag.
 *
 * @version 2.6.0
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0#tagsObject">Tag</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Tag {

    /**
     * Required. The name of the tag.
     */
    @Nonnull
    @NonNull
    private String name;

    /**
     * A short description for the tag. <a href="https://spec.commonmark.org/">CommonMark syntax</a> can be used for rich text representation.
     */
    @CheckForNull
    private String description;

    /**
     * Additional external documentation for this tag.
     */
    @CheckForNull
    private ExternalDocumentation externalDocs;

}
