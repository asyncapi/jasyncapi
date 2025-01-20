package com.asyncapi.schemas.security.v3.oauth2.flow

import com.asyncapi.schemas.asyncapi.security.v3.oauth2.flow.ClientCredentialsOAuthFlow
import com.asyncapi.v3.SerDeTest

class ClientCredentialsOAuthFlowTest: SerDeTest<ClientCredentialsOAuthFlow>() {

    override fun objectClass() = ClientCredentialsOAuthFlow::class.java

    override fun baseObjectJson() = "/schemas/security/v3/oauth2/flow/clientCredentialsOAuthFlow.json"

    override fun extendedObjectJson() = "/schemas/security/v3/oauth2/flow/clientCredentialsOAuthFlow - extended.json"

    override fun wronglyExtendedObjectJson() = "/schemas/security/v3/oauth2/flow/clientCredentialsOAuthFlow - wrongly extended.json"

    override fun build(): ClientCredentialsOAuthFlow {
        return ClientCredentialsOAuthFlow.clientCredentialsBuilder()
                .tokenUrl("https://example.com/api/oauth/token")
                .refreshUrl("https://example.com/api/oauth/refresh")
                .availableScopes(mapOf(
                        Pair("write:pets", "modify pets in your account"),
                        Pair("read:pets", "read your pets")
                ))
                .build()
    }

}