package com.asyncapi.v2.security_scheme

import com.asyncapi.v2.SerDeTest

/**
 * @author Pavel Bodiachevskii
 */
class UserPasswordSecuritySchemeTest: SerDeTest<SecurityScheme>() {

    override fun objectClass() = SecurityScheme::class.java

    override fun baseObjectJson() = "/json/v2/security_scheme/userPassword.json"

    override fun extendedObjectJson() = "/json/v2/security_scheme/userPassword - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/security_scheme/userPassword - wrongly extended.json"

    override fun build(): SecurityScheme {
        return SecurityScheme.builder()
                .type(SecurityScheme.Type.USER_PASSWORD)
                .description("userPassword")
                .build()
    }

}
