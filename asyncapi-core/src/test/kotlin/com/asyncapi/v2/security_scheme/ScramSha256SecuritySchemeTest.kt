package com.asyncapi.v2.security_scheme

import com.asyncapi.v2.ClasspathUtils
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @author Pavel Bodiachevskii
 */
class ScramSha256SecuritySchemeTest {

    private val objectMapper = ObjectMapper()

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/2.6.0/model/security_scheme/scramSha256.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, SecurityScheme::class.java),
                build()
        )
    }

    companion object {
        @JvmStatic
        fun build(): SecurityScheme {
            return SecurityScheme.builder()
                    .type(SecurityScheme.Type.SCRAM_SHA256)
                    .description("scramSha256")
                    .build()
        }
    }

}
