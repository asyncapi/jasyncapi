package com.asyncapi.v2.model

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.v2.model.channel.ChannelItem
import com.asyncapi.v2.model.info.Info
import com.google.gson.GsonBuilder
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @author Pavel Bodiachevskii
 */
class AsyncAPITest {

    private val gson = GsonBuilder().setPrettyPrinting().create()

    private fun buildInfo(): Info {
        return gson.fromJson(
                ClasspathUtils.readAsString("/json/model/info/info.json"),
                Info::class.java
        )
    }

    private fun buildChannels(): Map<String, ChannelItem> {
        val channelItem = gson.fromJson(
                ClasspathUtils.readAsString("/json/model/channel/channel.json"),
                ChannelItem::class.java
        )

        return mapOf(Pair("channelName", channelItem))
    }

    private fun buildAsyncAPI(): AsyncAPI {
        return AsyncAPI(
                "2.0.0",
                "https://www.asyncapi.com",
                "application/json",
                buildInfo(),
                buildChannels()
        )
    }

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/model/asyncapi.json")

        Assertions.assertEquals(
                gson.fromJson(model, AsyncAPI::class.java),
                buildAsyncAPI()
        )
    }

}
