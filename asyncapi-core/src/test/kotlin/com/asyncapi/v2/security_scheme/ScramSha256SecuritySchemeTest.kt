package com.asyncapi.v2.security_scheme

import com.asyncapi.v2.SerDeTest

/**
 * @author Pavel Bodiachevskii
 */
class ScramSha256SecuritySchemeTest: SerDeTest<SecurityScheme>() {

    override fun objectClass() = SecurityScheme::class.java

    override fun baseObjectJson() = "/json/security_scheme/scramSha256.json"

    override fun extendedObjectJson() = "/json/security_scheme/scramSha256 - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/security_scheme/scramSha256 - wrongly extended.json"

    override fun build(): SecurityScheme {
        return SecurityScheme.builder()
                .type(SecurityScheme.Type.SCRAM_SHA256)
                .description("scramSha256")
                .build()
    }

}
