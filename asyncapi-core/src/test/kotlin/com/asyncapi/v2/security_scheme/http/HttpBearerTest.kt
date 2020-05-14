package com.asyncapi.v2.security_scheme.http

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.v2.model.security_scheme.SecurityScheme
import com.asyncapi.v2.model.security_scheme.http.HttpSecurityScheme
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class HttpBearerTest {

    private val objectMapper = ObjectMapper()

    private fun build(): SecurityScheme {
        return HttpSecurityScheme.httpSecuritySchemeBuilder()
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT")
                .build()
    }

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/security_scheme/http/httpBearer.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, SecurityScheme::class.java),
                build()
        )
    }

}
