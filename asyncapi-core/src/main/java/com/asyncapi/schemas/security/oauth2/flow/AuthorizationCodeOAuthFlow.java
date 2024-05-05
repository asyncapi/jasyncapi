package com.asyncapi.schemas.security.oauth2.flow;

import com.asyncapi.schemas.ExtendableObject;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

/**
 * Configuration for the OAuth Authorization Code flow
 * <p>
 * This object MAY be extended with {@link ExtendableObject}.
 *
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#oauthFlowObject">OAuth Flow</a>
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#specificationExtensions">Specification Extensions</a>
 * @author Pavel Bodiachevskii
 * @version 3.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AuthorizationCodeOAuthFlow extends OAuthFlow {

    /**
     * <b>REQUIRED</b>.
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
                                      @NotNull Map<String, String> availableScopes,
                                      @NotNull String authorizationUrl,
                                      @Nullable String tokenUrl) {
        super(refreshUrl, availableScopes);
        this.authorizationUrl = authorizationUrl;
        this.tokenUrl = tokenUrl;
    }

}
