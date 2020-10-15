package com.asyncapi.plugin.core.generator.strategy

import com.asyncapi.plugin.core.DefaultSchemaProperties
import com.asyncapi.plugin.core.generator.settings.GenerationSettings
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

/*
    TODO: compare generated schemas with handwritten
 */
class JsonGenerationStrategyTest: GenerationStrategyTest() {

    private fun composeGenerationSettings(classes: Array<String> = emptyArray(),
                                          packages: Array<String> = emptyArray(),
                                          path: String = DefaultSchemaProperties.filePath,
                                          namePostfix: String = DefaultSchemaProperties.fileNamePostfix): GenerationSettings {
        return GenerationSettings(
                logger,
                composeGenerationSources(classes, packages),
                composeGenerationRules(),
                composeSchemaFileSettings(path, namePostfix)
        )
    }

    /*
        * default path +
        * given path +
        * classes only +
        * packages only +
        * classes and packages
        * classes and packages are empty +
     */

    /*
        Default schema properties.
     */
    @Test
    fun `generate with default schema properties when classes and packages are empty`() {
        val jsonGenerationStrategy = JsonGenerationStrategy(composeGenerationSettings())
        jsonGenerationStrategy.generate()

        val schemasFolder = File(DefaultSchemaProperties.filePath)
        schemasFolder.listFiles()?.forEach { it.deleteOnExit() }
        schemasFolder.deleteOnExit()

        Assertions.assertFalse(schemasFolder.exists(), "Folders must not be created in case when classes & packages are empty.")
    }

    @Test
    fun `generate with default schema properties when classes are not empty`() {
        val jsonGenerationStrategy = JsonGenerationStrategy(composeGenerationSettings(
                classes = arrayOf(
                        "com.asyncapi.schemas.lamps.Lamps",
                        "com.asyncapi.schemas.streetlights.Streetlights"
                )
        ))
        jsonGenerationStrategy.generate()

        val schemasFolder = File(DefaultSchemaProperties.filePath)

        Assertions.assertTrue(schemasFolder.exists() && schemasFolder.isDirectory, "Schemas folder must exists and be folder.")
        Assertions.assertTrue(schemasFolder.list()!!.isNotEmpty(), "Schemas folder must not be empty.")

        val expectedSchemaFileNameEnding = "${DefaultSchemaProperties.fileNamePostfix}.json"
        schemasFolder.listFiles()?.forEach {
            Assertions.assertTrue(it.name.endsWith(expectedSchemaFileNameEnding), "Schema must ends with: $expectedSchemaFileNameEnding")
        }

        schemasFolder.deleteRecursively()
    }

    @Test
    fun `generate with default schema properties when packages are not empty`() {
        val jsonGenerationStrategy = JsonGenerationStrategy(composeGenerationSettings(
                packages = arrayOf(
                        "com.asyncapi.schemas.lamps",
                        "com.asyncapi.schemas.streetlights"
                )
        ))
        jsonGenerationStrategy.generate()

        val schemasFolder = File(DefaultSchemaProperties.filePath)

        Assertions.assertTrue(schemasFolder.exists() && schemasFolder.isDirectory, "Schemas folder must exists and be folder.")
        Assertions.assertTrue(schemasFolder.list()!!.isNotEmpty(), "Schemas folder must not be empty.")

        val expectedSchemaFileNameEnding = "${DefaultSchemaProperties.fileNamePostfix}.json"
        schemasFolder.listFiles()?.forEach {
            Assertions.assertTrue(it.name.endsWith(expectedSchemaFileNameEnding), "Schema must ends with: $expectedSchemaFileNameEnding")
        }

        schemasFolder.deleteRecursively()
    }

    @Test
    fun `generate with default schema properties when classes and packages are not empty`() {
        val jsonGenerationStrategy = JsonGenerationStrategy(composeGenerationSettings(
                classes = arrayOf(
                        "com.asyncapi.schemas.lamps.Lamps",
                        "com.asyncapi.schemas.streetlights.Streetlights"
                ),
                packages = arrayOf(
                        "com.asyncapi.schemas.lamps",
                        "com.asyncapi.schemas.streetlights"
                )
        ))
        jsonGenerationStrategy.generate()

        val schemasFolder = File(DefaultSchemaProperties.filePath)

        Assertions.assertTrue(schemasFolder.exists() && schemasFolder.isDirectory, "Schemas folder must exists and be folder.")
        Assertions.assertTrue(schemasFolder.list()!!.isNotEmpty(), "Schemas folder must not be empty.")

        val expectedSchemaFileNameEnding = "${DefaultSchemaProperties.fileNamePostfix}.json"
        schemasFolder.listFiles()?.forEach {
            Assertions.assertTrue(it.name.endsWith(expectedSchemaFileNameEnding), "Schema must ends with: $expectedSchemaFileNameEnding")
        }

        schemasFolder.deleteRecursively()
    }

