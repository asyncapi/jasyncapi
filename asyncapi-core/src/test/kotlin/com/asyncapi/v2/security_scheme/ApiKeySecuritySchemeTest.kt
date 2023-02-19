package com.asyncapi.v2.security_scheme

import com.asyncapi.v2.ClasspathUtils
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @author Pavel Bodiachevskii
 */
class ApiKeySecuritySchemeTest {

    private val objectMapper = ObjectMapper()

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/model/security_scheme/apiKey.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, ApiKeySecurityScheme::class.java),
                build()
        )
    }

    companion object {
        @JvmStatic
        fun build(): SecurityScheme {
            return ApiKeySecurityScheme.apiKeySecuritySchemeBuilder()
                    .type(SecurityScheme.Type.API_KEY)
                    .description("apiKey")
                    .`in`(ApiKeySecurityScheme.ApiKeyLocation.USER)
                    .build()
        }
    }

}
