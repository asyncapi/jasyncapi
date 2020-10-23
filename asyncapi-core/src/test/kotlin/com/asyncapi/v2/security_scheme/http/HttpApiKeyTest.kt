package com.asyncapi.v2.security_scheme.http

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.v2.model.security_scheme.SecurityScheme
import com.asyncapi.v2.model.security_scheme.http.HttpApiKeySecurityScheme
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class HttpApiKeyTest {

    private val objectMapper = ObjectMapper()

    private fun build(): SecurityScheme {
        return HttpApiKeySecurityScheme.httpApiKeySecuritySchemeBuilder()
                .type(SecurityScheme.Type.HTTP_API_KEY)
                .name("api_key")
                .`in`(HttpApiKeySecurityScheme.ApiKeyLocation.HEADER)
                .build()
    }

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/security_scheme/http/httpApiKey.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, SecurityScheme::class.java),
                build()
        )
    }

}
