package com.asyncapi.v2.model.info

import com.asyncapi.v2.ClasspathUtils
import com.google.gson.GsonBuilder
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @author Pavel Bodiachevskii
 */
class InfoTest {

    private val gson = GsonBuilder().setPrettyPrinting().create()

    private fun buildContact(): Contact {
        return gson.fromJson(
                ClasspathUtils.readAsString("/json/model/info/contact.json"),
                Contact::class.java
        )
    }

    private fun buildLicense(): License {
        return gson.fromJson(
                ClasspathUtils.readAsString("/json/model/info/license.json"),
                License::class.java
        )
    }

    private fun buildInfo(): Info {
        return Info(
                "AsyncApi sample",
                "2.0",
                "short description",
                "https://www.asyncapi.com/about/",
                buildContact(),
                buildLicense()
        )
    }

    @Test
    @DisplayName("Compare hand crafted model with parsed json")
    fun compareModelWithParsedJson() {
        val model = ClasspathUtils.readAsString("/json/model/info/info.json")

        Assertions.assertEquals(
                gson.fromJson(model, Info::class.java),
                buildInfo()
        )
    }

}
