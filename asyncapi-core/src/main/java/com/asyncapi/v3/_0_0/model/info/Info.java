package com.asyncapi.v3._0_0.model.info;

import com.asyncapi.lsp.TextDocumentCompletion;
import com.asyncapi.schemas.asyncapi.Reference;
import com.asyncapi.v3._0_0.jackson.model.ExternalDocumentationDeserializer;
import com.asyncapi.v3._0_0.jackson.model.TagsDeserializer;
import com.asyncapi.v3._0_0.model.ExternalDocumentation;
import com.asyncapi.v3._0_0.model.Tag;
import com.asyncapi.schemas.asyncapi.ExtendableObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * The object provides metadata about the API. The metadata can be used by the clients if needed.
 *
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#infoObject">Info</a>
 * @author Pavel Bodiachevskii
 * @version 3.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Info extends ExtendableObject {

    /**
     * <b>Required</b>.
     * <p>
     * The title of the application.
     */
    @NotNull
    @JsonProperty
    @Builder.Default
    @TextDocumentCompletion(
            detail = "String",
            documentation = "The title of the application."
    )
    private String title = "";

    /**
     * <b>Required</b>.
     * <p>
     * Provides the version of the application API (not to be confused with the specification version).
     */
    @NotNull
    @JsonProperty
    @Builder.Default
    @TextDocumentCompletion(
            detail = "String",
            documentation = "Version of the application API\n\n" +
                    "Provides the version of the application API (not to be confused with the specification version)."
    )
    private String version = "";

    /**
     * A short description of the application. <a href="https://spec.commonmark.org/">CommonMark syntax</a> can be used
     * for rich text representation.
     */
    @Nullable
    @JsonProperty
    @TextDocumentCompletion(
            detail = "String",
            documentation = "Description of the application\n\n" +
                    "A short description of the application. CommonMark syntax can be used for rich text representation."
    )
    private String description;

    /**
     * A URL to the Terms of Service for the API. This MUST be in the form of an absolute URL.
     */
    @Nullable
    @JsonProperty
    @TextDocumentCompletion(
            detail = "String",
            documentation = "URL to the Terms of Service\n\n" +
                    "A URL to the Terms of Service for the API. This MUST be in the form of an absolute URL."
    )
    private String termsOfService;

    /**
     * The contact information for the exposed API.
     */
    @Nullable
    @JsonProperty
    @TextDocumentCompletion(
            detail = "Contact",
            documentation = "Contact information for the API\n\n" +
                    "The contact information for the exposed API.",
            variants = {Contact.class}
    )
    private Contact contact;

    /**
     * The license information for the exposed API.
     */
    @Nullable
    @JsonProperty
    @TextDocumentCompletion(
            detail = "License",
            documentation = "License information for the API\n\n" +
                    "The license information for the exposed API.",
            variants = {License.class}
    )
    private License license;

    /**
     * A list of tags for application API documentation control. Tags can be used for logical grouping of applications.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link Tag}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonProperty
    @JsonDeserialize(using = TagsDeserializer.class)
    @TextDocumentCompletion(
            detail = "List<Tag | Reference>",
            documentation = "Tags for API documentation control\n\n" +
                    "A list of tags for application API documentation control.\n\n" +
                    "Tags can be used for logical grouping of applications.",
            variants = {Tag.class, Reference.class}
    )
    private List<Object> tags;

    /**
     * Additional external documentation of the exposed API.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link ExternalDocumentation}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonProperty
    @JsonDeserialize(using = ExternalDocumentationDeserializer.class)
    @TextDocumentCompletion(
            detail = "ExternalDocumentation | Reference",
            documentation = "External documentation of the API\n\n" +
                    "Additional external documentation of the exposed API.",
            variants = {ExternalDocumentation.class, Reference.class}
    )
    private Object externalDocs;

}
