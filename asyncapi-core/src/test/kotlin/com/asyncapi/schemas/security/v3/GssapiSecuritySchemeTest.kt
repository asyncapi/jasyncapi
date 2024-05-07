package com.asyncapi.schemas.security.v3

import com.asyncapi.v3.SerDeTest

/**
 * @author Pavel Bodiachevskii
 */
class GssapiSecuritySchemeTest: SerDeTest<SecurityScheme>() {

    override fun objectClass() = SecurityScheme::class.java

    override fun baseObjectJson() = "/schemas/security/v3/gssapi.json"

    override fun extendedObjectJson() = "/schemas/security/v3/gssapi - extended.json"

    override fun wronglyExtendedObjectJson() = "/schemas/security/v3/gssapi - wrongly extended.json"

    override fun build(): SecurityScheme {
        return SecurityScheme.builder()
                .type(SecurityScheme.Type.GSSAPI)
                .description("gssapi")
                .build()
    }

}
