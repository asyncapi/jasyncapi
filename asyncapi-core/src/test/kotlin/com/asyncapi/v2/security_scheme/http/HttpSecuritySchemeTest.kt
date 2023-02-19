package com.asyncapi.v2.security_scheme.http

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.v2.security_scheme.SecurityScheme
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class HttpSecuritySchemeTest {

    private val objectMapper = ObjectMapper()

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun httpBasic() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/model/security_scheme/http/httpBasic.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, HttpSecurityScheme::class.java),
                buildBasic()
        )
    }

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun httpBearer() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/model/security_scheme/http/httpBearer.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, HttpSecurityScheme::class.java),
                buildBearer()
        )
    }

    companion object {
        @JvmStatic
        fun buildBasic(): HttpSecurityScheme {
            return HttpSecurityScheme.httpSecuritySchemeBuilder()
                    .type(SecurityScheme.Type.HTTP_API_KEY)
                    .description("http")
                    .scheme("basic")
                    .build()
        }

        @JvmStatic
        fun buildBearer(): HttpSecurityScheme {
            return HttpSecurityScheme.httpSecuritySchemeBuilder()
                    .type(SecurityScheme.Type.HTTP_API_KEY)
                    .description("http")
                    .scheme("bearer")
                    .bearerFormat("JWT")
                    .build()
        }
    }

}