package com.asyncapi.examples.v3._0_0

import com.asyncapi.v3.Reference
import com.asyncapi.v3._0_0.model.channel.Channel
import com.asyncapi.v3._0_0.model.channel.message.CorrelationId
import com.asyncapi.v3._0_0.model.channel.message.Message
import com.asyncapi.v3._0_0.model.channel.message.MessageExample
import com.asyncapi.v3._0_0.model.component.Components
import com.asyncapi.v3._0_0.model.info.Info
import com.asyncapi.v3._0_0.model.operation.Operation
import com.asyncapi.v3._0_0.model.operation.OperationAction
import com.asyncapi.v3._0_0.model.operation.reply.OperationReply
import com.asyncapi.v3.schema.Schema

class KrakenWebsocketRequestReplyMessageFilterInReplyAsyncAPI: AbstractExampleValidationTest() {

    override fun specificationLocation(): String = "/examples/v3.0.0/kraken-websocket-request-reply-message-filter-in-reply-asyncapi.yml"

    override fun expectedInfo(): Info {
        return Info.builder()
                .title("Kraken Websockets API")
                .version("1.8.0")
                .description(
                        "WebSockets API offers real-time market data updates. WebSockets is a bidirectional protocol offering fastest real-time data, helping you build real-time applications. The public message types presented below do not require authentication. Private-data messages can be subscribed on a separate authenticated endpoint. \n" +
                        "\n" +
                        "### General Considerations\n" +
                        "\n" +
                        "- TLS with SNI (Server Name Indication) is required in order to establish a Kraken WebSockets API connection. See Cloudflare's [What is SNI?](https://www.cloudflare.com/learning/ssl/what-is-sni/) guide for more details.\n" +
                        "- All messages sent and received via WebSockets are encoded in JSON format\n" +
                        "- All decimal fields (including timestamps) are quoted to preserve precision.\n" +
                        "- Timestamps should not be considered unique and not be considered as aliases for transaction IDs. Also, the granularity of timestamps is not representative of transaction rates.\n" +
                        "- At least one private message should be subscribed to keep the authenticated client connection open.\n" +
                        "- Please use REST API endpoint [AssetPairs](https://www.kraken.com/features/api#get-tradable-pairs) to fetch the list of pairs which can be subscribed via WebSockets API. For example, field 'wsname' gives the supported pairs name which can be used to subscribe.\n" +
                        "- Cloudflare imposes a connection/re-connection rate limit (per IP address) of approximately 150 attempts per rolling 10 minutes. If this is exceeded, the IP is banned for 10 minutes.\n" +
                        "- Recommended reconnection behaviour is to (1) attempt reconnection instantly up to a handful of times if the websocket is dropped randomly during normal operation but (2) after maintenance or extended downtime, attempt to reconnect no more quickly than once every 5 seconds. There is no advantage to reconnecting more rapidly after maintenance during cancel_only mode.\n"
                )
                .build()
    }

    override fun expectedServers(): Map<String, Any> = emptyMap()

    override fun expectedChannels(): Map<String, Any> {
        return mapOf(
                Pair("currencyExchange",
                        Channel.builder()
                                .address("/")
                                .messages(mapOf(
                                        Pair("ping", Reference("#/components/messages/ping")),
                                        Pair("pong", Reference("#/components/messages/pong")),
                                        Pair("heartbeat", Reference("#/components/messages/heartbeat")),
                                        Pair("systemStatus", Reference("#/components/messages/systemStatus")),
                                        Pair("subscriptionStatus", Reference("#/components/messages/subscriptionStatus")),
                                        Pair("subscribe", Reference("#/components/messages/subscribe")),
                                        Pair("unsubscribe", Reference("#/components/messages/unsubscribe")),
                                        Pair("dummyCurrencyInfo", Reference("#/components/messages/dummyCurrencyInfo")),
                                ))
                                .build()
                )
        )
    }

