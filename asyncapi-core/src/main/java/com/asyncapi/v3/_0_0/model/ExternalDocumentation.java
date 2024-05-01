package com.asyncapi.v3._0_0.model;

import com.asyncapi.schemas.ExtendableObject;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Allows referencing an external resource for extended documentation.
 *
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#externalDocumentationObject">ExternalDocumentation</a>
 * @author Pavel Bodiachevskii
 * @version 3.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ExternalDocumentation extends ExtendableObject {

    /**
     * A short description of the target documentation. <a href="https://spec.commonmark.org/">CommonMark syntax</a> can be used for rich text representation.
     */
    @Nullable
    private String description;

    /**
     * <b>Required</b>.
     * <p>
     * The URL for the target documentation. Value MUST be in the format of a URL.
     */
    @NotNull
    @Builder.Default
    private String url = "";

}
