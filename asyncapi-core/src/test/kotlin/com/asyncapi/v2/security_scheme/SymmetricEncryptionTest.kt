package com.asyncapi.v2.security_scheme

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.v2._0_0.model.security_scheme.SecurityScheme
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @author Pavel Bodiachevskii
 */
class SymmetricEncryptionTest {

    private val objectMapper = ObjectMapper()

    private fun build(): SecurityScheme {
        return SecurityScheme.builder()
                .type(SecurityScheme.Type.SYMMETRIC_ENCRYPTION)
                .build()
    }

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/security_scheme/encryption/symmetricEncryption.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, SecurityScheme::class.java),
                build()
        )
    }

}
