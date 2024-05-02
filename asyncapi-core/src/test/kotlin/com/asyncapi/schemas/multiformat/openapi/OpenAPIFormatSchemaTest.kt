package com.asyncapi.schemas.multiformat.openapi

import com.asyncapi.v3.ClasspathUtils
import com.asyncapi.schemas.multiformat.OpenAPIFormatSchema
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import org.junit.jupiter.api.Assertions

abstract class OpenAPIFormatSchemaTest {

    private val objectMapper: ObjectMapper = ObjectMapper(YAMLFactory())
        .setSerializationInclusion(JsonInclude.Include.NON_NULL)
        .findAndRegisterModules()

    fun compareSchemas(
        openAPIFormatSchemaToCompareWithFilePath: String,
        schemaToCheck: OpenAPIFormatSchema
    ) {
        val schemaAsJson = ClasspathUtils.readAsString(openAPIFormatSchemaToCompareWithFilePath)
        val schema = objectMapper.readValue(schemaAsJson, OpenAPIFormatSchema::class.java)

        Assertions.assertEquals(schema, schemaToCheck)
    }

    abstract fun parseJson(
        openAPIFormatSchemaToCompareWithFilePath: String,
        openAPIFormatSchema: OpenAPIFormatSchema
    )

    abstract fun parseYaml(
        openAPIFormatSchemaToCompareWithFilePath: String,
        openAPIFormatSchema: OpenAPIFormatSchema
    )

}