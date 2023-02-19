package com.asyncapi.v2.security_scheme.oauth2.flow;

import lombok.*;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Map;

/**
 * @version 2.6.0
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0#oauthFlowObject">OAuth Flow Object</a>
 * @author Pavel Bodiachevskii
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PasswordOAuthFlow extends OAuthFlow {

    /**
     * REQUIRED.
     * <p>
     * The token URL to be used for this flow. This MUST be in the form of a URL.
     */
    @Nonnull
    private String tokenUrl;

    @Builder(builderMethodName = "passwordOAuthFlowBuilder")
    public PasswordOAuthFlow(@Nullable String refreshUrl,
                             @Nonnull Map<String, String> scopes,
                             @Nonnull String tokenUrl) {
        super(refreshUrl, scopes);
        this.tokenUrl = tokenUrl;
    }

}
