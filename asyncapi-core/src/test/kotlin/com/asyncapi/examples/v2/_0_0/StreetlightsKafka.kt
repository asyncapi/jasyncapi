package com.asyncapi.examples.v2._0_0

import com.asyncapi.schemas.Reference
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
import com.asyncapi.bindings.kafka.v0._4_0.operation.KafkaOperationBinding
import com.asyncapi.schemas.AsyncAPISchema
import com.asyncapi.v2.security_scheme.SecurityScheme
import java.math.BigDecimal

class StreetlightsKafka: AbstractExampleValidationTest() {

    override fun specificationLocation(): String = "/examples/v2.0.0/streetlights-kafka.yml"

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
                Pair("scram-connections", Server.builder()
                        .url("test.mykafkacluster.org:18092")
                        .protocol("kafka-secure")
                        .description("Test broker secured with scramSha256")
                        .security(listOf(
                                mapOf(Pair("saslScram", emptyList()))
                        ))
                        .build()
                ),
                Pair("mtls-connections", Server.builder()
                        .url("test.mykafkacluster.org:28092")
                        .protocol("kafka-secure")
                        .description("Test broker secured with X509")
                        .security(listOf(
                                mapOf(Pair("certs", emptyList()))
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
                                .parameters(mapOf(Pair("streetlightId",
                                    Reference("#/components/parameters/streetlightId")
                                )))
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
                                .parameters(mapOf(Pair("streetlightId",
                                    Reference("#/components/parameters/streetlightId")
                                )))
                                .subscribe(Operation.builder()
                                        .operationId("turnOn")
                                        .traits(listOf(Reference("#/components/operationTraits/kafka")))
                                        .message(Reference("#/components/messages/turnOnOff"))
                                        .build())
                                .build()
                ),
                Pair("smartylighting.streetlights.1.0.action.{streetlightId}.turn.off",
                        ChannelItem.builder()
                                .parameters(mapOf(Pair("streetlightId",
                                    Reference("#/components/parameters/streetlightId")
                                )))
                                .subscribe(Operation.builder()
                                        .operationId("turnOff")
                                        .traits(listOf(Reference("#/components/operationTraits/kafka")))
                                        .message(Reference("#/components/messages/turnOnOff"))
                                        .build())
                                .build()
                ),
                Pair("smartylighting.streetlights.1.0.action.{streetlightId}.dim",
                        ChannelItem.builder()
                                .parameters(mapOf(Pair("streetlightId",
                                    Reference("#/components/parameters/streetlightId")
                                )))
                                .subscribe(Operation.builder()
                                        .operationId("dimLight")
                                        .traits(listOf(Reference("#/components/operationTraits/kafka")))
                                        .message(Reference("#/components/messages/dimLight"))
                                        .build())
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
                                        .payload(AsyncAPISchema.builder().ref("#/components/schemas/lightMeasuredPayload").build())
                                        .build()
                        ),
                        Pair("turnOnOff",
                                Message.builder()
                                        .name("turnOnOff")
                                        .title("Turn on/off")
                                        .summary("Command a particular streetlight to turn the lights on or off.")
                                        .traits(listOf(Reference("#/components/messageTraits/commonHeaders")))
                                        .payload(AsyncAPISchema.builder().ref("#/components/schemas/turnOnOffPayload").build())
                                        .build()
                        ),
                        Pair("dimLight",
                                Message.builder()
                                        .name("dimLight")
                                        .title("Dim light")
                                        .summary("Command a particular streetlight to dim the lights.")
                                        .traits(listOf(Reference("#/components/messageTraits/commonHeaders")))
                                        .payload(AsyncAPISchema.builder().ref("#/components/schemas/dimLightPayload").build())
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
                        Pair("streetlightId", Parameter.builder()
                                .description("The ID of the streetlight.")
                                .schema(AsyncAPISchema.builder().type("string").build())
                                .build()
                        )
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
                                                        .clientId(
                                                            AsyncAPISchema.builder()
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