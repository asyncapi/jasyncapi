package com.asyncapi.examples.v2._0_0

import com.asyncapi.schemas.Reference
import com.asyncapi.v2._0_0.model.channel.ChannelItem
import com.asyncapi.v2._0_0.model.channel.message.Message
import com.asyncapi.v2._0_0.model.channel.operation.Operation
import com.asyncapi.v2._0_0.model.component.Components
import com.asyncapi.v2._0_0.model.info.Info
import com.asyncapi.v2._0_0.model.server.Server
import com.asyncapi.v2.schema.Schema
import com.asyncapi.v2.security_scheme.http.HttpApiKeySecurityScheme

class SlackRtm: AbstractExampleValidationTest() {

    override fun specificationLocation(): String = "/examples/v2.0.0/slack-rtm.yml"

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
                                .url("https://slack.com/api/rtm.connect")
                                .protocol("https")
                                .protocolVersion("1.1")
                                .security(listOf(
                                        mapOf(Pair("token", emptyList<String>()))
                                ))
                                .build()
                )
        )
    }

    override fun expectedChannels(): Map<String, Any> {
        return mapOf(
                Pair("/",
                        ChannelItem.builder()
                                .publish(Operation.builder()
                                        .message(Reference("#/components/messages/outgoingMessage"))
                                        .build()
                                )
                                .subscribe(Operation.builder()
                                        // TODO: add OneOfMessage to 2.0.0
                                        .message(Reference("#/components/messages/hello"))
                                        .build()
                                )
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