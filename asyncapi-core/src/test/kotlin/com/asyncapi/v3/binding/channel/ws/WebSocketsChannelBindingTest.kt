package com.asyncapi.v3.binding.channel.ws

import com.asyncapi.v3.SerDeTest
import com.asyncapi.v3.schema.Schema
import com.asyncapi.v3.schema.Type

/**
 * @version 3.0.0
 * @author Pavel Bodiachevskii
 */
class WebSocketsChannelBindingTest: SerDeTest<WebSocketsChannelBinding>() {

    override fun objectClass() = WebSocketsChannelBinding::class.java

    override fun baseObjectJson() = "/json/v3/binding/channel/ws/webSocketsChannelBinding.json"

    override fun extendedObjectJson() = "/json/v3/binding/channel/ws/webSocketsChannelBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/binding/channel/ws/webSocketsChannelBinding - wrongly extended.json"

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