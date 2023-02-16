package com.asyncapi.v2._6_0.binding.operation.http

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.v2.binding.operation.http.HTTPOperationBinding
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class HTTPOperationBindingTest {

    private val objectMapper = ObjectMapper()

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/binding/operation/http/httpOperationBinding.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, HTTPOperationBinding::class.java),
                build()
        )
    }

    companion object {
        @JvmStatic
        fun build(): HTTPOperationBinding {
            return HTTPOperationBinding.builder()
                    .type("request")
                    .method("GET")
                    .query(mapOf(
                            Pair("type", "object"),
                            Pair("required", listOf("companyId")),
                            Pair("properties", mapOf(
                                    Pair("companyId", mapOf(
                                            Pair("type", "number"),
                                            Pair("minimum", 1),
                                            Pair("description", "The Id of the company.")
                                    )),
                                    Pair("additionalProperties", false)
                            )),
                    ))
                    .build()
        }
    }

}