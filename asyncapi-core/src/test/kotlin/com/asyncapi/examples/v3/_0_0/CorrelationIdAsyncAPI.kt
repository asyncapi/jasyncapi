package com.asyncapi.examples.v3._0_0

import com.asyncapi.schemas.asyncapi.security.v3.ApiKeySecurityScheme
import com.asyncapi.schemas.asyncapi.Reference
import com.asyncapi.v3._0_0.model.channel.Channel
import com.asyncapi.v3._0_0.model.channel.Parameter
import com.asyncapi.v3._0_0.model.channel.message.CorrelationId
import com.asyncapi.v3._0_0.model.channel.message.Message
import com.asyncapi.v3._0_0.model.component.Components
import com.asyncapi.v3._0_0.model.info.Info
import com.asyncapi.v3._0_0.model.info.License
import com.asyncapi.v3._0_0.model.operation.Operation
import com.asyncapi.v3._0_0.model.operation.OperationAction
import com.asyncapi.v3._0_0.model.server.Server
import com.asyncapi.v3._0_0.model.server.ServerVariable
import com.asyncapi.schemas.asyncapi.AsyncAPISchema
import com.asyncapi.schemas.asyncapi.security.v3.OpenIdConnectSecurityScheme
import com.asyncapi.schemas.asyncapi.security.v3.oauth2.OAuth2SecurityScheme
import com.asyncapi.schemas.asyncapi.security.v3.oauth2.OAuthFlows
import com.asyncapi.schemas.asyncapi.security.v3.oauth2.flow.AuthorizationCodeOAuthFlow
import com.asyncapi.schemas.asyncapi.security.v3.oauth2.flow.ClientCredentialsOAuthFlow
import com.asyncapi.schemas.asyncapi.security.v3.oauth2.flow.ImplicitOAuthFlow
import com.asyncapi.schemas.asyncapi.security.v3.oauth2.flow.PasswordOAuthFlow
import java.math.BigDecimal

class CorrelationIdAsyncAPI: AbstractExampleValidationTest() {

    override fun specificationLocation(): String = "/examples/v3.0.0/correlation-id-asyncapi.yml"

    override fun expectedDefaultContentType(): String = "application/json"

    override fun expectedInfo(): Info {
        return Info.builder()
                .title("Correlation ID Example")
                .version("1.0.0")
                .description("A cut of the Streetlights API to test Correlation ID")
                .license(License("Apache 2.0", "https://www.apache.org/licenses/LICENSE-2.0"))
                .build()
    }

    override fun expectedServers(): Map<String, Any> {
        return mapOf(
                Pair("production",
                        Server.builder()
                                .host("test.mosquitto.org:{port}")
                                .protocol("mqtt")
                                .description("Test broker")
                                .variables(mapOf(
                                        Pair("port",
                                                ServerVariable(
                                                        listOf("1883", "8883"),
                                                        "1883",
                                                        "Secure connection (TLS) is available through port 8883.",
                                                        null
                                                )
                                        )
                                ))
                                .security(listOf(
                                        Reference("#/components/securitySchemes/apiKey"),
                                        OAuth2SecurityScheme(
                                                "Flows to support OAuth 2.0",
                                                OAuthFlows(
                                                        ImplicitOAuthFlow(
                                                                "",
                                                                mapOf(
                                                                        Pair(
                                                                                "streetlights:on",
                                                                                "Ability to switch lights on"
                                                                        ),
                                                                        Pair(
                                                                                "streetlights:off",
                                                                                "Ability to switch lights off"
                                                                        ),
                                                                        Pair(
                                                                                "streetlights:dim",
                                                                                "Ability to dim the lights"
                                                                        ),
                                                                ),
                                                                "https://authserver.example/auth"
                                                        ),
                                                        PasswordOAuthFlow(
                                                                "",
                                                                mapOf(
                                                                        Pair(
                                                                                "streetlights:on",
                                                                                "Ability to switch lights on"
                                                                        ),
                                                                        Pair(
                                                                                "streetlights:off",
                                                                                "Ability to switch lights off"
                                                                        ),
                                                                        Pair(
                                                                                "streetlights:dim",
                                                                                "Ability to dim the lights"
                                                                        ),
                                                                ),
                                                                "https://authserver.example/token"
                                                        ),
                                                        ClientCredentialsOAuthFlow(
                                                                "",
                                                                mapOf(
                                                                        Pair(
                                                                                "streetlights:on",
                                                                                "Ability to switch lights on"
                                                                        ),
                                                                        Pair(
                                                                                "streetlights:off",
                                                                                "Ability to switch lights off"
                                                                        ),
                                                                        Pair(
                                                                                "streetlights:dim",
                                                                                "Ability to dim the lights"
                                                                        ),
                                                                ),
                                                                "https://authserver.example/token"
                                                        ),
                                                        AuthorizationCodeOAuthFlow(
                                                                "https://authserver.example/refresh",
                                                                mapOf(
                                                                        Pair(
                                                                                "streetlights:on",
                                                                                "Ability to switch lights on"
                                                                        ),
                                                                        Pair(
                                                                                "streetlights:off",
                                                                                "Ability to switch lights off"
                                                                        ),
                                                                        Pair(
                                                                                "streetlights:dim",
                                                                                "Ability to dim the lights"
                                                                        ),
                                                                ),
                                                                "https://authserver.example/auth",
                                                                "https://authserver.example/token"
                                                        )
                                                ),
                                                listOf(
                                                        "streetlights:on",
                                                        "streetlights:off",
                                                        "streetlights:dim",
                                                ),
                                        ),
                                        Reference("#/components/securitySchemes/openIdConnectWellKnown"),
                                ))
                                .build()
                )
        )
    }

