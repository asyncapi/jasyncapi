package com.asyncapi.v2._0_0.model.info;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

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
    @NotNull
    @JsonProperty
    private String title;

    /**
     * Required.
     *
     * Provides the version of the application API (not to be confused with the specification version).
     */
    @NotNull
    @JsonProperty
    private String version;

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
     * Extension fields in the form x-extension-field-name for the exposed API.
     */
    @JsonAnyGetter
    @JsonAnySetter
    @Builder.Default
    protected Map<String, String> extensionFields = new HashMap<String, String>();

}
