package com.asyncapi.v2._0_0.model.info;

import com.asyncapi.schemas.ExtendableObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * License information for the exposed API.
 *
 * @version 2.0.0
 * @see <a href="https://www.asyncapi.com/docs/specifications/2.0.0/#licenseObject">License</a>
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
