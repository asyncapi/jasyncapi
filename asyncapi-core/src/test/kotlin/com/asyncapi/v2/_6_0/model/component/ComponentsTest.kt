package com.asyncapi.v2._6_0.model.component

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.v2._6_0.model.Reference
import com.asyncapi.v2._6_0.model.server.Server
import com.asyncapi.v2._6_0.model.server.ServerVariable
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

    private fun build(): Components {
        return Components.builder()
                .servers(mapOf(
                        Pair(
                                "mqtt-test",
                                Server.builder()
                                        .url("{username}.gigantic-server.com:{port}/{basePath}")
                                        .protocol("secure-mqtt")
                                        .protocolVersion("5")
                                        .description("The test API server")
                                        .build()
                        ),
                        Pair("mqtt-stage", Reference("#/components/servers/mqtt-stage"))
                ))
                .serverVariables(mapOf(
                        Pair(
                                "username",
                                ServerVariable.builder()
                                        .defaultValue("demo")
                                        .description("This value is assigned by the service provider, in this example `gigantic-server.com`")
                                        .build()
                        ),
                        Pair(
                                "port",
                                ServerVariable.builder()
                                        .enumValues(listOf("8883", "8884"))
                                        .defaultValue("8883")
                                        .build()
                        ),
                        Pair("basePath", Reference("#/components/serverVariables/basePath"))
                ))
                .build()
    }

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/model/components/components.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, Components::class.java),
                build()
        )
    }

}
