package com.asyncapi.v2._6_0.model.channel.message

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.v2._6_0.model.Reference
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class OneOfMessagesTest {

    private val objectMapper = ObjectMapper()

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/model/channel/message/oneOfMessages.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, OneOfMessages::class.java),
                build()
        )
    }

    companion object {
        @JvmStatic
        fun build(): OneOfMessages {
            return OneOfMessages(listOf(
                    Reference("#/components/schemas/sendMessage"),
                    MessageTest.build()
            ))
        }
    }

}