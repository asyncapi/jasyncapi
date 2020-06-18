package com.asyncapi.v2.model.security_scheme.oauth2;

import com.asyncapi.v2.model.security_scheme.oauth2.flow.AuthorizationCodeOAuthFlow;
import com.asyncapi.v2.model.security_scheme.oauth2.flow.ClientCredentialsOAuthFlow;
import com.asyncapi.v2.model.security_scheme.oauth2.flow.ImplicitOAuthFlow;
import com.asyncapi.v2.model.security_scheme.oauth2.flow.PasswordOAuthFlow;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.CheckForNull;

/**
 * Allows configuration of the supported OAuth Flows.
 *
 * This object MAY be extended with <a href="https://www.asyncapi.com/docs/specifications/2.0.0/#specificationExtensions">Specification Extensions</a>.
 *
 * @version 2.0.0
 * @see <a href="https://www.asyncapi.com/docs/specifications/2.0.0/#a-name-oauthflowsobject-a-oauth-flows-object">OAuth Flows Object</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OAuthFlows {

    /**
     * Configuration for the OAuth Implicit flow
     */
    @CheckForNull
    private ImplicitOAuthFlow implicit;

    /**
     * Configuration for the OAuth Resource Owner Protected Credentials flow
     */
    @CheckForNull
    private PasswordOAuthFlow password;

    /**
     * Configuration for the OAuth Client Credentials flow.
     */
    @CheckForNull
    private ClientCredentialsOAuthFlow clientCredentials;

    /**
     * Configuration for the OAuth Authorization Code flow
     */
    @CheckForNull
    private AuthorizationCodeOAuthFlow authorizationCode;

}
