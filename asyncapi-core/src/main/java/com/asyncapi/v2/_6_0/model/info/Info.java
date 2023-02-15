package com.asyncapi.v2._6_0.model.info;

import lombok.*;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * The object provides metadata about the API. The metadata can be used by the clients if needed.
 *
 * @version 2.6.0
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0#infoObject">Info</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Info {

    /**
     * Required.
     * <p>
     * The title of the application.
     */
    @Nonnull
    @NonNull
    private String title;

    /**
     * Required.
     * <p>
     * Provides the version of the application API (not to be confused with the specification version).
     */
    @Nonnull
    @NonNull
    private String version;

    /**
     * A short description of the application. CommonMark syntax can be used for rich text representation.
     */
    @CheckForNull
    private String description;

    /**
     * A URL to the Terms of Service for the API. MUST be in the format of a URL.
     */
    @CheckForNull
    private String termsOfService;

    /**
     * The contact information for the exposed API.
     */
    @CheckForNull
    private Contact contact;

    /**
     * The license information for the exposed API.
     */
    @CheckForNull
    private License license;

}
