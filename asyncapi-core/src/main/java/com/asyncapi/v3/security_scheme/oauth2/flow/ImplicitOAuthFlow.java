package com.asyncapi.v3.security_scheme.oauth2.flow;

import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

/**
 * Configuration for the OAuth Implicit flow
 * <p>
 * This object MAY be extended with {@link com.asyncapi.v3.ExtendableObject}.
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
public class ImplicitOAuthFlow extends OAuthFlow {

    /**
     * <b>REQUIRED</b>.
     * <p>
     * The authorization URL to be used for this flow. This MUST be in the form of a URL
     */
    @NotNull
    private String authorizationUrl = "";

    @Builder(builderMethodName = "implicitBuilder")
    public ImplicitOAuthFlow(@Nullable String refreshUrl,
                             @NotNull Map<String, String> scopes,
                             @NotNull String authorizationUrl) {
        super(refreshUrl, scopes);
        this.authorizationUrl = authorizationUrl;
    }

}
