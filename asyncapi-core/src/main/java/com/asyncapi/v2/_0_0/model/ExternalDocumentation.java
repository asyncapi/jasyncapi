package com.asyncapi.v2._0_0.model;

import com.asyncapi.schemas.ExtendableObject;
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
 * @version 2.0.0
 * @see <a href="https://www.asyncapi.com/docs/specifications/2.0.0/#externalDocumentationObject">ExternalDocumentation</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ExternalDocumentation extends ExtendableObject {

    /**
     * A short description of the target documentation. CommonMark syntax can be used for rich text representation.
     */
    @Nullable
    private String description;

    /**
     * Required.
     * <p>
     * The URL for the target documentation. Value MUST be in the format of a URL.
     */
    @NotNull
    @Builder.Default
    private String url = "";

}
