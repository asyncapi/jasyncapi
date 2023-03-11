package com.asyncapi.v2.security_scheme

import com.asyncapi.v2.SerDeTest

/**
 * @author Pavel Bodiachevskii
 */
class X509SecuritySchemeTest: SerDeTest<SecurityScheme>() {

    override fun objectClass() = SecurityScheme::class.java

    override fun baseObjectJson() = "/json/security_scheme/X509.json"

    override fun extendedObjectJson() = "/json/security_scheme/X509 - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/security_scheme/X509 - wrongly extended.json"

    override fun build(): SecurityScheme {
        return SecurityScheme.builder()
                .type(SecurityScheme.Type.X509)
                .description("X509")
                .build()
    }

}
