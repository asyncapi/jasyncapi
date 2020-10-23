package com.asyncapi.v2.model.channel.message

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.v2.model.Reference
import com.asyncapi.v2.model.Tag
import com.asyncapi.v2.model.schema.Schema
import com.asyncapi.v2.model.schema.Type
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @author Pavel Bodiachevskii
 */
class MessageTest {

    private val objectMapper = ObjectMapper()

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
                .headers(Schema.builder()
                        .type(Type.OBJECT)
                        .properties(mapOf(
                                Pair("correlationId", Schema.builder()
                                        .type(Type.STRING)
                                        .description("Correlation ID set by application")
                                        .build()
                                ),
                                Pair("applicationInstanceId", Schema.builder()
                                        .type(Type.STRING)
                                        .description("Unique identifier for a given instance of the publishing application")
                                        .build()
                                )
                        ))
                        .build()
                )
                .payload(
                        Schema.builder()
                                .type(Type.OBJECT)
                                .properties(mapOf(
                                        Pair("user", Schema.builder().ref("#/components/schemas/userCreate").build()),
                                        Pair("signup", Schema.builder().ref("#/components/schemas/signup").build())
                                ))
                                .build()
                )
                .correlationId(CorrelationId("Default Correlation ID", "\$message.header#/correlationId"))
                .traits(listOf(
                        Reference("#/components/messageTraits/commonHeaders"),
                        MessageTrait.builder()
                                .schemaFormat("application/vnd.apache.avro+json;version=1.9.0")
                                .contentType("application/json")
                                .build()
                ))
                .build()
    }

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/model/channel/message/message.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, object: TypeReference<Message>() {}),
                buildMessage()
        )
    }

}
