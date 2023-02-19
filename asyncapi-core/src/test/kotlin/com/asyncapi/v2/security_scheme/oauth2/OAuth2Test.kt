package com.asyncapi.v2.security_scheme.oauth2

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.v2._0_0.model.security_scheme.SecurityScheme
import com.asyncapi.v2._0_0.model.security_scheme.oauth2.OAuth2SecurityScheme
import com.asyncapi.v2._0_0.model.security_scheme.oauth2.OAuthFlows
import com.asyncapi.v2._0_0.model.security_scheme.oauth2.flow.ImplicitOAuthFlow
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @author Pavel Bodiachevskii
 */
class OAuth2Test {

    private val objectMapper = ObjectMapper()

    private fun build(): SecurityScheme {
        return OAuth2SecurityScheme.oauth2SecuritySchemeBuilder()
                .type(SecurityScheme.Type.OAUTH2)
                .flows(OAuthFlows.builder()
                        .implicit(ImplicitOAuthFlow.implicitOAuthFlowBuilder()
                                .authorizationUrl("https://example.com/api/oauth/dialog")
                                .scopes(mapOf(
                                        Pair("write:pets", "modify pets in your account"),
                                        Pair("read:pets", "read your pets")
                                ))
                                .build()
                        )
                        .build()
                )
                .build()
    }

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/security_scheme/oauth2/oauth2.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, SecurityScheme::class.java),
                build()
        )
    }

}
