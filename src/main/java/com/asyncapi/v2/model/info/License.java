package com.asyncapi.v2.model.info;

import lombok.*;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * License information for the exposed API.
 *
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class License {

    /**
     * Required. The license name used for the API.
     */
    @Nonnull
    @NonNull
    private String name;

    /**
     * A URL to the license used for the API. MUST be in the format of a URL.
     */
    @CheckForNull
    private String url;

}
