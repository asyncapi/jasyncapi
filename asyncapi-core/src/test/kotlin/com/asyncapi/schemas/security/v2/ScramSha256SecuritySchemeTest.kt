package com.asyncapi.schemas.security.v2

import com.asyncapi.schemas.asyncapi.security.v2.SecurityScheme
import com.asyncapi.v2.SerDeTest

/**
 * @author Pavel Bodiachevskii
 */
class ScramSha256SecuritySchemeTest: SerDeTest<SecurityScheme>() {

    override fun objectClass() = SecurityScheme::class.java

    override fun baseObjectJson() = "/schemas/security/v2/scramSha256.json"

    override fun extendedObjectJson() = "/schemas/security/v2/scramSha256 - extended.json"

    override fun wronglyExtendedObjectJson() = "/schemas/security/v2/scramSha256 - wrongly extended.json"

    override fun build(): SecurityScheme {
        return SecurityScheme.builder()
                .type(SecurityScheme.Type.SCRAM_SHA256)
                .description("scramSha256")
                .build()
    }

}
