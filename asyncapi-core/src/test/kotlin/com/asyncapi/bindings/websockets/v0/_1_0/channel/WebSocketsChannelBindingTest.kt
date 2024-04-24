package com.asyncapi.bindings.websockets.v0._1_0.channel

import com.asyncapi.v3.SerDeTest
import com.asyncapi.v3.schema.AsyncAPISchema
import com.asyncapi.v3.schema.Type


/**
 * @version 3.0.0
 * @author Pavel Bodiachevskii
 */
class WebSocketsChannelBindingTest: SerDeTest<WebSocketsChannelBinding>() {

    override fun objectClass() = WebSocketsChannelBinding::class.java

    override fun baseObjectJson() = "/bindings/websockets/channel/webSocketsChannelBinding.json"

    override fun extendedObjectJson() = "/bindings/websockets/channel/webSocketsChannelBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/bindings/websockets/channel/webSocketsChannelBinding - wrongly extended.json"

    override fun build(): WebSocketsChannelBinding {
        return WebSocketsChannelBinding.builder()
                .method(WebSocketsChannelMethod.GET)
                .query(AsyncAPISchema.builder()
                        .type(Type.OBJECT)
                        .properties(mapOf(
                                Pair(
                                        "ref",
                                        AsyncAPISchema.builder()
                                                .type(Type.STRING)
                                                .description("Referral.")
                                                .build()
                                )
                        ))
                        .build()
                )
                .headers(AsyncAPISchema.builder()
                        .type(Type.OBJECT)
                        .properties(mapOf(
                                Pair(
                                        "Authentication",
                                        AsyncAPISchema.builder()
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