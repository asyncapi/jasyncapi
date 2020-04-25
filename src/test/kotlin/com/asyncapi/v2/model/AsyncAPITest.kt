package com.asyncapi.v2.model

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.v2.model.channel.ChannelItem
import com.asyncapi.v2.model.component.Components
import com.asyncapi.v2.model.info.Info
import com.asyncapi.v2.model.server.Server
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @author Pavel Bodiachevskii
 */
class AsyncAPITest {

    private val objectMapper = ObjectMapper()

    private fun buildInfo(): Info {
        return objectMapper.readValue(
                ClasspathUtils.readAsString("/json/model/info/info.json"),
                Info::class.java
        )
    }

    private fun buildChannels(): Map<String, ChannelItem> {
        val channelItem = objectMapper.readValue(
                ClasspathUtils.readAsString("/json/model/channel/channel.json"),
                ChannelItem::class.java
        )

        return mapOf(Pair("channelName", channelItem))
    }

    private fun buildServers(): Map<String, Server> {
        val server = objectMapper.readValue(
                ClasspathUtils.readAsString("/json/model/server/server.json"),
                Server::class.java
        )

        return mapOf(Pair("stage", server))
    }

    private fun buildTags(): List<Tag> {
        val tag = objectMapper.readValue(
                ClasspathUtils.readAsString("/json/model/tag.json"),
                Tag::class.java
        )

        return listOf(tag)
    }

    private fun buildExternalDocs(): ExternalDocumentation {
        return objectMapper.readValue(
                ClasspathUtils.readAsString("/json/model/externalDocumentation.json"),
                ExternalDocumentation::class.java
        )
    }

    private fun buildComponents(): Components {
        return objectMapper.readValue(
                ClasspathUtils.readAsString("/json/model/components.json"),
                Components::class.java
        )
    }

    private fun buildAsyncAPI(): AsyncAPI {
        return AsyncAPI(
                "2.0.0",
                "https://www.asyncapi.com",
                "application/json",
                buildInfo(),
                buildServers(),
                buildChannels(),
                buildComponents(),
                buildTags(),
                buildExternalDocs()
        )
    }

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/model/asyncapi.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, AsyncAPI::class.java),
                buildAsyncAPI()
        )
    }

}
