package com.asyncapi.v2.security_scheme.oauth2.flow;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

/**
 * This object MAY be extended with <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0#specificationExtensions">Specification Extensions</a>.
 *
 * @version 2.6.0
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
     * REQUIRED.
     * <p>
     * The token URL to be used for this flow. This MUST be in the form of an absolute URL.
     */
    @NotNull
    private String tokenUrl = "";

    @Builder(builderMethodName = "authorizationCodeOAuthFlowBuilder")
    public AuthorizationCodeOAuthFlow(@Nullable String refreshUrl,
                                      @NotNull Map<String, String> scopes,
                                      @NotNull String authorizationUrl,
                                      @NotNull String tokenUrl) {
        super(refreshUrl, scopes);
        this.authorizationUrl = authorizationUrl;
        this.tokenUrl = tokenUrl;
    }

}
