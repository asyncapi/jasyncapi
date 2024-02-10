package com.asyncapi.examples.v3._0_0

import com.asyncapi.v3.binding.message.http.HTTPMessageBinding
import com.asyncapi.v3.Reference
import com.asyncapi.v3._0_0.model.channel.Channel
import com.asyncapi.v3._0_0.model.channel.Parameter
import com.asyncapi.v3._0_0.model.channel.message.Message
import com.asyncapi.v3._0_0.model.component.Components
import com.asyncapi.v3._0_0.model.info.Info
import com.asyncapi.v3._0_0.model.operation.Operation
import com.asyncapi.v3._0_0.model.operation.OperationAction
import com.asyncapi.v3._0_0.model.server.Server
import com.asyncapi.v3.binding.operation.http.HTTPOperationBinding
import com.asyncapi.v3.binding.operation.http.HTTPOperationMethod
import com.asyncapi.v3.schema.MultiFormatSchema
import com.asyncapi.v3.schema.Schema
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
                                        Pair("chatMessage", Reference("#/components/messages/chatMessage")),
                                        Pair("heartbeat", Reference("#/components/messages/heartbeat"))
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
                                .payload(MultiFormatSchema(
                                        "application/schema+yaml;version=draft-07",
                                        mapOf(
                                                Pair("type", "object"),
                                                Pair("properties", mapOf(
                                                        Pair("id", mapOf(
                                                                Pair("type", "string"),
                                                                Pair("description", "ID of the message."),
                                                        )),
                                                        Pair("text", mapOf(
                                                                Pair("type", "string"),
                                                                Pair("description", "Original message in plain-text/markdown."),
                                                        )),
                                                        Pair("html", mapOf(
                                                                Pair("type", "string"),
                                                                Pair("description", "HTML formatted message."),
                                                        )),
                                                        Pair("sent", mapOf(
                                                                Pair("type", "string"),
                                                                Pair("format", "date-time"),
                                                                Pair("description", "ISO formatted date of the message."),
                                                        )),
                                                        Pair("fromUser", mapOf(
                                                                Pair("type", "object"),
                                                                Pair("description", "User that sent the message."),
                                                                Pair("properties", mapOf(
                                                                        Pair("id", mapOf(
                                                                                Pair("type", "string"),
                                                                                Pair("description", "Gitter User ID."),
                                                                        )),
                                                                        Pair("username", mapOf(
                                                                                Pair("type", "string"),
                                                                                Pair("description", "Gitter/GitHub username."),
                                                                        )),
                                                                        Pair("displayName", mapOf(
                                                                                Pair("type", "string"),
                                                                                Pair("description", "Gitter/GitHub user real name."),
                                                                        )),
                                                                        Pair("url", mapOf(
                                                                                Pair("type", "string"),
                                                                                Pair("description", "Path to the user on Gitter."),
                                                                        )),
                                                                        Pair("avatarUrl", mapOf(
                                                                                Pair("type", "string"),
                                                                                Pair("format", "uri"),
                                                                                Pair("description", "User avatar URI."),
                                                                        )),
                                                                        Pair("avatarUrlSmall", mapOf(
                                                                                Pair("type", "string"),
                                                                                Pair("format", "uri"),
                                                                                Pair("description", "User avatar URI (small)."),
                                                                        )),
                                                                        Pair("avatarUrlMedium", mapOf(
                                                                                Pair("type", "string"),
                                                                                Pair("format", "uri"),
                                                                                Pair("description", "User avatar URI (medium)."),
                                                                        )),
                                                                        Pair("v", mapOf(
                                                                                Pair("type", "number"),
                                                                                Pair("description", "Version."),
                                                                        )),
                                                                        Pair("gv", mapOf(
                                                                                Pair("type", "string"),
                                                                                Pair("description", "Stands for \"Gravatar version\" and is used for cache busting."),
                                                                        ))
                                                                )),
                                                        )),
                                                        Pair("unread", mapOf(
                                                                Pair("type", "boolean"),
                                                                Pair("description", "Boolean that indicates if the current user has read the message."),
                                                        )),
                                                        Pair("readBy", mapOf(
                                                                Pair("type", "number"),
                                                                Pair("description", "Number of users that have read the message."),
                                                        )),
                                                        Pair("urls", mapOf(
                                                                Pair("type", "array"),
                                                                Pair("description", "List of URLs present in the message."),
                                                                Pair("items", mapOf(
                                                                        Pair("type", "string"),
                                                                        Pair("format", "uri")
                                                                )),
                                                        )),
                                                        Pair("mentions", mapOf(
                                                                Pair("type", "array"),
                                                                Pair("description", "List of @Mentions in the message."),
                                                                Pair("items", mapOf(
                                                                        Pair("type", "object"),
                                                                        Pair("properties", mapOf(
                                                                                Pair("screenName", mapOf(Pair("type", "string"))),
                                                                                Pair("userId", mapOf(Pair("type", "string"))),
                                                                                Pair("userIds", mapOf(
                                                                                        Pair("type", "array"),
                                                                                        Pair("items", mapOf(Pair("type", "string"))),
                                                                                )),
                                                                        ))
                                                                )),
                                                        )),
                                                        Pair("issues", mapOf(
                                                                Pair("type", "array"),
                                                                Pair("description", "List of #Issues referenced in the message."),
                                                                Pair("items", mapOf(
                                                                        Pair("type", "object"),
                                                                        Pair("properties", mapOf(
                                                                                Pair("number", mapOf(Pair("type", "string")))
                                                                        ))
                                                                )),
                                                        )),
                                                        Pair("meta", mapOf(
                                                                Pair("type", "array"),
                                                                Pair("description", "Metadata. This is currently not used for anything."),
                                                                Pair("items", emptyMap<String, Any>()),
                                                        )),
                                                        Pair("v", mapOf(
                                                                Pair("type", "number"),
                                                                Pair("description", "Version.")
                                                        )),
                                                        Pair("gv", mapOf(
                                                                Pair("type", "string"),
                                                                Pair("description", "Stands for \"Gravatar version\" and is used for cache busting.")
                                                        ))
                                                )),
                                        )
                                ))
                                .bindings(mapOf(
                                        Pair("http", HTTPMessageBinding.builder()
                                                .headers(Schema.builder()
                                                        .type("object")
                                                        .properties(mapOf(
                                                                Pair("Transfer-Encoding", Schema.builder()
                                                                        .type("string")
                                                                        .constValue("chunked")
                                                                        .build()
                                                                ),
                                                                Pair("Trailer", Schema.builder()
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
                                .payload(MultiFormatSchema(
                                        "application/schema+yaml;version=draft-07",
                                        mapOf(
                                                Pair("type", "string"),
                                                Pair("enum", listOf("\r\n")),
                                        )
                                ))
                                .bindings(mapOf(
                                        Pair("http", HTTPMessageBinding.builder()
                                                .headers(Schema.builder()
                                                        .type("object")
                                                        .properties(mapOf(
                                                                Pair("Transfer-Encoding", Schema.builder()
                                                                        .type("string")
                                                                        .constValue("chunked")
                                                                        .build()
                                                                ),
                                                                Pair("Trailer", Schema.builder()
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