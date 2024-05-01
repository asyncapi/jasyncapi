package com.asyncapi.examples.v2._0_0

import com.asyncapi.schemas.Reference
import com.asyncapi.v2._0_0.model.channel.ChannelItem
import com.asyncapi.v2._0_0.model.channel.Parameter
import com.asyncapi.v2._0_0.model.channel.message.Message
import com.asyncapi.v2._0_0.model.channel.operation.Operation
import com.asyncapi.v2._0_0.model.component.Components
import com.asyncapi.v2._0_0.model.info.Info
import com.asyncapi.v2._0_0.model.server.Server
import com.asyncapi.bindings.http.v0._3_0.message.HTTPMessageBinding
import com.asyncapi.bindings.http.v0._3_0.operation.HTTPOperationBinding
import com.asyncapi.schemas.AsyncAPISchema
import com.asyncapi.v2.security_scheme.http.HttpSecurityScheme

class GitterStreaming: AbstractExampleValidationTest() {

    override fun specificationLocation(): String = "/examples/v2.0.0/gitter-streaming.yml"

    override fun expectedId(): String = "tag:stream.gitter.im,2022:api"

    override fun expectedInfo(): Info {
        return Info.builder()
                .title("Gitter Streaming API")
                .version("1.0.0")
                .build()
    }

    override fun expectedServers(): Map<String, Any> {
        return mapOf(
                Pair("production", Server.builder()
                        .url("https://stream.gitter.im/v1")
                        .protocol("https")
                        .protocolVersion("1.1")
                        .security(listOf(
                                mapOf(Pair("httpBearerToken", emptyList<String>())),
                        ))
                        .build()
                )
        )
    }

