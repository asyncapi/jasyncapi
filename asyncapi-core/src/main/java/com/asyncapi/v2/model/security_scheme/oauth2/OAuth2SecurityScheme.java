package com.asyncapi.v2.model.security_scheme.oauth2;

import com.asyncapi.v2.model.security_scheme.SecurityScheme;
import lombok.*;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @author Pavel Bodiachevskii
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class OAuth2SecurityScheme extends SecurityScheme {

    /**
     * REQUIRED.
     *
     * An object containing configuration information for the flow types supported.
     */
    @Nonnull
    @NonNull
    private OAuthFlows flows;

    @Builder(builderMethodName = "oauth2SecuritySchemeBuilder")
    public OAuth2SecurityScheme(@Nonnull @NonNull Type type,
                                @Nullable String description,
                                @Nonnull @NonNull OAuthFlows flows) {
        super(type, description);
        this.flows = flows;
    }

}
