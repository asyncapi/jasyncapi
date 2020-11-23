package com.asyncapi.v2.security_scheme.oauth2

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.v2.model.security_scheme.oauth2.OAuthFlows
import com.asyncapi.v2.model.security_scheme.oauth2.flow.AuthorizationCodeOAuthFlow
import com.asyncapi.v2.model.security_scheme.oauth2.flow.ImplicitOAuthFlow
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @author Pavel Bodiachevskii
 */
class OAuthFlowTest {

    private val objectMapper = ObjectMapper()

    private fun build(): OAuthFlows {
        return OAuthFlows.builder()
                .implicit(ImplicitOAuthFlow.implicitOAuthFlowBuilder()
                        .authorizationUrl("https://example.com/api/oauth/dialog")
                        .scopes(mapOf(
                                Pair("write:pets", "modify pets in your account"),
                                Pair("read:pets", "read your pets")
                        ))
                        .build()
                )
                .authorizationCode(AuthorizationCodeOAuthFlow.authorizationCodeOAuthFlowBuilder()
                        .authorizationUrl("https://example.com/api/oauth/dialog")
                        .tokenUrl("https://example.com/api/oauth/token")
                        .scopes(mapOf(
                                Pair("write:pets", "modify pets in your account"),
                                Pair("read:pets", "read your pets")
                        ))
                        .build()
                )
                .build()
    }

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/security_scheme/oauth2/oauthFlow.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, OAuthFlows::class.java),
                build()
        )
    }

}
