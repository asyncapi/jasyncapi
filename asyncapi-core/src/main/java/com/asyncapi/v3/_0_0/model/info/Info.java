package com.asyncapi.v3._0_0.model.info;

import com.asyncapi.v3.Reference;
import com.asyncapi.v3._0_0.jackson.model.ExternalDocumentationDeserializer;
import com.asyncapi.v3._0_0.jackson.model.TagsDeserializer;
import com.asyncapi.v3._0_0.model.ExternalDocumentation;
import com.asyncapi.v3._0_0.model.Tag;
import com.asyncapi.v3.ExtendableObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * The object provides metadata about the API. The metadata can be used by the clients if needed.
 *
 * @version 3.0.0
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0-next-major-spec.14#infoObject">Info</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Info extends ExtendableObject {

    /**
     * Required.
     * <p>
     * The title of the application.
     */
    @NotNull
    @JsonProperty
    @Builder.Default
    private String title = "";

    /**
     * Required.
     * <p>
     * Provides the version of the application API (not to be confused with the specification version).
     */
    @NotNull
    @JsonProperty
    @Builder.Default
    private String version = "";

    /**
     * A short description of the application. CommonMark syntax can be used for rich text representation.
     */
    @Nullable
    @JsonProperty
    private String description;

    /**
     * A URL to the Terms of Service for the API. MUST be in the format of a URL.
     */
    @Nullable
    @JsonProperty
    private String termsOfService;

    /**
     * The contact information for the exposed API.
     */
    @Nullable
    @JsonProperty
    private Contact contact;

    /**
     * The license information for the exposed API.
     */
    @Nullable
    @JsonProperty
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
    private Object externalDocs;

}
