package com.asyncapi.v2.security_scheme.http

import com.asyncapi.v2.SerDeTest

class HttpSecuritySchemeBasicTest: SerDeTest<HttpSecurityScheme>() {

    override fun objectClass() = HttpSecurityScheme::class.java

    override fun baseObjectJson() = "/json/v2/security_scheme/http/httpBasic.json"

    override fun extendedObjectJson() = "/json/v2/security_scheme/http/httpBasic - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/security_scheme/http/httpBasic - wrongly extended.json"

    override fun build(): HttpSecurityScheme {
        return HttpSecurityScheme.httpBuilder()
                .description("http")
                .scheme("basic")
                .build()
    }

}

class HttpSecuritySchemeBearerTest: SerDeTest<HttpSecurityScheme>() {

    override fun objectClass() = HttpSecurityScheme::class.java

    override fun baseObjectJson() = "/json/v2/security_scheme/http/httpBearer.json"

    override fun extendedObjectJson() = "/json/v2/security_scheme/http/httpBearer - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/security_scheme/http/httpBearer - wrongly extended.json"

    override fun build(): HttpSecurityScheme {
        return HttpSecurityScheme.httpBuilder()
                .description("http")
                .scheme("bearer")
                .bearerFormat("JWT")
                .build()
    }

}