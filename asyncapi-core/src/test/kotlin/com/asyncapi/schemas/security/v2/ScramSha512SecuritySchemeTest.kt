package com.asyncapi.schemas.security.v2

import com.asyncapi.v2.SerDeTest

/**
 * @author Pavel Bodiachevskii
 */
class ScramSha512SecuritySchemeTest: SerDeTest<SecurityScheme>() {

    override fun objectClass() = SecurityScheme::class.java

    override fun baseObjectJson() = "/schemas/security/v2/scramSha512.json"

    override fun extendedObjectJson() = "/schemas/security/v2/scramSha512 - extended.json"

    override fun wronglyExtendedObjectJson() = "/schemas/security/v2/scramSha512 - wrongly extended.json"

    override fun build(): SecurityScheme {
        return SecurityScheme.builder()
                .type(SecurityScheme.Type.SCRAM_SHA512)
                .description("scramSha512")
                .build()
    }

}
