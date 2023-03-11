package com.asyncapi.v2.security_scheme

import com.asyncapi.v2.SerDeTest

/**
 * @author Pavel Bodiachevskii
 */
class OpenIdConnectSecuritySchemeTest: SerDeTest<OpenIdConnectSecurityScheme>() {

    override fun objectClass() = OpenIdConnectSecurityScheme::class.java

    override fun baseObjectJson() = "/json/security_scheme/openIdConnect.json"

    override fun extendedObjectJson() = "/json/security_scheme/openIdConnect - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/security_scheme/openIdConnect - wrongly extended.json"

    override fun build(): SecurityScheme {
        return OpenIdConnectSecurityScheme.openIdConnectSecurityScheme()
                .type(SecurityScheme.Type.OPENID_CONNECT)
                .description("openIdConnect")
                .openIdConnectUrl("https://server.com/.well-known/openid-configuration")
                .build()
    }

}
