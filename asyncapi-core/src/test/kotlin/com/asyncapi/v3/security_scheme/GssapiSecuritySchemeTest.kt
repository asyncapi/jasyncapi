package com.asyncapi.v3.security_scheme

import com.asyncapi.v3.SerDeTest

/**
 * @author Pavel Bodiachevskii
 */
class GssapiSecuritySchemeTest: SerDeTest<SecurityScheme>() {

    override fun objectClass() = SecurityScheme::class.java

    override fun baseObjectJson() = "/json/v3/security_scheme/gssapi.json"

    override fun extendedObjectJson() = "/json/v3/security_scheme/gssapi - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/security_scheme/gssapi - wrongly extended.json"

    override fun build(): SecurityScheme {
        return SecurityScheme.builder()
                .type(SecurityScheme.Type.GSSAPI)
                .description("gssapi")
                .build()
    }

}
