package com.asyncapi.v2._6_0.binding.message.http

import com.asyncapi.v2.ClasspathUtils
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class HTTPMessageBindingTest {

    private val objectMapper = ObjectMapper()

    private fun build(): HTTPMessageBinding {
        return HTTPMessageBinding.builder()
                .headers(mapOf(
                        Pair("type", "object"),
                        Pair("properties", mapOf(
                                Pair("Content-Type", mapOf(
                                        Pair("type", "string"),
                                        Pair("enum", listOf("application/json"))
                                ))
                        )),
                ))
                .build()
    }

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/binding/message/http/httpMessageBinding.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, HTTPMessageBinding::class.java),
                build()
        )
    }

}