package com.asyncapi.v2._6_0.model.component

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.v2._6_0.model.Reference
import com.asyncapi.v2._6_0.model.channel.ChannelItemTest
import com.asyncapi.v2._6_0.model.channel.ParameterTest
import com.asyncapi.v2._6_0.model.channel.message.CorrelationIdTest
import com.asyncapi.v2._6_0.model.channel.message.MessageTest
import com.asyncapi.v2._6_0.model.channel.message.MessageTraitTest
import com.asyncapi.v2._6_0.model.channel.operation.OperationTest
import com.asyncapi.v2._6_0.model.channel.operation.OperationTraitTest
import com.asyncapi.v2._6_0.model.server.ServerTest
import com.asyncapi.v2._6_0.model.server.ServerVariableTest
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @version 2.6.0
 * @author Pavel Bodiachevskii
 */
class ComponentsTest {

    private val objectMapper = ObjectMapper()

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/model/components/components.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, Components::class.java),
                build()
        )
    }

    companion object {
        @JvmStatic
        fun build(): Components {
            return Components.builder()
                    .schemas(null)
                    .servers(mapOf(
                            Pair("mqtt-test", ServerTest.build()),
                            Pair("mqtt-stage", Reference("#/components/servers/mqtt-stage"))
                    ))
                    .serverVariables(mapOf(
                            Pair("port", ServerVariableTest.build()),
                            Pair("basePath", Reference("#/components/serverVariables/basePath"))
                    ))
                    .channels(mapOf(
                            Pair("sign-up", ChannelItemTest.build()),
                    ))
                    .messages(mapOf(
                            Pair("userSignup", MessageTest.build()),
                            Pair("userSignout", Reference("#/components/messages/userSignout"))
                    ))
                    .securitySchemes(null)
                    .parameters(mapOf(
                            Pair("parameterWithSchema", ParameterTest.buildWithSchema()),
                            Pair("parameterWithSchemaReference", ParameterTest.buildWithSchemaReference()),
                            Pair("parameter", Reference("#/components/parameters/parameter"))
                    ))
                    .correlationIds(mapOf(
                            Pair("userSignupCorrelationId", CorrelationIdTest.build()),
                            Pair("correlationId", Reference("#/correlationIds/parameters/correlationId"))
                    ))
                    .operationTraits(mapOf(
                            Pair("sendMessage", OperationTraitTest.build()),
                            Pair("deleteMessage", Reference("#/components/operationTraits/deleteMessage"))
                    ))
                    .messageTraits(mapOf(
                            Pair("userSignup", MessageTraitTest.build()),
                            Pair("userSignout", Reference("#/components/messageTraits/userSignout"))
                    ))
                    .serverBindings(ServerTest.bindings())
                    .channelBindings(ChannelItemTest.bindings())
                    .operationBindings(OperationTest.bindings())
                    .messageBindings(MessageTest.bindings())
                    .build()
        }
    }

}
