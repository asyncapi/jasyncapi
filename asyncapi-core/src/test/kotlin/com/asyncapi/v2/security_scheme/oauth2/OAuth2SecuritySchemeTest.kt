package com.asyncapi.v2.security_scheme.oauth2

import com.asyncapi.v2.SerDeTest
import com.asyncapi.v2.security_scheme.SecurityScheme

/**
 * @author Pavel Bodiachevskii
 */
class OAuth2SecuritySchemeTest: SerDeTest<OAuth2SecurityScheme>() {

    override fun objectClass() = OAuth2SecurityScheme::class.java

    override fun baseObjectJson() = "/json/v2/security_scheme/oauth2/oauth2.json"

    override fun extendedObjectJson() = "/json/v2/security_scheme/oauth2/oauth2 - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/security_scheme/oauth2/oauth2 - wrongly extended.json"

    override fun build(): SecurityScheme {
        return OAuth2SecurityScheme.oauth2Builder()
                .description("oauth2")
                .flows(OAuthFlowTest().build())
                .build()
    }

}
