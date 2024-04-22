package com.asyncapi.examples.v3._0_0

import com.asyncapi.bindings.http.v0._1_0.message.HTTPMessageBinding
import com.asyncapi.Reference
import com.asyncapi.v3._0_0.model.channel.Channel
import com.asyncapi.v3._0_0.model.channel.Parameter
import com.asyncapi.v3._0_0.model.channel.message.Message
import com.asyncapi.v3._0_0.model.component.Components
import com.asyncapi.v3._0_0.model.info.Info
import com.asyncapi.v3._0_0.model.operation.Operation
import com.asyncapi.v3._0_0.model.operation.OperationAction
import com.asyncapi.v3._0_0.model.server.Server
import com.asyncapi.bindings.http.v0._1_0.operation.HTTPOperationBinding
import com.asyncapi.bindings.http.v0._1_0.operation.HTTPOperationMethod
import com.asyncapi.v3.schema.AsyncAPISchema
import com.asyncapi.v3.schema.JsonSchema
import com.asyncapi.v3.schema.multiformat.JsonFormatSchema
import com.asyncapi.v3.security_scheme.http.HttpSecurityScheme

class GitterStreamingAsyncAPI: AbstractExampleValidationTest() {

    override fun specificationLocation(): String = "/examples/v3.0.0/gitter-streaming-asyncapi.yml"

    override fun expectedId(): String = "tag:stream.gitter.im,2022:api"

    override fun expectedInfo(): Info {
        return Info.builder()
                .title("Gitter Streaming API")
                .version("1.0.0")
                .build()
    }

    override fun expectedServers(): Map<String, Any> {
        return mapOf(
                Pair("production",
                        Server.builder()
                                .host("stream.gitter.im")
                                .pathname("/v1")
                                .protocol("https")
                                .protocolVersion("1.1")
                                .security(listOf(
                                    Reference("#/components/securitySchemes/httpBearerToken")
                                ))
                                .build()
                )
        )
    }

    override fun expectedChannels(): Map<String, Any> {
        return mapOf(
                Pair("rooms",
                        Channel.builder()
                                .address("/rooms/{roomId}/{resource}")
                                .messages(mapOf(
                                        Pair("chatMessage",
                                            Reference("#/components/messages/chatMessage")
                                        ),
                                        Pair("heartbeat",
                                            Reference("#/components/messages/heartbeat")
                                        )
                                ))
                                .parameters(mapOf(
                                        Pair("roomId", Parameter.builder()
                                                .description("Id of the Gitter room.")
                                                .examples(listOf("53307860c3599d1de448e19d"))
                                                .build()
                                        ),
                                        Pair("resource", Parameter.builder()
                                                .description("The resource to consume.")
                                                .enumValues(listOf("chatMessages", "events"))
                                                .build())
                                ))
                                .build()
                )
        )
    }

    override fun expectedOperations(): Map<String, Any> {
        return mapOf(
                Pair("sendRoomInfo", Operation.builder()
                        .action(OperationAction.SEND)
                        .channel(Reference("#/channels/rooms"))
                        .bindings(mapOf(
                                Pair("http", HTTPOperationBinding.builder()
                                        .method(HTTPOperationMethod.POST)
                                        .build()
                                )
                        ))
                        .messages(listOf(
                            Reference("#/channels/rooms/messages/chatMessage"),
                            Reference("#/channels/rooms/messages/heartbeat")
                        ))
                        .build()
                )
        )
    }

