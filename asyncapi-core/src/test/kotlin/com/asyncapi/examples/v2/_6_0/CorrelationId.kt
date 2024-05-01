package com.asyncapi.examples.v2._6_0

import com.asyncapi.schemas.Reference
import com.asyncapi.v2._6_0.model.channel.ChannelItem
import com.asyncapi.v2._6_0.model.channel.Parameter
import com.asyncapi.v2._6_0.model.channel.message.CorrelationId
import com.asyncapi.v2._6_0.model.channel.message.Message
import com.asyncapi.v2._6_0.model.channel.operation.Operation
import com.asyncapi.v2._6_0.model.component.Components
import com.asyncapi.v2._6_0.model.info.Info
import com.asyncapi.v2._6_0.model.info.License
import com.asyncapi.v2._6_0.model.server.Server
import com.asyncapi.v2._6_0.model.server.ServerVariable
import com.asyncapi.v2.schema.Schema
import com.asyncapi.v2.security_scheme.ApiKeySecurityScheme
import com.asyncapi.v2.security_scheme.OpenIdConnectSecurityScheme
import com.asyncapi.v2.security_scheme.oauth2.OAuth2SecurityScheme
import com.asyncapi.v2.security_scheme.oauth2.OAuthFlows
import com.asyncapi.v2.security_scheme.oauth2.flow.AuthorizationCodeOAuthFlow
import com.asyncapi.v2.security_scheme.oauth2.flow.ClientCredentialsOAuthFlow
import com.asyncapi.v2.security_scheme.oauth2.flow.ImplicitOAuthFlow
import com.asyncapi.v2.security_scheme.oauth2.flow.PasswordOAuthFlow
import java.math.BigDecimal

class CorrelationId: AbstractExampleValidationTest() {

    override fun specificationLocation(): String = "/examples/v2.6.0/correlation-id.yml"

    override fun expectedDefaultContentType(): String = "application/json"

    override fun expectedInfo(): Info {
        return Info.builder()
                .title("Correlation ID Example")
                .version("1.0.0")
                .description("A cut of the Streetlights API to test Correlation ID")
                .license(License(
                        "Apache 2.0",
                        "https://www.apache.org/licenses/LICENSE-2.0"
                ))
                .build()
    }

    override fun expectedServers(): Map<String, Any> {
        return mapOf(
                Pair("production", Server.builder()
                        .url("test.mosquitto.org:{port}")
                        .protocol("mqtt")
                        .description("Test broker")
                        .variables(mapOf(
                                Pair("port", ServerVariable.builder()
                                        .description("Secure connection (TLS) is available through port 8883.")
                                        .defaultValue("1883")
                                        .enumValues(listOf("1883", "8883"))
                                        .build()
                                )
                        ))
                        .security(listOf(
                                mapOf(Pair("apiKey", emptyList<String>())),
                                mapOf(Pair("supportedOauthFlows", listOf(
                                        "streetlights:on", "streetlights:off", "streetlights:dim"
                                ))),
                                mapOf(Pair("openIdConnectWellKnown", emptyList<String>())),
                        ))
                        .build()
                )
        )
    }

    override fun expectedChannels(): Map<String, Any> {
        return mapOf(
                Pair("smartylighting/streetlights/1/0/event/{streetlightId}/lighting/measured", ChannelItem.builder()
                        .parameters(mapOf(
                                Pair("streetlightId",
                                    Reference("#/components/parameters/streetlightId")
                                )
                        ))
                        .publish(Operation.builder()
                                .summary("Inform about environmental lighting conditions of a particular streetlight.")
                                .operationId("receiveLightMeasurement")
                                .message(Reference("#/components/messages/lightMeasured"))
                                .build()
                        )
                        .build()
                ),
                Pair("smartylighting/streetlights/1/0/action/{streetlightId}/dim", ChannelItem.builder()
                        .parameters(mapOf(
                                Pair("streetlightId",
                                    Reference("#/components/parameters/streetlightId")
                                )
                        ))
                        .subscribe(Operation.builder()
                                .operationId("dimLight")
                                .message(Reference("#/components/messages/dimLight"))
                                .build()
                        )
                        .build()
                )
        )
    }

