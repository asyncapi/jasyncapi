package com.asyncapi.schemas.security.v2

import com.asyncapi.schemas.asyncapi.security.v2.SecurityScheme
import com.asyncapi.v2.SerDeTest

/**
 * @author Pavel Bodiachevskii
 */
class SymmetricEncryptionSecuritySchemeTest: SerDeTest<SecurityScheme>() {

    override fun objectClass() = SecurityScheme::class.java

    override fun baseObjectJson() = "/schemas/security/v2/symmetricEncryption.json"

    override fun extendedObjectJson() = "/schemas/security/v2/symmetricEncryption - extended.json"

    override fun wronglyExtendedObjectJson() = "/schemas/security/v2/symmetricEncryption - wrongly extended.json"

    override fun build(): SecurityScheme {
        return SecurityScheme.builder()
                .type(SecurityScheme.Type.SYMMETRIC_ENCRYPTION)
                .description("symmetricEncryption")
                .build()
    }

}
