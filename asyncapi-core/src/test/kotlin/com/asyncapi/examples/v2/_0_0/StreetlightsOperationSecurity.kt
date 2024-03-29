package com.asyncapi.examples.v2._0_0

import com.asyncapi.v2.Reference
import com.asyncapi.v2._0_0.model.Tag
import com.asyncapi.v2._0_0.model.channel.ChannelItem
import com.asyncapi.v2._0_0.model.channel.Parameter
import com.asyncapi.v2._0_0.model.channel.message.Message
import com.asyncapi.v2._0_0.model.channel.message.MessageTrait
import com.asyncapi.v2._0_0.model.channel.operation.Operation
import com.asyncapi.v2._0_0.model.channel.operation.OperationTrait
import com.asyncapi.v2._0_0.model.component.Components
import com.asyncapi.v2._0_0.model.info.Info
import com.asyncapi.v2._0_0.model.info.License
import com.asyncapi.v2._0_0.model.server.Server
import com.asyncapi.v2.binding.operation.kafka.KafkaOperationBinding
import com.asyncapi.v2.schema.Schema
import com.asyncapi.v2.security_scheme.SecurityScheme
import com.asyncapi.v2.security_scheme.oauth2.OAuth2SecurityScheme
import com.asyncapi.v2.security_scheme.oauth2.OAuthFlows
import com.asyncapi.v2.security_scheme.oauth2.flow.ClientCredentialsOAuthFlow
import java.math.BigDecimal

class StreetlightsOperationSecurity: AbstractExampleValidationTest() {

    override fun specificationLocation(): String = "/examples/v2.0.0/streetlights-operation-security.yml"

    override fun expectedDefaultContentType(): String = "application/json"

    override fun expectedInfo(): Info {
        return Info(
                "Streetlights Kafka API",
                "1.0.0",
                "The Smartylighting Streetlights API allows you to remotely manage the city lights.\n\n" +
                        "### Check out its awesome features:\n\n" +
                        "* Turn a specific streetlight on/off \uD83C\uDF03\n" +
                        "* Dim a specific streetlight \uD83D\uDE0E\n" +
                        "* Receive real-time information about environmental lighting conditions \uD83D\uDCC8\n",
                null,
                null,
                License("Apache 2.0", "https://www.apache.org/licenses/LICENSE-2.0"),
        )
    }

    override fun expectedServers(): Map<String, Any> {
        return mapOf(
                Pair("test", Server.builder()
                        .url("test.mykafkacluster.org:8092")
                        .protocol("kafka-secure")
                        .description("Test broker")
                        .security(listOf(
                                mapOf(Pair("saslScram", emptyList()))
                        ))
                        .build()
                ),
                Pair("test_oauth", Server.builder()
                        .url("test.mykafkacluster.org:8093")
                        .protocol("kafka-secure")
                        .description("Test port for oauth")
                        .security(listOf(
                                mapOf(Pair("streetlights_auth", listOf(
                                        "streetlights:write",
                                        "streetlights:read"
                                )))
                        ))
                        .build()
                )
        )
    }

