package com.asyncapi.v2.security_scheme.oauth2.flow;

import lombok.*;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import java.util.Map;

/**
 * Configuration details for a supported OAuth Flow
 * <p>
 * This object MAY be extended with <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0#specificationExtensions">Specification Extensions</a>.
 *
 * @version 2.6.0
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0#oauthFlowObject">OAuth Flow Object</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OAuthFlow {

    /**
     * The URL to be used for obtaining refresh tokens. This MUST be in the form of an absolute URL.
     */
    @CheckForNull
    private String refreshUrl;

    /**
     * REQUIRED.
     * <p>
     * The available scopes for the OAuth2 security scheme. A map between the scope name and a short description for it.
     */
    @Nonnull
    private Map<String, String> scopes;

}
