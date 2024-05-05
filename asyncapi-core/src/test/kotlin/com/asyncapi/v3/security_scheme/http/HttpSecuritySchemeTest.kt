package com.asyncapi.v3.security_scheme.http

import com.asyncapi.schemas.security.http.HttpSecurityScheme
import com.asyncapi.v3.SerDeTest

class HttpSecuritySchemeBasicTest: SerDeTest<HttpSecurityScheme>() {

    override fun objectClass() = HttpSecurityScheme::class.java

    override fun baseObjectJson() = "/json/v3/security_scheme/http/httpBasic.json"

    override fun extendedObjectJson() = "/json/v3/security_scheme/http/httpBasic - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/security_scheme/http/httpBasic - wrongly extended.json"

    override fun build(): HttpSecurityScheme {
        return HttpSecurityScheme.httpBuilder()
                .description("http")
                .scheme("basic")
                .build()
    }

}

class HttpSecuritySchemeBearerTest: SerDeTest<HttpSecurityScheme>() {

    override fun objectClass() = HttpSecurityScheme::class.java

    override fun baseObjectJson() = "/json/v3/security_scheme/http/httpBearer.json"

    override fun extendedObjectJson() = "/json/v3/security_scheme/http/httpBearer - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/security_scheme/http/httpBearer - wrongly extended.json"

    override fun build(): HttpSecurityScheme {
        return HttpSecurityScheme.httpBuilder()
                .description("http")
                .scheme("bearer")
                .bearerFormat("JWT")
                .build()
    }

}