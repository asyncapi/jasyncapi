package com.asyncapi.v2.security_scheme.oauth2.flow

import com.asyncapi.v2.SerDeTest

class ImplicitOAuthFlowTest: SerDeTest<ImplicitOAuthFlow>() {

    override fun objectClass() = ImplicitOAuthFlow::class.java

    override fun baseObjectJson() = "/json/v2/security_scheme/oauth2/flow/implicitOAuthFlow.json"

    override fun extendedObjectJson() = "/json/v2/security_scheme/oauth2/flow/implicitOAuthFlow - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/security_scheme/oauth2/flow/implicitOAuthFlow - wrongly extended.json"

    override fun build(): ImplicitOAuthFlow {
        return ImplicitOAuthFlow.implicitBuilder()
                .authorizationUrl("https://example.com/api/oauth/dialog")
                .refreshUrl("https://example.com/api/oauth/refresh")
                .scopes(mapOf(
                        Pair("write:pets", "modify pets in your account"),
                        Pair("read:pets", "read your pets")
                ))
                .build()
    }

}