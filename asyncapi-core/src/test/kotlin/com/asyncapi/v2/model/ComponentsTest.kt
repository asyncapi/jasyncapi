package com.asyncapi.v2.model

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.v2._0_0.model.Reference
import com.asyncapi.v2._0_0.model.Tag
import com.asyncapi.v2._0_0.model.channel.Parameter
import com.asyncapi.v2._0_0.model.channel.message.CorrelationId
import com.asyncapi.v2._0_0.model.channel.message.Message
import com.asyncapi.v2._0_0.model.channel.message.MessageTrait
import com.asyncapi.v2._0_0.model.component.Components
import com.asyncapi.v2._0_0.model.schema.Schema
import com.asyncapi.v2._0_0.model.schema.Type
import com.asyncapi.v2.security_scheme.SecurityScheme
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.math.BigDecimal

/**
 * @author Pavel Bodiachevskii
 */
class ComponentsTest {

    private val objectMapper = ObjectMapper()

    private fun buildComponents(): Components {
        return Components.builder()
                .schemas(mapOf(
                        Pair("Category", Schema.builder()
                                .type(Type.OBJECT)
                                .properties(mapOf(
                                        Pair("id", Schema.builder().type(Type.INTEGER).format("int64").build()),
                                        Pair("name", Schema.builder().type(Type.STRING).build())
                                ))
                                .build()
                        ),
                        Pair("Tag", Schema.builder()
                                .type(Type.OBJECT)
                                .properties(mapOf(
                                        Pair("id", Schema.builder().type(Type.INTEGER).format("int64").build()),
                                        Pair("name", Schema.builder().type(Type.STRING).build())
                                ))
                                .build()
                        ),
                        Pair("User", Reference("#/components/schemas/user"))
                ))
                .messages(mapOf(
                        Pair("userSignUp", Message.builder()
                                .summary("Action to sign a user up.")
                                .description("Multiline description of what this action does.\n" +
                                        "Here you have another line.\n")
                                .tags(listOf(
                                        Tag("user", null, null),
                                        Tag("signup", null, null)
                                ))
                                .headers(Schema.builder()
                                        .type(Type.OBJECT)
                                        .properties(mapOf(
                                                Pair("applicationInstanceId", Schema.builder()
                                                        .type(Type.STRING)
                                                        .description("Unique identifier for a given instance of the publishing application")
                                                        .build()
                                                )
                                        ))
                                        .build()
                                )
                                .payload(Schema.builder()
                                        .type(Type.OBJECT)
                                        .properties(mapOf(
                                                Pair("user", Schema.builder().ref("#/components/schemas/userCreate").build()),
                                                Pair("signup", Schema.builder().ref("#/components/schemas/signup").build())
                                        ))
                                        .build()
                                )
                                .build()),
                        Pair("userSignOut", Reference("#/components/schemas/userSignOut"))
                ))
                .securitySchemes(mapOf(
                        Pair("1", SecurityScheme.builder().type(SecurityScheme.Type.USER_PASSWORD).build()),
                        Pair("2", Reference("#/components/schemas/2"))
                ))
                .parameters(mapOf(
                        Pair("userId", Parameter.builder()
                                .description("Id of the user.")
                                .schema(Schema.builder().type(Type.STRING).build())
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
                        Pair("commonHeaders", MessageTrait.builder()
                                .headers(Schema.builder()
                                        .type(Type.OBJECT)
                                        .properties(mapOf(Pair("my-app-header", Schema.builder()
                                                .type(Type.INTEGER)
                                                .minimum(BigDecimal.ZERO)
                                                .maximum(BigDecimal.valueOf(100))
                                                .build()))
                                        )
                                        .build()
                                )
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
