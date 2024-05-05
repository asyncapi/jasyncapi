package com.asyncapi.v3.security_scheme

import com.asyncapi.schemas.security.OpenIdConnectSecurityScheme
import com.asyncapi.v3.SerDeTest

/**
 * @author Pavel Bodiachevskii
 */
class OpenIdConnectSecuritySchemeTest: SerDeTest<OpenIdConnectSecurityScheme>() {

    override fun objectClass() = OpenIdConnectSecurityScheme::class.java

    override fun baseObjectJson() = "/json/v3/security_scheme/openIdConnect.json"

    override fun extendedObjectJson() = "/json/v3/security_scheme/openIdConnect - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/security_scheme/openIdConnect - wrongly extended.json"

    override fun build(): SecurityScheme {
        return OpenIdConnectSecurityScheme.openIdBuilder()
                .description("openIdConnect")
                .openIdConnectUrl("https://server.com/.well-known/openid-configuration")
                .scopes(listOf("write:pets", "read:pets"))
                .build()
    }

}
