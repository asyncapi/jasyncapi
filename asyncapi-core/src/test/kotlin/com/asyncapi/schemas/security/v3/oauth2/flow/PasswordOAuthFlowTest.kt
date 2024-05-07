package com.asyncapi.schemas.security.v3.oauth2.flow

import com.asyncapi.v3.SerDeTest

class PasswordOAuthFlowTest: SerDeTest<PasswordOAuthFlow>() {

    override fun objectClass() = PasswordOAuthFlow::class.java

    override fun baseObjectJson() = "/schemas/security/v3/oauth2/flow/passwordOAuthFlow.json"

    override fun extendedObjectJson() = "/schemas/security/v3/oauth2/flow/passwordOAuthFlow - extended.json"

    override fun wronglyExtendedObjectJson() = "/schemas/security/v3/oauth2/flow/passwordOAuthFlow - wrongly extended.json"

    override fun build(): PasswordOAuthFlow {
        return PasswordOAuthFlow.passwordBuilder()
                .tokenUrl("https://example.com/api/oauth/token")
                .refreshUrl("https://example.com/api/oauth/refresh")
                .scopes(mapOf(
                        Pair("write:pets", "modify pets in your account"),
                        Pair("read:pets", "read your pets")
                ))
                .build()
    }

}