package com.asyncapi.v2.security_scheme.http

import com.asyncapi.v2.SerDeTest

class HttpApiKeySecuritySchemeTest: SerDeTest<HttpApiKeySecurityScheme>() {

    override fun objectClass() = HttpApiKeySecurityScheme::class.java

    override fun baseObjectJson() = "/json/security_scheme/http/httpApiKey.json"

    override fun extendedObjectJson() = "/json/security_scheme/http/httpApiKey - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/security_scheme/http/httpApiKey - wrongly extended.json"

    override fun build(): HttpApiKeySecurityScheme {
        return HttpApiKeySecurityScheme.httpApiKeyBuilder()
                .description("httpApiKey")
                .name("api_key")
                .`in`(HttpApiKeySecurityScheme.ApiKeyLocation.HEADER)
                .build()
    }

}