    override fun expectedChannels(): Map<String, Any> {
        return mapOf(
                Pair("/rooms/{roomId}/{resource}", ChannelItem.builder()
                        .parameters(mapOf(
                                Pair("roomId", Parameter.builder()
                                        .description("Id of the Gitter room.")
                                        .schema(AsyncAPISchema.builder()
                                                .type("string")
                                                .examples(listOf("53307860c3599d1de448e19d"))
                                                .build()
                                        )
                                        .build()
                                ),
                                Pair("resource", Parameter.builder()
                                        .description("The resource to consume.")
                                        .schema(AsyncAPISchema.builder()
                                                .type("string")
                                                .enumValue(listOf("chatMessages", "events"))
                                                .build()
                                        )
                                        .build()
                                )
                        ))
                        .subscribe(Operation.builder()
                                .bindings(mapOf(
                                        Pair("http", HTTPOperationBinding.builder()
                                                .build()
                                        )
                                ))
                                // TODO: add OneOfMessages for 2.0.0
                                .message(Reference("#/components/messages/chatMessage"))
                                .build()
                        )
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
                                .schemaFormat("application/schema+yaml;version=draft-07")
                                .summary("A message represents an individual chat message sent to a room. They are a sub-resource of a room.")
                                .payload(AsyncAPISchema.builder()
                                        .type("object")
                                        .properties(mapOf(
                                                Pair("id", AsyncAPISchema.builder()
                                                        .type("string")
                                                        .description("ID of the message.")
                                                        .build()
                                                ),
                                                Pair("text", AsyncAPISchema.builder()
                                                        .type("string")
                                                        .description("Original message in plain-text/markdown.")
                                                        .build()
                                                ),
                                                Pair("html", AsyncAPISchema.builder()
                                                        .type("string")
                                                        .description("HTML formatted message.")
                                                        .build()
                                                ),
                                                Pair("sent", AsyncAPISchema.builder()
                                                        .type("string")
                                                        .format("date-time")
                                                        .description("ISO formatted date of the message.")
                                                        .build()
                                                ),
                                                Pair("fromUser", AsyncAPISchema.builder()
                                                        .type("object")
                                                        .description("User that sent the message.")
                                                        .properties(mapOf(
                                                                Pair("id", AsyncAPISchema.builder()
                                                                        .type("string")
                                                                        .description("Gitter User ID.")
                                                                        .build()
                                                                ),
                                                                Pair("username", AsyncAPISchema.builder()
                                                                        .type("string")
                                                                        .description("Gitter/GitHub username.")
                                                                        .build()
                                                                ),
                                                                Pair("displayName", AsyncAPISchema.builder()
                                                                        .type("string")
                                                                        .description("Gitter/GitHub user real name.")
                                                                        .build()
                                                                ),
                                                                Pair("url", AsyncAPISchema.builder()
                                                                        .type("string")
                                                                        .description("Path to the user on Gitter.")
                                                                        .build()
                                                                ),
                                                                Pair("avatarUrl", AsyncAPISchema.builder()
                                                                        .type("string")
                                                                        .format("uri")
                                                                        .description("User avatar URI.")
                                                                        .build()
                                                                ),
                                                                Pair("avatarUrlSmall", AsyncAPISchema.builder()
                                                                        .type("string")
                                                                        .format("uri")
                                                                        .description("User avatar URI (small).")
                                                                        .build()
                                                                ),
                                                                Pair("avatarUrlMedium", AsyncAPISchema.builder()
                                                                        .type("string")
                                                                        .format("uri")
                                                                        .description("User avatar URI (medium).")
                                                                        .build()
                                                                ),
                                                                Pair("v", AsyncAPISchema.builder()
                                                                        .type("number")
                                                                        .description("Version.")
                                                                        .build()
                                                                ),
                                                                Pair("gv", AsyncAPISchema.builder()
                                                                        .type("string")
                                                                        .description("Stands for \"Gravatar version\" and is used for cache busting.")
                                                                        .build()
                                                                )
                                                        ))
                                                        .build()
                                                ),
                                                Pair("unread", AsyncAPISchema.builder()
                                                        .type("boolean")
                                                        .description("Boolean that indicates if the current user has read the message.")
                                                        .build()
                                                ),
                                                Pair("readBy", AsyncAPISchema.builder()
                                                        .type("number")
                                                        .description("Number of users that have read the message.")
                                                        .build()
                                                ),
                                                Pair("urls", AsyncAPISchema.builder()
                                                        .type("array")
                                                        .description("List of URLs present in the message.")
                                                        .items(AsyncAPISchema.builder()
                                                                .type("string")
                                                                .format("uri")
                                                                .build())
                                                        .build()
                                                ),
                                                Pair("mentions", AsyncAPISchema.builder()
                                                        .type("array")
                                                        .description("List of @Mentions in the message.")
                                                        .items(AsyncAPISchema.builder()
                                                                .type("object")
                                                                .properties(mapOf(
                                                                        Pair("screenName", AsyncAPISchema.builder()
                                                                                .type("string")
                                                                                .build()
                                                                        ),
                                                                        Pair("userId", AsyncAPISchema.builder()
                                                                                .type("string")
                                                                                .build()
                                                                        ),
                                                                        Pair("userIds", AsyncAPISchema.builder()
                                                                                .type("array")
                                                                                .items(AsyncAPISchema.builder()
                                                                                        .type("string")
                                                                                        .build())
                                                                                .build()
                                                                        )
                                                                ))
                                                                .build())
                                                        .build()
                                                ),
                                                Pair("issues", AsyncAPISchema.builder()
                                                        .type("array")
                                                        .description("List of #Issues referenced in the message.")
                                                        .items(AsyncAPISchema.builder()
                                                                .type("object")
                                                                .properties(mapOf(
                                                                        Pair("number", AsyncAPISchema.builder().type("string").build())
                                                                ))
                                                                .build())
                                                        .build()
                                                ),
                                                Pair("meta", AsyncAPISchema.builder()
                                                        .type("array")
                                                        .description("Metadata. This is currently not used for anything.")
                                                        .items(AsyncAPISchema.builder().build())
                                                        .build()
                                                ),
                                                Pair("v", AsyncAPISchema.builder()
                                                        .type("number")
                                                        .description("Version.")
                                                        .build()
                                                ),
                                                Pair("gv", AsyncAPISchema.builder()
                                                        .type("string")
                                                        .description("Stands for \"Gravatar version\" and is used for cache busting.")
                                                        .build()
                                                ),
                                        ))
                                        .build()
                                )
                                .bindings(mapOf(
                                        Pair("http", HTTPMessageBinding.builder()
                                                .headers(
                                                    AsyncAPISchema.builder()
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
                                                        .build()
                                                )
                                                .build())
                                ))
                                .build()
                        ),
                        Pair("heartbeat", Message.builder()
                                .schemaFormat("application/schema+yaml;version=draft-07")
                                .summary("Its purpose is to keep the connection alive.")
                                .payload(AsyncAPISchema.builder()
                                        .type("string")
                                        .enumValue(listOf("\r\n"))
                                        .build()
                                )
                                .bindings(mapOf(
                                        Pair("http", HTTPMessageBinding.builder()
                                                .headers(
                                                    AsyncAPISchema.builder()
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
                                                        .build()
                                                )
                                                .build())
                                ))
                                .build()
                        ),
                ))
                .build()
    }

}