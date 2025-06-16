package com.asyncapi.v3._0_0.model.info;

import com.asyncapi.lsp.TextDocumentCompletion;
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
    @TextDocumentCompletion(
            detail = "String",
            documentation = "The license name used for the API."
    )
    private String name = "";

    /**
     * A URL to the license used for the API. This MUST be in the form of an absolute URL.
     */
    @Nullable
    @TextDocumentCompletion(
            detail = "",
            documentation = "URL to the license\n\n" +
                    "A URL to the license used for the API.\n\n" +
                    "This MUST be in the form of an absolute URL."
    )
    private String url;

}