    override fun expectedChannels(): Map<String, Any> {
        return mapOf(
                Pair("lightingMeasured",
                        Channel.builder()
                                .address("smartylighting/streetlights/1/0/event/{streetlightId}/lighting/measured")
                                .messages(mapOf(
                                        Pair("lightMeasured",
                                                Reference("#/components/messages/lightMeasured")
                                        )
                                ))
                                .parameters(mapOf(
                                        Pair("streetlightId",
                                                Reference("#/components/parameters/streetlightId")
                                        )
                                ))
                                .build()
                ),
                Pair("lightsDim",
                        Channel.builder()
                                .address("smartylighting/streetlights/1/0/action/{streetlightId}/dim")
                                .messages(mapOf(
                                        Pair("dimLight",
                                                Reference("#/components/messages/dimLight")
                                        )
                                ))
                                .parameters(mapOf(
                                        Pair("streetlightId",
                                                Reference("#/components/parameters/streetlightId")
                                        )
                                ))
                                .build()
                )
        )
    }

    override fun expectedOperations(): Map<String, Any> {
        return mapOf(
                Pair("receiveLightMeasurement",
                        Operation.builder()
                                .action(OperationAction.RECEIVE)
                                .channel(Reference("#/channels/lightingMeasured"))
                                .summary("Inform about environmental lighting conditions of a particular streetlight.")
                                .messages(listOf(
                                        Reference("#/channels/lightingMeasured/messages/lightMeasured")
                                ))
                                .build()
                ),
                Pair("dimLight",
                        Operation.builder()
                                .action(OperationAction.SEND)
                                .channel(Reference("#/channels/lightsDim"))
                                .messages(listOf(
                                        Reference("#/channels/lightsDim/messages/dimLight")
                                ))
                                .build()
                )
        )
    }

