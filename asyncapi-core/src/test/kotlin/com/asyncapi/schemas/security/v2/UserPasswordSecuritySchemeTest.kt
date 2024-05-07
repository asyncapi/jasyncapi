package com.asyncapi.schemas.security.v2

import com.asyncapi.v2.SerDeTest

/**
 * @author Pavel Bodiachevskii
 */
class UserPasswordSecuritySchemeTest: SerDeTest<SecurityScheme>() {

    override fun objectClass() = SecurityScheme::class.java

    override fun baseObjectJson() = "/schemas/security/v2/userPassword.json"

    override fun extendedObjectJson() = "/schemas/security/v2/userPassword - extended.json"

    override fun wronglyExtendedObjectJson() = "/schemas/security/v2/userPassword - wrongly extended.json"

    override fun build(): SecurityScheme {
        return SecurityScheme.builder()
                .type(SecurityScheme.Type.USER_PASSWORD)
                .description("userPassword")
                .build()
    }

}
