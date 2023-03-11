package com.asyncapi.v2._0_0.model.info

import com.asyncapi.v2.ClasspathUtils
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @author Pavel Bodiachevskii
 */
class LicenseTest {

    private val objectMapper = ObjectMapper()

    private fun buildLicense(): License {
        return License(
                "Apache License 2.0",
                "http://www.apache.org/licenses/"
        )
    }

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/2.0.0/model/info/license.json")

        Assertions.assertEquals(
                objectMapper.readValue(model, License::class.java),
                buildLicense()
        )
    }

}
