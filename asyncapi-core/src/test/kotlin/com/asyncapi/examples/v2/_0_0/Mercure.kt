package com.asyncapi.examples.v2._0_0

import com.asyncapi.v2.Reference
import com.asyncapi.v2._0_0.model.ExternalDocumentation
import com.asyncapi.v2._0_0.model.channel.ChannelItem
import com.asyncapi.v2._0_0.model.channel.Parameter
import com.asyncapi.v2._0_0.model.channel.message.Message
import com.asyncapi.v2._0_0.model.channel.operation.Operation
import com.asyncapi.v2._0_0.model.component.Components
import com.asyncapi.v2._0_0.model.info.Info
import com.asyncapi.v2._0_0.model.server.Server
import com.asyncapi.v2.schema.Schema

class Mercure: AbstractExampleValidationTest() {

    override fun specificationLocation(): String = "/examples/v2.0.0/mercure.yml"

    override fun expectedDefaultContentType(): String = "application/ld+json"

    override fun expectedInfo(): Info {
        return Info.builder()
                .title("Mercure Hub Example")
                .description("This example demonstrates how to define a Mercure hub.")
                .version("1.0.0")
                .build()
    }

    override fun expectedServers(): Map<String, Any> {
        return mapOf(
                Pair("production", Server.builder()
                        .url("https://demo.mercure.rocks/.well-known/mercure")
                        .protocol("mercure")
                        .build()
                )
        )
    }

    override fun expectedChannels(): Map<String, Any> {
        return mapOf(
                Pair("https://example.com/books/{id}", ChannelItem.builder()
                        .description("Every time a resource of type `http://schema.org/Book` is created or modified, a JSON-LD representation of the new version of this resource must be pushed in this Mercure topic.")
                        .parameters(mapOf(
                                Pair("id", Parameter.builder()
                                        .schema(Schema.builder()
                                                .type("integer")
                                                .build()
                                        )
                                        .build()
                                )
                        ))
                        .subscribe(Operation.builder()
                                .message(Reference("#/components/messages/book"))
                                .build()
                        )
                        .publish(Operation.builder()
                                .message(Reference("#/components/messages/book"))
                                .build()
                        )
                        .build()
                )
        )
    }

    override fun expectedComponents(): Components? {
        return Components.builder()
                .messages(mapOf(
                        Pair("book", Message.builder()
                                .summary("The content of a book resource.")
                                .externalDocs(ExternalDocumentation(
                                        null,
                                        "https://schema.org/Book"
                                ))
                                .payload(Schema.builder()
                                        .type("object")
                                        .properties(mapOf(
                                                Pair("@id", Schema.builder()
                                                        .type("string")
                                                        .format("iri-reference")
                                                        .build()
                                                ),
                                                Pair("@type", Schema.builder()
                                                        .type("string")
                                                        .format("iri-reference")
                                                        .build()
                                                ),
                                                Pair("name", Schema.builder()
                                                        .type("string")
                                                        .build()
                                                ),
                                                Pair("isbn", Schema.builder()
                                                        .type("string")
                                                        .build()
                                                ),
                                                Pair("abstract", Schema.builder()
                                                        .type("string")
                                                        .build()
                                                ),
                                        ))
                                        .build()
                                )
                                .build()
                        ),
                ))
                .build()
    }

}