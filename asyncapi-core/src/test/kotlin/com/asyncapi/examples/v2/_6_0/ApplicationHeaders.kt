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
import com.asyncapi.schemas.AsyncAPISchema
import java.math.BigDecimal

class ApplicationHeaders: AbstractExampleValidationTest() {

    override fun specificationLocation(): String = "/examples/v2.6.0/application-headers.yml"

    override fun expectedDefaultContentType(): String = "application/json"

    override fun expectedInfo(): Info {
        return Info.builder()
                .title("Application Headers example")
                .version("1.0.0")
                .description("A cut of the Streetlights API to test application header changes supporting")
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
                                .headers(AsyncAPISchema.builder()
                                        .type("object")
                                        .properties(mapOf(
                                                Pair("MQMD", AsyncAPISchema.builder()
                                                        .type("object")
                                                        .properties(mapOf(
                                                                Pair("CorrelId", AsyncAPISchema.builder()
                                                                        .type("string")
                                                                        .minLength(24)
                                                                        .maxLength(24)
                                                                        .format("binary")
                                                                        .build()
                                                                )
                                                        ))
                                                        .build()
                                                ),
                                                Pair("applicationInstanceId", AsyncAPISchema.builder()
                                                        .ref("#/components/schemas/applicationInstanceId")
                                                        .build()
                                                )
                                        ))
                                        .build()
                                )
                                .payload(AsyncAPISchema.builder().ref("#/components/schemas/lightMeasuredPayload").build())
                                .build()
                        )
                ))
                .schemas(mapOf(
                        Pair("lightMeasuredPayload", AsyncAPISchema.builder()
                                .type("object")
                                .properties(mapOf(
                                        Pair("lumens", AsyncAPISchema.builder()
                                                .type("integer")
                                                .minimum(BigDecimal.ZERO)
                                                .description("Light intensity measured in lumens.")
                                                .build()
                                        ),
                                        Pair("sentAt", AsyncAPISchema.builder()
                                                .ref("#/components/schemas/sentAt")
                                                .build()
                                        )
                                ))
                                .build()
                        ),
                        Pair("sentAt", AsyncAPISchema.builder()
                                .type("string")
                                .format("date-time")
                                .description("Date and time when the message was sent.")
                                .build()
                        ),
                        Pair("applicationInstanceId", AsyncAPISchema.builder()
                                .type("string")
                                .description("Unique identifier for a given instance of the publishing application")
                                .build()
                        )
                ))
                .parameters(mapOf(
                        Pair("streetlightId", Parameter.builder()
                                .description("The ID of the streetlight.")
                                .schema(AsyncAPISchema.builder().type("string").build())
                                .build()
                        )
                ))
                .build()
    }

}