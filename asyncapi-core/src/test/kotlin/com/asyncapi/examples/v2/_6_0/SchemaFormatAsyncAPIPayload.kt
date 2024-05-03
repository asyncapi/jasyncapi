package com.asyncapi.examples.v2._6_0

import com.asyncapi.schemas.AsyncAPISchema
import com.asyncapi.schemas.JsonSchema
import com.asyncapi.schemas.Reference
import com.asyncapi.v2._6_0.model.channel.ChannelItem
import com.asyncapi.v2._6_0.model.channel.message.Message
import com.asyncapi.v2._6_0.model.channel.operation.Operation
import com.asyncapi.v2._6_0.model.component.Components
import com.asyncapi.v2._6_0.model.info.Info
import com.asyncapi.v2._6_0.model.server.Server
import java.math.BigDecimal

class SchemaFormatAsyncAPIPayload: AbstractExampleValidationTest() {

    override fun specificationLocation(): String = "/examples/v2.6.0/schemaFormat - asyncapi payload.yml"

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
                    .schemaFormat("application/vnd.aai.asyncapi+json;version=2.6.0")
                    .payload(AsyncAPISchema.builder()
                        .id("https://example.com/person.schema.json")
                        .schema("http://json-schema.org/draft-07/schema#")
                        .title("Person")
                        .type("object")
                        .properties(mapOf(
                            Pair("firstName", AsyncAPISchema.builder()
                                .type("string")
                                .description("The person's first name.")
                                .build()
                            ),
                            Pair("lastName", AsyncAPISchema.builder()
                                .type("string")
                                .description("The person's last name.")
                                .build()
                            ),
                            Pair("age", AsyncAPISchema.builder()
                                .type("integer")
                                .description("Age in years which must be equal to or greater than zero.")
                                .minimum(BigDecimal.ZERO)
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