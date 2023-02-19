package com.asyncapi.v2.security_scheme.http

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.v2.security_scheme.SecurityScheme
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class HttpApiKeySecuritySchemeTest {

    private val objectMapper = ObjectMapper()

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/model/security_scheme/http/httpApiKey.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, HttpApiKeySecurityScheme::class.java),
                build()
        )
    }

    companion object {
        @JvmStatic
        fun build(): SecurityScheme {
            return HttpApiKeySecurityScheme.httpApiKeySecuritySchemeBuilder()
                    .type(SecurityScheme.Type.HTTP_API_KEY)
                    .description("httpApiKey")
                    .name("api_key")
                    .`in`(HttpApiKeySecurityScheme.ApiKeyLocation.HEADER)
                    .build()
        }
    }

}