    override fun expectedComponents(): Components? {
        return Components.builder()
                .securitySchemes(mapOf(
                        Pair("httpBearerToken", HttpSecurityScheme(
                                null,
                                "bearer",
                                null,
                        ))
                ))
                .messages(mapOf(
                        Pair("chatMessage", Message.builder()
                                .summary("A message represents an individual chat message sent to a room. They are a sub-resource of a room.")
                                .payload(
                                    JsonFormatSchema(
                                        "application/schema+yaml;version=draft-07",
                                        JsonSchema.builder()
                                            .type("object")
                                            .properties(mapOf(
                                                Pair("id", JsonSchema.builder()
                                                    .type("string")
                                                    .description("ID of the message.")
                                                    .build()
                                                ),
                                                Pair("text", JsonSchema.builder()
                                                    .type("string")
                                                    .description("Original message in plain-text/markdown.")
                                                    .build()
                                                ),
                                                Pair("html", JsonSchema.builder()
                                                    .type("string")
                                                    .description("HTML formatted message.")
                                                    .build()
                                                ),
                                                Pair("sent", JsonSchema.builder()
                                                    .type("string")
                                                    .format("date-time")
                                                    .description("ISO formatted date of the message.")
                                                    .build()
                                                ),
                                                Pair("fromUser", JsonSchema.builder()
                                                    .type("object")
                                                    .description("User that sent the message.")
                                                    .properties(mapOf(
                                                        Pair("id", JsonSchema.builder()
                                                            .type("string")
                                                            .description("Gitter User ID.")
                                                            .build()
                                                        ),
                                                        Pair("username", JsonSchema.builder()
                                                            .type("string")
                                                            .description("Gitter/GitHub username.")
                                                            .build()
                                                        ),
                                                        Pair("displayName", JsonSchema.builder()
                                                            .type("string")
                                                            .description("Gitter/GitHub user real name.")
                                                            .build()
                                                        ),
                                                        Pair("url", JsonSchema.builder()
                                                            .type("string")
                                                            .description("Path to the user on Gitter.")
                                                            .build()
                                                        ),
                                                        Pair("avatarUrl", JsonSchema.builder()
                                                            .type("string")
                                                            .format("uri")
                                                            .description("User avatar URI.")
                                                            .build()
                                                        ),
                                                        Pair("avatarUrlSmall", JsonSchema.builder()
                                                            .type("string")
                                                            .format("uri")
                                                            .description("User avatar URI (small).")
                                                            .build()
                                                        ),
                                                        Pair("avatarUrlMedium", JsonSchema.builder()
                                                            .type("string")
                                                            .format("uri")
                                                            .description("User avatar URI (medium).")
                                                            .build()
                                                        ),
                                                        Pair("v", JsonSchema.builder()
                                                            .type("number")
                                                            .description("Version.")
                                                            .build()
                                                        ),
                                                        Pair("gv", JsonSchema.builder()
                                                            .type("string")
                                                            .description("Stands for \"Gravatar version\" and is used for cache busting.")
                                                            .build()
                                                        ),
                                                    ))
                                                    .build()
                                                ),
                                                Pair("unread", JsonSchema.builder()
                                                    .type("boolean")
                                                    .description("Boolean that indicates if the current user has read the message.")
                                                    .build()
                                                ),
                                                Pair("readBy", JsonSchema.builder()
                                                    .type("number")
                                                    .description("Number of users that have read the message.")
                                                    .build()
                                                ),
                                                Pair("urls", JsonSchema.builder()
                                                    .type("array")
                                                    .description("List of URLs present in the message.")
                                                    .items(JsonSchema.builder()
                                                        .type("string")
                                                        .format("uri")
                                                        .build()
                                                    )
                                                    .build()
                                                ),
                                                Pair("mentions", JsonSchema.builder()
                                                    .type("array")
                                                    .description("List of @Mentions in the message.")
                                                    .items(JsonSchema.builder()
                                                        .type("object")
                                                        .properties(mapOf(
                                                            Pair("screenName", JsonSchema.builder().type("string").build()),
                                                            Pair("userId", JsonSchema.builder().type("string").build()),
                                                            Pair("userIds", JsonSchema.builder()
                                                                .type("array")
                                                                .items(JsonSchema.builder().type("string").build())
                                                                .build()
                                                            ),
                                                        ))
                                                        .build()
                                                    )
                                                    .build()
                                                ),
                                                Pair("issues", JsonSchema.builder()
                                                    .type("array")
                                                    .description("List of #Issues referenced in the message.")
                                                    .items(JsonSchema.builder()
                                                        .type("object")
                                                        .properties(mapOf(
                                                            Pair("number", JsonSchema.builder().type("string").build()),
                                                        ))
                                                        .build()
                                                    )
                                                    .build()
                                                ),
                                                Pair("meta", JsonSchema.builder()
                                                    .type("array")
                                                    .description("Metadata. This is currently not used for anything.")
                                                    .items(JsonSchema.builder().build())
                                                    .build()
                                                ),
                                                Pair("v", JsonSchema.builder()
                                                    .type("number")
                                                    .description("Version.")
                                                    .build()
                                                ),
                                                Pair("gv", JsonSchema.builder()
                                                    .type("string")
                                                    .description("Stands for \"Gravatar version\" and is used for cache busting.")
                                                    .build()
                                                ),
                                            ))
                                            .build()
                                ))
                                .bindings(mapOf(
                                        Pair("http", HTTPMessageBinding.builder()
                                                .headers(AsyncAPISchema.builder()
                                                        .type("object")
                                                        .properties(mapOf(
                                                                Pair("Transfer-Encoding", AsyncAPISchema.builder()
                                                                        .type("string")
                                                                        .constValue("chunked")
                                                                        .build()
                                                                ),
                                                                Pair("Trailer", AsyncAPISchema.builder()
                                                                        .type("string")
                                                                        .constValue("\\r\\n")
                                                                        .build()
                                                                )
                                                        ))
                                                        .build())
                                                .build()
                                        )
                                ))
                                .build()),
                        Pair("heartbeat", Message.builder()
                                .summary("Its purpose is to keep the connection alive.")
                                .payload(JsonFormatSchema(
                                    "application/schema+yaml;version=draft-07",
                                    JsonSchema.builder()
                                        .type("string")
                                        .enumValue(listOf("\r\n"))
                                        .build()
                                ))
                                .bindings(mapOf(
                                        Pair("http", HTTPMessageBinding.builder()
                                                .headers(AsyncAPISchema.builder()
                                                        .type("object")
                                                        .properties(mapOf(
                                                                Pair("Transfer-Encoding", AsyncAPISchema.builder()
                                                                        .type("string")
                                                                        .constValue("chunked")
                                                                        .build()
                                                                ),
                                                                Pair("Trailer", AsyncAPISchema.builder()
                                                                        .type("string")
                                                                        .constValue("\\r\\n")
                                                                        .build()
                                                                )
                                                        ))
                                                        .build())
                                                .build()
                                        )
                                ))
                                .build()
                        )
                ))
                .build()
    }

}