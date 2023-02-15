package com.asyncapi.v2._6_0.model.security_scheme.oauth2

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.v2._6_0.model.security_scheme.SecurityScheme
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @author Pavel Bodiachevskii
 */
class OAuth2SecuritySchemeTest {

    private val objectMapper = ObjectMapper()

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/model/security_scheme/oauth2/oauth2.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, OAuth2SecurityScheme::class.java),
                build()
        )
    }

    companion object {
        @JvmStatic
        fun build(): SecurityScheme {
            return OAuth2SecurityScheme.oauth2SecuritySchemeBuilder()
                    .type(SecurityScheme.Type.OAUTH2)
                    .description("oauth2")
                    .flows(OAuthFlowTest.build())
                    .build()
        }
    }

}
