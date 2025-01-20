package com.asyncapi.schemas.security.v3

import com.asyncapi.schemas.asyncapi.security.v3.ApiKeySecurityScheme
import com.asyncapi.schemas.asyncapi.security.v3.SecurityScheme
import com.asyncapi.v3.SerDeTest

/**
 * @author Pavel Bodiachevskii
 */
class ApiKeySecuritySchemeTest: SerDeTest<ApiKeySecurityScheme>() {

    override fun objectClass() = ApiKeySecurityScheme::class.java

    override fun baseObjectJson() = "/schemas/security/v3/apiKey.json"

    override fun extendedObjectJson() = "/schemas/security/v3/apiKey - extended.json"

    override fun wronglyExtendedObjectJson() = "/schemas/security/v3/apiKey - wrongly extended.json"

    override fun build(): SecurityScheme {
        return ApiKeySecurityScheme.apiKeyBuilder()
                .description("apiKey")
                .`in`(ApiKeySecurityScheme.ApiKeyLocation.USER)
                .build()
    }

}
