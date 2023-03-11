package com.asyncapi.v2.binding.channel.ws

import com.asyncapi.v2.SerDeTest

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
                .method("GET")
                .query(mapOf(
                        Pair("type", "object"),
                        Pair("properties", mapOf(
                                Pair("ref", mapOf(
                                        Pair("type", "string"),
                                        Pair("description", "Referral.")
                                ))
                        )),
                ))
                .headers(mapOf(
                        Pair("type", "object"),
                        Pair("properties", mapOf(
                                Pair("Authentication", mapOf(
                                        Pair("type", "string"),
                                        Pair("description", "Authentication token")
                                ))
                        )),
                ))
                .build()
    }

}