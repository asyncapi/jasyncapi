package com.asyncapi.v2.security_scheme.oauth2

import com.asyncapi.v2.SerDeTest
import com.asyncapi.v2.security_scheme.SecurityScheme

/**
 * @author Pavel Bodiachevskii
 */
class OAuth2SecuritySchemeTest: SerDeTest<OAuth2SecurityScheme>() {

    override fun objectClass() = OAuth2SecurityScheme::class.java

    override fun baseObjectJson() = "/json/2.6.0/model/security_scheme/oauth2/oauth2.json"

    override fun extendedObjectJson() = "/json/2.6.0/model/security_scheme/oauth2/oauth2 - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/2.6.0/model/security_scheme/oauth2/oauth2 - wrongly extended.json"

    override fun build(): SecurityScheme {
        return OAuth2SecurityScheme.oauth2SecuritySchemeBuilder()
                .type(SecurityScheme.Type.OAUTH2)
                .description("oauth2")
                .flows(OAuthFlowTest().build())
                .build()
    }

}
