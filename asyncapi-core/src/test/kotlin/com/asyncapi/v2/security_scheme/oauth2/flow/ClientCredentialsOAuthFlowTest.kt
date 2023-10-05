package com.asyncapi.v2.security_scheme.oauth2.flow

import com.asyncapi.v2.SerDeTest

class ClientCredentialsOAuthFlowTest: SerDeTest<ClientCredentialsOAuthFlow>() {

    override fun objectClass() = ClientCredentialsOAuthFlow::class.java

    override fun baseObjectJson() = "/json/v2/security_scheme/oauth2/flow/clientCredentialsOAuthFlow.json"

    override fun extendedObjectJson() = "/json/v2/security_scheme/oauth2/flow/clientCredentialsOAuthFlow - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/security_scheme/oauth2/flow/clientCredentialsOAuthFlow - wrongly extended.json"

    override fun build(): ClientCredentialsOAuthFlow {
        return ClientCredentialsOAuthFlow.clientCredentialsBuilder()
                .tokenUrl("https://example.com/api/oauth/token")
                .refreshUrl("https://example.com/api/oauth/refresh")
                .scopes(mapOf(
                        Pair("write:pets", "modify pets in your account"),
                        Pair("read:pets", "read your pets")
                ))
                .build()
    }

}