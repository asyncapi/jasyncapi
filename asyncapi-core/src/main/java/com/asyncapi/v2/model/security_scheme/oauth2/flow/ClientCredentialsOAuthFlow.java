package com.asyncapi.v2.model.security_scheme.oauth2.flow;

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
public class ClientCredentialsOAuthFlow extends OAuthFlow {

    /**
     * REQUIRED.
     *
     * The token URL to be used for this flow. This MUST be in the form of a URL.
     */
    @Nonnull
    @NonNull
    private String tokenUrl;

    @Builder(builderMethodName = "clientCredentialsOAuthFlowBuilder")
    public ClientCredentialsOAuthFlow(@Nullable String refreshUrl,
                                      @Nonnull @NonNull Map<String, String> scopes,
                                      @Nonnull @NonNull String tokenUrl) {
        super(refreshUrl, scopes);
        this.tokenUrl = tokenUrl;
    }

}
