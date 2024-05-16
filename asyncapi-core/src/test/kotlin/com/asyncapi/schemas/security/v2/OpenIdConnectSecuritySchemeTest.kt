package com.asyncapi.schemas.security.v2

import com.asyncapi.schemas.asyncapi.security.v2.OpenIdConnectSecurityScheme
import com.asyncapi.schemas.asyncapi.security.v2.SecurityScheme
import com.asyncapi.v2.SerDeTest

/**
 * @author Pavel Bodiachevskii
 */
class OpenIdConnectSecuritySchemeTest: SerDeTest<OpenIdConnectSecurityScheme>() {

    override fun objectClass() = OpenIdConnectSecurityScheme::class.java

    override fun baseObjectJson() = "/schemas/security/v2/openIdConnect.json"

    override fun extendedObjectJson() = "/schemas/security/v2/openIdConnect - extended.json"

    override fun wronglyExtendedObjectJson() = "/schemas/security/v2/openIdConnect - wrongly extended.json"

    override fun build(): SecurityScheme {
        return OpenIdConnectSecurityScheme.openIdBuilder()
                .description("openIdConnect")
                .openIdConnectUrl("https://server.com/.well-known/openid-configuration")
                .build()
    }

}
