package com.asyncapi.v2.security_scheme.oauth2;

import com.asyncapi.v2.security_scheme.SecurityScheme;
import lombok.*;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @version 2.6.0
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0#securitySchemeObject">SecurityScheme</a>
 * @author Pavel Bodiachevskii
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class OAuth2SecurityScheme extends SecurityScheme {

    /**
     * REQUIRED.
     * <p>
     * An object containing configuration information for the flow types supported.
     */
    @Nonnull
    private OAuthFlows flows;

    @Builder(builderMethodName = "oauth2SecuritySchemeBuilder")
    public OAuth2SecurityScheme(@Nonnull Type type,
                                @Nullable String description,
                                @Nonnull OAuthFlows flows) {
        super(type, description);
        this.flows = flows;
    }

}
