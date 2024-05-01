package com.asyncapi.examples.v3._0_0

import com.asyncapi.schemas.Reference
import com.asyncapi.v3._0_0.model.ExternalDocumentation
import com.asyncapi.v3._0_0.model.channel.Channel
import com.asyncapi.v3._0_0.model.channel.Parameter
import com.asyncapi.v3._0_0.model.channel.message.Message
import com.asyncapi.v3._0_0.model.component.Components
import com.asyncapi.v3._0_0.model.info.Info
import com.asyncapi.v3._0_0.model.operation.Operation
import com.asyncapi.v3._0_0.model.operation.OperationAction
import com.asyncapi.v3._0_0.model.server.Server
import com.asyncapi.schemas.AsyncAPISchema

class MercureAsyncAPI: AbstractExampleValidationTest() {

    override fun specificationLocation(): String = "/examples/v3.0.0/mercure-asyncapi.yml"

    override fun expectedDefaultContentType(): String = "application/ld+json"

    override fun expectedInfo(): Info {
        return Info.builder()
                .title("Mercure Hub Example")
                .version("1.0.0")
                .description("This example demonstrates how to define a Mercure hub.")
                .build()
    }

    override fun expectedServers(): Map<String, Any> {
        return mapOf(
                Pair("production",
                        Server.builder()
                                .host("demo.mercure.rocks")
                                .pathname("/.well-known/mercure")
                                .protocol("mercure")
                                .build()
                )
        )
    }

    override fun expectedChannels(): Map<String, Any> {
        return mapOf(
                Pair("books",
                        Channel.builder()
                                .address("https://example.com/books/{id}")
                                .messages(mapOf(
                                        Pair("book",
                                            Reference("#/components/messages/book")
                                        )
                                ))
                                .description(
                                        "Every time a resource of type `http://schema.org/Book` is created or " +
                                        "modified, a JSON-LD representation of the new version of this resource " +
                                        "must be pushed in this Mercure topic."
                                )
                                .parameters(mapOf(
                                        Pair("id", Parameter.builder().description("ID of the book").build())
                                ))
                                .build()
                )
        )
    }

    override fun expectedOperations(): Map<String, Any> {
        return mapOf(
                Pair("ReceiveBooksInfo",
                        Operation.builder()
                                .action(OperationAction.RECEIVE)
                                .channel(Reference("#/channels/books"))
                                .messages(listOf(
                                    Reference("#/channels/books/messages/book")
                                ))
                                .build()
                ),
                Pair("SendBooksInfo",
                        Operation.builder()
                                .action(OperationAction.SEND)
                                .channel(Reference("#/channels/books"))
                                .messages(listOf(
                                    Reference("#/channels/books/messages/book")
                                ))
                                .build()
                )
        )
    }

    override fun expectedComponents(): Components {
        return Components.builder()
                .messages(mapOf(
                        Pair("book",
                                Message.builder()
                                        .summary("The content of a book resource.")
                                        .externalDocs(ExternalDocumentation(null, "https://schema.org/Book"))
                                        .payload(
                                            AsyncAPISchema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("@id",
                                                                AsyncAPISchema.builder()
                                                                        .type("string")
                                                                        .format("iri-reference")
                                                                        .build()
                                                        ),
                                                        Pair("@type",
                                                                AsyncAPISchema.builder()
                                                                        .type("string")
                                                                        .format("iri-reference")
                                                                        .build()
                                                        ),
                                                        Pair("name",
                                                                AsyncAPISchema.builder()
                                                                        .type("string")
                                                                        .build()
                                                        ),
                                                        Pair("isbn",
                                                                AsyncAPISchema.builder()
                                                                        .type("string")
                                                                        .build()
                                                        ),
                                                        Pair("abstract",
                                                                AsyncAPISchema.builder()
                                                                        .type("string")
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