package com.asyncapi.schemas.multiformat.avro

import com.asyncapi.v3.ClasspathUtils
import com.asyncapi.schemas.multiformat.AvroFormatSchema
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import org.junit.jupiter.api.Assertions

abstract class AvroFormatSchemaTest {

    private val objectMapper: ObjectMapper = ObjectMapper(YAMLFactory())
        .setSerializationInclusion(JsonInclude.Include.NON_NULL)
        .findAndRegisterModules()

    fun compareSchemas(
        avroFormatSchemaToCompareWithFilePath: String,
        schemaToCheck: AvroFormatSchema
    ) {
        val schemaAsJson = ClasspathUtils.readAsString(avroFormatSchemaToCompareWithFilePath)
        val schema = objectMapper.readValue(schemaAsJson, AvroFormatSchema::class.java)

        Assertions.assertEquals(schema, schemaToCheck)
    }

    abstract fun parseJson(
        avroFormatSchemaToCompareWithFilePath: String,
        avroFormatSchema: AvroFormatSchema
    )

    abstract fun parseYaml(
        avroFormatSchemaToCompareWithFilePath: String,
        avroFormatSchema: AvroFormatSchema
    )

}