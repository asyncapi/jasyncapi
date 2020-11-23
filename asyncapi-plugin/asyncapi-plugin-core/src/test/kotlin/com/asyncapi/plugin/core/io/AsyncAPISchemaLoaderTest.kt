package com.asyncapi.plugin.core.io

import com.asyncapi.plugin.core.generator.exception.AsyncAPISchemaGenerationException
import com.asyncapi.plugin.core.generator.settings.GenerationSources
import com.asyncapi.plugin.core.logging.Logger
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.net.URLClassLoader
import kotlin.streams.toList

class AsyncAPISchemaLoaderTest {

    private fun mockLogger(): Logger {
        return object: Logger {
            override fun info(message: String) {
                println(message)
            }

            override fun error(message: String) {
                println(message)
            }

        }
    }

    private fun composeClassLoader(): ClassLoader {
        return URLClassLoader.getSystemClassLoader()
    }

    @Test
    fun `when classes and packages are empty`() {
        val loader = AsyncAPISchemaLoader(mockLogger(), GenerationSources(emptyArray(), emptyArray(), composeClassLoader()))
        val loadedSchemas = loader.load()

        Assertions.assertTrue(loadedSchemas.isEmpty())
    }

    @Test
    fun `when packages are empty`() {
        val classesToLoad = arrayOf(
                "com.asyncapi.schemas.lamps.Lamps",
                "com.asyncapi.schemas.streetlights.Streetlights"
        )

        val loader = AsyncAPISchemaLoader(mockLogger(), GenerationSources(classesToLoad, emptyArray(), composeClassLoader()))
        val loadedSchemas = loader.load()

        Assertions.assertEquals(classesToLoad.size, loadedSchemas.size, "Loader must load all given classes")

        Assertions.assertTrue(classesToLoad.asList().containsAll(loadedSchemas.stream().map { it.name }.toList()), "Loader must load all given classes")
    }

    @Test
    fun `when classes are empty`() {
        val packagesToLoad = arrayOf(
                "com.asyncapi.schemas.lamps",
                "com.asyncapi.schemas.streetlights"
        )
        val expectedSchemas = arrayOf(
                "com.asyncapi.schemas.lamps.Lamps",
                "com.asyncapi.schemas.streetlights.Streetlights"
        )

        val loader = AsyncAPISchemaLoader(mockLogger(), GenerationSources(emptyArray(), packagesToLoad, composeClassLoader()))
        val loadedSchemas = loader.load()

        Assertions.assertEquals(expectedSchemas.size, loadedSchemas.size, "Loader must load all given classes from given packages")

        Assertions.assertTrue(expectedSchemas.asList().containsAll(loadedSchemas.stream().map { it.name }.toList()), "Loader must load all given classes from given packages")
    }

    @Test
    fun `when both classes and packages are present`() {
        val classesToLoad = arrayOf(
                "com.asyncapi.schemas.lamps.Lamps",
                "com.asyncapi.schemas.streetlights.Streetlights"
        )
        val packagesToLoad = arrayOf(
                "com.asyncapi.schemas.lamps",
                "com.asyncapi.schemas.streetlights"
        )
        val expectedSchemas = arrayOf(
                "com.asyncapi.schemas.lamps.Lamps",
                "com.asyncapi.schemas.streetlights.Streetlights"
        )

        val loader = AsyncAPISchemaLoader(mockLogger(), GenerationSources(classesToLoad, packagesToLoad, composeClassLoader()))
        val loadedSchemas = loader.load()

        Assertions.assertEquals(expectedSchemas.size, loadedSchemas.size, "Loader must load all given classes from given packages")

        Assertions.assertTrue(expectedSchemas.asList().containsAll(loadedSchemas.stream().map { it.name }.toList()), "Loader must load all given classes from given packages")

    }

    @Test
    fun `when class doesn't exists`() {
        val classesToLoad = arrayOf(
                "com.asyncapi.schemas.streetlights.GothamStreetlights"
        )

        val loader = AsyncAPISchemaLoader(mockLogger(), GenerationSources(classesToLoad, emptyArray(), composeClassLoader()))
        Assertions.assertThrows(AsyncAPISchemaGenerationException::class.java) {loader.load()}
    }

    @Test
    fun `when one of classes doesn't exists`() {
        val classesToLoad = arrayOf(
                "com.asyncapi.schemas.lamps.Lamps",
                "com.asyncapi.schemas.streetlights.Streetlights",
                "com.asyncapi.schemas.streetlights.GothamStreetlights"
        )

        val loader = AsyncAPISchemaLoader(mockLogger(), GenerationSources(classesToLoad, emptyArray(), composeClassLoader()))
        Assertions.assertThrows(AsyncAPISchemaGenerationException::class.java) {loader.load()}
    }

    @Test
    fun `when root package given`() {
        val packagesToLoad = arrayOf(
                "com.asyncapi.schemas"
        )
        val expectedSchemas = arrayOf(
                "com.asyncapi.schemas.lamps.Lamps",
                "com.asyncapi.schemas.streetlights.Streetlights"
        )

        val loader = AsyncAPISchemaLoader(mockLogger(), GenerationSources(emptyArray(), packagesToLoad, composeClassLoader()))
        val loadedSchemas = loader.load()

        Assertions.assertEquals(expectedSchemas.size, loadedSchemas.size, "Loader must load all given classes from given packages")

        Assertions.assertTrue(expectedSchemas.asList().containsAll(loadedSchemas.stream().map { it.name }.toList()), "Loader must load all given classes from given packages")
    }

    @Test
    fun `when single package given`() {
        val packagesToLoad = arrayOf(
                "com.asyncapi.schemas.lamps.Lamps"
        )
        val expectedSchemas = arrayOf(
                "com.asyncapi.schemas.lamps.Lamps"
        )

        val loader = AsyncAPISchemaLoader(mockLogger(), GenerationSources(emptyArray(), packagesToLoad, composeClassLoader()))
        val loadedSchemas = loader.load()

        Assertions.assertEquals(expectedSchemas.size, loadedSchemas.size, "Loader must load all given classes from given packages")

        Assertions.assertTrue(expectedSchemas.asList().containsAll(loadedSchemas.stream().map { it.name }.toList()), "Loader must load all given classes from given packages")
    }

}