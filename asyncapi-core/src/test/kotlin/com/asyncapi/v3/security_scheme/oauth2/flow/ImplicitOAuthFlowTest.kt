package com.asyncapi.v3.security_scheme.oauth2.flow

import com.asyncapi.schemas.security.oauth2.flow.ImplicitOAuthFlow
import com.asyncapi.v3.SerDeTest

class ImplicitOAuthFlowTest: SerDeTest<ImplicitOAuthFlow>() {

    override fun objectClass() = ImplicitOAuthFlow::class.java

    override fun baseObjectJson() = "/json/v3/security_scheme/oauth2/flow/implicitOAuthFlow.json"

    override fun extendedObjectJson() = "/json/v3/security_scheme/oauth2/flow/implicitOAuthFlow - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/security_scheme/oauth2/flow/implicitOAuthFlow - wrongly extended.json"

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