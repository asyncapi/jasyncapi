package com.asyncapi.schemas.asyncapi.security.v2.oauth2.flow;

import com.asyncapi.schemas.asyncapi.ExtendableObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

/**
 * Configuration for the OAuth Implicit flow
 * <p>
 * This object MAY be extended with {@link ExtendableObject}.
 *
 * @version 2.6.0
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0#oauthFlowObject">OAuth Flow Object</a>
 * @author Pavel Bodiachevskii
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ImplicitOAuthFlow extends OAuthFlow {

    /**
     * REQUIRED.
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
