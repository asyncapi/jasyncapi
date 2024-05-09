package com.asyncapi.schemas.security.v3.oauth2.flow

import com.asyncapi.schemas.asyncapi.security.v3.oauth2.flow.OAuthFlow
import com.asyncapi.v3.SerDeTest

class OAuthFlowTest: SerDeTest<OAuthFlow>() {

    override fun objectClass() = OAuthFlow::class.java

    override fun baseObjectJson() = "/schemas/security/v3/oauth2/flow/oauthFlow.json"

    override fun extendedObjectJson() = "/schemas/security/v3/oauth2/flow/oauthFlow - extended.json"

    override fun wronglyExtendedObjectJson() = "/schemas/security/v3/oauth2/flow/oauthFlow - wrongly extended.json"

    override fun build(): OAuthFlow {
        return OAuthFlow.builder()
                .refreshUrl("https://example.com/api/oauth/refresh")
                .availableScopes(mapOf(
                        Pair("write:pets", "modify pets in your account"),
                        Pair("read:pets", "read your pets")
                ))
                .build()
    }

}