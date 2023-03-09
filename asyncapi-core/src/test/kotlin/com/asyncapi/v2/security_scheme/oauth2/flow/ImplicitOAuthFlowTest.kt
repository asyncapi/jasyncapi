package com.asyncapi.v2.security_scheme.oauth2.flow

import com.asyncapi.v2.SerDeTest

class ImplicitOAuthFlowTest: SerDeTest<ImplicitOAuthFlow>() {

    override fun objectClass() = ImplicitOAuthFlow::class.java

    override fun baseObjectJson() = "/json/2.6.0/model/security_scheme/oauth2/flow/implicitOAuthFlow.json"

    override fun extendedObjectJson() = "/json/2.6.0/model/security_scheme/oauth2/flow/implicitOAuthFlow - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/2.6.0/model/security_scheme/oauth2/flow/implicitOAuthFlow - wrongly extended.json"

    override fun build(): ImplicitOAuthFlow {
        return ImplicitOAuthFlow.implicitOAuthFlowBuilder()
                .authorizationUrl("https://example.com/api/oauth/dialog")
                .refreshUrl("https://example.com/api/oauth/refresh")
                .scopes(mapOf(
                        Pair("write:pets", "modify pets in your account"),
                        Pair("read:pets", "read your pets")
                ))
                .build()
    }

}