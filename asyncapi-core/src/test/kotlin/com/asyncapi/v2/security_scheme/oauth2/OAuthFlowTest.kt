package com.asyncapi.v2.security_scheme.oauth2

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.v2.security_scheme.oauth2.flow.AuthorizationCodeOAuthFlow
import com.asyncapi.v2.security_scheme.oauth2.flow.ClientCredentialsOAuthFlow
import com.asyncapi.v2.security_scheme.oauth2.flow.ImplicitOAuthFlow
import com.asyncapi.v2.security_scheme.oauth2.flow.PasswordOAuthFlow
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @author Pavel Bodiachevskii
 */
class OAuthFlowTest {

    private val objectMapper = ObjectMapper()

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/model/security_scheme/oauth2/oauthFlows.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, OAuthFlows::class.java),
                build()
        )
    }

    companion object {
        @JvmStatic
        fun build(): OAuthFlows {
            return OAuthFlows.builder()
                    .authorizationCode(AuthorizationCodeOAuthFlow.authorizationCodeOAuthFlowBuilder()
                            .authorizationUrl("https://example.com/api/oauth/dialog")
                            .tokenUrl("https://example.com/api/oauth/token")
                            .refreshUrl("https://example.com/api/oauth/refresh")
                            .scopes(mapOf(
                                    Pair("write:pets", "modify pets in your account"),
                                    Pair("read:pets", "read your pets")
                            ))
                            .build()
                    )
                    .clientCredentials(ClientCredentialsOAuthFlow.clientCredentialsOAuthFlowBuilder()
                            .tokenUrl("https://example.com/api/oauth/token")
                            .refreshUrl("https://example.com/api/oauth/refresh")
                            .scopes(mapOf(
                                    Pair("write:pets", "modify pets in your account"),
                                    Pair("read:pets", "read your pets")
                            ))
                            .build()
                    )
                    .implicit(ImplicitOAuthFlow.implicitOAuthFlowBuilder()
                            .authorizationUrl("https://example.com/api/oauth/dialog")
                            .refreshUrl("https://example.com/api/oauth/refresh")
                            .scopes(mapOf(
                                    Pair("write:pets", "modify pets in your account"),
                                    Pair("read:pets", "read your pets")
                            ))
                            .build()
                    )
                    .password(PasswordOAuthFlow.passwordOAuthFlowBuilder()
                            .tokenUrl("https://example.com/api/oauth/token")
                            .refreshUrl("https://example.com/api/oauth/refresh")
                            .scopes(mapOf(
                                    Pair("write:pets", "modify pets in your account"),
                                    Pair("read:pets", "read your pets")
                            ))
                            .build()
                    )
                    .build()
        }
    }

}
