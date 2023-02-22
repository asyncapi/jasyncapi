package com.asyncapi.v2._0_0.model;

import com.asyncapi.v2.ExtendableObject;
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
 * @version 2.0.0
 * @see <a href="https://www.asyncapi.com/docs/specifications/2.0.0/#a-name-tagobject-a-tag-object">Tag</a>
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
    private String name;

    /**
     * A short description for the tag. CommonMark syntax can be used for rich text representation.
     */
    @Nullable
    private String description;

    /**
     * Additional external documentation for this tag.
     */
    @Nullable
    private ExternalDocumentation externalDocs;

}
