package com.asyncapi.v2.security_scheme

import com.asyncapi.v2.SerDeTest

/**
 * @author Pavel Bodiachevskii
 */
class ApiKeySecuritySchemeTest: SerDeTest<ApiKeySecurityScheme>() {

    override fun objectClass() = ApiKeySecurityScheme::class.java

    override fun baseObjectJson() = "/json/2.6.0/model/security_scheme/apiKey.json"

    override fun extendedObjectJson() = "/json/2.6.0/model/security_scheme/apiKey - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/2.6.0/model/security_scheme/apiKey - wrongly extended.json"

    override fun build(): SecurityScheme {
        return ApiKeySecurityScheme.apiKeySecuritySchemeBuilder()
                .type(SecurityScheme.Type.API_KEY)
                .description("apiKey")
                .`in`(ApiKeySecurityScheme.ApiKeyLocation.USER)
                .build()
    }

}
