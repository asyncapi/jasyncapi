package com.asyncapi.v3.security_scheme

import com.asyncapi.v3.SerDeTest

/**
 * @author Pavel Bodiachevskii
 */
class UserPasswordSecuritySchemeTest: SerDeTest<SecurityScheme>() {

    override fun objectClass() = SecurityScheme::class.java

    override fun baseObjectJson() = "/json/v3/security_scheme/userPassword.json"

    override fun extendedObjectJson() = "/json/v3/security_scheme/userPassword - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/security_scheme/userPassword - wrongly extended.json"

    override fun build(): SecurityScheme {
        return SecurityScheme.builder()
                .type(SecurityScheme.Type.USER_PASSWORD)
                .description("userPassword")
                .build()
    }

}
