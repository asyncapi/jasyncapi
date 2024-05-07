package com.asyncapi.schemas.security.v3.oauth2

import com.asyncapi.schemas.security.v3.oauth2.flow.AuthorizationCodeOAuthFlowTest
import com.asyncapi.schemas.security.v3.oauth2.flow.ClientCredentialsOAuthFlowTest
import com.asyncapi.schemas.security.v3.oauth2.flow.ImplicitOAuthFlowTest
import com.asyncapi.schemas.security.v3.oauth2.flow.PasswordOAuthFlowTest
import com.asyncapi.v3.SerDeTest

/**
 * @author Pavel Bodiachevskii
 */
class OAuthFlowTest: SerDeTest<OAuthFlows>() {

    override fun objectClass() = OAuthFlows::class.java

    override fun baseObjectJson() = "/schemas/security/v3/oauth2/oauthFlows.json"

    override fun extendedObjectJson() = "/schemas/security/v3/oauth2/oauthFlows - extended.json"

    override fun wronglyExtendedObjectJson() = "/schemas/security/v3/oauth2/oauthFlows - wrongly extended.json"

    override fun build(): OAuthFlows {
        return OAuthFlows.builder()
                .authorizationCode(AuthorizationCodeOAuthFlowTest().build())
                .clientCredentials(ClientCredentialsOAuthFlowTest().build())
                .implicit(ImplicitOAuthFlowTest().build())
                .password(PasswordOAuthFlowTest().build())
                .build()
    }

}
