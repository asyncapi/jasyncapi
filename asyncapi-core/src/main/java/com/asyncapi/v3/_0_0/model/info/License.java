package com.asyncapi.v3._0_0.model.info;

import com.asyncapi.v3.ExtendableObject;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * License information for the exposed API.
 *
 * @version 3.0.0
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0-next-major-spec.14#licenseObject">License</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class License extends ExtendableObject {

    /**
     * Required. The license name used for the API.
     */
    @NotNull
    @Builder.Default
    private String name = "";

    /**
     * A URL to the license used for the API. MUST be in the format of a URL.
     */
    @Nullable
    private String url;

}
