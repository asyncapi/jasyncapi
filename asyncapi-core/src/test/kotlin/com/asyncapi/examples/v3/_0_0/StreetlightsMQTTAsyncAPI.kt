package com.asyncapi.examples.v3._0_0

import com.asyncapi.v3.security_scheme.ApiKeySecurityScheme
import com.asyncapi.v3.security_scheme.OpenIdConnectSecurityScheme
import com.asyncapi.schemas.Reference
import com.asyncapi.v3._0_0.model.Tag
import com.asyncapi.v3._0_0.model.channel.Channel
import com.asyncapi.v3._0_0.model.channel.Parameter
import com.asyncapi.v3._0_0.model.channel.message.Message
import com.asyncapi.v3._0_0.model.channel.message.MessageTrait
import com.asyncapi.v3._0_0.model.component.Components
import com.asyncapi.v3._0_0.model.info.Info
import com.asyncapi.v3._0_0.model.info.License
import com.asyncapi.v3._0_0.model.operation.Operation
import com.asyncapi.v3._0_0.model.operation.OperationAction
import com.asyncapi.v3._0_0.model.operation.OperationTrait
import com.asyncapi.v3._0_0.model.server.Server
import com.asyncapi.v3._0_0.model.server.ServerVariable
import com.asyncapi.bindings.mqtt.v0._1_0.operation.MQTTOperationBinding
import com.asyncapi.schemas.AsyncAPISchema
import com.asyncapi.v3.security_scheme.oauth2.OAuth2SecurityScheme
import com.asyncapi.v3.security_scheme.oauth2.OAuthFlows
import com.asyncapi.v3.security_scheme.oauth2.flow.AuthorizationCodeOAuthFlow
import com.asyncapi.v3.security_scheme.oauth2.flow.ClientCredentialsOAuthFlow
import com.asyncapi.v3.security_scheme.oauth2.flow.ImplicitOAuthFlow
import com.asyncapi.v3.security_scheme.oauth2.flow.PasswordOAuthFlow
import java.math.BigDecimal

class StreetlightsMQTTAsyncAPI: AbstractExampleValidationTest() {

    override fun specificationLocation(): String = "/examples/v3.0.0/streetlights-mqtt-asyncapi.yml"

    override fun expectedInfo(): Info {
        return Info(
                "Streetlights MQTT API",
                "1.0.0",
                "The Smartylighting Streetlights API allows you to remotely manage the city lights.\n\n" +
                        "### Check out its awesome features:\n\n" +
                        "* Turn a specific streetlight on/off \uD83C\uDF03\n" +
                        "* Dim a specific streetlight \uD83D\uDE0E\n" +
                        "* Receive real-time information about environmental lighting conditions \uD83D\uDCC8\n",
                null,
                null,
                License("Apache 2.0", "https://www.apache.org/licenses/LICENSE-2.0"),
                null,
                null
        )
    }

    override fun expectedDefaultContentType(): String = "application/json"

