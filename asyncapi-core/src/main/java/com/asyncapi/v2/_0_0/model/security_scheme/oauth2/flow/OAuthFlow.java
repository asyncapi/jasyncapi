package com.asyncapi.v2._0_0.model.security_scheme.oauth2.flow;

import lombok.*;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import java.util.Map;

/**
 * Configuration details for a supported OAuth Flow
 *
 * This object MAY be extended with <a href="https://www.asyncapi.com/docs/specifications/2.0.0/#specificationExtensions">Specification Extensions</a>.
 *
 * @version 2.0.0
 * @see <a href="https://www.asyncapi.com/docs/specifications/2.0.0/#a-name-oauthflowobject-a-oauth-flow-object">OAuth Flow Object</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OAuthFlow {

    /**
     * The URL to be used for obtaining refresh tokens. This MUST be in the form of a URL.
     */
    @CheckForNull
    private String refreshUrl;

    /**
     * REQUIRED.
     *
     * The available scopes for the OAuth2 security scheme. A map between the scope name and a short description for it.
     */
    @Nonnull
    @NonNull
    private Map<String, String> scopes;

}