    override fun expectedOperations(): Map<String, Any> {
        return mapOf(
                Pair("receivePing", Operation.builder()
                        .action(OperationAction.RECEIVE)
                        .channel(Reference("#/channels/currencyExchange"))
                        .reply(OperationReply(
                                null,
                                Reference("#/channels/currencyExchange"),
                                listOf(Reference("#/channels/currencyExchange/messages/pong"))
                        ))
                        .messages(listOf(Reference("#/channels/currencyExchange/messages/ping")))
                        .build()
                ),
                Pair("sendHeartbeat", Operation.builder()
                        .action(OperationAction.SEND)
                        .channel(Reference("#/channels/currencyExchange"))
                        .messages(listOf(Reference("#/channels/currencyExchange/messages/heartbeat")))
                        .build()
                ),
                Pair("systemStatus", Operation.builder()
                        .action(OperationAction.SEND)
                        .channel(Reference("#/channels/currencyExchange"))
                        .messages(listOf(Reference("#/channels/currencyExchange/messages/systemStatus")))
                        .build()
                ),
                Pair("receiveSubscribeRequest", Operation.builder()
                        .action(OperationAction.RECEIVE)
                        .channel(Reference("#/channels/currencyExchange"))
                        .reply(OperationReply(
                                null,
                                Reference("#/channels/currencyExchange"),
                                listOf(
                                        Reference("#/channels/currencyExchange/messages/subscriptionStatus"),
                                        Reference("#/channels/currencyExchange/messages/dummyCurrencyInfo")
                                )
                        ))
                        .messages(listOf(Reference("#/channels/currencyExchange/messages/subscribe")))
                        .build()
                ),
                Pair("receiveUnsubscribeRequest", Operation.builder()
                        .action(OperationAction.RECEIVE)
                        .channel(Reference("#/channels/currencyExchange"))
                        .reply(OperationReply(
                                null,
                                Reference("#/channels/currencyExchange"),
                                listOf(
                                        Reference("#/channels/currencyExchange/messages/subscriptionStatus")
                                )
                        ))
                        .messages(listOf(Reference("#/channels/currencyExchange/messages/unsubscribe")))
                        .build()
                )
        )
    }

