package com.asyncapi.v3.schema.multiformat.asyncapi

import com.asyncapi.v3.ClasspathUtils
import com.asyncapi.schemas.multiformat.AsyncAPIFormatSchema
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import org.junit.jupiter.api.Assertions

abstract class AsyncAPIFormatSchemaTest {

    private val objectMapper: ObjectMapper = ObjectMapper(YAMLFactory())
        .setSerializationInclusion(JsonInclude.Include.NON_NULL)
        .findAndRegisterModules()

    fun compareSchemas(
        openAPIFormatSchemaToCompareWithFilePath: String,
        schemaToCheck: AsyncAPIFormatSchema
    ) {
        val schemaAsJson = ClasspathUtils.readAsString(openAPIFormatSchemaToCompareWithFilePath)
        val schema = objectMapper.readValue(schemaAsJson, AsyncAPIFormatSchema::class.java)

        Assertions.assertEquals(schema, schemaToCheck)
    }

    abstract fun parseJson(
        asyncAPIFormatSchemaToCompareWithFilePath: String,
        asyncAPIFormatSchema: AsyncAPIFormatSchema
    )

    abstract fun parseYaml(
        asyncAPIFormatSchemaToCompareWithFilePath: String,
        asyncAPIFormatSchema: AsyncAPIFormatSchema
    )

}