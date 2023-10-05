package com.asyncapi.v3.security_scheme

import com.asyncapi.v3.SerDeTest

/**
 * @author Pavel Bodiachevskii
 */
class AsymmetricEncryptionSecuritySchemeTest: SerDeTest<SecurityScheme>() {

    override fun objectClass() = SecurityScheme::class.java

    override fun baseObjectJson() = "/json/v3/security_scheme/asymmetricEncryption.json"

    override fun extendedObjectJson() = "/json/v3/security_scheme/asymmetricEncryption - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/security_scheme/asymmetricEncryption - wrongly extended.json"

    override fun build(): SecurityScheme {
        return SecurityScheme.builder()
                .type(SecurityScheme.Type.ASYMMETRIC_ENCRYPTION)
                .description("asymmetricEncryption")
                .build()
    }

}
