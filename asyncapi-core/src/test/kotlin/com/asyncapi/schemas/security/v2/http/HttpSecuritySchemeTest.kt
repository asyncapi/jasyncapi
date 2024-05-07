package com.asyncapi.schemas.security.v2.http

import com.asyncapi.v2.SerDeTest

class HttpSecuritySchemeBasicTest: SerDeTest<HttpSecurityScheme>() {

    override fun objectClass() = HttpSecurityScheme::class.java

    override fun baseObjectJson() = "/schemas/security/v2/http/httpBasic.json"

    override fun extendedObjectJson() = "/schemas/security/v2/http/httpBasic - extended.json"

    override fun wronglyExtendedObjectJson() = "/schemas/security/v2/http/httpBasic - wrongly extended.json"

    override fun build(): HttpSecurityScheme {
        return HttpSecurityScheme.httpBuilder()
                .description("http")
                .scheme("basic")
                .build()
    }

}

class HttpSecuritySchemeBearerTest: SerDeTest<HttpSecurityScheme>() {

    override fun objectClass() = HttpSecurityScheme::class.java

    override fun baseObjectJson() = "/schemas/security/v2/http/httpBearer.json"

    override fun extendedObjectJson() = "/schemas/security/v2/http/httpBearer - extended.json"

    override fun wronglyExtendedObjectJson() = "/schemas/security/v2/http/httpBearer - wrongly extended.json"

    override fun build(): HttpSecurityScheme {
        return HttpSecurityScheme.httpBuilder()
                .description("http")
                .scheme("bearer")
                .bearerFormat("JWT")
                .build()
    }

}