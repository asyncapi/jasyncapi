package com.asyncapi.v2.model

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.v2.model.channel.message.CorrelationId
import com.asyncapi.v2.model.channel.message.MessageTrait
import com.asyncapi.v2.model.component.Components
import com.google.gson.GsonBuilder
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @author Pavel Bodiachevskii
 */
class ComponentsTest {

    private val gson = GsonBuilder().setPrettyPrinting().create()

    private fun buildComponents(): Components {
        return Components.builder()
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
                        Pair("userSignUp", mapOf(
                                Pair("summary", "Action to sign a user up."),
                                Pair("description", "Multiline description of what this action does.\n" +
                                        "Here you have another line.\n"),
                                Pair("tags", listOf(
                                        mapOf(Pair("name", "user")),
                                        mapOf(Pair("name", "signup"))
                                )),
                                Pair("headers", mapOf(
                                        Pair("type", "object"),
                                        Pair("properties", mapOf(
                                                Pair("applicationInstanceId", mapOf(
                                                        Pair("description", "Unique identifier for a given instance of the publishing application"),
                                                        Pair("type", "string")
                                                ))
                                        ))
                                )),
                                Pair("payload", mapOf(
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
                        ))
                ))
                .parameters(mapOf(
                        Pair("userId", mapOf(
                                Pair("name", "userId"),
                                Pair("description", "Id of the user."),
                                Pair("schema", mapOf(
                                        Pair("type", "string")
                                ))
                        ))
                ))
                .correlationIds(mapOf(
                        Pair("default", CorrelationId(
                                "Default Correlation ID",
                                "\$message.header#/correlationId"
                        ))
                ))
                .messageTraits(mapOf(
                        Pair("commonHeaders", MessageTrait.builder()
                                .headers(mapOf(
                                        Pair("type", "object"),
                                        Pair("properties", mapOf(
                                                Pair("my-app-header", mapOf(
                                                        Pair("type", "integer"),
                                                        Pair("minimum", 0.0),
                                                        Pair("maximum", 100.0)
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
                gson.fromJson(components, Components::class.java),
                buildComponents()
        )
    }

}
