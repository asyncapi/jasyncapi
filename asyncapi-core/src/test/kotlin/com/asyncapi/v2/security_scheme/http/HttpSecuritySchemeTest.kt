package com.asyncapi.v2.security_scheme.http

import com.asyncapi.v2.SerDeTest
import com.asyncapi.v2.security_scheme.SecurityScheme

class HttpSecuritySchemeBasicTest: SerDeTest<HttpSecurityScheme>() {

    override fun objectClass() = HttpSecurityScheme::class.java

    override fun baseObjectJson() = "/json/2.6.0/model/security_scheme/http/httpBasic.json"

    override fun extendedObjectJson() = "/json/2.6.0/model/security_scheme/http/httpBasic - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/2.6.0/model/security_scheme/http/httpBasic - wrongly extended.json"

    override fun build(): HttpSecurityScheme {
        return HttpSecurityScheme.httpSecuritySchemeBuilder()
                .type(SecurityScheme.Type.HTTP)
                .description("http")
                .scheme("basic")
                .build()
    }

}

class HttpSecuritySchemeBearerTest: SerDeTest<HttpSecurityScheme>() {

    override fun objectClass() = HttpSecurityScheme::class.java

    override fun baseObjectJson() = "/json/2.6.0/model/security_scheme/http/httpBearer.json"

    override fun extendedObjectJson() = "/json/2.6.0/model/security_scheme/http/httpBearer - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/2.6.0/model/security_scheme/http/httpBearer - wrongly extended.json"

    override fun build(): HttpSecurityScheme {
        return HttpSecurityScheme.httpSecuritySchemeBuilder()
                .type(SecurityScheme.Type.HTTP)
                .description("http")
                .scheme("bearer")
                .bearerFormat("JWT")
                .build()
    }

}