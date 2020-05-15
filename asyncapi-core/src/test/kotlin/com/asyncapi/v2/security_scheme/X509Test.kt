package com.asyncapi.v2.security_scheme

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.v2.model.security_scheme.SecurityScheme
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @author Pavel Bodiachevskii
 */
class X509Test {

    private val objectMapper = ObjectMapper().registerKotlinModule()

    private fun build(): SecurityScheme {
        return SecurityScheme.builder()
                .type(SecurityScheme.Type.X509)
                .build()
    }

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/security_scheme/X509.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, SecurityScheme::class.java),
                build()
        )
    }

}
