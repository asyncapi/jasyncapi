package com.asyncapi.v2.security_scheme.http

import com.asyncapi.v2.SerDeTest
import com.asyncapi.v2.security_scheme.SecurityScheme

class HttpApiKeySecuritySchemeTest: SerDeTest<HttpApiKeySecurityScheme>() {

    override fun objectClass() = HttpApiKeySecurityScheme::class.java

    override fun baseObjectJson() = "/json/2.6.0/model/security_scheme/http/httpApiKey.json"

    override fun extendedObjectJson() = "/json/2.6.0/model/security_scheme/http/httpApiKey - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/2.6.0/model/security_scheme/http/httpApiKey - wrongly extended.json"

    override fun build(): HttpApiKeySecurityScheme {
        return HttpApiKeySecurityScheme.httpApiKeySecuritySchemeBuilder()
                .type(SecurityScheme.Type.HTTP_API_KEY)
                .description("httpApiKey")
                .name("api_key")
                .`in`(HttpApiKeySecurityScheme.ApiKeyLocation.HEADER)
                .build()
    }

}