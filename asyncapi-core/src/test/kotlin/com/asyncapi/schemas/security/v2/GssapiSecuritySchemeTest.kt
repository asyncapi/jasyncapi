package com.asyncapi.schemas.security.v2

import com.asyncapi.v2.SerDeTest

/**
 * @author Pavel Bodiachevskii
 */
class GssapiSecuritySchemeTest: SerDeTest<SecurityScheme>() {

    override fun objectClass() = SecurityScheme::class.java

    override fun baseObjectJson() = "/schemas/security/v2/gssapi.json"

    override fun extendedObjectJson() = "/schemas/security/v2/gssapi - extended.json"

    override fun wronglyExtendedObjectJson() = "/schemas/security/v2/gssapi - wrongly extended.json"

    override fun build(): SecurityScheme {
        return SecurityScheme.builder()
                .type(SecurityScheme.Type.GSSAPI)
                .description("gssapi")
                .build()
    }

}
