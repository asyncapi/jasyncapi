package com.asyncapi.v3.security_scheme

import com.asyncapi.schemas.security.SecurityScheme
import com.asyncapi.v3.SerDeTest

/**
 * @author Pavel Bodiachevskii
 */
class ScramSha256SecuritySchemeTest: SerDeTest<SecurityScheme>() {

    override fun objectClass() = SecurityScheme::class.java

    override fun baseObjectJson() = "/json/v3/security_scheme/scramSha256.json"

    override fun extendedObjectJson() = "/json/v3/security_scheme/scramSha256 - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/security_scheme/scramSha256 - wrongly extended.json"

    override fun build(): SecurityScheme {
        return SecurityScheme.builder()
                .type(SecurityScheme.Type.SCRAM_SHA256)
                .description("scramSha256")
                .build()
    }

}
