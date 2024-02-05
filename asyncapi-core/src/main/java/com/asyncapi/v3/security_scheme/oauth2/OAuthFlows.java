package com.asyncapi.v3.security_scheme.oauth2;

import com.asyncapi.v3.ExtendableObject;
import com.asyncapi.v3.security_scheme.oauth2.flow.AuthorizationCodeOAuthFlow;
import com.asyncapi.v3.security_scheme.oauth2.flow.ClientCredentialsOAuthFlow;
import com.asyncapi.v3.security_scheme.oauth2.flow.ImplicitOAuthFlow;
import com.asyncapi.v3.security_scheme.oauth2.flow.PasswordOAuthFlow;
import lombok.*;
import org.jetbrains.annotations.Nullable;

/**
 * Allows configuration of the supported OAuth Flows.
 * <p>
 * This object MAY be extended with {@link ExtendableObject}.
 *
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#oauthFlowsObject">OAuth Flows</a>
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#securitySchemeObject">Security Scheme</a>
 * @author Pavel Bodiachevskii
 * @version 3.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OAuthFlows extends ExtendableObject {

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
