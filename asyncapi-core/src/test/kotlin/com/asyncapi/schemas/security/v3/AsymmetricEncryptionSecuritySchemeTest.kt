package com.asyncapi.schemas.security.v3

import com.asyncapi.schemas.asyncapi.security.v3.SecurityScheme
import com.asyncapi.v3.SerDeTest

/**
 * @author Pavel Bodiachevskii
 */
class AsymmetricEncryptionSecuritySchemeTest: SerDeTest<SecurityScheme>() {

    override fun objectClass() = SecurityScheme::class.java

    override fun baseObjectJson() = "/schemas/security/v3/asymmetricEncryption.json"

    override fun extendedObjectJson() = "/schemas/security/v3/asymmetricEncryption - extended.json"

    override fun wronglyExtendedObjectJson() = "/schemas/security/v3/asymmetricEncryption - wrongly extended.json"

    override fun build(): SecurityScheme {
        return SecurityScheme.builder()
                .type(SecurityScheme.Type.ASYMMETRIC_ENCRYPTION)
                .description("asymmetricEncryption")
                .build()
    }

}
