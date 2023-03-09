package com.asyncapi.v2.security_scheme

import com.asyncapi.v2.SerDeTest

/**
 * @author Pavel Bodiachevskii
 */
class PlainSecuritySchemeTest: SerDeTest<SecurityScheme>() {

    override fun objectClass() = SecurityScheme::class.java

    override fun baseObjectJson() = "/json/2.6.0/model/security_scheme/plain.json"

    override fun extendedObjectJson() = "/json/2.6.0/model/security_scheme/plain - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/2.6.0/model/security_scheme/plain - wrongly extended.json"

    override fun build(): SecurityScheme {
        return SecurityScheme.builder()
                .type(SecurityScheme.Type.PLAIN)
                .description("plain")
                .build()
    }

}
