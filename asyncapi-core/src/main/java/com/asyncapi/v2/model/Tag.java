package com.asyncapi.v2.model;

import lombok.*;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * Allows adding meta data to a single tag.
 *
 * @version 2.0.0
 * @see <a href="https://www.asyncapi.com/docs/specifications/2.0.0/#a-name-tagobject-a-tag-object">Tag</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tag {

    /**
     * Required. The name of the tag.
     */
    @Nonnull
    @NonNull
    private String name;

    /**
     * A short description for the tag. CommonMark syntax can be used for rich text representation.
     */
    @CheckForNull
    private String description;

    /**
     * Additional external documentation for this tag.
     */
    @CheckForNull
    private ExternalDocumentation externalDocs;

}
