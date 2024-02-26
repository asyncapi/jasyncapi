package com.asyncapi.examples.v2._6_0

import com.asyncapi.v3.ClasspathUtils
import com.asyncapi.v2._6_0.model.AsyncAPI
import com.asyncapi.v2._6_0.model.component.Components
import com.asyncapi.v2._6_0.model.info.Info
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

abstract class AbstractExampleValidationTest {

    private val objectMapper = ObjectMapper(YAMLFactory())
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)

    abstract fun specificationLocation(): String

    private fun specification(): AsyncAPI {
        return objectMapper.readValue(
                ClasspathUtils.readAsString(specificationLocation()),
                AsyncAPI::class.java
        )
    }

    open fun expectedId(): String? = null

    @Test
    fun `ensure that id was read correctly`() {
        Assertions.assertEquals(
                specification().id,
                expectedId(),
                "id must be read correctly"
        )
    }

    open fun expectedDefaultContentType(): String? = null

    @Test
    fun `ensure that defaultContentType was read correctly`() {
        Assertions.assertEquals(
                specification().defaultContentType,
                expectedDefaultContentType(),
                "defaultContentType must be read correctly"
        )
    }

    abstract fun expectedInfo(): Info

    @Test
    fun `ensure that info was read correctly`() {
        Assertions.assertEquals(
                specification().info,
                expectedInfo(),
                "Info must be read correctly"
        )
    }

    abstract fun expectedServers(): Map<String, Any>?

    @Test
    fun `ensure that servers were read correctly`() {
        Assertions.assertEquals(
                specification().servers,
                expectedServers(),
                "Servers must be read correctly"
        )
    }

    abstract fun expectedChannels(): Map<String, Any>

    @Test
    fun `ensure that channels were read correctly`() {
        Assertions.assertEquals(
                specification().channels,
                expectedChannels(),
                "Channels must be read correctly"
        )
    }

    abstract fun expectedComponents(): Components?

    @Test
    fun `ensure that components were read correctly`() {
        Assertions.assertEquals(
                specification().components,
                expectedComponents(),
                "Components must be read correctly"
        )
    }

}