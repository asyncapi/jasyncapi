package com.asyncapi.v2._0_0.model.security_scheme.oauth2.flow;

import lombok.*;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Map;

/**
 * @version 2.0.0
 * @see <a href="https://www.asyncapi.com/docs/specifications/2.0.0/#a-name-oauthflowobject-a-oauth-flow-object">OAuth Flow Object</a>
 * @author Pavel Bodiachevskii
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AuthorizationCodeOAuthFlow extends OAuthFlow {

    /**
     * REQUIRED.
     *
     * The authorization URL to be used for this flow. This MUST be in the form of a URL
     */
    @Nonnull
    @NonNull
    private String authorizationUrl;

    /**
     * REQUIRED.
     *
     * The token URL to be used for this flow. This MUST be in the form of a URL.
     */
    @Nonnull
    @NonNull
    private String tokenUrl;

    @Builder(builderMethodName = "authorizationCodeOAuthFlowBuilder")
    public AuthorizationCodeOAuthFlow(@Nullable String refreshUrl,
                                      @Nonnull @NonNull Map<String, String> scopes,
                                      @Nonnull @NonNull String authorizationUrl,
                                      @Nonnull @NonNull String tokenUrl) {
        super(refreshUrl, scopes);
        this.authorizationUrl = authorizationUrl;
        this.tokenUrl = tokenUrl;
    }

}