    override fun expectedComponents(): Components? {
        return Components.builder()
                .messages(mapOf(
                        Pair("lightMeasured",
                                Message.builder()
                                        .name("lightMeasured")
                                        .title("Light measured")
                                        .summary("Inform about environmental lighting conditions of a particular streetlight.")
                                        .correlationId(CorrelationId(null, "\$message.header#/MQMD/CorrelId"))
                                        .contentType("application/json")
                                        .payload(Reference("#/components/schemas/lightMeasuredPayload"))
                                        .build()
                        ),
                        Pair("dimLight",
                                Message.builder()
                                        .name("dimLight")
                                        .title("Dim light")
                                        .summary("Command a particular streetlight to dim the lights.")
                                        .correlationId(Reference("#/components/correlationIds/sentAtCorrelator"))
                                        .payload(Reference("#/components/schemas/dimLightPayload"))
                                        .build()
                        )
                ))
                .schemas(mapOf(
                        Pair("lightMeasuredPayload",
                                AsyncAPISchema.builder()
                                        .type("object")
                                        .properties(mapOf(
                                                Pair("lumens",
                                                        AsyncAPISchema.builder()
                                                                .type("integer")
                                                                .minimum(BigDecimal.ZERO)
                                                                .description("Light intensity measured in lumens.")
                                                                .build()
                                                ),
                                                Pair("sentAt",
                                                        AsyncAPISchema.builder()
                                                                .ref("#/components/schemas/sentAt")
                                                                .build()
                                                )
                                        ))
                                        .build()
                        ),
                        Pair("dimLightPayload",
                                AsyncAPISchema.builder()
                                        .type("object")
                                        .properties(mapOf(
                                                Pair("percentage",
                                                        AsyncAPISchema.builder()
                                                                .type("integer")
                                                                .minimum(BigDecimal.ZERO)
                                                                .maximum(BigDecimal.valueOf(100))
                                                                .description("Percentage to which the light should be dimmed to.")
                                                                .build()
                                                ),
                                                Pair("sentAt",
                                                        AsyncAPISchema.builder()
                                                                .ref("#/components/schemas/sentAt")
                                                                .build()
                                                )
                                        ))
                                        .build()
                        ),
                        Pair("sentAt",
                                AsyncAPISchema.builder()
                                        .type("string")
                                        .format("date-time")
                                        .description("Date and time when the message was sent.")
                                        .build()
                        )
                ))
                .parameters(mapOf(
                        Pair("streetlightId", Parameter.builder().description("The ID of the streetlight.").build())
                ))
                .correlationIds(mapOf(
                        Pair("sentAtCorrelator",
                                CorrelationId(
                                        "Data from message payload used as correlation ID",
                                        "\$message.payload#/sentAt"
                                )
                        )
                ))
                .securitySchemes(mapOf(
                        Pair("apiKey",
                                ApiKeySecurityScheme(
                                        "Provide your API key as the user and leave the password empty.",
                                        ApiKeySecurityScheme.ApiKeyLocation.USER
                                )
                        ),
                        Pair("supportedOauthFlows",
                                OAuth2SecurityScheme(
                                        "Flows to support OAuth 2.0",
                                        OAuthFlows(
                                                ImplicitOAuthFlow(
                                                        "",
                                                        mapOf(
                                                                Pair("streetlights:on", "Ability to switch lights on"),
                                                                Pair(
                                                                        "streetlights:off",
                                                                        "Ability to switch lights off"
                                                                ),
                                                                Pair("streetlights:dim", "Ability to dim the lights"),
                                                        ),
                                                        "https://authserver.example/auth"
                                                ),
                                                PasswordOAuthFlow(
                                                        "",
                                                        mapOf(
                                                                Pair("streetlights:on", "Ability to switch lights on"),
                                                                Pair(
                                                                        "streetlights:off",
                                                                        "Ability to switch lights off"
                                                                ),
                                                                Pair("streetlights:dim", "Ability to dim the lights"),
                                                        ),
                                                        "https://authserver.example/token"
                                                ),
                                                ClientCredentialsOAuthFlow(
                                                        "",
                                                        mapOf(
                                                                Pair("streetlights:on", "Ability to switch lights on"),
                                                                Pair(
                                                                        "streetlights:off",
                                                                        "Ability to switch lights off"
                                                                ),
                                                                Pair("streetlights:dim", "Ability to dim the lights"),
                                                        ),
                                                        "https://authserver.example/token"
                                                ),
                                                AuthorizationCodeOAuthFlow(
                                                        "https://authserver.example/refresh",
                                                        mapOf(
                                                                Pair("streetlights:on", "Ability to switch lights on"),
                                                                Pair(
                                                                        "streetlights:off",
                                                                        "Ability to switch lights off"
                                                                ),
                                                                Pair("streetlights:dim", "Ability to dim the lights"),
                                                        ),
                                                        "https://authserver.example/auth",
                                                        "https://authserver.example/token"
                                                )
                                        ),
                                        null
                                )
                        ),
                        Pair("openIdConnectWellKnown",
                                OpenIdConnectSecurityScheme(
                                        null,
                                        "https://authserver.example/.well-known",
                                        null
                                )
                        ),
                ))
                .build()
    }

}