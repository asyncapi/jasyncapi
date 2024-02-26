package com.asyncapi.v3.security_scheme

import com.asyncapi.v3.SerDeTest

/**
 * @author Pavel Bodiachevskii
 */
class ApiKeySecuritySchemeTest: SerDeTest<ApiKeySecurityScheme>() {

    override fun objectClass() = ApiKeySecurityScheme::class.java

    override fun baseObjectJson() = "/json/v3/security_scheme/apiKey.json"

    override fun extendedObjectJson() = "/json/v3/security_scheme/apiKey - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/security_scheme/apiKey - wrongly extended.json"

    override fun build(): SecurityScheme {
        return ApiKeySecurityScheme.apiKeyBuilder()
                .description("apiKey")
                .`in`(ApiKeySecurityScheme.ApiKeyLocation.USER)
                .build()
    }

}
