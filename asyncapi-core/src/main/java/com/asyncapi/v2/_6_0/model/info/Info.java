package com.asyncapi.v2._6_0.model.info;

import com.asyncapi.schemas.ExtendableObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
@EqualsAndHashCode(callSuper = true)
public class Info extends ExtendableObject {

    /**
     * Required.
     * <p>
     * The title of the application.
     */
    @NotNull
    @Builder.Default
    private String title = "";

    /**
     * Required.
     * <p>
     * Provides the version of the application API (not to be confused with the specification version).
     */
    @NotNull
    @Builder.Default
    private String version = "";

    /**
     * A short description of the application. CommonMark syntax can be used for rich text representation.
     */
    @Nullable
    private String description;

    /**
     * A URL to the Terms of Service for the API. MUST be in the format of a URL.
     */
    @Nullable
    private String termsOfService;

    /**
     * The contact information for the exposed API.
     */
    @Nullable
    private Contact contact;

    /**
     * The license information for the exposed API.
     */
    @Nullable
    private License license;

}
