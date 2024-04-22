package com.asyncapi.v3._0_0.model

import com.asyncapi.v3.ClasspathUtils
import com.asyncapi.Reference
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ReferenceTest {

    private val objectMapper = ObjectMapper()

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/v3/3.0.0/model/reference.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, Reference::class.java),
                build()
        )
    }

    fun build(): Reference {
        return Reference("#/components/schemas/user")
    }

}