    /*
        Custom path.
     */
    @Test
    fun `generate with given path when classes and packages are empty`() {
        val path = "asyncapi-schemas"

        val jsonGenerationStrategy = JsonGenerationStrategy(composeGenerationSettings(path = path))
        jsonGenerationStrategy.generate()

        val schemasFolder = File(DefaultSchemaProperties.filePath)
        schemasFolder.listFiles()?.forEach { it.deleteOnExit() }
        schemasFolder.deleteOnExit()

        Assertions.assertFalse(schemasFolder.exists(), "Folders must not be created in case when classes & packages are empty.")
    }

    @Test
    fun `generate with given path when classes are not empty`() {
        val path = "asyncapi-schemas"

        val jsonGenerationStrategy = JsonGenerationStrategy(composeGenerationSettings(
                classes = arrayOf(
                        "com.asyncapi.schemas.lamps.Lamps",
                        "com.asyncapi.schemas.streetlights.Streetlights"
                ),
                path = path
        ))
        jsonGenerationStrategy.generate()

        val schemasFolder = File(path)

        Assertions.assertTrue(schemasFolder.exists() && schemasFolder.isDirectory, "Schemas folder must exists and be folder.")
        Assertions.assertTrue(schemasFolder.list()!!.isNotEmpty(), "Schemas folder must not be empty.")

        val expectedSchemaFileNameEnding = "${DefaultSchemaProperties.fileNamePostfix}.json"
        schemasFolder.listFiles()?.forEach {
            Assertions.assertTrue(it.name.endsWith(expectedSchemaFileNameEnding), "Schema must ends with: $expectedSchemaFileNameEnding")
        }

        schemasFolder.deleteRecursively()
    }

    @Test
    fun `generate with given path when packages are not empty`() {
        val path = "asyncapi-schemas"

        val jsonGenerationStrategy = JsonGenerationStrategy(composeGenerationSettings(
                packages = arrayOf(
                        "com.asyncapi.schemas.lamps",
                        "com.asyncapi.schemas.streetlights"
                ),
                path = path
        ))
        jsonGenerationStrategy.generate()

        val schemasFolder = File(path)

        Assertions.assertTrue(schemasFolder.exists() && schemasFolder.isDirectory, "Schemas folder must exists and be folder.")
        Assertions.assertTrue(schemasFolder.list()!!.isNotEmpty(), "Schemas folder must not be empty.")

        val expectedSchemaFileNameEnding = "${DefaultSchemaProperties.fileNamePostfix}.json"
        schemasFolder.listFiles()?.forEach {
            Assertions.assertTrue(it.name.endsWith(expectedSchemaFileNameEnding), "Schema must ends with: $expectedSchemaFileNameEnding")
        }

        schemasFolder.deleteRecursively()
    }

    @Test
    fun `generate with given path when classes and packages are not empty`() {
        val path = "asyncapi-schemas"

        val jsonGenerationStrategy = JsonGenerationStrategy(composeGenerationSettings(
                classes = arrayOf(
                        "com.asyncapi.schemas.lamps.Lamps",
                        "com.asyncapi.schemas.streetlights.Streetlights"
                ),
                packages = arrayOf(
                        "com.asyncapi.schemas.lamps",
                        "com.asyncapi.schemas.streetlights"
                ),
                path = path
        ))
        jsonGenerationStrategy.generate()

        val schemasFolder = File(path)

        Assertions.assertTrue(schemasFolder.exists() && schemasFolder.isDirectory, "Schemas folder must exists and be folder.")
        Assertions.assertTrue(schemasFolder.list()!!.isNotEmpty(), "Schemas folder must not be empty.")

        val expectedSchemaFileNameEnding = "${DefaultSchemaProperties.fileNamePostfix}.json"
        schemasFolder.listFiles()?.forEach {
            Assertions.assertTrue(it.name.endsWith(expectedSchemaFileNameEnding), "Schema must ends with: $expectedSchemaFileNameEnding")
        }

        schemasFolder.deleteRecursively()
    }

}