package com.asyncapi.v3.security_scheme.oauth2

import com.asyncapi.v3.SerDeTest
import com.asyncapi.v3.security_scheme.oauth2.flow.*

/**
 * @author Pavel Bodiachevskii
 */
class OAuthFlowTest: SerDeTest<OAuthFlows>() {

    override fun objectClass() = OAuthFlows::class.java

    override fun baseObjectJson() = "/json/v3/security_scheme/oauth2/oauthFlows.json"

    override fun extendedObjectJson() = "/json/v3/security_scheme/oauth2/oauthFlows - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/security_scheme/oauth2/oauthFlows - wrongly extended.json"

    override fun build(): OAuthFlows {
        return OAuthFlows.builder()
                .authorizationCode(AuthorizationCodeOAuthFlowTest().build())
                .clientCredentials(ClientCredentialsOAuthFlowTest().build())
                .implicit(ImplicitOAuthFlowTest().build())
                .password(PasswordOAuthFlowTest().build())
                .build()
    }

}
