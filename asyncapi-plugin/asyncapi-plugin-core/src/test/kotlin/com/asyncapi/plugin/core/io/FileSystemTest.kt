package com.asyncapi.plugin.core.io

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

class FileSystemTest {

    @Test
    fun `save with default path`() {
        FileSystem.save("StreetLights-asyncapi.json", "{}", "")
        val savedSchema = File("${FileSystem.defaultPath}/StreetLights-asyncapi.json")
        savedSchema.deleteOnExit()

        Assertions.assertTrue(savedSchema.exists())
    }

    @Test
    fun `save with given path`() {
        val path = "generated/asyncapi"

        FileSystem.save("StreetLights-asyncapi.json", "{}", path)
        val savedSchema = File("$path/StreetLights-asyncapi.json")
        savedSchema.deleteOnExit()

        Assertions.assertTrue(savedSchema.exists())
    }

}