    override fun expectedComponents(): Components? {
        return Components.builder()
                .messages(mapOf(
                        Pair("lightMeasured", Message.builder()
                                .name("lightMeasured")
                                .title("Light measured")
                                .summary("Inform about environmental lighting conditions of a particular streetlight.")
                                .correlationId(CorrelationId(
                                        null,
                                        "\$message.header#/MQMD/CorrelId"
                                ))
                                .contentType("application/json")
                                .payload(Schema.builder().ref("#/components/schemas/lightMeasuredPayload").build())
                                .build()
                        ),
                        Pair("dimLight", Message.builder()
                                .name("dimLight")
                                .title("Dim light")
                                .summary("Command a particular streetlight to dim the lights.")
                                .correlationId(Reference("#/components/correlationIds/sentAtCorrelator"))
                                .payload(Schema.builder().ref("#/components/schemas/dimLightPayload").build())
                                .build()
                        )
                ))
                .schemas(mapOf(
                        Pair("lightMeasuredPayload", Schema.builder()
                                .type("object")
                                .properties(mapOf(
                                        Pair("lumens", Schema.builder()
                                                .type("integer")
                                                .minimum(BigDecimal.ZERO)
                                                .description("Light intensity measured in lumens.")
                                                .build()
                                        ),
                                        Pair("sentAt", Schema.builder()
                                                .ref("#/components/schemas/sentAt")
                                                .build()
                                        )
                                ))
                                .build()
                        ),
                        Pair("sentAt", Schema.builder()
                                .type("string")
                                .format("date-time")
                                .description("Date and time when the message was sent.")
                                .build()
                        ),
                        Pair("dimLightPayload", Schema.builder()
                                .type("object")
                                .properties(mapOf(
                                        Pair("percentage", Schema.builder()
                                                .type("integer")
                                                .minimum(BigDecimal.ZERO)
                                                .maximum(BigDecimal.valueOf(100))
                                                .description("Percentage to which the light should be dimmed to.")
                                                .build()
                                        ),
                                        Pair("sentAt", Schema.builder()
                                                .ref("#/components/schemas/sentAt")
                                                .build()
                                        )
                                ))
                                .build()
                        )
                ))
                .parameters(mapOf(
                        Pair("streetlightId", Parameter.builder()
                                .description("The ID of the streetlight.")
                                .schema(Schema.builder().type("string").build())
                                .build()
                        )
                ))
                .correlationIds(mapOf(
                        Pair("sentAtCorrelator", CorrelationId(
                                "Data from message payload used as correlation ID",
                                "\$message.payload#/sentAt"
                        ))
                ))
                .securitySchemes(mapOf(
                        Pair("apiKey", ApiKeySecurityScheme(
                                "Provide your API key as the user and leave the password empty.",
                                ApiKeySecurityScheme.ApiKeyLocation.USER
                        )),
                        Pair("supportedOauthFlows", OAuth2SecurityScheme(
                                "Flows to support OAuth 2.0",
                                OAuthFlows(
                                        ImplicitOAuthFlow(
                                                "",
                                                mapOf(
                                                        Pair("streetlights:on", "Ability to switch lights on"),
                                                        Pair("streetlights:off", "Ability to switch lights off"),
                                                        Pair("streetlights:dim", "Ability to dim the lights"),
                                                ),
                                                "https://authserver.example/auth",
                                        ),
                                        PasswordOAuthFlow(
                                                "",
                                                mapOf(
                                                        Pair("streetlights:on", "Ability to switch lights on"),
                                                        Pair("streetlights:off", "Ability to switch lights off"),
                                                        Pair("streetlights:dim", "Ability to dim the lights"),
                                                ),
                                                "https://authserver.example/token",
                                        ),
                                        ClientCredentialsOAuthFlow(
                                                "",
                                                mapOf(
                                                        Pair("streetlights:on", "Ability to switch lights on"),
                                                        Pair("streetlights:off", "Ability to switch lights off"),
                                                        Pair("streetlights:dim", "Ability to dim the lights"),
                                                ),
                                                "https://authserver.example/token",
                                        ),
                                        AuthorizationCodeOAuthFlow(
                                                "https://authserver.example/refresh",
                                                mapOf(
                                                        Pair("streetlights:on", "Ability to switch lights on"),
                                                        Pair("streetlights:off", "Ability to switch lights off"),
                                                        Pair("streetlights:dim", "Ability to dim the lights"),
                                                ),
                                                "https://authserver.example/auth",
                                                "https://authserver.example/token",
                                        )
                                )
                        )),
                        Pair("openIdConnectWellKnown", OpenIdConnectSecurityScheme(
                                null,
                                "https://authserver.example/.well-known"
                        ))
                ))
                .build()
    }

}