package com.asyncapi.examples.v2._6_0

import com.asyncapi.schemas.Reference
import com.asyncapi.schemas.openapi.v3._0_0.OpenAPISchema
import com.asyncapi.v2._6_0.model.channel.ChannelItem
import com.asyncapi.v2._6_0.model.channel.message.Message
import com.asyncapi.v2._6_0.model.channel.operation.Operation
import com.asyncapi.v2._6_0.model.component.Components
import com.asyncapi.v2._6_0.model.info.Info
import com.asyncapi.v2._6_0.model.server.Server

class SchemaFormatOpenAPIPayload: AbstractExampleValidationTest() {

    override fun specificationLocation(): String = "/examples/v2.6.0/schemaFormat - openapi payload.yml"

    override fun expectedInfo(): Info {
        return Info.builder()
            .title("Kafka Queue Example")
            .version("1.0.0")
            .build()
    }

    override fun expectedServers(): Map<String, Any> {
        return mapOf(
            Pair("activemq", Server.builder()
                .url("tcp://localhost:61616")
                .protocol("kafka")
                .build()
            )
        )
    }

    override fun expectedChannels(): Map<String, Any> {
        return mapOf(
            Pair("products", ChannelItem.builder()
                .publish(Operation.builder()
                    .operationId("publishObjectMessage")
                    .message(Reference("#/components/messages/product"))
                    .build()
                )
                .build()
            )
        )
    }

    override fun expectedComponents(): Components {
        return Components.builder()
            .messages(mapOf(
                Pair("product", Message.builder()
                    .name("product")
                    .title("An inventory product")
                    .summary("Product representing items in inventory")
                    .contentType("application/json")
                    .schemaFormat("application/vnd.oai.openapi;version=3.0.0")
                    .payload(OpenAPISchema.builder()
                        .type("object")
                        .properties(mapOf(
                            Pair("name", OpenAPISchema.builder()
                                .description("Every product has a name")
                                .type("string")
                                .example("Iphone")
                                .build()
                            ),
                            Pair("inventory", OpenAPISchema.builder()
                                .description("Count of items in inventory")
                                .type("number")
                                .nullable(true)
                                .build()
                            ),
                            Pair("id", OpenAPISchema.builder()
                                .description("Unique identifier of the product")
                                .type("number")
                                .build()
                            )
                        ))
                        .build()
                    )
                    .build()
                )
            ))
            .build()
    }

}