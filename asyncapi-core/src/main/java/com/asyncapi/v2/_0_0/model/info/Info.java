package com.asyncapi.v2._0_0.model.info;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The object provides metadata about the API. The metadata can be used by the clients if needed.
 *
 * @version 2.0.0
 * @see <a href="https://www.asyncapi.com/docs/specifications/2.0.0/#infoObject">Info</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Info {

    /**
     * Required.
     *
     * The title of the application.
     */
    @Nonnull
    @NonNull
    @JsonProperty
    private String title;

    /**
     * Required.
     *
     * Provides the version of the application API (not to be confused with the specification version).
     */
    @Nonnull
    @NonNull
    @JsonProperty
    private String version;

    /**
     * A short description of the application. CommonMark syntax can be used for rich text representation.
     */
    @CheckForNull
    @JsonProperty
    private String description;

    /**
     * A URL to the Terms of Service for the API. MUST be in the format of a URL.
     */
    @CheckForNull
    @JsonProperty
    private String termsOfService;

    /**
     * The contact information for the exposed API.
     */
    @CheckForNull
    @JsonProperty
    private Contact contact;

    /**
     * The license information for the exposed API.
     */
    @CheckForNull
    @JsonProperty
    private License license;

    /**
     * Extension fields in the form x-extension-field-name for the exposed API.
     */
    @JsonAnyGetter
    @JsonAnySetter
    @Builder.Default
    protected Map<String, String> extensionFields = new HashMap<String, String>();

}
