package com.asyncapi.v2.security_scheme.oauth2.flow

import com.asyncapi.v2.SerDeTest

class AuthorizationCodeOAuthFlowTest: SerDeTest<AuthorizationCodeOAuthFlow>() {

    override fun objectClass() = AuthorizationCodeOAuthFlow::class.java

    override fun baseObjectJson() = "/json/v2/security_scheme/oauth2/flow/authorizationCodeOAuthFlow.json"

    override fun extendedObjectJson() = "/json/v2/security_scheme/oauth2/flow/authorizationCodeOAuthFlow - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/security_scheme/oauth2/flow/authorizationCodeOAuthFlow - wrongly extended.json"

    override fun build(): AuthorizationCodeOAuthFlow {
        return AuthorizationCodeOAuthFlow.authorizationCodeBuilder()
                .authorizationUrl("https://example.com/api/oauth/dialog")
                .tokenUrl("https://example.com/api/oauth/token")
                .refreshUrl("https://example.com/api/oauth/refresh")
                .scopes(mapOf(
                        Pair("write:pets", "modify pets in your account"),
                        Pair("read:pets", "read your pets")
                ))
                .build()
    }

}