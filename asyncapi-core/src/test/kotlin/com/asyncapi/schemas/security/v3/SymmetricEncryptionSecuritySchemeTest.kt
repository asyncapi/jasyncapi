package com.asyncapi.schemas.security.v3

import com.asyncapi.v3.SerDeTest

/**
 * @author Pavel Bodiachevskii
 */
class SymmetricEncryptionSecuritySchemeTest: SerDeTest<SecurityScheme>() {

    override fun objectClass() = SecurityScheme::class.java

    override fun baseObjectJson() = "/schemas/security/v3/symmetricEncryption.json"

    override fun extendedObjectJson() = "/schemas/security/v3/symmetricEncryption - extended.json"

    override fun wronglyExtendedObjectJson() = "/schemas/security/v3/symmetricEncryption - wrongly extended.json"

    override fun build(): SecurityScheme {
        return SecurityScheme.builder()
                .type(SecurityScheme.Type.SYMMETRIC_ENCRYPTION)
                .description("symmetricEncryption")
                .build()
    }

}
