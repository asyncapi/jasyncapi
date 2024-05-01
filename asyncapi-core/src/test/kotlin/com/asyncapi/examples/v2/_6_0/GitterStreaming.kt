package com.asyncapi.examples.v2._6_0

import com.asyncapi.schemas.Reference
import com.asyncapi.v2._6_0.model.channel.ChannelItem
import com.asyncapi.v2._6_0.model.channel.Parameter
import com.asyncapi.v2._6_0.model.channel.message.Message
import com.asyncapi.v2._6_0.model.channel.message.OneOfMessages
import com.asyncapi.v2._6_0.model.channel.operation.Operation
import com.asyncapi.v2._6_0.model.component.Components
import com.asyncapi.v2._6_0.model.info.Info
import com.asyncapi.v2._6_0.model.server.Server
import com.asyncapi.bindings.http.v0._3_0.message.HTTPMessageBinding
import com.asyncapi.bindings.http.v0._3_0.operation.HTTPOperationBinding
import com.asyncapi.v2.schema.Schema
import com.asyncapi.v2.security_scheme.http.HttpSecurityScheme
import com.asyncapi.v3.schema.AsyncAPISchema

class GitterStreaming: AbstractExampleValidationTest() {

    override fun specificationLocation(): String = "/examples/v2.6.0/gitter-streaming.yml"

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
                                        .schema(Schema.builder()
                                                .type("string")
                                                .examples(listOf("53307860c3599d1de448e19d"))
                                                .build()
                                        )
                                        .build()
                                ),
                                Pair("resource", Parameter.builder()
                                        .description("The resource to consume.")
                                        .schema(Schema.builder()
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
                                .message(OneOfMessages(listOf(
                                    Reference("#/components/messages/chatMessage"),
                                    Reference("#/components/messages/heartbeat")
                                )))
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
                                .payload(Schema.builder()
                                        .type("object")
                                        .properties(mapOf(
                                                Pair("id", Schema.builder()
                                                        .type("string")
                                                        .description("ID of the message.")
                                                        .build()
                                                ),
                                                Pair("text", Schema.builder()
                                                        .type("string")
                                                        .description("Original message in plain-text/markdown.")
                                                        .build()
                                                ),
                                                Pair("html", Schema.builder()
                                                        .type("string")
                                                        .description("HTML formatted message.")
                                                        .build()
                                                ),
                                                Pair("sent", Schema.builder()
                                                        .type("string")
                                                        .format("date-time")
                                                        .description("ISO formatted date of the message.")
                                                        .build()
                                                ),
                                                Pair("fromUser", Schema.builder()
                                                        .type("object")
                                                        .description("User that sent the message.")
                                                        .properties(mapOf(
                                                                Pair("id", Schema.builder()
                                                                        .type("string")
                                                                        .description("Gitter User ID.")
                                                                        .build()
                                                                ),
                                                                Pair("username", Schema.builder()
                                                                        .type("string")
                                                                        .description("Gitter/GitHub username.")
                                                                        .build()
                                                                ),
                                                                Pair("displayName", Schema.builder()
                                                                        .type("string")
                                                                        .description("Gitter/GitHub user real name.")
                                                                        .build()
                                                                ),
                                                                Pair("url", Schema.builder()
                                                                        .type("string")
                                                                        .description("Path to the user on Gitter.")
                                                                        .build()
                                                                ),
                                                                Pair("avatarUrl", Schema.builder()
                                                                        .type("string")
                                                                        .format("uri")
                                                                        .description("User avatar URI.")
                                                                        .build()
                                                                ),
                                                                Pair("avatarUrlSmall", Schema.builder()
                                                                        .type("string")
                                                                        .format("uri")
                                                                        .description("User avatar URI (small).")
                                                                        .build()
                                                                ),
                                                                Pair("avatarUrlMedium", Schema.builder()
                                                                        .type("string")
                                                                        .format("uri")
                                                                        .description("User avatar URI (medium).")
                                                                        .build()
                                                                ),
                                                                Pair("v", Schema.builder()
                                                                        .type("number")
                                                                        .description("Version.")
                                                                        .build()
                                                                ),
                                                                Pair("gv", Schema.builder()
                                                                        .type("string")
                                                                        .description("Stands for \"Gravatar version\" and is used for cache busting.")
                                                                        .build()
                                                                )
                                                        ))
                                                        .build()
                                                ),
                                                Pair("unread", Schema.builder()
                                                        .type("boolean")
                                                        .description("Boolean that indicates if the current user has read the message.")
                                                        .build()
                                                ),
                                                Pair("readBy", Schema.builder()
                                                        .type("number")
                                                        .description("Number of users that have read the message.")
                                                        .build()
                                                ),
                                                Pair("urls", Schema.builder()
                                                        .type("array")
                                                        .description("List of URLs present in the message.")
                                                        .items(Schema.builder()
                                                                .type("string")
                                                                .format("uri")
                                                                .build())
                                                        .build()
                                                ),
                                                Pair("mentions", Schema.builder()
                                                        .type("array")
                                                        .description("List of @Mentions in the message.")
                                                        .items(Schema.builder()
                                                                .type("object")
                                                                .properties(mapOf(
                                                                        Pair("screenName", Schema.builder()
                                                                                .type("string")
                                                                                .build()
                                                                        ),
                                                                        Pair("userId", Schema.builder()
                                                                                .type("string")
                                                                                .build()
                                                                        ),
                                                                        Pair("userIds", Schema.builder()
                                                                                .type("array")
                                                                                .items(Schema.builder()
                                                                                        .type("string")
                                                                                        .build())
                                                                                .build()
                                                                        )
                                                                ))
                                                                .build())
                                                        .build()
                                                ),
                                                Pair("issues", Schema.builder()
                                                        .type("array")
                                                        .description("List of #Issues referenced in the message.")
                                                        .items(Schema.builder()
                                                                .type("object")
                                                                .properties(mapOf(
                                                                        Pair("number", Schema.builder().type("string").build())
                                                                ))
                                                                .build())
                                                        .build()
                                                ),
                                                Pair("meta", Schema.builder()
                                                        .type("array")
                                                        .description("Metadata. This is currently not used for anything.")
                                                        .items(Schema.builder().build())
                                                        .build()
                                                ),
                                                Pair("v", Schema.builder()
                                                        .type("number")
                                                        .description("Version.")
                                                        .build()
                                                ),
                                                Pair("gv", Schema.builder()
                                                        .type("string")
                                                        .description("Stands for \"Gravatar version\" and is used for cache busting.")
                                                        .build()
                                                ),
                                        ))
                                        .build()
                                )
                                .bindings(mapOf(
                                        Pair("http",
                                            Reference("#/components/messageBindings/streamingHeaders")
                                        )
                                ))
                                .build()
                        ),
                        Pair("heartbeat", Message.builder()
                                .schemaFormat("application/schema+yaml;version=draft-07")
                                .summary("Its purpose is to keep the connection alive.")
                                .payload(Schema.builder()
                                        .type("string")
                                        .enumValue(listOf("\r\n"))
                                        .build()
                                )
                                .bindings(mapOf(
                                        Pair("http",
                                            Reference("#/components/messageBindings/streamingHeaders")
                                        )
                                ))
                                .build()
                        ),
                ))
                .messageBindings(mapOf(
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
                                        .build()
                                )
                                .build()
                        )
                ))
                .build()
    }

}