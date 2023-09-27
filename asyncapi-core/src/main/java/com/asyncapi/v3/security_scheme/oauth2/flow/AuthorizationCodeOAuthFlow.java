package com.asyncapi.v3.security_scheme.oauth2.flow;

import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

/**
 * This object MAY be extended with <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0#specificationExtensions">Specification Extensions</a>.
 *
 * @version 3.0.0
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0#oauthFlowObject">OAuth Flow Object</a>
 * @author Pavel Bodiachevskii
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AuthorizationCodeOAuthFlow extends OAuthFlow {

    /**
     * REQUIRED.
     * <p>
     * The authorization URL to be used for this flow. This MUST be in the form of an absolute URL.
     */
    @NotNull
    private String authorizationUrl = "";

    /**
     * The token URL to be used for this flow. This MUST be in the form of an absolute URL.
     */
    @Nullable
    private String tokenUrl = "";

    @Builder(builderMethodName = "authorizationCodeBuilder")
    public AuthorizationCodeOAuthFlow(@Nullable String refreshUrl,
                                      @NotNull Map<String, String> scopes,
                                      @NotNull String authorizationUrl,
                                      @Nullable String tokenUrl) {
        super(refreshUrl, scopes);
        this.authorizationUrl = authorizationUrl;
        this.tokenUrl = tokenUrl;
    }

}
