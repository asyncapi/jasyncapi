package com.asyncapi.schemas.security.v2

import com.asyncapi.schemas.asyncapi.security.v2.ApiKeySecurityScheme
import com.asyncapi.schemas.asyncapi.security.v2.SecurityScheme
import com.asyncapi.v2.SerDeTest

/**
 * @author Pavel Bodiachevskii
 */
class ApiKeySecuritySchemeTest: SerDeTest<ApiKeySecurityScheme>() {

    override fun objectClass() = ApiKeySecurityScheme::class.java

    override fun baseObjectJson() = "/schemas/security/v2/apiKey.json"

    override fun extendedObjectJson() = "/schemas/security/v2/apiKey - extended.json"

    override fun wronglyExtendedObjectJson() = "/schemas/security/v2/apiKey - wrongly extended.json"

    override fun build(): SecurityScheme {
        return ApiKeySecurityScheme.apiKeyBuilder()
                .description("apiKey")
                .`in`(ApiKeySecurityScheme.ApiKeyLocation.USER)
                .build()
    }

}
