package com.asyncapi.v2.security_scheme

import com.asyncapi.v2.SerDeTest

/**
 * @author Pavel Bodiachevskii
 */
class PlainSecuritySchemeTest: SerDeTest<SecurityScheme>() {

    override fun objectClass() = SecurityScheme::class.java

    override fun baseObjectJson() = "/json/v2/security_scheme/plain.json"

    override fun extendedObjectJson() = "/json/v2/security_scheme/plain - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/security_scheme/plain - wrongly extended.json"

    override fun build(): SecurityScheme {
        return SecurityScheme.builder()
                .type(SecurityScheme.Type.PLAIN)
                .description("plain")
                .build()
    }

}
