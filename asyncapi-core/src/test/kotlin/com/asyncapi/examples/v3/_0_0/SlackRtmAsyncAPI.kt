package com.asyncapi.examples.v3._0_0

import com.asyncapi.v3.Reference
import com.asyncapi.v3._0_0.model.channel.Channel
import com.asyncapi.v3._0_0.model.channel.message.Message
import com.asyncapi.v3._0_0.model.component.Components
import com.asyncapi.v3._0_0.model.info.Info
import com.asyncapi.v3._0_0.model.operation.Operation
import com.asyncapi.v3._0_0.model.operation.OperationAction
import com.asyncapi.v3._0_0.model.server.Server
import com.asyncapi.v3.schema.Schema
import com.asyncapi.v3.security_scheme.http.HttpApiKeySecurityScheme

class SlackRtmAsyncAPI: AbstractExampleValidationTest() {

    override fun specificationLocation(): String = "/examples/v3.0.0/slack-rtm-asyncapi.yml"

    override fun expectedId(): String = "wss://wss-primary.slack.com/websocket"

    override fun expectedInfo(): Info {
        return Info.builder()
                .title("Slack Real Time Messaging API")
                .version("1.0.0")
                .build()
    }

    override fun expectedServers(): Map<String, Any> {
        return mapOf(
                Pair("production",
                        Server.builder()
                                .host("slack.com")
                                .pathname("/api/rtm.connect")
                                .protocol("https")
                                .protocolVersion("1.1")
                                .security(listOf(
                                        Reference("#/components/securitySchemes/token")
                                ))
                                .build()
                )
        )
    }

    override fun expectedChannels(): Map<String, Any> {
        return mapOf(
                Pair("root",
                        Channel.builder()
                                .address("/")
                                .messages(mapOf(
                                        Pair("outgoingMessage", Reference("#/components/messages/outgoingMessage")),
                                        Pair("hello", Reference("#/components/messages/hello")),
                                        Pair("connectionError", Reference("#/components/messages/connectionError")),
                                        Pair("accountsChanged", Reference("#/components/messages/accountsChanged")),
                                        Pair("botAdded", Reference("#/components/messages/botAdded")),
                                        Pair("botChanged", Reference("#/components/messages/botChanged")),
                                        Pair("channelArchive", Reference("#/components/messages/channelArchive")),
                                        Pair("channelCreated", Reference("#/components/messages/channelCreated")),
                                        Pair("channelDeleted", Reference("#/components/messages/channelDeleted")),
                                        Pair("channelHistoryChanged", Reference("#/components/messages/channelHistoryChanged")),
                                        Pair("channelJoined", Reference("#/components/messages/channelJoined")),
                                        Pair("channelLeft", Reference("#/components/messages/channelLeft")),
                                        Pair("channelMarked", Reference("#/components/messages/channelMarked")),
                                        Pair("channelRename", Reference("#/components/messages/channelRename")),
                                        Pair("channelUnarchive", Reference("#/components/messages/channelUnarchive")),
                                        Pair("commandsChanged", Reference("#/components/messages/commandsChanged")),
                                        Pair("dndUpdated", Reference("#/components/messages/dndUpdated")),
                                        Pair("dndUpdatedUser", Reference("#/components/messages/dndUpdatedUser")),
                                        Pair("emailDomainChanged", Reference("#/components/messages/emailDomainChanged")),
                                        Pair("emojiRemoved", Reference("#/components/messages/emojiRemoved")),
                                        Pair("emojiAdded", Reference("#/components/messages/emojiAdded")),
                                        Pair("fileChange", Reference("#/components/messages/fileChange")),
                                        Pair("fileCommentAdded", Reference("#/components/messages/fileCommentAdded")),
                                        Pair("fileCommentDeleted", Reference("#/components/messages/fileCommentDeleted")),
                                        Pair("fileCommentEdited", Reference("#/components/messages/fileCommentEdited")),
                                        Pair("fileCreated", Reference("#/components/messages/fileCreated")),
                                        Pair("fileDeleted", Reference("#/components/messages/fileDeleted")),
                                        Pair("filePublic", Reference("#/components/messages/filePublic")),
                                        Pair("fileShared", Reference("#/components/messages/fileShared")),
                                        Pair("fileUnshared", Reference("#/components/messages/fileUnshared")),
                                        Pair("goodbye", Reference("#/components/messages/goodbye")),
                                        Pair("groupArchive", Reference("#/components/messages/groupArchive")),
                                        Pair("groupClose", Reference("#/components/messages/groupClose")),
                                        Pair("groupHistoryChanged", Reference("#/components/messages/groupHistoryChanged")),
                                        Pair("groupJoined", Reference("#/components/messages/groupJoined")),
                                        Pair("groupLeft", Reference("#/components/messages/groupLeft")),
                                        Pair("groupMarked", Reference("#/components/messages/groupMarked")),
                                        Pair("groupOpen", Reference("#/components/messages/groupOpen")),
                                        Pair("groupRename", Reference("#/components/messages/groupRename")),
                                        Pair("groupUnarchive", Reference("#/components/messages/groupUnarchive")),
                                        Pair("imClose", Reference("#/components/messages/imClose")),
                                        Pair("imCreated", Reference("#/components/messages/imCreated")),
                                        Pair("imMarked", Reference("#/components/messages/imMarked")),
                                        Pair("imOpen", Reference("#/components/messages/imOpen")),
                                        Pair("manualPresenceChange", Reference("#/components/messages/manualPresenceChange")),
                                        Pair("memberJoinedChannel", Reference("#/components/messages/memberJoinedChannel")),
                                        Pair("message", Reference("#/components/messages/message")),
                                ))
                                .build()
                )
        )
    }

