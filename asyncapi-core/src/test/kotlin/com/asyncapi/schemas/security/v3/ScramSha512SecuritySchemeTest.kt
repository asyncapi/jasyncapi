package com.asyncapi.schemas.security.v3

import com.asyncapi.schemas.asyncapi.security.v3.SecurityScheme
import com.asyncapi.v3.SerDeTest

/**
 * @author Pavel Bodiachevskii
 */
class ScramSha512SecuritySchemeTest: SerDeTest<SecurityScheme>() {

    override fun objectClass() = SecurityScheme::class.java

    override fun baseObjectJson() = "/schemas/security/v3/scramSha512.json"

    override fun extendedObjectJson() = "/schemas/security/v3/scramSha512 - extended.json"

    override fun wronglyExtendedObjectJson() = "/schemas/security/v3/scramSha512 - wrongly extended.json"

    override fun build(): SecurityScheme {
        return SecurityScheme.builder()
                .type(SecurityScheme.Type.SCRAM_SHA512)
                .description("scramSha512")
                .build()
    }

}
