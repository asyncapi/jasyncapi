package com.asyncapi.v3._0_0.model.info;

import com.asyncapi.schemas.asyncapi.ExtendableObject;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * License information for the exposed API.
 *
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#licenseObject">License</a>
 * @author Pavel Bodiachevskii
 * @version 3.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class License extends ExtendableObject {

    /**
     * <b>Required</b>.
     * <p>
     * The license name used for the API.
     */
    @NotNull
    @Builder.Default
    private String name = "";

    /**
     * A URL to the license used for the API. This MUST be in the form of an absolute URL.
     */
    @Nullable
    private String url;

}