    override fun expectedOperations(): Map<String, Any> {
        return mapOf(
                Pair("receiveOutgoingMessage",
                        Operation.builder()
                                .action(OperationAction.RECEIVE)
                                .channel(Reference("#/channels/root"))
                                .messages(listOf(
                                        Reference("#/channels/root/messages/outgoingMessage")
                                ))
                                .build()
                ),
                Pair("sendMessages",
                        Operation.builder()
                                .action(OperationAction.SEND)
                                .channel(Reference("#/channels/root"))
                                .messages(listOf(
                                        Reference("#/channels/root/messages/hello"),
                                        Reference("#/channels/root/messages/connectionError"),
                                        Reference("#/channels/root/messages/accountsChanged"),
                                        Reference("#/channels/root/messages/botAdded"),
                                        Reference("#/channels/root/messages/botChanged"),
                                        Reference("#/channels/root/messages/channelArchive"),
                                        Reference("#/channels/root/messages/channelCreated"),
                                        Reference("#/channels/root/messages/channelDeleted"),
                                        Reference("#/channels/root/messages/channelHistoryChanged"),
                                        Reference("#/channels/root/messages/channelJoined"),
                                        Reference("#/channels/root/messages/channelLeft"),
                                        Reference("#/channels/root/messages/channelMarked"),
                                        Reference("#/channels/root/messages/channelRename"),
                                        Reference("#/channels/root/messages/channelUnarchive"),
                                        Reference("#/channels/root/messages/commandsChanged"),
                                        Reference("#/channels/root/messages/dndUpdated"),
                                        Reference("#/channels/root/messages/dndUpdatedUser"),
                                        Reference("#/channels/root/messages/emailDomainChanged"),
                                        Reference("#/channels/root/messages/emojiRemoved"),
                                        Reference("#/channels/root/messages/emojiAdded"),
                                        Reference("#/channels/root/messages/fileChange"),
                                        Reference("#/channels/root/messages/fileCommentAdded"),
                                        Reference("#/channels/root/messages/fileCommentDeleted"),
                                        Reference("#/channels/root/messages/fileCommentEdited"),
                                        Reference("#/channels/root/messages/fileCreated"),
                                        Reference("#/channels/root/messages/fileDeleted"),
                                        Reference("#/channels/root/messages/filePublic"),
                                        Reference("#/channels/root/messages/fileShared"),
                                        Reference("#/channels/root/messages/fileUnshared"),
                                        Reference("#/channels/root/messages/goodbye"),
                                        Reference("#/channels/root/messages/groupArchive"),
                                        Reference("#/channels/root/messages/groupClose"),
                                        Reference("#/channels/root/messages/groupHistoryChanged"),
                                        Reference("#/channels/root/messages/groupJoined"),
                                        Reference("#/channels/root/messages/groupLeft"),
                                        Reference("#/channels/root/messages/groupMarked"),
                                        Reference("#/channels/root/messages/groupOpen"),
                                        Reference("#/channels/root/messages/groupRename"),
                                        Reference("#/channels/root/messages/groupUnarchive"),
                                        Reference("#/channels/root/messages/imClose"),
                                        Reference("#/channels/root/messages/imCreated"),
                                        Reference("#/channels/root/messages/imMarked"),
                                        Reference("#/channels/root/messages/imOpen"),
                                        Reference("#/channels/root/messages/manualPresenceChange"),
                                        Reference("#/channels/root/messages/memberJoinedChannel"),
                                        Reference("#/channels/root/messages/message"),
                                ))
                                .build()
                )
        )
    }

