package com.asyncapi.v2.security_scheme

import com.asyncapi.v2.SerDeTest

/**
 * @author Pavel Bodiachevskii
 */
class OpenIdConnectSecuritySchemeTest: SerDeTest<OpenIdConnectSecurityScheme>() {

    override fun objectClass() = OpenIdConnectSecurityScheme::class.java

    override fun baseObjectJson() = "/json/v2/security_scheme/openIdConnect.json"

    override fun extendedObjectJson() = "/json/v2/security_scheme/openIdConnect - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/security_scheme/openIdConnect - wrongly extended.json"

    override fun build(): SecurityScheme {
        return OpenIdConnectSecurityScheme.openIdBuilder()
                .description("openIdConnect")
                .openIdConnectUrl("https://server.com/.well-known/openid-configuration")
                .build()
    }

}
