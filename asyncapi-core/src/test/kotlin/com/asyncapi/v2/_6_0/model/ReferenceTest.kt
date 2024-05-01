package com.asyncapi.v2._6_0.model

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.schemas.Reference
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ReferenceTest {

    private val objectMapper = ObjectMapper()

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/v2/2.6.0/model/reference.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, Reference::class.java),
                build()
        )
    }

    fun build(): Reference {
        return Reference("#/components/schemas/user")
    }

}