    override fun expectedComponents(): Components? {
        return Components.builder()
                .securitySchemes(mapOf(
                        Pair("token", HttpApiKeySecurityScheme(
                                null,
                                "token",
                                HttpApiKeySecurityScheme.ApiKeyLocation.QUERY
                        ))
                ))
                .schemas(mapOf(
                        Pair("attachment",
                                Schema.builder()
                                        .type("object")
                                        .properties(mapOf(
                                                Pair("fallback", Schema.builder()
                                                        .type("string")
                                                        .build()
                                                ),
                                                Pair("color", Schema.builder()
                                                        .type("string")
                                                        .build()
                                                ),
                                                Pair("pretext", Schema.builder()
                                                        .type("string")
                                                        .build()
                                                ),
                                                Pair("author_name", Schema.builder()
                                                        .type("string")
                                                        .build()
                                                ),
                                                Pair("author_link", Schema.builder()
                                                        .type("string")
                                                        .format("uri")
                                                        .build()
                                                ),
                                                Pair("author_icon", Schema.builder()
                                                        .type("string")
                                                        .format("uri")
                                                        .build()
                                                ),
                                                Pair("title", Schema.builder()
                                                        .type("string")
                                                        .build()
                                                ),
                                                Pair("title_link", Schema.builder()
                                                        .type("string")
                                                        .format("uri")
                                                        .build()
                                                ),
                                                Pair("text", Schema.builder()
                                                        .type("string")
                                                        .build()
                                                ),
                                                Pair("fields", Schema.builder()
                                                        .type("array")
                                                        .items(Schema.builder()
                                                                .type("object")
                                                                .properties(mapOf(
                                                                        Pair("title", Schema.builder()
                                                                                .type("string")
                                                                                .build()
                                                                        ),
                                                                        Pair("value", Schema.builder()
                                                                                .type("string")
                                                                                .build()
                                                                        ),
                                                                        Pair("short", Schema.builder()
                                                                                .type("boolean")
                                                                                .build()
                                                                        ),
                                                                ))
                                                                .build()
                                                        )
                                                        .build()
                                                ),
                                                Pair("image_url", Schema.builder()
                                                        .type("string")
                                                        .format("uri")
                                                        .build()
                                                ),
                                                Pair("thumb_url", Schema.builder()
                                                        .type("string")
                                                        .format("uri")
                                                        .build()
                                                ),
                                                Pair("footer", Schema.builder()
                                                        .type("string")
                                                        .build()
                                                ),
                                                Pair("footer_icon", Schema.builder()
                                                        .type("string")
                                                        .format("uri")
                                                        .build()
                                                ),
                                                Pair("ts", Schema.builder()
                                                        .type("number")
                                                        .build()
                                                ),
                                        ))
                                        .build()
                        )
                ))
                .messages(mapOf(
                        Pair("hello",
                                Message.builder()
                                        .summary("First event received upon connection.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("hello"))
                                                                .build()
                                                        )
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("connectionError",
                                Message.builder()
                                        .summary("Event received when a connection error happens.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("error"))
                                                                .build()
                                                        ),
                                                        Pair("error", Schema.builder()
                                                                .type("object")
                                                                .properties(mapOf(
                                                                        Pair("code", Schema.builder().type("number").build()),
                                                                        Pair("msg", Schema.builder().type("string").build()),
                                                                ))
                                                                .build()
                                                        )
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("accountsChanged",
                                Message.builder()
                                        .summary("The list of accounts a user is signed into has changed.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("accounts_changed"))
                                                                .build()
                                                        )
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("botAdded",
                                Message.builder()
                                        .summary("A bot user was added.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("bot_added"))
                                                                .build()
                                                        ),
                                                        Pair("bot", Schema.builder()
                                                                .type("object")
                                                                .properties(mapOf(
                                                                        Pair("id", Schema.builder()
                                                                                .type("string")
                                                                                .build()
                                                                        ),
                                                                        Pair("app_id", Schema.builder()
                                                                                .type("string")
                                                                                .build()
                                                                        ),
                                                                        Pair("name", Schema.builder()
                                                                                .type("string")
                                                                                .build()
                                                                        ),
                                                                        Pair("icons", Schema.builder()
                                                                                .type("object")
                                                                                .additionalProperties(Schema.builder().type("string").build())
                                                                                .build()
                                                                        )
                                                                ))
                                                                .build()
                                                        )
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("botChanged",
                                Message.builder()
                                        .summary("A bot user was changed.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("bot_added"))
                                                                .build()
                                                        ),
                                                        Pair("bot", Schema.builder()
                                                                .type("object")
                                                                .properties(mapOf(
                                                                        Pair("id", Schema.builder()
                                                                                .type("string")
                                                                                .build()
                                                                        ),
                                                                        Pair("app_id", Schema.builder()
                                                                                .type("string")
                                                                                .build()
                                                                        ),
                                                                        Pair("name", Schema.builder()
                                                                                .type("string")
                                                                                .build()
                                                                        ),
                                                                        Pair("icons", Schema.builder()
                                                                                .type("object")
                                                                                .additionalProperties(Schema.builder().type("string").build())
                                                                                .build()
                                                                        )
                                                                ))
                                                                .build()
                                                        )
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("channelArchive",
                                Message.builder()
                                        .summary("A channel was archived.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("channel_archive"))
                                                                .build()
                                                        ),
                                                        Pair("channel", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                        Pair("user", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("channelCreated",
                                Message.builder()
                                        .summary("A channel was created.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("channel_created"))
                                                                .build()
                                                        ),
                                                        Pair("channel", Schema.builder()
                                                                .type("object")
                                                                .properties(mapOf(
                                                                        Pair("id", Schema.builder()
                                                                                .type("string")
                                                                                .build()
                                                                        ),
                                                                        Pair("name", Schema.builder()
                                                                                .type("string")
                                                                                .build()
                                                                        ),
                                                                        Pair("created", Schema.builder()
                                                                                .type("number")
                                                                                .build()
                                                                        ),
                                                                        Pair("creator", Schema.builder()
                                                                                .type("string")
                                                                                .build()
                                                                        )
                                                                ))
                                                                .build()
                                                        )
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("channelDeleted",
                                Message.builder()
                                        .summary("A channel was deleted.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("channel_deleted"))
                                                                .build()
                                                        ),
                                                        Pair("channel", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        )
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("channelHistoryChanged",
                                Message.builder()
                                        .summary("Bulk updates were made to a channel's history.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("channel_history_changed"))
                                                                .build()
                                                        ),
                                                        Pair("latest", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                        Pair("ts", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                        Pair("event_ts", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        )
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("channelJoined",
                                Message.builder()
                                        .summary("You joined a channel.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("channel_joined"))
                                                                .build()
                                                        ),
                                                        Pair("channel", Schema.builder()
                                                                .type("object")
                                                                .properties(mapOf(
                                                                        Pair("id", Schema.builder()
                                                                                .type("string")
                                                                                .build()
                                                                        ),
                                                                        Pair("name", Schema.builder()
                                                                                .type("string")
                                                                                .build()
                                                                        ),
                                                                        Pair("created", Schema.builder()
                                                                                .type("number")
                                                                                .build()
                                                                        ),
                                                                        Pair("creator", Schema.builder()
                                                                                .type("string")
                                                                                .build()
                                                                        )
                                                                ))
                                                                .build()
                                                        )
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("channelLeft",
                                Message.builder()
                                        .summary("You left a channel.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("channel_left"))
                                                                .build()
                                                        ),
                                                        Pair("channel", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        )
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("channelMarked",
                                Message.builder()
                                        .summary("Your channel read marker was updated.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("channel_marked"))
                                                                .build()
                                                        ),
                                                        Pair("channel", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                        Pair("ts", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        )
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("channelRename",
                                Message.builder()
                                        .summary("A channel was renamed.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("channel_rename"))
                                                                .build()
                                                        ),
                                                        Pair("channel", Schema.builder()
                                                                .type("object")
                                                                .properties(mapOf(
                                                                        Pair("id", Schema.builder()
                                                                                .type("string")
                                                                                .build()
                                                                        ),
                                                                        Pair("name", Schema.builder()
                                                                                .type("string")
                                                                                .build()
                                                                        ),
                                                                        Pair("created", Schema.builder()
                                                                                .type("number")
                                                                                .build()
                                                                        )
                                                                ))
                                                                .build()
                                                        ),
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("channelUnarchive",
                                Message.builder()
                                        .summary("A channel was unarchived.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("channel_unarchive"))
                                                                .build()
                                                        ),
                                                        Pair("channel", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                        Pair("user", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("commandsChanged",
                                Message.builder()
                                        .summary("A slash command has been added or changed.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("commands_changed"))
                                                                .build()
                                                        ),
                                                        Pair("event_ts", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        )
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("dndUpdated",
                                Message.builder()
                                        .summary("Do not Disturb settings changed for the current user.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("dnd_updated"))
                                                                .build()
                                                        ),
                                                        Pair("user", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                        Pair("dnd_status", Schema.builder()
                                                                .type("object")
                                                                .properties(mapOf(
                                                                        Pair("dnd_enabled", Schema.builder()
                                                                                .type("boolean")
                                                                                .build()
                                                                        ),
                                                                        Pair("next_dnd_start_ts", Schema.builder()
                                                                                .type("number")
                                                                                .build()
                                                                        ),
                                                                        Pair("next_dnd_end_ts", Schema.builder()
                                                                                .type("number")
                                                                                .build()
                                                                        ),
                                                                        Pair("snooze_enabled", Schema.builder()
                                                                                .type("boolean")
                                                                                .build()
                                                                        ),
                                                                        Pair("snooze_endtime", Schema.builder()
                                                                                .type("number")
                                                                                .build()
                                                                        )
                                                                ))
                                                                .build()
                                                        )
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("dndUpdatedUser",
                                Message.builder()
                                        .summary("Do not Disturb settings changed for a member.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("dnd_updated_user"))
                                                                .build()
                                                        ),
                                                        Pair("user", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                        Pair("dnd_status", Schema.builder()
                                                                .type("object")
                                                                .properties(mapOf(
                                                                        Pair("dnd_enabled", Schema.builder()
                                                                                .type("boolean")
                                                                                .build()
                                                                        ),
                                                                        Pair("next_dnd_start_ts", Schema.builder()
                                                                                .type("number")
                                                                                .build()
                                                                        ),
                                                                        Pair("next_dnd_end_ts", Schema.builder()
                                                                                .type("number")
                                                                                .build()
                                                                        )
                                                                ))
                                                                .build()
                                                        )
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("emailDomainChanged",
                                Message.builder()
                                        .summary("The workspace email domain has changed.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("email_domain_changed"))
                                                                .build()
                                                        ),
                                                        Pair("email_domain", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                        Pair("event_ts", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("emojiRemoved",
                                Message.builder()
                                        .summary("A custom emoji has been removed.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("emoji_changed"))
                                                                .build()
                                                        ),
                                                        Pair("subtype", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("remove"))
                                                                .build()
                                                        ),
                                                        Pair("names", Schema.builder()
                                                                .type("array")
                                                                .items(Schema.builder().type("string").build())
                                                                .build()
                                                        ),
                                                        Pair("event_ts", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("emojiAdded",
                                Message.builder()
                                        .summary("A custom emoji has been added.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("emoji_changed"))
                                                                .build()
                                                        ),
                                                        Pair("subtype", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("add"))
                                                                .build()
                                                        ),
                                                        Pair("name", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                        Pair("value", Schema.builder()
                                                                .type("string")
                                                                .format("uri")
                                                                .build()
                                                        ),
                                                        Pair("event_ts", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("fileChange",
                                Message.builder()
                                        .summary("A file was changed.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("file_change"))
                                                                .build()
                                                        ),
                                                        Pair("file_id", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                        Pair("file", Schema.builder()
                                                                .type("object")
                                                                .properties(mapOf(
                                                                        Pair("id", Schema.builder().type("string").build()),
                                                                ))
                                                                .build()
                                                        ),
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("fileCommentAdded",
                                Message.builder()
                                        .summary("A file comment was added.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("file_comment_added"))
                                                                .build()
                                                        ),
                                                        Pair("comment", Schema()),
                                                        Pair("file_id", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                        Pair("file", Schema.builder()
                                                                .type("object")
                                                                .properties(mapOf(
                                                                        Pair("id", Schema.builder().type("string").build()),
                                                                ))
                                                                .build()
                                                        ),
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("fileCommentDeleted",
                                Message.builder()
                                        .summary("A file comment was deleted.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("file_comment_deleted"))
                                                                .build()
                                                        ),
                                                        Pair("comment", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                        Pair("file_id", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                        Pair("file", Schema.builder()
                                                                .type("object")
                                                                .properties(mapOf(
                                                                        Pair("id", Schema.builder().type("string").build()),
                                                                ))
                                                                .build()
                                                        ),
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("fileCommentEdited",
                                Message.builder()
                                        .summary("A file comment was edited.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("file_comment_edited"))
                                                                .build()
                                                        ),
                                                        Pair("comment", Schema()),
                                                        Pair("file_id", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                        Pair("file", Schema.builder()
                                                                .type("object")
                                                                .properties(mapOf(
                                                                        Pair("id", Schema.builder().type("string").build()),
                                                                ))
                                                                .build()
                                                        ),
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("fileCreated",
                                Message.builder()
                                        .summary("A file was created.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("file_created"))
                                                                .build()
                                                        ),
                                                        Pair("file_id", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                        Pair("file", Schema.builder()
                                                                .type("object")
                                                                .properties(mapOf(
                                                                        Pair("id", Schema.builder().type("string").build()),
                                                                ))
                                                                .build()
                                                        ),
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("fileDeleted",
                                Message.builder()
                                        .summary("A file was deleted.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("file_deleted"))
                                                                .build()
                                                        ),
                                                        Pair("file_id", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                        Pair("event_ts", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("filePublic",
                                Message.builder()
                                        .summary("A file was made public.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("file_public"))
                                                                .build()
                                                        ),
                                                        Pair("file_id", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                        Pair("file", Schema.builder()
                                                                .type("object")
                                                                .properties(mapOf(
                                                                        Pair("id", Schema.builder().type("string").build()),
                                                                ))
                                                                .build()
                                                        ),
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("fileShared",
                                Message.builder()
                                        .summary("A file was shared.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("file_shared"))
                                                                .build()
                                                        ),
                                                        Pair("file_id", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                        Pair("file", Schema.builder()
                                                                .type("object")
                                                                .properties(mapOf(
                                                                        Pair("id", Schema.builder().type("string").build()),
                                                                ))
                                                                .build()
                                                        ),
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("fileUnshared",
                                Message.builder()
                                        .summary("A file was unshared.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("file_unshared"))
                                                                .build()
                                                        ),
                                                        Pair("file_id", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                        Pair("file", Schema.builder()
                                                                .type("object")
                                                                .properties(mapOf(
                                                                        Pair("id", Schema.builder().type("string").build()),
                                                                ))
                                                                .build()
                                                        ),
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("goodbye",
                                Message.builder()
                                        .summary("The server intends to close the connection soon.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("goodbye"))
                                                                .build()
                                                        ),
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("groupArchive",
                                Message.builder()
                                        .summary("A private channel was archived.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("group_archive"))
                                                                .build()
                                                        ),
                                                        Pair("channel", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("groupClose",
                                Message.builder()
                                        .summary("You closed a private channel.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("group_close"))
                                                                .build()
                                                        ),
                                                        Pair("user", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                        Pair("channel", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("groupHistoryChanged",
                                Message.builder()
                                        .summary("Bulk updates were made to a private channel's history.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("group_history_changed"))
                                                                .build()
                                                        ),
                                                        Pair("latest", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                        Pair("ts", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                        Pair("event_ts", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("groupJoined",
                                Message.builder()
                                        .summary("You joined a private channel.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("group_joined"))
                                                                .build()
                                                        ),
                                                        Pair("channel", Schema.builder()
                                                                .type("object")
                                                                .properties(mapOf(
                                                                        Pair("id", Schema.builder()
                                                                                .type("string")
                                                                                .build()
                                                                        ),
                                                                        Pair("name", Schema.builder()
                                                                                .type("string")
                                                                                .build()
                                                                        ),
                                                                        Pair("created", Schema.builder()
                                                                                .type("number")
                                                                                .build()
                                                                        ),
                                                                        Pair("creator", Schema.builder()
                                                                                .type("string")
                                                                                .build()
                                                                        ),
                                                                ))
                                                                .build()
                                                        ),
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("groupLeft",
                                Message.builder()
                                        .summary("You left a private channel.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("group_left"))
                                                                .build()
                                                        ),
                                                        Pair("channel", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("groupMarked",
                                Message.builder()
                                        .summary("A private channel read marker was updated.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("group_marked"))
                                                                .build()
                                                        ),
                                                        Pair("channel", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                        Pair("ts", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("groupOpen",
                                Message.builder()
                                        .summary("You opened a private channel.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("group_open"))
                                                                .build()
                                                        ),
                                                        Pair("channel", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                        Pair("user", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("groupRename",
                                Message.builder()
                                        .summary("A private channel was renamed.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("group_rename"))
                                                                .build()
                                                        ),
                                                        Pair("channel", Schema.builder()
                                                                .type("object")
                                                                .properties(mapOf(
                                                                        Pair("id", Schema.builder()
                                                                                .type("string")
                                                                                .build()
                                                                        ),
                                                                        Pair("name", Schema.builder()
                                                                                .type("string")
                                                                                .build()
                                                                        ),
                                                                        Pair("created", Schema.builder()
                                                                                .type("number")
                                                                                .build()
                                                                        ),
                                                                ))
                                                                .build()
                                                        ),
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("groupUnarchive",
                                Message.builder()
                                        .summary("A private channel was unarchived.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("group_unarchive"))
                                                                .build()
                                                        ),
                                                        Pair("channel", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                        Pair("user", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("imClose",
                                Message.builder()
                                        .summary("You closed a DM.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("im_close"))
                                                                .build()
                                                        ),
                                                        Pair("channel", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                        Pair("user", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("imCreated",
                                Message.builder()
                                        .summary("A DM was created.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("im_created"))
                                                                .build()
                                                        ),
                                                        Pair("channel", Schema.builder()
                                                                .type("object")
                                                                .properties(mapOf(
                                                                        Pair("id", Schema.builder()
                                                                                .type("string")
                                                                                .build()
                                                                        ),
                                                                        Pair("name", Schema.builder()
                                                                                .type("string")
                                                                                .build()
                                                                        ),
                                                                        Pair("created", Schema.builder()
                                                                                .type("number")
                                                                                .build()
                                                                        ),
                                                                        Pair("creator", Schema.builder()
                                                                                .type("string")
                                                                                .build()
                                                                        ),
                                                                ))
                                                                .build()
                                                        ),
                                                        Pair("user", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("imMarked",
                                Message.builder()
                                        .summary("A direct message read marker was updated.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("im_marked"))
                                                                .build()
                                                        ),
                                                        Pair("channel", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                        Pair("ts", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("imOpen",
                                Message.builder()
                                        .summary("You opened a DM.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("im_open"))
                                                                .build()
                                                        ),
                                                        Pair("channel", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                        Pair("user", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("manualPresenceChange",
                                Message.builder()
                                        .summary("You manually updated your presence.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("manual_presence_change"))
                                                                .build()
                                                        ),
                                                        Pair("presence", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("memberJoinedChannel",
                                Message.builder()
                                        .summary("A user joined a public or private channel.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("member_joined_channel"))
                                                                .build()
                                                        ),
                                                        Pair("user", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                        Pair("channel", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                        Pair("channel_type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("C", "G"))
                                                                .build()
                                                        ),
                                                        Pair("team", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                        Pair("inviter", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("memberLeftChannel",
                                Message.builder()
                                        .summary("A user left a public or private channel.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("member_left_channel"))
                                                                .build()
                                                        ),
                                                        Pair("user", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                        Pair("channel", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                        Pair("channel_type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("C", "G"))
                                                                .build()
                                                        ),
                                                        Pair("team", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("message",
                                Message.builder()
                                        .summary("A message was sent to a channel.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("message"))
                                                                .build()
                                                        ),
                                                        Pair("user", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                        Pair("channel", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                        Pair("text", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                        Pair("ts", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                        Pair("attachments", Schema.builder()
                                                                .type("array")
                                                                .items(Schema.builder().ref("#/components/schemas/attachment").build())
                                                                .build()
                                                        ),
                                                        Pair("edited", Schema.builder()
                                                                .type("object")
                                                                .properties(mapOf(
                                                                        Pair("user", Schema.builder()
                                                                                .type("string")
                                                                                .build()
                                                                        ),
                                                                        Pair("ts", Schema.builder()
                                                                                .type("string")
                                                                                .build()
                                                                        )
                                                                ))
                                                                .build()
                                                        ),
                                                ))
                                                .build()
                                        )
                                        .build()
                        ),
                        Pair("outgoingMessage",
                                Message.builder()
                                        .summary("A message was sent to a channel.")
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf("message"))
                                                                .build()
                                                        ),
                                                        Pair("id", Schema.builder()
                                                                .type("number")
                                                                .build()
                                                        ),
                                                        Pair("channel", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                        Pair("text", Schema.builder()
                                                                .type("string")
                                                                .build()
                                                        ),
                                                ))
                                                .build()
                                        )
                                        .build()
                        )
                ))
                .build()
    }

}