    override fun expectedComponents(): Components? {
        return Components.builder()
                .messages(mapOf(
                        Pair("dummyCurrencyInfo", Message.builder()
                                .summary("Dummy message with no real life details")
                                .description("It is here in this example to showcase that there is an additional message that normally is of a complex structure. It represents actually currency exchange value to show a reply to operation receiveSubscribeRequest with more than one possible message.")
                                .payload(Schema.builder()
                                        .type("object")
                                        .properties(mapOf(
                                                Pair("event", Schema.builder()
                                                        .type("string")
                                                        .constValue("currencyInfo")
                                                        .build()
                                                ),
                                                Pair("reqid", Schema.builder()
                                                        .ref("#/components/schemas/reqid")
                                                        .build()
                                                ),
                                                Pair("data", Schema.builder()
                                                        .type("object")
                                                        .build()
                                                ),
                                        ))
                                        .required(listOf("event"))
                                        .build()
                                )
                                .correlationId(CorrelationId(null, "\$message.payload#/reqid"))
                                .build()
                        ),
                        Pair("ping", Message.builder()
                                .summary("Ping server to determine whether connection is alive")
                                .description("Client can ping server to determine whether connection is alive, server responds with pong. This is an application level ping as opposed to default ping in websockets standard which is server initiated")
                                .payload(Reference("#/components/schemas/ping"))
                                .correlationId(CorrelationId(null, "\$message.payload#/reqid"))
                                .build()
                        ),
                        Pair("pong", Message.builder()
                                .summary("Pong is a response to ping message")
                                .description("Server pong response to a ping to determine whether connection is alive. This is an application level pong as opposed to default pong in websockets standard which is sent by client in response to a ping")
                                .payload(Reference("#/components/schemas/pong"))
                                .correlationId(CorrelationId(null, "\$message.payload#/reqid"))
                                .build()
                        ),
                        Pair("subscribe", Message.builder()
                                .description("Subscribe to a topic on a single or multiple currency pairs.")
                                .payload(Reference("#/components/schemas/subscribe"))
                                .correlationId(CorrelationId(null, "\$message.payload#/reqid"))
                                .build()
                        ),
                        Pair("unsubscribe", Message.builder()
                                .description("Unsubscribe, can specify a channelID or multiple currency pairs.")
                                .payload(Reference("#/components/schemas/unsubscribe"))
                                .correlationId(CorrelationId(null, "\$message.payload#/reqid"))
                                .build()
                        ),
                        Pair("subscriptionStatus", Message.builder()
                                .description("Subscription status response to subscribe, unsubscribe or exchange initiated unsubscribe.")
                                .payload(Reference("#/components/schemas/subscriptionStatus"))
                                .examples(listOf(
                                        MessageExample.builder()
                                                .payload(mapOf(
                                                        Pair("channelID", 10001),
                                                        Pair("channelName", "ohlc-5"),
                                                        Pair("event", "subscriptionStatus"),
                                                        Pair("pair", "XBT/EUR"),
                                                        Pair("reqid", 42),
                                                        Pair("status", "unsubscribed"),
                                                        Pair("subscription", mapOf(
                                                                Pair("interval", 5),
                                                                Pair("name", "ohlc")
                                                        )),
                                                ))
                                                .build(),
                                        MessageExample.builder()
                                                .payload(mapOf(
                                                        Pair("errorMessage", "Subscription depth not supported"),
                                                        Pair("event", "subscriptionStatus"),
                                                        Pair("pair", "XBT/USD"),
                                                        Pair("status", "error"),
                                                        Pair("subscription", mapOf(
                                                                Pair("depth", 42),
                                                                Pair("name", "book")
                                                        )),
                                                ))
                                                .build()
                                ))
                                .build()
                        ),
                        Pair("systemStatus", Message.builder()
                                .description("Status sent on connection or system status changes.")
                                .payload(Reference("#/components/schemas/systemStatus"))
                                .build()
                        ),
                        Pair("heartbeat", Message.builder()
                                .description("Server heartbeat sent if no subscription traffic within 1 second (approximately)")
                                .payload(Reference("#/components/schemas/heartbeat"))
                                .build()
                        ),
                ))
                .schemas(mapOf(
                        Pair("ping", Schema.builder()
                                .type("object")
                                .properties(mapOf(
                                        Pair("event", Schema.builder()
                                                .type("string")
                                                .constValue("ping")
                                                .build()
                                        ),
                                        Pair("reqid", Schema.builder()
                                                .ref("#/components/schemas/reqid")
                                                .build()
                                        )
                                ))
                                .required(listOf("event"))
                                .build()
                        ),
                        Pair("heartbeat", Schema.builder()
                                .type("object")
                                .properties(mapOf(
                                        Pair("event", Schema.builder()
                                                .type("string")
                                                .constValue("heartbeat")
                                                .build()
                                        )
                                ))
                                .build()
                        ),
                        Pair("pong", Schema.builder()
                                .type("object")
                                .properties(mapOf(
                                        Pair("event", Schema.builder()
                                                .type("string")
                                                .constValue("pong")
                                                .build()
                                        ),
                                        Pair("reqid", Schema.builder()
                                                .ref("#/components/schemas/reqid")
                                                .build()
                                        )
                                ))
                                .build()
                        ),
                        Pair("systemStatus", Schema.builder()
                                .type("object")
                                .properties(mapOf(
                                        Pair("event", Schema.builder()
                                                .type("string")
                                                .constValue("systemStatus")
                                                .build()
                                        ),
                                        Pair("connectionID", Schema.builder()
                                                .type("integer")
                                                .description("The ID of the connection")
                                                .build()
                                        ),
                                        Pair("status", Schema.builder()
                                                .ref("#/components/schemas/status")
                                                .build()
                                        ),
                                        Pair("version", Schema.builder()
                                                .type("string")
                                                .build()
                                        )
                                ))
                                .build()
                        ),
                        Pair("status", Schema.builder()
                                .type("string")
                                .enumValue(listOf(
                                        "online", "maintenance", "cancel_only", "limit_only", "post_only"
                                ))
                                .build()
                        ),
                        Pair("subscribe", Schema.builder()
                                .type("object")
                                .properties(mapOf(
                                        Pair("event", Schema.builder()
                                                .type("string")
                                                .constValue("subscribe")
                                                .build()
                                        ),
                                        Pair("reqid", Schema.builder()
                                                .ref("#/components/schemas/reqid")
                                                .build()
                                        ),
                                        Pair("pair", Schema.builder()
                                                .ref("#/components/schemas/pair")
                                                .build()
                                        ),
                                        Pair("subscription", Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("depth", Schema.builder()
                                                                .ref("#/components/schemas/depth")
                                                                .build()
                                                        ),
                                                        Pair("interval", Schema.builder()
                                                                .ref("#/components/schemas/interval")
                                                                .build()
                                                        ),
                                                        Pair("name", Schema.builder()
                                                                .ref("#/components/schemas/name")
                                                                .build()
                                                        ),
                                                        Pair("ratecounter", Schema.builder()
                                                                .ref("#/components/schemas/ratecounter")
                                                                .build()
                                                        ),
                                                        Pair("snapshot", Schema.builder()
                                                                .ref("#/components/schemas/snapshot")
                                                                .build()
                                                        ),
                                                        Pair("token", Schema.builder()
                                                                .ref("#/components/schemas/token")
                                                                .build()
                                                        )
                                                ))
                                                .required(listOf("name"))
                                                .build()
                                        )
                                ))
                                .required(listOf("event"))
                                .build()
                        ),
                        Pair("unsubscribe", Schema.builder()
                                .type("object")
                                .properties(mapOf(
                                        Pair("event", Schema.builder()
                                                .type("string")
                                                .constValue("unsubscribe")
                                                .build()
                                        ),
                                        Pair("reqid", Schema.builder()
                                                .ref("#/components/schemas/reqid")
                                                .build()
                                        ),
                                        Pair("pair", Schema.builder()
                                                .ref("#/components/schemas/pair")
                                                .build()
                                        ),
                                        Pair("subscription", Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("depth", Schema.builder()
                                                                .ref("#/components/schemas/depth")
                                                                .build()
                                                        ),
                                                        Pair("interval", Schema.builder()
                                                                .ref("#/components/schemas/interval")
                                                                .build()
                                                        ),
                                                        Pair("name", Schema.builder()
                                                                .ref("#/components/schemas/name")
                                                                .build()
                                                        ),
                                                        Pair("token", Schema.builder()
                                                                .ref("#/components/schemas/token")
                                                                .build()
                                                        )
                                                ))
                                                .required(listOf("name"))
                                                .build()
                                        )
                                ))
                                .required(listOf("event"))
                                .build()
                        ),
                        Pair("subscriptionStatus", Schema.builder()
                                .type("object")
                                .oneOf(listOf(
                                        Schema.builder().ref("#/components/schemas/subscriptionStatusError").build(),
                                        Schema.builder().ref("#/components/schemas/subscriptionStatusSuccess").build()
                                ))
                                .build()
                        ),
                        Pair("subscriptionStatusError", Schema.builder()
                                .allOf(listOf(
                                        Schema.builder()
                                                .properties(mapOf(
                                                        Pair("errorMessage", Schema.builder().type("string").build())
                                                ))
                                                .required(listOf("errorMessage"))
                                                .build(),
                                        Schema.builder().ref("#/components/schemas/subscriptionStatusCommon").build()
                                ))
                                .build()
                        ),
                        Pair("subscriptionStatusSuccess", Schema.builder()
                                .allOf(listOf(
                                        Schema.builder()
                                                .properties(mapOf(
                                                        Pair("channelID", Schema.builder()
                                                                .type("integer")
                                                                .description("ChannelID on successful subscription, applicable to public messages only.")
                                                                .build()
                                                        ),
                                                        Pair("channelName", Schema.builder()
                                                                .type("string")
                                                                .description("Channel Name on successful subscription. For payloads 'ohlc' and 'book', respective interval or depth will be added as suffix.")
                                                                .build()
                                                        )
                                                ))
                                                .required(listOf("channelID", "channelName"))
                                                .build(),
                                        Schema.builder().ref("#/components/schemas/subscriptionStatusCommon").build()
                                ))
                                .build()
                        ),
                        Pair("subscriptionStatusCommon", Schema.builder()
                                .type("object")
                                .required(listOf("event"))
                                .properties(mapOf(
                                        Pair("event", Schema.builder()
                                                .type("string")
                                                .constValue("subscriptionStatus")
                                                .build()
                                        ),
                                        Pair("reqid", Schema.builder()
                                                .ref("#/components/schemas/reqid")
                                                .build()
                                        ),
                                        Pair("pair", Schema.builder()
                                                .ref("#/components/schemas/pair")
                                                .build()
                                        ),
                                        Pair("status", Schema.builder()
                                                .ref("#/components/schemas/status")
                                                .build()
                                        ),
                                        Pair("subscription", Schema.builder()
                                                .type("object")
                                                .required(listOf("name"))
                                                .properties(mapOf(
                                                        Pair("depth", Schema.builder().ref("#/components/schemas/depth").build()),
                                                        Pair("interval", Schema.builder().ref("#/components/schemas/interval").build()),
                                                        Pair("maxratecount", Schema.builder().ref("#/components/schemas/maxratecount").build()),
                                                        Pair("name", Schema.builder().ref("#/components/schemas/name").build()),
                                                        Pair("token", Schema.builder().ref("#/components/schemas/token").build()),
                                                ))
                                                .build()
                                        )
                                ))
                                .build()
                        ),
                        Pair("interval", Schema.builder()
                                .type("integer")
                                .description("Time interval associated with ohlc subscription in minutes.")
                                .defaultValue(1)
                                .enumValue(listOf(
                                        1, 5, 15, 30, 60, 240, 1440, 10080, 21600
                                ))
                                .build()
                        ),
                        Pair("name", Schema.builder()
                                .type("string")
                                .description("The name of the channel you subscribe too.")
                                .enumValue(listOf(
                                        "book", "ohlc", "openOrders", "ownTrades", "spread", "ticker", "trade"
                                ))
                                .build()
                        ),
                        Pair("token", Schema.builder()
                                .type("string")
                                .description("base64-encoded authentication token for private-data endpoints.")
                                .build()
                        ),
                        Pair("depth", Schema.builder()
                                .type("integer")
                                .defaultValue(10)
                                .description("Depth associated with book subscription in number of levels each side.")
                                .enumValue(listOf(
                                        10, 25, 100, 500, 1000
                                ))
                                .build()
                        ),
                        Pair("maxratecount", Schema.builder()
                                .type("integer")
                                .description("Max rate-limit budget. Compare to the ratecounter field in the openOrders updates to check whether you are approaching the rate limit.")
                                .build()
                        ),
                        Pair("ratecounter", Schema.builder()
                                .type("boolean")
                                .defaultValue(false)
                                .description("Whether to send rate-limit counter in updates (supported only for openOrders subscriptions)")
                                .build()
                        ),
                        Pair("snapshot", Schema.builder()
                                .type("boolean")
                                .defaultValue(true)
                                .description("Whether to send historical feed data snapshot upon subscription (supported only for ownTrades subscriptions)")
                                .build()
                        ),
                        Pair("reqid", Schema.builder()
                                .type("integer")
                                .description("client originated ID reflected in response message.")
                                .build()
                        ),
                        Pair("pair", Schema.builder()
                                .type("array")
                                .description("Array of currency pairs.")
                                .items(Schema.builder()
                                        .type("string")
                                        .description("Format of each pair is \"A/B\", where A and B are ISO 4217-A3 for standardized assets and popular unique symbol if not standardized.")
                                        .pattern("[A-Z\\s]+\\/[A-Z\\s]+")
                                        .build()
                                )
                                .build()
                        ),
                ))
                .build()
    }

}