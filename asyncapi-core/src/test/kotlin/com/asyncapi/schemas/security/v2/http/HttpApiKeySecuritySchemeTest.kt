package com.asyncapi.schemas.security.v2.http

import com.asyncapi.schemas.asyncapi.security.v2.http.HttpApiKeySecurityScheme
import com.asyncapi.v2.SerDeTest

class HttpApiKeySecuritySchemeTest: SerDeTest<HttpApiKeySecurityScheme>() {

    override fun objectClass() = HttpApiKeySecurityScheme::class.java

    override fun baseObjectJson() = "/schemas/security/v2/http/httpApiKey.json"

    override fun extendedObjectJson() = "/schemas/security/v2/http/httpApiKey - extended.json"

    override fun wronglyExtendedObjectJson() = "/schemas/security/v2/http/httpApiKey - wrongly extended.json"

    override fun build(): HttpApiKeySecurityScheme {
        return HttpApiKeySecurityScheme.httpApiKeyBuilder()
                .description("httpApiKey")
                .name("api_key")
                .`in`(HttpApiKeySecurityScheme.ApiKeyLocation.HEADER)
                .build()
    }

}