package com.asyncapi.v3.security_scheme

import com.asyncapi.v3.SerDeTest

/**
 * @author Pavel Bodiachevskii
 */
class X509SecuritySchemeTest: SerDeTest<SecurityScheme>() {

    override fun objectClass() = SecurityScheme::class.java

    override fun baseObjectJson() = "/json/v3/security_scheme/X509.json"

    override fun extendedObjectJson() = "/json/v3/security_scheme/X509 - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/security_scheme/X509 - wrongly extended.json"

    override fun build(): SecurityScheme {
        return SecurityScheme.builder()
                .type(SecurityScheme.Type.X509)
                .description("X509")
                .build()
    }

}
