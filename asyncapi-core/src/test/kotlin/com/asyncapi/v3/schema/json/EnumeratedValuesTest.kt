package com.asyncapi.v3.schema.json

import com.asyncapi.v3.schema.JsonSchema
import com.asyncapi.v3.schema.ReadSchemaTest

class EnumeratedValuesTest: ReadSchemaTest<JsonSchema>() {

    override fun schemaClass() = JsonSchema::class.java

    override fun schemaToReadPath() = "/json/v3/schema/json/enumerated-values.schema.json"

    override fun buildSchema(): JsonSchema {
        return JsonSchema.builder()
                .id("https://example.com/enumerated-values.schema.json")
                .schema("http://json-schema.org/draft-07/schema#")
                .title("Enumerated Values")
                .type("object")
                .properties(mapOf(
                        Pair("data", JsonSchema.builder()
                                .enumValue(listOf(
                                        42, true, "hello", null, listOf(1, 2, 3)
                                ))
                                .build()
                        )
                ))
                .build()
    }

}