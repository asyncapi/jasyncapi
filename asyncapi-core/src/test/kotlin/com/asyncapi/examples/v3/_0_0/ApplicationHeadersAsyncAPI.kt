package com.asyncapi.examples.v3._0_0

import com.asyncapi.v3.Reference
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
import com.asyncapi.v3.schema.AsyncAPISchema
import java.math.BigDecimal

class ApplicationHeadersAsyncAPI: AbstractExampleValidationTest() {

    override fun specificationLocation(): String = "/examples/v3.0.0/application-headers-asyncapi.yml"

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
                                        Pair("lightMeasured", Reference("#/components/messages/lightMeasured"))
                                ))
                                .parameters(mapOf(
                                        Pair("streetlightId", Reference("#/components/parameters/streetlightId"))
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
                                        .correlationId(CorrelationId(null, "\$message.header#/MQMD/CorrelId"))
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
                                                        Pair("applicationInstanceId", AsyncAPISchema.builder().ref("#/components/schemas/applicationInstanceId").build())
                                                ))
                                                .build()
                                        )
                                        .payload(Reference("#/components/schemas/lightMeasuredPayload"))
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
                        Pair("sentAt",
                                AsyncAPISchema.builder()
                                        .type("string")
                                        .format("date-time")
                                        .description("Date and time when the message was sent.")
                                        .build()
                        ),
                        Pair("applicationInstanceId",
                                AsyncAPISchema.builder()
                                        .type("string")
                                        .description("Unique identifier for a given instance of the publishing application")
                                        .build()
                        )
                ))
                .parameters(mapOf(
                        Pair("streetlightId",
                                Parameter.builder()
                                        .description("The ID of the streetlight.")
                                        .build()
                        )
                ))
                .build()
    }

}