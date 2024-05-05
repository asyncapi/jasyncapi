package com.asyncapi.v3.security_scheme

import com.asyncapi.schemas.security.SecurityScheme
import com.asyncapi.v3.SerDeTest

/**
 * @author Pavel Bodiachevskii
 */
class SymmetricEncryptionSecuritySchemeTest: SerDeTest<SecurityScheme>() {

    override fun objectClass() = SecurityScheme::class.java

    override fun baseObjectJson() = "/json/v3/security_scheme/symmetricEncryption.json"

    override fun extendedObjectJson() = "/json/v3/security_scheme/symmetricEncryption - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/security_scheme/symmetricEncryption - wrongly extended.json"

    override fun build(): SecurityScheme {
        return SecurityScheme.builder()
                .type(SecurityScheme.Type.SYMMETRIC_ENCRYPTION)
                .description("symmetricEncryption")
                .build()
    }

}
