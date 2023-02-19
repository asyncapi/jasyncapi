package com.asyncapi.v2.security_scheme

import com.asyncapi.v2.ClasspathUtils
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @author Pavel Bodiachevskii
 */
class OpenIdConnectSecuritySchemeTest {

    private val objectMapper = ObjectMapper()

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/model/security_scheme/openIdConnect.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, OpenIdConnectSecurityScheme::class.java),
                build()
        )
    }

    companion object {
        @JvmStatic
        fun build(): SecurityScheme {
            return OpenIdConnectSecurityScheme.openIdConnectSecurityScheme()
                    .type(SecurityScheme.Type.OPENID_CONNECT)
                    .description("openIdConnect")
                    .openIdConnectUrl("https://server.com/.well-known/openid-configuration")
                    .build()
        }
    }

}
