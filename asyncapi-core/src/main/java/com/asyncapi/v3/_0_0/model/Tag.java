package com.asyncapi.v3._0_0.model;

import com.asyncapi.lsp.TextDocumentCompletion;
import com.asyncapi.schemas.asyncapi.ExtendableObject;
import com.asyncapi.schemas.asyncapi.Reference;
import com.asyncapi.v3._0_0.jackson.model.ExternalDocumentationDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Allows adding meta data to a single tag.
 *
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#tagObject">Tag</a>
 * @author Pavel Bodiachevskii
 * @version 3.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Tag extends ExtendableObject {

    /**
     * <b>Required</b>.
     * <p>
     * The name of the tag.
     */
    @NotNull
    @Builder.Default
    @TextDocumentCompletion(
            detail = "String",
            documentation = "The name of the tag."
    )
    private String name = "";

    /**
     * A short description for the tag. <a href="https://spec.commonmark.org/">CommonMark syntax</a> can be used for rich text representation.
     */
    @Nullable
    @TextDocumentCompletion(
            detail = "String",
            documentation = "A short description for the tag. CommonMark syntax can be used for rich text representation."
    )
    private String description;

    /**
     * Additional external documentation for this tag.
     * MUST BE:
     * <ul>
     *     <li>{@link ExternalDocumentation}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ExternalDocumentationDeserializer.class)
    @TextDocumentCompletion(
            detail = "ExternalDocumentation | Reference",
            documentation = "External documentation for this tag",
            variants = {ExternalDocumentation.class, Reference.class}
    )
    private Object externalDocs;

}
