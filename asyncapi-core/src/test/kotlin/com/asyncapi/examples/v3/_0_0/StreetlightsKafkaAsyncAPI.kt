package com.asyncapi.examples.v3._0_0

import com.asyncapi.v3.Reference
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
import com.asyncapi.bindings.kafka.v0._4_0.operation.KafkaOperationBinding
import com.asyncapi.v3.schema.AsyncAPISchema
import com.asyncapi.v3.security_scheme.SecurityScheme
import java.math.BigDecimal

class StreetlightsKafkaAsyncAPI: AbstractExampleValidationTest() {

    override fun specificationLocation(): String = "/examples/v3.0.0/streetlights-kafka-asyncapi.yml"

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
                null,
                null
        )
    }

    override fun expectedServers(): Map<String, Any> {
        return mapOf(
                Pair("scram-connections", Server.builder()
                        .host("test.mykafkacluster.org:18092")
                        .protocol("kafka-secure")
                        .description("Test broker secured with scramSha256")
                        .security(listOf(Reference("#/components/securitySchemes/saslScram")))
                        .tags(listOf(
                                Tag.builder()
                                        .name("env:test-scram")
                                        .description("This environment is meant for running internal tests through scramSha256")
                                        .build(),
                                Tag.builder()
                                        .name("kind:remote")
                                        .description("This server is a remote server. Not exposed by the application")
                                        .build(),
                                Tag.builder()
                                        .name("visibility:private")
                                        .description("This resource is private and only available to certain users")
                                        .build()
                        ))
                        .build()
                ),
                Pair("mtls-connections", Server.builder()
                        .host("test.mykafkacluster.org:28092")
                        .protocol("kafka-secure")
                        .description("Test broker secured with X509")
                        .security(listOf(
                                Reference("#/components/securitySchemes/certs")
                        ))
                        .tags(listOf(
                                Tag.builder()
                                        .name("env:test-mtls")
                                        .description("This environment is meant for running internal tests through mtls")
                                        .build(),
                                Tag.builder()
                                        .name("kind:remote")
                                        .description("This server is a remote server. Not exposed by the application")
                                        .build(),
                                Tag.builder()
                                        .name("visibility:private")
                                        .description("This resource is private and only available to certain users")
                                        .build()
                        ))
                        .build()
                )
        )
    }

    override fun expectedChannels(): Map<String, Any> {
        return mapOf(
                Pair("lightingMeasured",
                        Channel.builder()
                                .address("smartylighting.streetlights.1.0.event.{streetlightId}.lighting.measured")
                                .messages(mapOf(Pair("lightMeasured", Reference("#/components/messages/lightMeasured"))))
                                .description("The topic on which measured values may be produced and consumed.")
                                .parameters(mapOf(Pair("streetlightId", Reference("#/components/parameters/streetlightId"))))
                                .build()
                ),
                Pair("lightTurnOn",
                        Channel.builder()
                                .address("smartylighting.streetlights.1.0.action.{streetlightId}.turn.on")
                                .messages(mapOf(Pair("turnOn", Reference("#/components/messages/turnOnOff"))))
                                .parameters(mapOf(Pair("streetlightId", Reference("#/components/parameters/streetlightId"))))
                                .build()
                ),
                Pair("lightTurnOff",
                        Channel.builder()
                                .address("smartylighting.streetlights.1.0.action.{streetlightId}.turn.off")
                                .messages(mapOf(Pair("turnOff", Reference("#/components/messages/turnOnOff"))))
                                .parameters(mapOf(Pair("streetlightId", Reference("#/components/parameters/streetlightId"))))
                                .build()
                ),
                Pair("lightsDim",
                        Channel.builder()
                                .address("smartylighting.streetlights.1.0.action.{streetlightId}.dim")
                                .messages(mapOf(Pair("dimLight", Reference("#/components/messages/dimLight"))))
                                .parameters(mapOf(Pair("streetlightId", Reference("#/components/parameters/streetlightId"))))
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
                                .traits(listOf(Reference("#/components/operationTraits/kafka")))
                                .messages(listOf(Reference("#/channels/lightingMeasured/messages/lightMeasured")))
                                .build()
                ),
                Pair("turnOn",
                        Operation.builder()
                                .action(OperationAction.SEND)
                                .channel(Reference("#/channels/lightTurnOn"))
                                .traits(listOf(Reference("#/components/operationTraits/kafka")))
                                .messages(listOf(Reference("#/channels/lightTurnOn/messages/turnOn")))
                                .build()
                ),
                Pair("turnOff",
                        Operation.builder()
                                .action(OperationAction.SEND)
                                .channel(Reference("#/channels/lightTurnOff"))
                                .traits(listOf(Reference("#/components/operationTraits/kafka")))
                                .messages(listOf(Reference("#/channels/lightTurnOff/messages/turnOff")))
                                .build()
                ),
                Pair("dimLight",
                        Operation.builder()
                                .action(OperationAction.SEND)
                                .channel(Reference("#/channels/lightsDim"))
                                .traits(listOf(Reference("#/components/operationTraits/kafka")))
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
                                                Pair("sentAt",
                                                        AsyncAPISchema.builder().ref("#/components/schemas/sentAt").build()
                                                )
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
                                                Pair("sentAt",
                                                        AsyncAPISchema.builder().ref("#/components/schemas/sentAt").build()
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
                                                        AsyncAPISchema.builder().ref("#/components/schemas/sentAt").build()
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
                .securitySchemes(mapOf(
                        Pair("saslScram",
                                SecurityScheme.builder()
                                .type(SecurityScheme.Type.SCRAM_SHA256)
                                .description("Provide your username and password for SASL/SCRAM authentication")
                                .build()
                        ),
                        Pair("certs",
                                SecurityScheme(
                                        SecurityScheme.Type.X509,
                                        "Download the certificate files from service provider"
                                )
                        )
                ))
                .parameters(mapOf(
                        Pair("streetlightId", Parameter.builder().description("The ID of the streetlight.").build())
                ))
                .messageTraits(mapOf(
                        Pair("commonHeaders",
                                MessageTrait.builder()
                                        .headers(AsyncAPISchema.builder()
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
                        Pair("kafka",
                                OperationTrait.builder()
                                        .bindings(mapOf(
                                                Pair("kafka", KafkaOperationBinding.builder()
                                                        .clientId(AsyncAPISchema.builder()
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