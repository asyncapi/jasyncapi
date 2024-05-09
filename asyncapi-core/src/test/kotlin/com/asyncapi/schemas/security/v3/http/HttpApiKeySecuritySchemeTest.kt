package com.asyncapi.schemas.security.v3.http

import com.asyncapi.schemas.asyncapi.security.v3.http.HttpApiKeySecurityScheme
import com.asyncapi.v3.SerDeTest

class HttpApiKeySecuritySchemeTest: SerDeTest<HttpApiKeySecurityScheme>() {

    override fun objectClass() = HttpApiKeySecurityScheme::class.java

    override fun baseObjectJson() = "/schemas/security/v3/http/httpApiKey.json"

    override fun extendedObjectJson() = "/schemas/security/v3/http/httpApiKey - extended.json"

    override fun wronglyExtendedObjectJson() = "/schemas/security/v3/http/httpApiKey - wrongly extended.json"

    override fun build(): HttpApiKeySecurityScheme {
        return HttpApiKeySecurityScheme.httpApiKeyBuilder()
                .description("httpApiKey")
                .name("api_key")
                .`in`(HttpApiKeySecurityScheme.ApiKeyLocation.HEADER)
                .build()
    }

}