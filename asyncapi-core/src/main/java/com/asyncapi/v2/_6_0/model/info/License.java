package com.asyncapi.v2._6_0.model.info;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * License information for the exposed API.
 *
 * @version 2.6.0
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0#licenseObject">License</a>
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
    @NotNull
    private String name;

    /**
     * A URL to the license used for the API. MUST be in the format of a URL.
     */
    @Nullable
    private String url;

}
