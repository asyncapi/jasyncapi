package com.asyncapi.schemas.security.v3.oauth2

import com.asyncapi.v3.SerDeTest
import com.asyncapi.schemas.asyncapi.security.v3.SecurityScheme
import com.asyncapi.schemas.asyncapi.security.v3.oauth2.OAuth2SecurityScheme

/**
 * @author Pavel Bodiachevskii
 */
class OAuth2SecuritySchemeTest: SerDeTest<OAuth2SecurityScheme>() {

    override fun objectClass() = OAuth2SecurityScheme::class.java

    override fun baseObjectJson() = "/schemas/security/v3/oauth2/oauth2.json"

    override fun extendedObjectJson() = "/schemas/security/v3/oauth2/oauth2 - extended.json"

    override fun wronglyExtendedObjectJson() = "/schemas/security/v3/oauth2/oauth2 - wrongly extended.json"

    override fun build(): SecurityScheme {
        return OAuth2SecurityScheme.oauth2Builder()
                .description("oauth2")
                .flows(OAuthFlowTest().build())
                .scopes(listOf("write:pets", "read:pets"))
                .build()
    }

}