    override fun expectedServers(): Map<String, Any> {
        return mapOf(
                Pair("production",
                        Server.builder()
                                .host("test.mosquitto.org:{port}")
                                .protocol("mqtt")
                                .description("Test broker")
                                .variables(mapOf(
                                        Pair("port",
                                                ServerVariable.builder()
                                                        .description("Secure connection (TLS) is available through port 8883.")
                                                        .defaultValue("1883")
                                                        .enumValues(listOf("1883", "8883"))
                                                        .build()
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
                                                                        Pair("streetlights:on", "Ability to switch lights on"),
                                                                        Pair("streetlights:off", "Ability to switch lights off"),
                                                                        Pair("streetlights:dim", "Ability to dim the lights")
                                                                ),
                                                                "https://authserver.example/auth"
                                                        ),
                                                        PasswordOAuthFlow(
                                                                "",
                                                                mapOf(
                                                                        Pair("streetlights:on", "Ability to switch lights on"),
                                                                        Pair("streetlights:off", "Ability to switch lights off"),
                                                                        Pair("streetlights:dim", "Ability to dim the lights")
                                                                ),
                                                                "https://authserver.example/token"
                                                        ),
                                                        ClientCredentialsOAuthFlow(
                                                                "",
                                                                mapOf(
                                                                        Pair("streetlights:on", "Ability to switch lights on"),
                                                                        Pair("streetlights:off", "Ability to switch lights off"),
                                                                        Pair("streetlights:dim", "Ability to dim the lights")
                                                                ),
                                                                "https://authserver.example/token"
                                                        ),
                                                        AuthorizationCodeOAuthFlow(
                                                                "https://authserver.example/refresh",
                                                                mapOf(
                                                                        Pair("streetlights:on", "Ability to switch lights on"),
                                                                        Pair("streetlights:off", "Ability to switch lights off"),
                                                                        Pair("streetlights:dim", "Ability to dim the lights")
                                                                ),
                                                                "https://authserver.example/auth",
                                                                "https://authserver.example/token"
                                                        )
                                                ),
                                                listOf("streetlights:on", "streetlights:off", "streetlights:dim")
                                        ),
                                    Reference("#/components/securitySchemes/openIdConnectWellKnown")
                                ))
                                .tags(listOf(
                                        Tag("env:production", "This environment is meant for production use case", null),
                                        Tag("kind:remote", "This server is a remote server. Not exposed by the application", null),
                                        Tag("visibility:public", "This resource is public and available to everyone", null)
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
                                .description("The topic on which measured values may be produced and consumed.")
                                .parameters(mapOf(
                                        Pair("streetlightId",
                                            Reference("#/components/parameters/streetlightId")
                                        )
                                ))
                                .build()
                ),
                Pair("lightTurnOn",
                        Channel.builder()
                                .address("smartylighting/streetlights/1/0/action/{streetlightId}/turn/on")
                                .messages(mapOf(
                                        Pair("turnOn",
                                            Reference("#/components/messages/turnOnOff")
                                        )
                                ))
                                .parameters(mapOf(
                                        Pair("streetlightId",
                                            Reference("#/components/parameters/streetlightId")
                                        )
                                ))
                                .build()
                ),
                Pair("lightTurnOff",
                        Channel.builder()
                                .address("smartylighting/streetlights/1/0/action/{streetlightId}/turn/off")
                                .messages(mapOf(
                                        Pair("turnOff",
                                            Reference("#/components/messages/turnOnOff")
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
                                .summary(
                                        "Inform about environmental lighting conditions of a particular streetlight.")
                                .traits(listOf(Reference("#/components/operationTraits/mqtt")))
                                .messages(listOf(Reference("#/channels/lightingMeasured/messages/lightMeasured")))
                                .build()
                ),
                Pair("turnOn",
                        Operation.builder()
                                .action(OperationAction.SEND)
                                .channel(Reference("#/channels/lightTurnOn"))
                                .traits(listOf(Reference("#/components/operationTraits/mqtt")))
                                .messages(listOf(Reference("#/channels/lightTurnOn/messages/turnOn")))
                                .build()
                ),
                Pair("turnOff",
                        Operation.builder()
                                .action(OperationAction.SEND)
                                .channel(Reference("#/channels/lightTurnOff"))
                                .traits(listOf(Reference("#/components/operationTraits/mqtt")))
                                .messages(listOf(Reference("#/channels/lightTurnOff/messages/turnOff")))
                                .build()
                ),
                Pair("dimLight",
                        Operation.builder()
                                .action(OperationAction.SEND)
                                .channel(Reference("#/channels/lightsDim"))
                                .traits(listOf(Reference("#/components/operationTraits/mqtt")))
                                .messages(listOf(Reference("#/channels/lightsDim/messages/dimLight")))
                                .build()
                )
        )
    }

    override fun expectedComponents(): Components {
        return Components.builder()
                .messages(mapOf(
                        Pair("lightMeasured",
                                Message.builder()
                                        .name("lightMeasured")
                                        .title("Light measured")
                                        .summary("Inform about environmental lighting conditions of a particular streetlight.")
                                        .contentType("application/json")
                                        .traits(listOf(Reference("#/components/messageTraits/commonHeaders")))
                                        .payload(Reference("#/components/schemas/lightMeasuredPayload"))
                                        .build()
                        ),
                        Pair("turnOnOff",
                                Message.builder()
                                        .name("turnOnOff")
                                        .title("Turn on/off")
                                        .summary("Command a particular streetlight to turn the lights on or off.")
                                        .traits(listOf(Reference("#/components/messageTraits/commonHeaders")))
                                        .payload(Reference("#/components/schemas/turnOnOffPayload"))
                                        .build()
                        ),
                        Pair("dimLight",
                                Message.builder()
                                        .name("dimLight")
                                        .title("Dim light")
                                        .summary("Command a particular streetlight to dim the lights.")
                                        .traits(listOf(Reference("#/components/messageTraits/commonHeaders")))
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
                                                Pair("sentAt", AsyncAPISchema.builder().ref("#/components/schemas/sentAt").build())
                                        ))
                                        .build()
                        ),
                        Pair("turnOnOffPayload",
                                AsyncAPISchema.builder()
                                        .type("object")
                                        .properties(mapOf(
                                                Pair("command",
                                                        AsyncAPISchema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("on", "off"))
                                                                .description("Whether to turn on or off the light.")
                                                                .build()
                                                ),
                                                Pair("sentAt", AsyncAPISchema.builder().ref("#/components/schemas/sentAt").build())
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
                                                Pair("sentAt", AsyncAPISchema.builder().ref("#/components/schemas/sentAt").build())
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
                .securitySchemes(mapOf(
                        Pair("apiKey",
                                ApiKeySecurityScheme("Provide your API key as the user and leave the password empty.", ApiKeySecurityScheme.ApiKeyLocation.USER)
                        ),
                        Pair("supportedOauthFlows",
                                OAuth2SecurityScheme(
                                        "Flows to support OAuth 2.0",
                                        OAuthFlows(
                                                ImplicitOAuthFlow(
                                                        "",
                                                        mapOf(
                                                                Pair("streetlights:on", "Ability to switch lights on"),
                                                                Pair("streetlights:off", "Ability to switch lights off"),
                                                                Pair("streetlights:dim", "Ability to dim the lights")
                                                        ),
                                                        "https://authserver.example/auth"
                                                ),
                                                PasswordOAuthFlow(
                                                        "",
                                                        mapOf(
                                                                Pair("streetlights:on", "Ability to switch lights on"),
                                                                Pair("streetlights:off", "Ability to switch lights off"),
                                                                Pair("streetlights:dim", "Ability to dim the lights")
                                                        ),
                                                        "https://authserver.example/token"
                                                ),
                                                ClientCredentialsOAuthFlow(
                                                        "",
                                                        mapOf(
                                                                Pair("streetlights:on", "Ability to switch lights on"),
                                                                Pair("streetlights:off", "Ability to switch lights off"),
                                                                Pair("streetlights:dim", "Ability to dim the lights")
                                                        ),
                                                        "https://authserver.example/token"
                                                ),
                                                AuthorizationCodeOAuthFlow(
                                                        "https://authserver.example/refresh",
                                                        mapOf(
                                                                Pair("streetlights:on", "Ability to switch lights on"),
                                                                Pair("streetlights:off", "Ability to switch lights off"),
                                                                Pair("streetlights:dim", "Ability to dim the lights")
                                                        ),
                                                        "https://authserver.example/auth",
                                                        "https://authserver.example/token"
                                                )
                                        ),
                                        null
                                )
                        ),
                        Pair("openIdConnectWellKnown", OpenIdConnectSecurityScheme(null, "https://authserver.example/.well-known", null))
                ))
                .parameters(mapOf(
                        Pair("streetlightId", Parameter.builder().description("The ID of the streetlight.").build())
                ))
                .messageTraits(mapOf(
                        Pair("commonHeaders",
                                MessageTrait.builder()
                                        .headers(
                                            AsyncAPISchema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("my-app-header", AsyncAPISchema.builder()
                                                                .type("integer")
                                                                .minimum(BigDecimal.ZERO)
                                                                .maximum(BigDecimal.valueOf(100))
                                                                .build()
                                                        )
                                                ))
                                                .build()
                                        )
                                        .build()
                        )
                ))
                .operationTraits(mapOf(
                        Pair("mqtt",
                                OperationTrait.builder()
                                        .bindings(mapOf(
                                                Pair("mqtt", MQTTOperationBinding.builder().qos(1).build())
                                        ))
                                        .build()
                        )
                ))
                .build()
    }

}