    override fun expectedChannels(): Map<String, Any> {
        return mapOf(
                Pair("smartylighting.streetlights.1.0.event.{streetlightId}.lighting.measured",
                        ChannelItem.builder()
                                .description("The topic on which measured values may be produced and consumed.")
                                .parameters(mapOf(Pair("streetlightId", Reference("#/components/parameters/streetlightId"))))
                                .publish(Operation.builder()
                                        .operationId("receiveLightMeasurement")
                                        .summary("Inform about environmental lighting conditions of a particular streetlight.")
                                        .traits(listOf(Reference("#/components/operationTraits/kafka")))
                                        .message(Reference("#/components/messages/lightMeasured"))
                                        .build())
                                .build()
                ),
                Pair("smartylighting.streetlights.1.0.action.{streetlightId}.turn.on",
                        ChannelItem.builder()
                                .parameters(mapOf(Pair("streetlightId", Reference("#/components/parameters/streetlightId"))))
                                .subscribe(Operation.builder()
                                        .operationId("turnOn")
                                        .traits(listOf(Reference("#/components/operationTraits/kafka")))
                                        .message(Reference("#/components/messages/turnOnOff"))
                                        .build())
                                .build()
                ),
                Pair("smartylighting.streetlights.1.0.action.{streetlightId}.turn.off",
                        ChannelItem.builder()
                                .parameters(mapOf(Pair("streetlightId", Reference("#/components/parameters/streetlightId"))))
                                .subscribe(Operation.builder()
                                        .operationId("turnOff")
                                        .traits(listOf(Reference("#/components/operationTraits/kafka")))
                                        .message(Reference("#/components/messages/turnOnOff"))
                                        .build()
                                )
                                .build()
                ),
                Pair("smartylighting.streetlights.1.0.action.{streetlightId}.dim",
                        ChannelItem.builder()
                                .parameters(mapOf(Pair("streetlightId", Reference("#/components/parameters/streetlightId"))))
                                .subscribe(Operation.builder()
                                        .operationId("dimLight")
                                        .traits(listOf(Reference("#/components/operationTraits/kafka")))
                                        .message(Reference("#/components/messages/dimLight"))
                                        .build()
                                )
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
                                        .payload(Schema.builder().ref("#/components/schemas/lightMeasuredPayload").build())
                                        .build()
                        ),
                        Pair("turnOnOff",
                                Message.builder()
                                        .name("turnOnOff")
                                        .title("Turn on/off")
                                        .summary("Command a particular streetlight to turn the lights on or off.")
                                        .traits(listOf(Reference("#/components/messageTraits/commonHeaders")))
                                        .payload(Schema.builder().ref("#/components/schemas/turnOnOffPayload").build())
                                        .build()
                        ),
                        Pair("dimLight",
                                Message.builder()
                                        .name("dimLight")
                                        .title("Dim light")
                                        .summary("Command a particular streetlight to dim the lights.")
                                        .traits(listOf(Reference("#/components/messageTraits/commonHeaders")))
                                        .payload(Schema.builder().ref("#/components/schemas/dimLightPayload").build())
                                        .build()
                        )
                ))
                .schemas(mapOf(
                        Pair("lightMeasuredPayload",
                                Schema.builder()
                                        .type("object")
                                        .properties(mapOf(
                                                Pair("lumens",
                                                        Schema.builder()
                                                                .type("integer")
                                                                .minimum(BigDecimal.ZERO)
                                                                .description("Light intensity measured in lumens.")
                                                                .build()
                                                ),
                                                Pair("sentAt",
                                                        Schema.builder().ref("#/components/schemas/sentAt").build()
                                                )
                                        ))
                                        .build()
                        ),
                        Pair("turnOnOffPayload",
                                Schema.builder()
                                        .type("object")
                                        .properties(mapOf(
                                                Pair("command",
                                                        Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("on", "off"))
                                                                .description("Whether to turn on or off the light.")
                                                                .build()
                                                ),
                                                Pair("sentAt",
                                                        Schema.builder().ref("#/components/schemas/sentAt").build()
                                                )
                                        ))
                                        .build()
                        ),
                        Pair("dimLightPayload",
                                Schema.builder()
                                        .type("object")
                                        .properties(mapOf(
                                                Pair("percentage",
                                                        Schema.builder()
                                                                .type("integer")
                                                                .minimum(BigDecimal.ZERO)
                                                                .maximum(BigDecimal.valueOf(100))
                                                                .description("Percentage to which the light should be dimmed to.")
                                                                .build()
                                                ),
                                                Pair("sentAt",
                                                        Schema.builder().ref("#/components/schemas/sentAt").build()
                                                )
                                        ))
                                        .build()
                        ),
                        Pair("sentAt",
                                Schema.builder()
                                        .type("string")
                                        .format("date-time")
                                        .description("Date and time when the message was sent.")
                                        .build()
                        )
                ))
                .securitySchemes(mapOf(
                        Pair("saslScram",
                                SecurityScheme.builder()
                                .type(SecurityScheme.Type.SCRAM_SHA256)
                                .description("Provide your username and password for SASL/SCRAM authentication")
                                .build()
                        ),
                        Pair("streetlights_auth",
                                OAuth2SecurityScheme(
                                        "The oauth security descriptions",
                                        OAuthFlows(
                                                null,
                                                null,
                                                ClientCredentialsOAuthFlow(
                                                        "",
                                                        mapOf(
                                                                Pair("streetlights:read", "Scope required for subscribing to channel"),
                                                                Pair("streetlights:write", "Scope required for publishing to channel"),
                                                        ),
                                                        "https://example.com/api/oauth/dialog",
                                                ),
                                                null,
                                        )
                                )
                        )
                ))
                .parameters(mapOf(
                        Pair("streetlightId", Parameter.builder()
                                .description("The ID of the streetlight.")
                                .schema(Schema.builder().type("string").build())
                                .build()
                        )
                ))
                .messageTraits(mapOf(
                        Pair("commonHeaders",
                                MessageTrait.builder()
                                        .headers(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("my-app-header", Schema.builder()
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
                        Pair("kafka",
                                OperationTrait.builder()
                                        .bindings(mapOf(
                                                Pair("kafka", KafkaOperationBinding.builder()
                                                        .clientId(Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("my-app-id"))
                                                                .build()
                                                        )
                                                        .build()
                                                )
                                        ))
                                        .build()
                        )
                ))
                .build()
    }
}