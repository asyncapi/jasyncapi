package com.asyncapi.v3.security_scheme.http

import com.asyncapi.schemas.security.http.HttpApiKeySecurityScheme
import com.asyncapi.v3.SerDeTest

class HttpApiKeySecuritySchemeTest: SerDeTest<HttpApiKeySecurityScheme>() {

    override fun objectClass() = HttpApiKeySecurityScheme::class.java

    override fun baseObjectJson() = "/json/v3/security_scheme/http/httpApiKey.json"

    override fun extendedObjectJson() = "/json/v3/security_scheme/http/httpApiKey - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/security_scheme/http/httpApiKey - wrongly extended.json"

    override fun build(): HttpApiKeySecurityScheme {
        return HttpApiKeySecurityScheme.httpApiKeyBuilder()
                .description("httpApiKey")
                .name("api_key")
                .`in`(HttpApiKeySecurityScheme.ApiKeyLocation.HEADER)
                .build()
    }

}