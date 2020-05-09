package com.asyncapi.v2.model

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.v2.model.channel.Parameter
import com.asyncapi.v2.model.channel.message.CorrelationId
import com.asyncapi.v2.model.channel.message.Message
import com.asyncapi.v2.model.channel.message.MessageTrait
import com.asyncapi.v2.model.component.Components
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @author Pavel Bodiachevskii
 */
class ComponentsTest {

    private val objectMapper = ObjectMapper()

    private fun buildComponents(): Components<Any, Any> {
        return Components.builder<Any, Any>()
                .schemas(mapOf(
                        Pair("Category", mapOf(
                                Pair("type", "object"),
                                Pair("properties", mapOf(
                                        Pair("id", mapOf(
                                                Pair("type", "integer"),
                                                Pair("format", "int64")
                                        )),
                                        Pair("name", mapOf(
                                                Pair("type", "string")
                                        ))
                                ))
                        )),
                        Pair("Tag", mapOf(
                                Pair("type", "object"),
                                Pair("properties", mapOf(
                                        Pair("id", mapOf(
                                                Pair("type", "integer"),
                                                Pair("format", "int64")
                                        )),
                                        Pair("name", mapOf(
                                                Pair("type", "string")
                                        ))
                                ))
                        ))
                ))
                .messages(mapOf(
                        Pair("userSignUp", Message.builder<Any, Any>()
                                .summary("Action to sign a user up.")
                                .description("Multiline description of what this action does.\n" +
                                        "Here you have another line.\n")
                                .tags(listOf(
                                        Tag("user", null, null),
                                        Tag("signup", null, null)
                                ))
                                .headers(mapOf(
                                        Pair("type", "object"),
                                        Pair("properties", mapOf(
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
                                .build()),
                        Pair("userSignOut", Reference("#/components/schemas/userSignOut"))
                ))
                .securitySchemes(mapOf(
                        Pair("1", mapOf(Pair("type", "userPassword"))),
                        Pair("2", Reference("#/components/schemas/2"))
                ))
                .parameters(mapOf(
                        Pair("userId", Parameter.builder()
                                .description("Id of the user.")
                                .schema(mapOf(Pair("type", "string")))
                                .location("\$message.payload#/user/id")
                                .build()
                        ),
                        Pair("userKey", Reference("\$message.payload#/user/key"))
                ))
                .correlationIds(mapOf(
                        Pair("default", CorrelationId(
                                "Default Correlation ID",
                                "\$message.header#/correlationId"
                        ))
                ))
                .messageTraits(mapOf(
                        Pair("commonHeaders", MessageTrait.builder<Any, Any>()
                                .headers(mapOf(
                                        Pair("type", "object"),
                                        Pair("properties", mapOf(
                                                Pair("my-app-header", mapOf(
                                                        Pair("type", "integer"),
                                                        Pair("minimum", 0),
                                                        Pair("maximum", 100)
                                                ))
                                        ))
                                ))
                                .build()
                        )
                ))
                .build()
    }

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val components = ClasspathUtils.readAsString("/json/model/components.json")

        Assertions.assertEquals(
                objectMapper.readValue(components, Components::class.java),
                buildComponents()
        )
    }

}
