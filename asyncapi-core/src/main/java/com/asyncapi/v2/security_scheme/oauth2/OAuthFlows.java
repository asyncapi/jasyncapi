package com.asyncapi.v2.security_scheme.oauth2;

import com.asyncapi.v2.security_scheme.oauth2.flow.AuthorizationCodeOAuthFlow;
import com.asyncapi.v2.security_scheme.oauth2.flow.ClientCredentialsOAuthFlow;
import com.asyncapi.v2.security_scheme.oauth2.flow.ImplicitOAuthFlow;
import com.asyncapi.v2.security_scheme.oauth2.flow.PasswordOAuthFlow;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

/**
 * Allows configuration of the supported OAuth Flows.
 * <p>
 * This object MAY be extended with <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0#specificationExtensions">Specification Extensions</a>.
 *
 * @version 2.6.0
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0#oauthFlowsObject">OAuth Flows Object</a>
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
    @Nullable
    private ImplicitOAuthFlow implicit;

    /**
     * Configuration for the OAuth Resource Owner Protected Credentials flow
     */
    @Nullable
    private PasswordOAuthFlow password;

    /**
     * Configuration for the OAuth Client Credentials flow.
     */
    @Nullable
    private ClientCredentialsOAuthFlow clientCredentials;

    /**
     * Configuration for the OAuth Authorization Code flow
     */
    @Nullable
    private AuthorizationCodeOAuthFlow authorizationCode;

}
