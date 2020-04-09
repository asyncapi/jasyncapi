package com.asyncapi.v2.model.channel.message

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.v2.model.Tag
import com.google.gson.GsonBuilder
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @author Pavel Bodiachevskii
 */
class MessageTest {

    private val gson = GsonBuilder().setPrettyPrinting().create()

    private fun buildMessage(): Message {
        return Message.builder()
                .name("UserSignup")
                .title("User signup")
                .summary("Action to sign a user up.")
                .description("A longer description")
                .contentType("application/json")
                .tags(listOf(
                        Tag("user", null, null),
                        Tag("signup", null, null),
                        Tag("register", null, null)
                ))
                .headers(mapOf(
                        Pair("type", "object"),
                        Pair("properties", mapOf(
                                Pair("correlationId", mapOf(
                                        Pair("description", "Correlation ID set by application"),
                                        Pair("type", "string")
                                )),
                                Pair("applicationInstanceId", mapOf(
                                        Pair("description", "Unique identifier for a given instance of the publishing application"),
                                        Pair("type", "string")
                                ))
                        ))
                ))
                .payload(mapOf(
                        Pair("type", "object"),
                        Pair("properties", mapOf(
                                Pair("user", mapOf(
                                        Pair("\$ref", "#/components/schemas/userCreate")
                                )),
                                Pair("signup", mapOf(
                                        Pair("\$ref", "#/components/schemas/signup")
                                ))
                        ))
                ))
                .correlationId(CorrelationId("Default Correlation ID", "\$message.header#/correlationId"))
                .traits(listOf(mapOf(Pair("\$ref", "#/components/messageTraits/commonHeaders"))))
                .build()
    }

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/model/channel/message/message.json")

        Assertions.assertEquals(
                gson.fromJson(model, Message::class.java),
                buildMessage()
        )
    }

}
