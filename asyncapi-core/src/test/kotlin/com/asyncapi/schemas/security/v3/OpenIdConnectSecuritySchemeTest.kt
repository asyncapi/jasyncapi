package com.asyncapi.schemas.security.v3

import com.asyncapi.v3.SerDeTest

/**
 * @author Pavel Bodiachevskii
 */
class OpenIdConnectSecuritySchemeTest: SerDeTest<OpenIdConnectSecurityScheme>() {

    override fun objectClass() = OpenIdConnectSecurityScheme::class.java

    override fun baseObjectJson() = "/schemas/security/v3/openIdConnect.json"

    override fun extendedObjectJson() = "/schemas/security/v3/openIdConnect - extended.json"

    override fun wronglyExtendedObjectJson() = "/schemas/security/v3/openIdConnect - wrongly extended.json"

    override fun build(): SecurityScheme {
        return OpenIdConnectSecurityScheme.openIdBuilder()
                .description("openIdConnect")
                .openIdConnectUrl("https://server.com/.well-known/openid-configuration")
                .scopes(listOf("write:pets", "read:pets"))
                .build()
    }

}
