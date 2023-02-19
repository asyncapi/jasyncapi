package com.asyncapi.v2._0_0.model.channel.message

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.v2._0_0.model.channel.message.MessageTrait
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @author Pavel Bodiachevskii
 */
class MessageTraitTest {

    private val objectMapper = ObjectMapper()

    private fun buildMessageTrait(): MessageTrait {
        return MessageTrait.builder()
                .schemaFormat("application/vnd.apache.avro+json;version=1.9.0")
                .contentType("application/json")
                .build()
    }

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/model/channel/message/messageTrait.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, MessageTrait::class.java),
                buildMessageTrait()
        )
    }

}
