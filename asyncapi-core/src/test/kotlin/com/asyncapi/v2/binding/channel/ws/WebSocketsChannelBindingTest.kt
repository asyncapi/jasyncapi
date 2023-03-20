package com.asyncapi.v2.binding.channel.ws

import com.asyncapi.v2.SerDeTest
import com.asyncapi.v2.schema.Schema
import com.asyncapi.v2.schema.Type

/**
 * @version 2.6.0
 * @author Pavel Bodiachevskii
 */
class WebSocketsChannelBindingTest: SerDeTest<WebSocketsChannelBinding>() {

    override fun objectClass() = WebSocketsChannelBinding::class.java

    override fun baseObjectJson() = "/json/binding/channel/ws/webSocketsChannelBinding.json"

    override fun extendedObjectJson() = "/json/binding/channel/ws/webSocketsChannelBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/binding/channel/ws/webSocketsChannelBinding - wrongly extended.json"

    override fun build(): WebSocketsChannelBinding {
        return WebSocketsChannelBinding.builder()
                .method(WebSocketsChannelMethod.GET)
                .query(Schema.builder()
                        .type(Type.OBJECT)
                        .properties(mapOf(
                                Pair(
                                        "ref",
                                        Schema.builder()
                                                .type(Type.STRING)
                                                .description("Referral.")
                                                .build()
                                )
                        ))
                        .build()
                )
                .headers(Schema.builder()
                        .type(Type.OBJECT)
                        .properties(mapOf(
                                Pair(
                                        "Authentication",
                                        Schema.builder()
                                                .type(Type.STRING)
                                                .description("Authentication token")
                                                .build()
                                )
                        ))
                        .build()
                )
                .build()
    }

}