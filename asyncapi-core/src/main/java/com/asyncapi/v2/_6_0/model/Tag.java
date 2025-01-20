package com.asyncapi.v2._6_0.model;

import com.asyncapi.schemas.asyncapi.ExtendableObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
@EqualsAndHashCode(callSuper = true)
public class Tag extends ExtendableObject {

    /**
     * Required. The name of the tag.
     */
    @NotNull
    @Builder.Default
    private String name = "";

    /**
     * A short description for the tag. <a href="https://spec.commonmark.org/">CommonMark syntax</a> can be used for rich text representation.
     */
    @Nullable
    private String description;

    /**
     * Additional external documentation for this tag.
     */
    @Nullable
    private ExternalDocumentation externalDocs;

}
