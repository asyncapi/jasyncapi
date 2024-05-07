package com.asyncapi.schemas.security.v2

import com.asyncapi.v2.SerDeTest

/**
 * @author Pavel Bodiachevskii
 */
class X509SecuritySchemeTest: SerDeTest<SecurityScheme>() {

    override fun objectClass() = SecurityScheme::class.java

    override fun baseObjectJson() = "/schemas/security/v2/X509.json"

    override fun extendedObjectJson() = "/schemas/security/v2/X509 - extended.json"

    override fun wronglyExtendedObjectJson() = "/schemas/security/v2/X509 - wrongly extended.json"

    override fun build(): SecurityScheme {
        return SecurityScheme.builder()
                .type(SecurityScheme.Type.X509)
                .description("X509")
                .build()
    }

}
