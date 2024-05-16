package com.asyncapi.schemas.security.v2.oauth2.flow

import com.asyncapi.schemas.asyncapi.security.v2.oauth2.flow.ImplicitOAuthFlow
import com.asyncapi.v2.SerDeTest

class ImplicitOAuthFlowTest: SerDeTest<ImplicitOAuthFlow>() {

    override fun objectClass() = ImplicitOAuthFlow::class.java

    override fun baseObjectJson() = "/schemas/security/v2/oauth2/flow/implicitOAuthFlow.json"

    override fun extendedObjectJson() = "/schemas/security/v2/oauth2/flow/implicitOAuthFlow - extended.json"

    override fun wronglyExtendedObjectJson() = "/schemas/security/v2/oauth2/flow/implicitOAuthFlow - wrongly extended.json"

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