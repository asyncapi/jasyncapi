package com.asyncapi.v3.schema

import com.asyncapi.v3.ClasspathUtils
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

abstract class ReadSchemaTest<SchemaType> {

    protected val objectMapper = ObjectMapper()
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)

    protected abstract fun schemaClass(): Class<SchemaType>

    protected abstract fun schemaToReadPath(): String

    protected abstract fun buildSchema(): SchemaType

    @Test
    @DisplayName("Read: compare hand crafted schema with parsed schema")
    fun compareObjectWithParsedJson() {
        val model = ClasspathUtils.readAsString(schemaToReadPath())

        Assertions.assertEquals(
                objectMapper.readValue(model, schemaClass()),
                buildSchema()
        )
    }

}