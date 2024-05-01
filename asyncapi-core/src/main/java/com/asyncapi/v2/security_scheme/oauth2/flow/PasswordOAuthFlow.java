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
 * Configuration for the OAuth Resource Owner Protected Credentials flow
 * <p>
 * This object MAY be extended with {@link com.asyncapi.ExtendableObject}.
 *
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
    @NotNull
    private String tokenUrl = "";

    @Builder(builderMethodName = "passwordBuilder")
    public PasswordOAuthFlow(@Nullable String refreshUrl,
                             @NotNull Map<String, String> scopes,
                             @NotNull String tokenUrl) {
        super(refreshUrl, scopes);
        this.tokenUrl = tokenUrl;
    }

}
